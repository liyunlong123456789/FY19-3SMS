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

public class SystemOperation {
	public void SystemOperation() {
		System.out.println("系统正在初始化....");
		System.out.println("学校存有学生");
		SystemOperation sys = new SystemOperation();
		//初始化学生
		List<StudentManager> stu = sys.queryAllAccount();
		for(int i = 0;i <stu.size();i++)
		{
			System.out.println("  学号："+ stu.get(i).getId()+"  姓名："+ stu.get(i).getName()+ "  年龄："+ stu.get(i).getAge()
					+ "  性别："+ stu.get(i).getSex()+ "  课程号："+ stu.get(i).getCid());
		}
		List<CourseManager> que = sys.queryAll();
		for(int i = 0; i<que.size();i++)
		{
			System.out.println("课程ID："+ que.get(i).getCid()+"   课程名称："+ que.get(i).getCname());
		}
	}
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
		SystemOperation systemOperation = new SystemOperation();
		systemOperation.SystemOperation();
		
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
}
