package com.neudeu.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/*
  * 工具类
 */

public class DBUtils {
	//配置文件对象
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
	//拿到配置文件中的url
	private static final String URL = prop.getProperty("url");
	//拿到配置文件中的username
	private static final String USERNAME = prop.getProperty("username");
	//拿到配置文件中的password
	private static final String PASSWORD = prop.getProperty("password");
	//获取连接
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
