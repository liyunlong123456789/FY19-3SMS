package com.neudeu.Client;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.neudeu.dao.StudentDaoImpl;
import com.neudeu.entity.Student;
import com.neudeu.util.DBUtils;


public class StudentManager {
	static StudentManager sm = new StudentManager();
	//������ȡ���Ӷ���
	Connection connection = DBUtils.getConnection();
	StudentDaoImpl sdi = new StudentDaoImpl(connection);
	
	//ѧ�������ܽ���
	public void checkStudentPage(Scanner scanner) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+1.����ѧ��  2.�޸�ѧ��  3.ɾ��ѧ��  4.��ѯѧ��  5.��ӡѧ��  6.ͨ��ѧ��ѧ��,��ѯѡ�����   7.����������  8.ϵͳ�˳� ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("��ѡ��˵�:");
		int nextInt = scanner.nextInt();	
		switch (nextInt) {
		//����ѧ��
		case 1:
			addOneStudentPage(scanner);
			System.out.println("����������,ϵͳ�Զ�����Ŀ¼......");
			checkStudentPage(scanner);
			break;
		//����id��ѯѧ����Ϣ
		case 2:
			//�޸�ѧ����Ϣ
			updateOneStudentPage(scanner);
			System.out.println("�����޸����,ϵͳ�Զ�����Ŀ¼......");
			checkStudentPage(scanner);
			break;
			//����id��ѯѧ������	
		case 3:
			//ɾ��ѧ��
			deleteOneStudentPage(scanner);
			System.out.println("ɾ���ɹ�,������һ��");
			checkStudentPage(scanner);
			break;
	
		case 4:
			//��ѯ����ѧ��
			List<Student> allStudent = sdi.getAllStudent();
			for (int i = 0; i < allStudent.size(); i++) {
				System.out.println("ѧ��:" + allStudent.get(i).getsId() + "  ����:" + allStudent.get(i).getsName() + "  ����:"
						+ allStudent.get(i).getsAge() + "  �Ա�:" + allStudent.get(i).getsSex());
			}
			System.out.println("��ѯ�ɹ�,������һ��");
			checkStudentPage(scanner);
			break;

		case 5:
			//��ӡѧ��	(����id��ѯ)
			getStudentInfoByStuIdPage(scanner);
			System.out.println("��ӡѧ����Ϣ�ɹ�,������һ��");
			checkStudentPage(scanner);
			break;
		case 6:
			//ͨ��ѧ��ѧ��,��ѯѡ�����
			getCourseInfoByStuIdPage(scanner);
			System.out.println("��ӡ�γ���Ϣ�ɹ�,������һ��");
			checkStudentPage(scanner);
			break;
		case 7:
			//����������
			Client c = new Client();
			c.stuManagerIndex();
			break;
		case 8:
			//�˳�ϵͳ
			System.out.println("ϵͳ�˳��ɹ�");
			return;
			
		default:
			System.out.println("��������,����������");
			checkStudentPage(scanner);
			break;
		}
	
	}
	
	
	//���ѧ������
	public void addOneStudentPage(Scanner scanner) {
		System.out.println("���������ѧ����ID");
		String id = scanner.next();
		System.out.println("���������ѧ��������");
		String name = scanner.next();
		System.out.println("���������ѧ��������");
		int age = scanner.nextInt();
		while(true) {
			if(age > 120 || age < 0 ) {
				System.out.println("����:"+age+"��������,����������:");
				age = scanner.nextInt();
			}else {
				break;
			}	
		}
		System.out.println("���������ѧ�����Ա�");
		String sex = scanner.next();
		while(true) {
			if(!(sex.equals("��") || sex.equals("Ů"))) {
				System.out.println("�Ա�:"+sex+"��������,����������:");
				sex = scanner.next();
			}else {
				break;
			}	
		}
		Student stu = new Student(id, name, age, sex);
		sdi.addOneStudent(stu);
	}
	
	//ɾ��ѧ������
	public void deleteOneStudentPage(Scanner scanner) {
		System.out.println("������ɾ��ѧ����id");
		int id = scanner.nextInt();
		sdi.delOneStuden("cId");
		
	}
	
	//�޸�ѧ������
	public void updateOneStudentPage(Scanner scanner) {
			
		System.out.println("�������޸�ѧ����ID");
		String id = scanner.next();
		System.out.println("�������޸ĺ������");
		String name = scanner.next();
		System.out.println("�������޸ĺ������");
		int age = scanner.nextInt();
		while(true) {
			if(age > 120 || age < 0 ) {
				System.out.println("����:"+age+"��������,����������:");
				age = scanner.nextInt();
			}else {
				break;
			}	
		}
		System.out.println("�������޸ĺ���Ա�");
		String sex = scanner.next();
		while(true) {
			if(!(sex.equals("��") || sex.equals("Ů"))) {
				System.out.println("�Ա�:"+sex+"��������,����������:");
				sex = scanner.next();
			}else {
				break;
			}	
		}
		Student student = new Student(id, name, age, sex);
		sdi.updateOneStudent(student);
	}
	//��ӡѧ��(����id��ѯѧ��)
	public void getStudentInfoByStuIdPage(Scanner scanner) {
		System.out.println("�������ӡѧ����ѧ��");
		String stuid = scanner.next();
		Student stu = sdi.getStudentInfoBysId(stuid);
		System.out.println("ѧ��:" + stu.getsId() + "  ����:" + stu.getsName() + "  ����:"
				+ stu.getsAge() + "  �Ա�:" + stu.getsSex());		
	}
	//ͨ��ѧ��ѧ��,��ѯѡ���������
	public void getCourseInfoByStuIdPage(Scanner scanner){
		System.out.println("�������ѯѧ����ѧ��");
		String stuid = scanner.next();
		List<String> cours = sdi.getCourseInfoBysId(stuid);
		for (String string : cours) {
			System.out.println("ѧ��Ϊ"+stuid+"��ѧ��ѡ�޵Ŀ�Ŀ����"+string);
		}
		
	}
}
