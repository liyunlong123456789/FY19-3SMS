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
			StudentManager stu = new StudentManager(3,"苏苏", 20,"女","3");
			 new Increase().increase(stu);
		}
		//添加数据
		public void increase(StudentManager stu) 
		{
			//执行SQL语句
			String str = "INSERT INTO StudentManager VALUES (?,?,?,?,?)";
			//拿到连接
			try(Connection conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
				 PreparedStatement prepareStatement = conn.prepareStatement(str);) {

				//赋值
				prepareStatement.setInt(1,stu.getId());
				prepareStatement.setString(2,stu.getName());
				prepareStatement.setInt(3,stu.getAge());
				prepareStatement.setString(4,stu.getSex());
				prepareStatement.setString(5,stu.getCid());
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
