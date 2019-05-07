package com.neudeu.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class AddOneAccount {
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
	public static void main(String[] args) {
		Account ac = new Account(3, "����", 6000d);
		new AddOneAccount().addOneAccount(ac);
	}
	//�������
	public void addOneAccount(Account acc) 
	{
		//ִ��SQL���
		String str = "INSERT INTO account VALUES (?,?,?)";
		//�õ�����
		try(Connection conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
			 PreparedStatement prepareStatement = conn.prepareStatement(str);) {

			//��ֵ
			prepareStatement.setInt(1,acc.getId());
			prepareStatement.setString(2,acc.getName());
			prepareStatement.setDouble(3,acc.getDeposit());
			//��ɾ�����ڸ��²���    ��ѯ�ǲ�ѯ����
			//��Ӱ�������
			int executeUpdate = prepareStatement.executeUpdate();
			if(executeUpdate != 0)
			{
				System.out.println("��ӳɹ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
