package com.yuqixian.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 
 * JDBC 工具类
 * 
 * @author yuqixian
 */
public class JdbcUtils {

	/**
	 * 全局参数
	 */
	private static String url_db_machine_1_1 = null;
	private static String url_db_config_1 = null;
	private static String url_db_config = null;
	private static String user = null;
	private static String password = null;
	private static String MYSQLDriver = null;

	/**
	 * 静态代码块（代码只加载一次）
	 */
	static {
		try {
			// 读取db.properties文件
			Properties props = new Properties();
			InputStream inStream = JdbcUtils.class.getResourceAsStream("/DbConfig.property");

			// 加载db.properties文件
			props.load(inStream);

			// 读取信息
			url_db_machine_1_1 = props.getProperty("MYSQLURL_db_machine_1_1");
			url_db_config_1 = props.getProperty("MYSQLURL_db_config_1");
			url_db_config = props.getProperty("MYSQLURL_db_config");
			user = props.getProperty("user");
			password = props.getProperty("password");
			MYSQLDriver = props.getProperty("MYSQLDriver");

			// 注册驱动程序
			Class.forName(MYSQLDriver);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 返回数据库连接
	 */
	public static Connection getDb_machine_1_1Connection() {
		// 连接数据库
		Connection conn;

		try {
			conn = DriverManager.getConnection(url_db_machine_1_1, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Connection getDb_config_1Connection() {
		// 连接数据库
		Connection conn;

		try {
			conn = DriverManager.getConnection(url_db_config_1, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static Connection getDb_configConnection() {
		// 连接数据库
		Connection conn;

		try {
			conn = DriverManager.getConnection(url_db_config, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * 关闭
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
}
