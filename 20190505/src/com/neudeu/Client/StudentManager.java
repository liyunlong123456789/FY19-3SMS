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
	//创建获取连接对象
	Connection connection = DBUtils.getConnection();
	StudentDaoImpl sdi = new StudentDaoImpl(connection);
	
	//学生管理功能界面
	public void checkStudentPage(Scanner scanner) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+1.增加学生  2.修改学生  3.删除学生  4.查询学生  5.打印学生  6.通过学生学号,查询选课情况   7.返回主界面  8.系统退出 ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("请选择菜单:");
		int nextInt = scanner.nextInt();	
		switch (nextInt) {
		//增加学生
		case 1:
			addOneStudentPage(scanner);
			System.out.println("数据添加完毕,系统自动返回目录......");
			checkStudentPage(scanner);
			break;
		//根据id查询学生信息
		case 2:
			//修改学生信息
			updateOneStudentPage(scanner);
			System.out.println("数据修改完毕,系统自动返回目录......");
			checkStudentPage(scanner);
			break;
			//根据id查询学生姓名	
		case 3:
			//删除学生
			deleteOneStudentPage(scanner);
			System.out.println("删除成功,返回上一级");
			checkStudentPage(scanner);
			break;
	
		case 4:
			//查询所有学生
			List<Student> allStudent = sdi.getAllStudent();
			for (int i = 0; i < allStudent.size(); i++) {
				System.out.println("学号:" + allStudent.get(i).getsId() + "  姓名:" + allStudent.get(i).getsName() + "  年龄:"
						+ allStudent.get(i).getsAge() + "  性别:" + allStudent.get(i).getsSex());
			}
			System.out.println("查询成功,返回上一级");
			checkStudentPage(scanner);
			break;

		case 5:
			//打印学生	(根据id查询)
			getStudentInfoByStuIdPage(scanner);
			System.out.println("打印学生信息成功,返回上一级");
			checkStudentPage(scanner);
			break;
		case 6:
			//通过学生学号,查询选课情况
			getCourseInfoByStuIdPage(scanner);
			System.out.println("打印课程信息成功,返回上一级");
			checkStudentPage(scanner);
			break;
		case 7:
			//返回主界面
			Client c = new Client();
			c.stuManagerIndex();
			break;
		case 8:
			//退出系统
			System.out.println("系统退出成功");
			return;
			
		default:
			System.out.println("输入有误,请重新输入");
			checkStudentPage(scanner);
			break;
		}
	
	}
	
	
	//添加学生界面
	public void addOneStudentPage(Scanner scanner) {
		System.out.println("请输入添加学生的ID");
		String id = scanner.next();
		System.out.println("请输入添加学生的姓名");
		String name = scanner.next();
		System.out.println("请输入添加学生的年龄");
		int age = scanner.nextInt();
		while(true) {
			if(age > 120 || age < 0 ) {
				System.out.println("年龄:"+age+"输入有误,请重新输入:");
				age = scanner.nextInt();
			}else {
				break;
			}	
		}
		System.out.println("请输入添加学生的性别");
		String sex = scanner.next();
		while(true) {
			if(!(sex.equals("男") || sex.equals("女"))) {
				System.out.println("性别:"+sex+"输入有误,请重新输入:");
				sex = scanner.next();
			}else {
				break;
			}	
		}
		Student stu = new Student(id, name, age, sex);
		sdi.addOneStudent(stu);
	}
	
	//删除学生界面
	public void deleteOneStudentPage(Scanner scanner) {
		System.out.println("请输入删除学生的id");
		int id = scanner.nextInt();
		sdi.delOneStuden("cId");
		
	}
	
	//修改学生界面
	public void updateOneStudentPage(Scanner scanner) {
			
		System.out.println("请输入修改学生的ID");
		String id = scanner.next();
		System.out.println("请输入修改后的姓名");
		String name = scanner.next();
		System.out.println("请输入修改后的年龄");
		int age = scanner.nextInt();
		while(true) {
			if(age > 120 || age < 0 ) {
				System.out.println("年龄:"+age+"输入有误,请重新输入:");
				age = scanner.nextInt();
			}else {
				break;
			}	
		}
		System.out.println("请输入修改后的性别");
		String sex = scanner.next();
		while(true) {
			if(!(sex.equals("男") || sex.equals("女"))) {
				System.out.println("性别:"+sex+"输入有误,请重新输入:");
				sex = scanner.next();
			}else {
				break;
			}	
		}
		Student student = new Student(id, name, age, sex);
		sdi.updateOneStudent(student);
	}
	//打印学生(根据id查询学生)
	public void getStudentInfoByStuIdPage(Scanner scanner) {
		System.out.println("请输入打印学生的学号");
		String stuid = scanner.next();
		Student stu = sdi.getStudentInfoBysId(stuid);
		System.out.println("学号:" + stu.getsId() + "  姓名:" + stu.getsName() + "  年龄:"
				+ stu.getsAge() + "  性别:" + stu.getsSex());		
	}
	//通过学生学号,查询选课情况界面
	public void getCourseInfoByStuIdPage(Scanner scanner){
		System.out.println("请输入查询学生的学号");
		String stuid = scanner.next();
		List<String> cours = sdi.getCourseInfoBysId(stuid);
		for (String string : cours) {
			System.out.println("学号为"+stuid+"的学生选修的科目包括"+string);
		}
		
	}
}
