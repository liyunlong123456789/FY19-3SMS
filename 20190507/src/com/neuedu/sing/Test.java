package com.neuedu.sing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
//		DruidConnectionPool pool = DruidConnectionPool.getPool();
//		Connection connection = pool.getConnection();
//		try {
//			PreparedStatement prepareStatement = connection.prepareStatement("select * from student");
//			ResultSet rs = prepareStatement.executeQuery();
//			while(rs.next()) 
//			{
//				System.out.println(rs.getString("sName"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//µ¥Ïß³Ì
		Boos boosInstance = Boos.getBoosInstance();
		Boos boosInstance2= Boos.getBoosInstance();
		System.out.println(boosInstance == boosInstance2);
		
		
	}
}
