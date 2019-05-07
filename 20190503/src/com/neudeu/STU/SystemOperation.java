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
		System.out.println("ϵͳ���ڳ�ʼ��....");
		System.out.println("ѧУ����ѧ��");
		SystemOperation sys = new SystemOperation();
		//��ʼ��ѧ��
		List<StudentManager> stu = sys.queryAllAccount();
		for(int i = 0;i <stu.size();i++)
		{
			System.out.println("  ѧ�ţ�"+ stu.get(i).getId()+"  ������"+ stu.get(i).getName()+ "  ���䣺"+ stu.get(i).getAge()
					+ "  �Ա�"+ stu.get(i).getSex()+ "  �γ̺ţ�"+ stu.get(i).getCid());
		}
		List<CourseManager> que = sys.queryAll();
		for(int i = 0; i<que.size();i++)
		{
			System.out.println("�γ�ID��"+ que.get(i).getCid()+"   �γ����ƣ�"+ que.get(i).getCname());
		}
	}
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
	public List<StudentManager> queryAllAccount()
	{
		String url = prop.getProperty("url");
		Connection con =null;
		PreparedStatement prepareStatement = null;
		ResultSet rs =null;
		//��������
		List<StudentManager> accounts = new ArrayList<>();
		try {
			//��������
			 con = DriverManager.getConnection(url, prop.getProperty("username"), prop.getProperty("password"));
			//����SQL���
			String str = "SELECT * FROM StudentManager";
			//Ԥ����SQL���
			 prepareStatement = con.prepareStatement(str);
			//ִ��SQL����
			 rs = prepareStatement.executeQuery();
			//�ж��Ƿ���Ԫ��
			while(rs.next())
			{
				//�õ�ÿһ�е�ֵ
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String Cid = rs.getString("Cid");
				
				//�½�account
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
}
