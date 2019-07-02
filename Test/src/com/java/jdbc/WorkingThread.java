/**
 * 
 */
package com.java.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PE
 * @date 2019年6月28日 上午9:19:07
 * @explain 使用数据库连接池的方式

 */
public class WorkingThread  extends Thread{
	List<Connection> cs = new ArrayList<Connection>();
	    private ConnectionPool connectionPool;
	    private String sql;
	    public WorkingThread(String sql, ConnectionPool connectionPool) {
	        this.sql = sql;//sql语句
	        this.connectionPool = connectionPool;
	    }
		public void run() {
	        Connection connection = connectionPool.getConnection();
	        try(Statement statement = connection.createStatement()){
	            statement.execute(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        //使用完成之后，交还连接回到连接池
	        connectionPool.returnConnection(connection);
		}
	  
}