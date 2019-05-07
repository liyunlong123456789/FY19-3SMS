package com.neuedu.sing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidConnectionPool {
	//������˽�л�
	private DruidConnectionPool() 
	{
		
	}
	//���ж����������
	private static DruidConnectionPool druid;
	//�ṩ�õ����еķ���
	public static DruidConnectionPool getPool() 
	{
		if(null == druid)
		{
			druid = new DruidConnectionPool();
		}
		return druid;
	}
	//�������ӳص������ļ�
	private static Properties prop;
	//����һ��DataSource����
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
	//�����õ����ӵķ���
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
