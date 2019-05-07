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
	//创建连接对象
		Connection connection = DBUtils.getConnection();
		CourseDaoImpl cdi = new CourseDaoImpl(connection);
		
		public void checkCourse(Scanner scanner) {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+1.增加课程  2.修改课程  3.删除课程   4.查询课程   5.通过课程号打印学生信息    6.添加选这门课程的学生  7.删除选这门课程的学生  8.返回主界面  9.退出系统");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("请选择操作:");
			int nextInt = scanner.nextInt();
			switch (nextInt) {
			case 1:
				// 增加课程
				addOneCoursePage(scanner);
				System.out.println("数据添加完毕,系统自动返回目录......");
				checkCourse(scanner);
				break;
			case 2:
				// 修改数据
				updateOneCoursePage(scanner);
				System.out.println("数据修改完毕,系统自动返回目录......");
				checkCourse(scanner);
				break;
			case 3:
				// 删除数据
				deleteOneCoursePage(scanner);
				System.out.println("数据删除完毕,系统自动返回目录......");
				checkCourse(scanner);
				break;
			case 4:
				// 查询数据
				getAllCoursePage(scanner);
				System.out.println("数据查询完毕,系统自动返回目录......");
				checkCourse(scanner);
				break;
			case 5:
				//通过课程号打印学生信息
				getStudentInfoByCouIdPage(scanner);
				System.out.println("数据查打印完毕,系统自动返回目录......");
				checkCourse(scanner);
				break;
			case 6:
				//添加选这门课程的学生
				addStudentInfoByCouIdPage(scanner);
				System.out.println("数据添加完毕,系统自动返回目录......");
				checkCourse(scanner);
				break;
			case 7:
				//添加选这门课程的学生
				deleteStudentInfoByCouIdPage(scanner);
				System.out.println("数据添加完毕,系统自动返回目录......");
				checkCourse(scanner);
				break;
			case 8:
				//返回主界面
				Client c = new Client();
				c.stuManagerIndex();
				break;
			case 9:
				//退出系统
				System.out.println("系统退出成功");
				return;
			default:
				System.out.println("输入有误,请重新输入");
				checkCourse(scanner);
				break;
			}
			

		}

		// 增加课程界面
		public void addOneCoursePage(Scanner scanner) {
			System.out.println("请输入添加课程的ID");
			int id = scanner.nextInt();
			System.out.println("请输入添加课程名");
			String name = scanner.next();
			Course cou = new Course(id, name);
			cdi.addOneCourse(cou);
		}

		

		// 修改课程界面
		public void updateOneCoursePage(Scanner scanner) {

			System.out.println("请输入修改课程的ID");
			int id = scanner.nextInt();
			System.out.println("请输入修改后的课程名");
			String newName = scanner.next();
			Course course = new Course(id, newName);
			cdi.updateOneCourse(course);
		}

		
		// 删除课程界面
		public void deleteOneCoursePage(Scanner scanner) {
			System.out.println("请输入删除课程的id");
			int id = scanner.nextInt();
			cdi.deleteStudentInfoByCouId(id);

		}

		//查询课程界面
		public void getAllCoursePage(Scanner scanner) {
			List<Course> allCourse = cdi.getAllCourse();
			for (int i = 0; i < allCourse.size(); i++) {
				System.out.println("课程号:" + allCourse.get(i).getcId() + "  课程名称:" + allCourse.get(i).getcName());
			}
		}
		//通过课程号打印学生信息
		public void getStudentInfoByCouIdPage(Scanner scanner){
			System.out.println("请输入查询课程号");
			int couid = scanner.nextInt();
			List<Student> studentInfoByCouId = cdi.getStudentInfoBycId(couid);
			for (int i = 0; i < studentInfoByCouId.size(); i++) {
				System.out.println("学号:" + studentInfoByCouId.get(i).getsId() + "  姓名:" + studentInfoByCouId.get(i).getsName() + "  年龄:"
						+ studentInfoByCouId.get(i).getsAge() + "  性别:" + studentInfoByCouId.get(i).getsSex());
			}
		}
		
		//添加选这门课程的学生
		public void addStudentInfoByCouIdPage(Scanner scanner){
			System.out.println("请输入所选课程id");
			int cid = scanner.nextInt();
			System.out.println("请输入添加学生id");
			int sid = scanner.nextInt();
			cdi.addStudentInfoByCouId(cid, sid);
		}
		//删除选这门课的学生
		public void deleteStudentInfoByCouIdPage(Scanner scanner){
			System.out.println("请输入你要删除的课程id");
			int cid = scanner.nextInt();
			cdi.deleteStudentInfoByCouId(cid);
		}
}
