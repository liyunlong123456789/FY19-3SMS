package com.neudeu.STU;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.neudeu.STU.Read;
import com.neudeu.STU.StudentManager;
import com.neudeu.STU.Increase;

public class Increase {
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
			StudentManager stu = new StudentManager(3,"����", 20,"Ů","3");
			 new Increase().increase(stu);
		}
		//�������
		public void increase(StudentManager stu) 
		{
			//ִ��SQL���
			String str = "INSERT INTO StudentManager VALUES (?,?,?,?,?)";
			//�õ�����
			try(Connection conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
				 PreparedStatement prepareStatement = conn.prepareStatement(str);) {

				//��ֵ
				prepareStatement.setInt(1,stu.getId());
				prepareStatement.setString(2,stu.getName());
				prepareStatement.setInt(3,stu.getAge());
				prepareStatement.setString(4,stu.getSex());
				prepareStatement.setString(5,stu.getCid());
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
