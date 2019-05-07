package com.neudeu.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class AddOneAccount {
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
	public static void main(String[] args) {
		Account ac = new Account(3, "王五", 6000d);
		new AddOneAccount().addOneAccount(ac);
	}
	//添加数据
	public void addOneAccount(Account acc) 
	{
		//执行SQL语句
		String str = "INSERT INTO account VALUES (?,?,?)";
		//拿到连接
		try(Connection conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
			 PreparedStatement prepareStatement = conn.prepareStatement(str);) {

			//赋值
			prepareStatement.setInt(1,acc.getId());
			prepareStatement.setString(2,acc.getName());
			prepareStatement.setDouble(3,acc.getDeposit());
			//增删改属于更新操作    查询是查询操作
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
