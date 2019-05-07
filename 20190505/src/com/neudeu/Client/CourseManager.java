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

import com.neudeu.dao.CourseDaoImpl;
import com.neudeu.entity.Course;
import com.neudeu.entity.Student;
import com.neudeu.util.DBUtils;


public class CourseManager {
	//�������Ӷ���
		Connection connection = DBUtils.getConnection();
		CourseDaoImpl cdi = new CourseDaoImpl(connection);
		
		public void checkCourse(Scanner scanner) {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+1.���ӿγ�  2.�޸Ŀγ�  3.ɾ���γ�   4.��ѯ�γ�   5.ͨ���γ̺Ŵ�ӡѧ����Ϣ    6.���ѡ���ſγ̵�ѧ��  7.ɾ��ѡ���ſγ̵�ѧ��  8.����������  9.�˳�ϵͳ");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("��ѡ�����:");
			int nextInt = scanner.nextInt();
			switch (nextInt) {
			case 1:
				// ���ӿγ�
				addOneCoursePage(scanner);
				System.out.println("����������,ϵͳ�Զ�����Ŀ¼......");
				checkCourse(scanner);
				break;
			case 2:
				// �޸�����
				updateOneCoursePage(scanner);
				System.out.println("�����޸����,ϵͳ�Զ�����Ŀ¼......");
				checkCourse(scanner);
				break;
			case 3:
				// ɾ������
				deleteOneCoursePage(scanner);
				System.out.println("����ɾ�����,ϵͳ�Զ�����Ŀ¼......");
				checkCourse(scanner);
				break;
			case 4:
				// ��ѯ����
				getAllCoursePage(scanner);
				System.out.println("���ݲ�ѯ���,ϵͳ�Զ�����Ŀ¼......");
				checkCourse(scanner);
				break;
			case 5:
				//ͨ���γ̺Ŵ�ӡѧ����Ϣ
				getStudentInfoByCouIdPage(scanner);
				System.out.println("���ݲ��ӡ���,ϵͳ�Զ�����Ŀ¼......");
				checkCourse(scanner);
				break;
			case 6:
				//���ѡ���ſγ̵�ѧ��
				addStudentInfoByCouIdPage(scanner);
				System.out.println("����������,ϵͳ�Զ�����Ŀ¼......");
				checkCourse(scanner);
				break;
			case 7:
				//���ѡ���ſγ̵�ѧ��
				deleteStudentInfoByCouIdPage(scanner);
				System.out.println("����������,ϵͳ�Զ�����Ŀ¼......");
				checkCourse(scanner);
				break;
			case 8:
				//����������
				Client c = new Client();
				c.stuManagerIndex();
				break;
			case 9:
				//�˳�ϵͳ
				System.out.println("ϵͳ�˳��ɹ�");
				return;
			default:
				System.out.println("��������,����������");
				checkCourse(scanner);
				break;
			}
			

		}

		// ���ӿγ̽���
		public void addOneCoursePage(Scanner scanner) {
			System.out.println("��������ӿγ̵�ID");
			int id = scanner.nextInt();
			System.out.println("��������ӿγ���");
			String name = scanner.next();
			Course cou = new Course(id, name);
			cdi.addOneCourse(cou);
		}

		

		// �޸Ŀγ̽���
		public void updateOneCoursePage(Scanner scanner) {

			System.out.println("�������޸Ŀγ̵�ID");
			int id = scanner.nextInt();
			System.out.println("�������޸ĺ�Ŀγ���");
			String newName = scanner.next();
			Course course = new Course(id, newName);
			cdi.updateOneCourse(course);
		}

		
		// ɾ���γ̽���
		public void deleteOneCoursePage(Scanner scanner) {
			System.out.println("������ɾ���γ̵�id");
			int id = scanner.nextInt();
			cdi.deleteStudentInfoByCouId(id);

		}

		//��ѯ�γ̽���
		public void getAllCoursePage(Scanner scanner) {
			List<Course> allCourse = cdi.getAllCourse();
			for (int i = 0; i < allCourse.size(); i++) {
				System.out.println("�γ̺�:" + allCourse.get(i).getcId() + "  �γ�����:" + allCourse.get(i).getcName());
			}
		}
		//ͨ���γ̺Ŵ�ӡѧ����Ϣ
		public void getStudentInfoByCouIdPage(Scanner scanner){
			System.out.println("�������ѯ�γ̺�");
			int couid = scanner.nextInt();
			List<Student> studentInfoByCouId = cdi.getStudentInfoBycId(couid);
			for (int i = 0; i < studentInfoByCouId.size(); i++) {
				System.out.println("ѧ��:" + studentInfoByCouId.get(i).getsId() + "  ����:" + studentInfoByCouId.get(i).getsName() + "  ����:"
						+ studentInfoByCouId.get(i).getsAge() + "  �Ա�:" + studentInfoByCouId.get(i).getsSex());
			}
		}
		
		//���ѡ���ſγ̵�ѧ��
		public void addStudentInfoByCouIdPage(Scanner scanner){
			System.out.println("��������ѡ�γ�id");
			int cid = scanner.nextInt();
			System.out.println("���������ѧ��id");
			int sid = scanner.nextInt();
			cdi.addStudentInfoByCouId(cid, sid);
		}
		//ɾ��ѡ���ſε�ѧ��
		public void deleteStudentInfoByCouIdPage(Scanner scanner){
			System.out.println("��������Ҫɾ���Ŀγ�id");
			int cid = scanner.nextInt();
			cdi.deleteStudentInfoByCouId(cid);
		}
}
