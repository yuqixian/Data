package com.yuqixian.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuqixian.utils.JdbcUtils;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	/**
	 * 全局参数
	 */
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("开始调用.......");
		
		// 传递到前端的map
		Map<String, Object> map = new HashMap<String, Object>();

		
		List xDataList = new ArrayList();
		List yDataList = new ArrayList();
		try {
			
			// 1.获取连接
			conn = JdbcUtils.getDb_configConnection();

			// String sql = "insert into test(xData,yData) values(?,?)";
			String sql = "select * from test order by id desc limit 5";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int xData = rs.getInt("xData");
				int yData = rs.getInt("yData");
				
				System.out.println(xData);
				System.out.println(yData);
				xDataList.add(xData);
				yDataList.add(yData);
				
			}
			for(int i = 0;i < xDataList.size();i++) {
				System.out.println("x轴数据为：" + xDataList.get(i));
				System.out.println("y轴数据为：" + yDataList.get(i));
			}
			map.put("xDataList", xDataList);
			map.put("yDataList", yDataList);
			
			response.setContentType("text/json; charset=utf-8");
			JSONObject jsonObj1 = new JSONObject();

			jsonObj1.putAll(map);
			response.getWriter().println(jsonObj1.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
