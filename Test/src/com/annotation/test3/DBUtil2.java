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
 * @explain 注解方式数据库连接
 */
@JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "123456")
public class DBUtil2 {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		JDBCConfig config = DBUtil2.class.getAnnotation(JDBCConfig.class);
		String ip = config.ip();
		int port = config.port();
		String database = config.database();
		String encoding = config.encoding();
		String loginName = config.loginName();
		String password = config.password();
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
		return (Connection) DriverManager.getConnection(url, loginName, password);
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}
