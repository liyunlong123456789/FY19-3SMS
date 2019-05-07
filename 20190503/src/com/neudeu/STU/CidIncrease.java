package com.neudeu.STU;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class CidIncrease {
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
		public static void main(String[] args) {
			CourseManager cou = new CourseManager(3,"JAVA");
			 new CidIncrease().CidIncrease(cou);
		}
		//添加数据
		public void CidIncrease(CourseManager cou) 
		{
			//执行SQL语句
			String str = "INSERT INTO CourseManager VALUES (?,?)";
			//拿到连接
			try(Connection conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
				 PreparedStatement prepareStatement = conn.prepareStatement(str);) {

				//赋值
				prepareStatement.setInt(1,cou.getCid());
				prepareStatement.setString(2,cou.getCname());
				//受影响的行数
				int executeUpdate = prepareStatement.executeUpdate();
				if(executeUpdate != 0)
				{
					System.out.println("添加成功");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
