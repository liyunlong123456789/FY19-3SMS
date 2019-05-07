package com.neudeu.Client;

import java.util.Scanner;
public class Client {
	//创建学生管理类对象
		StudentManager sm = new StudentManager();
		//创建课程管理类对象
		CourseManager cm = new CourseManager();
		//创建本类对象
		static Client client = new Client();
		//创建流对象
		Scanner sca = new Scanner(System.in);

		//主函数
		public static void main(String[] args) {
			System.out.println("系统正在初始化.....");
			System.out.println("学校创建成功");
			//选择操作
			client.stuManagerIndex();
		}

		//退出系统方法
			public void exitSystem() {
				System.exit(0);
			}
		
		//学生管理首页
		
		public void stuManagerIndex() {
			System.out.println("****************请选择要操作的信息对应的数字****************");
			System.out.println("1.学生信息管理          2.课程信息管理       3.退出");
			System.out.println("************************************************************");
			System.out.println("请选择:");
			int nextInt = sca.nextInt();
			switch (nextInt) {
			//学生信息管理
			case 1:
				sm.checkStudentPage(sca);
				break;
			//课程信息管理
			case 2:
				cm.checkCourse(sca);
				break;	
			//退出	
			case 3:
				System.out.println("已退出");
				exitSystem();
				break;
			default:
				System.out.println("输入有误,请重新输入");
				stuManagerIndex();
				break;
			}
		}
	}


