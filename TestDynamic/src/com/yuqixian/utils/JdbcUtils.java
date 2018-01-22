package com.yuqixian.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 
 * JDBC ������
 * 
 * @author yuqixian
 */
public class JdbcUtils {

	/**
	 * ȫ�ֲ���
	 */
	private static String url_db_machine_1_1 = null;
	private static String url_db_config_1 = null;
	private static String url_db_config = null;
	private static String user = null;
	private static String password = null;
	private static String MYSQLDriver = null;

	/**
	 * ��̬����飨����ֻ����һ�Σ�
	 */
	static {
		try {
			// ��ȡdb.properties�ļ�
			Properties props = new Properties();
			InputStream inStream = JdbcUtils.class.getResourceAsStream("/DbConfig.property");

			// ����db.properties�ļ�
			props.load(inStream);

			// ��ȡ��Ϣ
			url_db_machine_1_1 = props.getProperty("MYSQLURL_db_machine_1_1");
			url_db_config_1 = props.getProperty("MYSQLURL_db_config_1");
			url_db_config = props.getProperty("MYSQLURL_db_config");
			user = props.getProperty("user");
			password = props.getProperty("password");
			MYSQLDriver = props.getProperty("MYSQLDriver");

			// ע����������
			Class.forName(MYSQLDriver);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * �������ݿ�����
	 */
	public static Connection getDb_machine_1_1Connection() {
		// �������ݿ�
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
		// �������ݿ�
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
		// �������ݿ�
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
	 * �ر�
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
