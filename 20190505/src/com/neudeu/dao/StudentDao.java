package com.neudeu.dao;

import java.util.List;

import com.neudeu.entity.Course;
import com.neudeu.entity.Student;

public interface StudentDao {
	//����ѧ��
	void addOneStudent(Student student);
	
	//�޸�ѧ��
	void updateOneStudent(Student student);
	//ɾ��ѧ��
	void delOneStuden(String sId);
	
	//��ѯ����ѧ��
	List<Student> getAllStudent();
	
	//����ID��ѯѧ��
	Student getStudentInfoBysId(String sId);
	//ͨ��ѧ��ѧ�Ų�ѯ�γ̵���Ϣ
	List<String> getCourseInfoBysId(String sId);
	
}
