package com.neudeu.dao;

import java.util.List;

import com.neudeu.entity.Course;
import com.neudeu.entity.Student;

public interface StudentDao {
	//增加学生
	void addOneStudent(Student student);
	
	//修改学生
	void updateOneStudent(Student student);
	//删除学生
	void delOneStuden(String sId);
	
	//查询所有学生
	List<Student> getAllStudent();
	
	//根据ID查询学生
	Student getStudentInfoBysId(String sId);
	//通过学生学号查询课程的信息
	List<String> getCourseInfoBysId(String sId);
	
}
