/**
 * 
 */
package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PE
 * @date 2019年6月28日 上午9:16:52
 * @explain 性能比较: 使用数据库连接池的方式>传统方式
 */
public class TestConnectionPool {

	public static void main(String[] args) {
		List<WorkingThread> list=new ArrayList<>();
	        try {
	            Class.forName("com.mysql.jdbc.Driver");//加载驱动
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        String sql = "insert into user_info values(null,'JDBC')";
	        //建立连接
	        try(Connection connection = DriverManager.getConnection
	                ("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8", "root", "123456");
	            Statement statement = connection.createStatement();
	        ) {
	            long startTime = System.currentTimeMillis();
	            for (int i = 0; i < 100; i++) {
	                statement.execute(sql);
	            }
	            long endTiem = System.currentTimeMillis();
	            System.out.println("传统方式时间："+(endTiem-startTime));
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        ConnectionPool connectionPool = new ConnectionPool(10);
	        long starTime1 = System.currentTimeMillis();
	        for (int i = 0; i < 100; i++) {
	           WorkingThread t = new WorkingThread(sql,connectionPool);
	                   list.add(t);
	        		   t.start();
	        		 
	        }
	        long endTime1 = System.currentTimeMillis();
	        System.out.println("线程池方式时间："+(endTime1-starTime1));
	        /**
	         * join的作用是，主线程main等待  
	         *  正在遍历的 t 线程结束后才继续执行。
                如果注释掉遍历，就是主线程不等待所有子线程都执行
                完就继续执行最后的输出
	         */
	        for (Thread t : list) {
	            try {
	                t.join();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    }
}
