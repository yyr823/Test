/**
 * 
 */
package com.socket.rootchat;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * @author PE
 * @date 2019年6月28日 下午3:40:23
 * @explain 
 */
public class DictionaryDAO {
	public DictionaryDAO() {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	 
	    public Connection getConnection() throws SQLException {
	        return (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8", "root",
	                "123456");
	    }
	 
	    public List<Dictionary> query(String recieve) {
	        List<Dictionary> ds = new ArrayList<Dictionary>();
	 
	        String sql = "select * from dictionary where receive = ? ";
	 
	        try (Connection c = getConnection(); 
	        PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);) {
	            ps.setString(1, recieve);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Dictionary d = new Dictionary();
	                int id = rs.getInt(1);
	                String receive = rs.getString("receive");
	                String response = rs.getString("response");
	                d.id=id;
	                d.receive=receive;
	                d.response=response;
	                ds.add(d);
	            }
	        } catch (SQLException e) {
	 
	            e.printStackTrace();
	        }
	        return ds;
	    }
	 
}
