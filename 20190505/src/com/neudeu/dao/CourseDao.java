package com.neudeu.dao;

import java.util.List;

import com.neudeu.entity.Course;
import com.neudeu.entity.Student;

public interface CourseDao {
	//增加课程
	void addOneCourse(Course course);
	//修改课程
	void updateOneCourse(Course course);
	//删除课程
	void delOneCourse(Integer cId);
	//查询
	List<Course> getAllCourse();
	//通过课程号，打印当前课程下面学生信息
	List<Student> getStudentInfoBycId(Integer cId);
	//添加选这门课程的学生
	void addStudentInfoByCouId(int cId,int sId);
	//删除选择这门课程的学生
	void deleteStudentInfoByCouId(int cId);
}
