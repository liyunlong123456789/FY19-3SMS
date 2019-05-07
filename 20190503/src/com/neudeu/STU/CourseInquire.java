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
	//静态代码块
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
		//创建集合
		List<CourseManager> course = new ArrayList<>();
		try {
			//建立连接
			 con = DriverManager.getConnection(url, prop.getProperty("username"), prop.getProperty("password"));
			//定义SQL语句
			String str = "SELECT * FROM CourseManager";
			//预编译SQL语句
			 prepareStatement = con.prepareStatement(str);
			//执行SQL操作
			 rs = prepareStatement.executeQuery();
			//判断是否有元素
			while(rs.next())
			{
				//拿到每一列的值
				int Cid = rs.getInt("Cid");
				String Cname = rs.getString("Cname");
				
				//新建CourseManager
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
