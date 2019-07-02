/**
 * 
 */
package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PE
 * @date 2019年6月28日 上午9:17:23
 * @explain 
 * 与传统方式不同，连接池在使用之前，就会创建好一定数量的连接。
如果有任何线程需要使用连接，那么就从连接池里面借用，而不是自己重新创建. 
使用完毕后，又把这个连接归还给连接池供下一次或者其他线程使用。
倘若发生多线程并发情况，连接池里的连接被借用光了，那么其他线程就会临时等待，直到有连接被归还回来，再继续使用。
整个过程，这些连接都不会被关闭，而是不断的被循环使用，从而节约了启动和关闭连接的时间。

1.ConnectionPool()构造方法约定了这个连接池一共有多少连接

2.在init() 初始化方法中,创建了size条连接。 注意,这里不能使用try-with-resource这种自动关闭连接的方式，因为连接恰恰需要保持不关闭状态，供后续循环使用

3.getConnection,判断是否为空，如果是空的就wait等待,否则就借用一条连接出去

4.returnConnection,在使用完毕后,归还这个连接到连接池,并且在归还完毕后,
  调用notifyAll，通知那些等待的线程，有新的连接可以借用了。

 */
public class ConnectionPool {
	 List<Connection> cs = new ArrayList<Connection>();
	  
	    int size;
	  
	    public ConnectionPool(int size) {
	        this.size = size;
	        init();
	    }
	  
	    public void init() {
	          
	        //这里恰恰不能使用try-with-resource的方式，因为这些连接都需要是"活"的，不要被自动关闭了
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            for (int i = 0; i < size; i++) {
	                Connection c = DriverManager
	                        .getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8", "root", "123456");
	  
	                cs.add(c);
	  
	            }
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	  
	    public synchronized Connection getConnection() {
	        while (cs.isEmpty()) {
	            try {
	            	//等待
	                this.wait();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        Connection c = cs.remove(0);
	        return c;
	    }
	  
	    public synchronized void returnConnection(Connection c) {
	        cs.add(c);
	        //唤醒
	        this.notifyAll();
	    }
	  
}
