package com.neudeu.Client;

import java.util.Scanner;
public class Client {
	//����ѧ�����������
		StudentManager sm = new StudentManager();
		//�����γ̹��������
		CourseManager cm = new CourseManager();
		//�����������
		static Client client = new Client();
		//����������
		Scanner sca = new Scanner(System.in);

		//������
		public static void main(String[] args) {
			System.out.println("ϵͳ���ڳ�ʼ��.....");
			System.out.println("ѧУ�����ɹ�");
			//ѡ�����
			client.stuManagerIndex();
		}

		//�˳�ϵͳ����
			public void exitSystem() {
				System.exit(0);
			}
		
		//ѧ��������ҳ
		
		public void stuManagerIndex() {
			System.out.println("****************��ѡ��Ҫ��������Ϣ��Ӧ������****************");
			System.out.println("1.ѧ����Ϣ����          2.�γ���Ϣ����       3.�˳�");
			System.out.println("************************************************************");
			System.out.println("��ѡ��:");
			int nextInt = sca.nextInt();
			switch (nextInt) {
			//ѧ����Ϣ����
			case 1:
				sm.checkStudentPage(sca);
				break;
			//�γ���Ϣ����
			case 2:
				cm.checkCourse(sca);
				break;	
			//�˳�	
			case 3:
				System.out.println("���˳�");
				exitSystem();
				break;
			default:
				System.out.println("��������,����������");
				stuManagerIndex();
				break;
			}
		}
	}


