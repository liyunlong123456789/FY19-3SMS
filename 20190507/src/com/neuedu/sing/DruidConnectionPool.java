package com.neuedu.sing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidConnectionPool {
	//构造器私有化
	private DruidConnectionPool() 
	{
		
	}
	//持有对自身的引用
	private static DruidConnectionPool druid;
	//提供拿到公有的方法
	public static DruidConnectionPool getPool() 
	{
		if(null == druid)
		{
			druid = new DruidConnectionPool();
		}
		return druid;
	}
	//声明连接池的配置文件
	private static Properties prop;
	//声明一个DataSource引用
	private static DataSource ds;
	
	static
	{
		prop = new Properties();
		try {
			prop.load(DruidConnectionPool.class.getResourceAsStream("/dataSource.properties"));
			ds = DruidDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	//创建得到连接的方法
	public Connection getConnection() 
	{
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
