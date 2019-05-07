package com.neudeu.STU;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class CidIncrease {
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
		public static void main(String[] args) {
			CourseManager cou = new CourseManager(3,"JAVA");
			 new CidIncrease().CidIncrease(cou);
		}
		//�������
		public void CidIncrease(CourseManager cou) 
		{
			//ִ��SQL���
			String str = "INSERT INTO CourseManager VALUES (?,?)";
			//�õ�����
			try(Connection conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
				 PreparedStatement prepareStatement = conn.prepareStatement(str);) {

				//��ֵ
				prepareStatement.setInt(1,cou.getCid());
				prepareStatement.setString(2,cou.getCname());
				//��Ӱ�������
				int executeUpdate = prepareStatement.executeUpdate();
				if(executeUpdate != 0)
				{
					System.out.println("��ӳɹ�");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
