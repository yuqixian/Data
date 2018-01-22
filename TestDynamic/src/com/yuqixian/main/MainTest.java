package com.yuqixian.main;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yuqixian.utils.JdbcUtils;


public class MainTest {
	/**
	 * 全局参数
	 */
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public static void main(String[] args) {
		
		insertData();
			
		//deleteData();
		
	}
	
	public static void deleteData() {
		try {
			// 1.获取连接
			conn = JdbcUtils.getDb_config_1Connection();
			
			String sql = "delete from test";
			
			pstmt = conn.prepareStatement(sql);
				
				
			pstmt.executeUpdate();
				
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new RuntimeException(e);
			
		} 
	}
	
	public static void insertData() {
		try {
			// 1.获取连接
			conn = JdbcUtils.getDb_config_1Connection();
			
			String sql = "insert into test(xData,yData) values(?,?)";
			
			for(int i = 0;i < 1000000;i++ ) {
				
				pstmt = conn.prepareStatement(sql);
				
				int x = 2*i;
				int y = (int) (Math.random() * 21);
				
				pstmt.setInt(1, x);
				
				pstmt.setInt(2, y);
				
				pstmt.executeUpdate();
				
				//removeData();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new RuntimeException(e);
			
		} 
	}
	
	
	public static void removeData() {
		try {
			// 1.获取连接
			conn = JdbcUtils.getDb_config_1Connection();
			
			String sql = "delete  from test limit 1";
				
			pstmt = conn.prepareStatement(sql);
				
				
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new RuntimeException(e);
			
		} 
	
	}
	
	
}
