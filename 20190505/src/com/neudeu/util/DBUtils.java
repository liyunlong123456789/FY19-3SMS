package com.neudeu.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/*
  * ������
 */

public class DBUtils {
	//�����ļ�����
	private static Properties prop ;
	static
	{
		prop = new Properties();
		try {
			prop.load(DBUtils.class.getResourceAsStream("/settings.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�õ������ļ��е�url
	private static final String URL = prop.getProperty("url");
	//�õ������ļ��е�username
	private static final String USERNAME = prop.getProperty("username");
	//�õ������ļ��е�password
	private static final String PASSWORD = prop.getProperty("password");
	//��ȡ����
	public static Connection getConnection() 
	{
		Connection connection =null;
		try 
		{
			 connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
