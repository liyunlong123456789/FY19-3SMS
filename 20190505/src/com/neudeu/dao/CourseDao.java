package com.neudeu.dao;

import java.util.List;

import com.neudeu.entity.Course;
import com.neudeu.entity.Student;

public interface CourseDao {
	//���ӿγ�
	void addOneCourse(Course course);
	//�޸Ŀγ�
	void updateOneCourse(Course course);
	//ɾ���γ�
	void delOneCourse(Integer cId);
	//��ѯ
	List<Course> getAllCourse();
	//ͨ���γ̺ţ���ӡ��ǰ�γ�����ѧ����Ϣ
	List<Student> getStudentInfoBycId(Integer cId);
	//���ѡ���ſγ̵�ѧ��
	void addStudentInfoByCouId(int cId,int sId);
	//ɾ��ѡ�����ſγ̵�ѧ��
	void deleteStudentInfoByCouId(int cId);
}
