package com.yuqixian.servlet;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuqixian.entity.ChannelData;
import com.yuqixian.utils.JdbcUtils;

import net.sf.json.JSONObject;

@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 全局参数
	 */
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		/*SimpleDateFormat sf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("开始时间为：" + startTime);
		System.out.println("结束时间为：" + endTime);*/
	    
		
		Map<String, Object> map = new HashMap<String, Object>();

		List xDataList = new ArrayList();
		List yDataList = new ArrayList();
		
		List<ChannelData> list = new ArrayList<ChannelData>();
		try {
			
			String startTime = request.getParameter("begin");
			String endTime = request.getParameter("end");
			/*Date date1 = sf.parse(startTime);
			long x = date1.getTime();
			Date date2 = sf.parse(endTime);
			long y = date2.getTime();
			Timestamp start = new Timestamp(x);
			Timestamp end = new Timestamp(y);*/
			
			conn = JdbcUtils.getDb_machine_1_1Connection();

			/*long z = start.getTime();*/
			/*String startTime = "2017-11-24 00:00:00";
			String endTime = "2017-11-30 00:00:00";*/
			String sql = "select * from t_vibra_data_ht_2 where Timestamp between '"+startTime+"' and '"+endTime+"'";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				ChannelData channelData = new ChannelData();
				channelData.setTimestamp(rs.getTimestamp("Timestamp")
						.getTime());
				System.out.println("时间为" + rs.getTimestamp("Timestamp")
						.getTime());
				
				channelData.setMillisecond(rs.getInt("Millisecond"));
				channelData.setSpeed(rs.getFloat("Speed")); // 转速
				channelData.setGap(rs.getFloat("Gap")); // 间隙电压
				channelData.setDirect(rs.getFloat("Direct")); // 通频值
				channelData.setAmplitude_1X(rs.getFloat("Amplitude_1X")); // 1倍频幅值
				channelData.setPhase_1X(rs.getFloat("Phase_1X")); // 1倍频相位
				channelData.setAmplitude_2X(rs.getFloat("Amplitude_2X")); // 可选倍频幅值
				channelData.setPhase_2X(rs.getFloat("Phase_2X")); // 可选倍频相位
				channelData.setAmplitude_3X(rs.getFloat("Amplitude_3X")); // 可选倍频幅值
				channelData.setPhase_3X(rs.getFloat("Phase_3X")); // 可选倍频相位
				// blob wave
				Blob blobWave = (Blob) rs.getBlob("Wave");
				int waveLength = rs.getInt("WaveLength");
				byte btWave[] = new byte[waveLength];
				btWave = blobWave.getBytes((long) 1, waveLength);
				channelData.setWave(btWave);
				channelData.setWaveLength(waveLength);
				// blob spectrum
				Blob blobSpectrum = (Blob) rs.getBlob("Spectrum");
				int spectrumLength = rs.getInt("SpectrumLength");
				byte btSpectrum[] = new byte[spectrumLength];
				btSpectrum = blobSpectrum.getBytes((long) 1,
						spectrumLength);
				channelData.setSpectrum(btSpectrum);
				channelData.setSpectrumLength(spectrumLength);
				// read 阶比
				channelData.setSampleRateOrder(rs.getInt("SampleRateOrder"));
				channelData.setDeltaOrder(rs.getFloat("DeltaOrder"));
				// 存入列表
				list.add(channelData);
				System.out.println("list的长度为：" + list.size());
			}
			
			System.out.println("list的长度为：" + list.size());
			
			for(int i = 0;i < list.size();i++) {
				System.out.println("时间戳为：" + list.get(i).getTimestamp());
			}
			for (int i = 0; i < xDataList.size(); i++) {
				System.out.println("x轴数据为：" + xDataList.get(i));
				System.out.println("y轴数据为：" + yDataList.get(i));
			}
			map.put("xDataList", xDataList);
			map.put("yDataList", yDataList);

			response.setContentType("text/json; charset=utf-8");
			JSONObject jsonObj1 = new JSONObject();

			jsonObj1.putAll(map);
			response.getWriter().println(jsonObj1.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
