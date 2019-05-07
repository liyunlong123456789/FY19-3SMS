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
			//��������
			Connection conn = DriverManager.getConnection(url,"root","123456");
			//����SQL���
			String str = "SELECT * FROM account";
			//Ԥ����SQL���
			PreparedStatement prepareStatement = conn.prepareStatement(str);
			//ִ��SQL���
			ResultSet rs = prepareStatement.executeQuery();
			//�ж��Ƿ���Ԫ��
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
