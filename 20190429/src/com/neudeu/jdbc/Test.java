package com.neudeu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		String url = "jdbc:mysql:///myemployees";
		try {
			//建立连接
			Connection conn = DriverManager.getConnection(url,"root","123456");
			//定义SQL语句
			String str = "SELECT * FROM account";
			//预编译SQL语句
			PreparedStatement prepareStatement = conn.prepareStatement(str);
			//执行SQL语句
			ResultSet rs = prepareStatement.executeQuery();
			//判断是否有元素
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double deposit = rs.getDouble("deposit");
				System.out.print(id);
				System.out.print(name);
				System.out.print(deposit);
				System.out.println();
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
