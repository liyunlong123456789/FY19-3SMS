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
	//静态代码块
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
		//创建集合
		List<Account> accounts = new ArrayList<>();
		try {
			//建立连接
			 con = DriverManager.getConnection(url, prop.getProperty("username"), prop.getProperty("password"));
			//定义SQL语句
			String str = "SELECT * FROM account";
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
				double deposit = rs.getDouble("deposit");
				//新建account
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
