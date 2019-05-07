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

import com.neudeu.STU.Read;
import com.neudeu.STU.StudentManager;
import com.neudeu.STU.Inquire;

public class Inquire {
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
	public List<StudentManager> queryAllAccount()
	{
		String url = prop.getProperty("url");
		Connection con =null;
		PreparedStatement prepareStatement = null;
		ResultSet rs =null;
		//创建集合
		List<StudentManager> accounts = new ArrayList<>();
		try {
			//建立连接
			 con = DriverManager.getConnection(url, prop.getProperty("username"), prop.getProperty("password"));
			//定义SQL语句
			String str = "SELECT * FROM StudentManager";
			//预编译SQL语句
			 prepareStatement = con.prepareStatement(str);
			//执行SQL操作
			 rs = prepareStatement.executeQuery();
			//判断是否有元素
			while(rs.next())
			{
				//拿到每一列的值
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String Cid = rs.getString("Cid");
				
				//新建account
				StudentManager stu = new StudentManager(id,name,age,sex,Cid);
				accounts.add(stu);
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
		return accounts;
	}
	
	
	
	public static void main(String[] args) {
		List<StudentManager> queryAllAccount = new Inquire().queryAllAccount();
		System.out.println(queryAllAccount);
	}
}
