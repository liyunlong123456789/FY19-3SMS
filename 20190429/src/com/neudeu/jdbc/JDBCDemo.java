package com.neudeu.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCDemo {
	private static Properties prop ;
	//��̬�����
	static
	{
		prop = new Properties();
		try {
			prop.load(ReadPro.class.getResourceAsStream("/settings.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Account> queryAllAccount()
	{
		String url = prop.getProperty("url");
		Connection con =null;
		PreparedStatement prepareStatement = null;
		ResultSet rs =null;
		//��������
		List<Account> accounts = new ArrayList<>();
		try {
			//��������
			 con = DriverManager.getConnection(url, prop.getProperty("username"), prop.getProperty("password"));
			//����SQL���
			String str = "SELECT * FROM account";
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
				double deposit = rs.getDouble("deposit");
				//�½�account
				Account account = new Account(id,name,deposit);
				accounts.add(account);
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
		List<Account> queryAllAccount = new JDBCDemo().queryAllAccount();
		System.out.println(queryAllAccount);
	}
}
