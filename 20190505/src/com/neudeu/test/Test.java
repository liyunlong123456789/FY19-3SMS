package com.neudeu.test;

import java.sql.Connection;
import java.util.List;

import com.neudeu.dao.CourseDao;
import com.neudeu.dao.CourseDaoImpl;
import com.neudeu.dao.StudentDao;
import com.neudeu.dao.StudentDaoImpl;
import com.neudeu.entity.Course;
import com.neudeu.entity.Student;
import com.neudeu.util.DBUtils;

public class Test {
	public static void main(String[] args) {
		Connection connection = DBUtils.getConnection();
//		StudentDao sd = new StudentDaoImpl(connection);
//		学生管理
		// 增加
//		Student student = new Student("1", "小李", 18, "男");
//		sd.addOneStudent(student);
//		System.out.println("增加成功");
		// 通过学生学号查询课程信息
//		List<String> courseInfoBysId = sd.getCourseInfoBysId("1");
//		System.out.println(courseInfoBysId);
		//修改
//		Student student = new Student("1","小明",24,"女");
//		sd.updateOneStudent(student);
//		System.out.println("修改成功");
		//删除
//		sd.delOneStuden("4");
//		System.out.println("删除成功");
		//查询
//		List<Student> allStudent = sd.getAllStudent();
//		System.out.println(allStudent);
		//根据ID查询
//		Student studentInfoBysId = sd.getStudentInfoBysId("2");
//		System.out.println(studentInfoBysId);
		
//		课程管理
		CourseDao cd = new CourseDaoImpl(connection);
		//增加
//		Course course = new Course(5, "javaSE");
//		cd.addOneCourse(course);
		//修改
//		Course course = new Course(5, "javaEE");
//		cd.updateOneCourse(course);
		//删除
//		cd.delOneCourse(5);
//		System.out.println("删除成功");
		//查询
//		List<Course> allCourse = cd.getAllCourse();
//		System.out.println(allCourse);
		//通过课程号，打印当前课程下面学生信息
//		List<Student> studentInfoBycId = cd.getStudentInfoBycId(1);
//		System.out.println(studentInfoBycId);
		//添加选这门课程的学生
//		cd.addStudentInfoByCouId(1, 2);
		//删除选择这门课程的学生
//		cd.deleteStudentInfoByCouId(1);
	}
	
}