package com.neudeu.STU;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CourseInquire {
	private static Properties prop ;
	//��̬�����
	static
	{
		prop = new Properties();
		try {
			prop.load(Read.class.getResourceAsStream("/settings.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<CourseManager> queryAll()
	{
		String url = prop.getProperty("url");
		Connection con =null;
		PreparedStatement prepareStatement = null;
		ResultSet rs =null;
		//��������
		List<CourseManager> course = new ArrayList<>();
		try {
			//��������
			 con = DriverManager.getConnection(url, prop.getProperty("username"), prop.getProperty("password"));
			//����SQL���
			String str = "SELECT * FROM CourseManager";
			//Ԥ����SQL���
			 prepareStatement = con.prepareStatement(str);
			//ִ��SQL����
			 rs = prepareStatement.executeQuery();
			//�ж��Ƿ���Ԫ��
			while(rs.next())
			{
				//�õ�ÿһ�е�ֵ
				int Cid = rs.getInt("Cid");
				String Cname = rs.getString("Cname");
				
				//�½�CourseManager
				CourseManager cou = new CourseManager(Cid,Cname);
				course.add(cou);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			if(null != rs)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null != prepareStatement)
			{
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null != con)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return course;
	}
	
	
	
	public static void main(String[] args) {
		List<CourseManager> queryAll = new CourseInquire().queryAll();
		System.out.println(queryAll);
	}
}
