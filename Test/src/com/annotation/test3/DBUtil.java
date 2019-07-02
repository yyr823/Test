/**
 * 
 */
package com.annotation.test3;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * @author PE
 * @date 2019年7月2日 下午2:45:11
 * @explain 非注解数据库连接
 */
public class DBUtil {
	static String ip = "127.0.0.1";
	static int port = 3306;
	static String database = "test";
	static String encoding = "UTF-8";
	static String loginName = "root";
	static String password = "123456";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
		return (Connection) DriverManager.getConnection(url, loginName, password);
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}
