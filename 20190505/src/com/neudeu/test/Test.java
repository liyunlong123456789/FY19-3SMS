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
//		ѧ������
		// ����
//		Student student = new Student("1", "С��", 18, "��");
//		sd.addOneStudent(student);
//		System.out.println("���ӳɹ�");
		// ͨ��ѧ��ѧ�Ų�ѯ�γ���Ϣ
//		List<String> courseInfoBysId = sd.getCourseInfoBysId("1");
//		System.out.println(courseInfoBysId);
		//�޸�
//		Student student = new Student("1","С��",24,"Ů");
//		sd.updateOneStudent(student);
//		System.out.println("�޸ĳɹ�");
		//ɾ��
//		sd.delOneStuden("4");
//		System.out.println("ɾ���ɹ�");
		//��ѯ
//		List<Student> allStudent = sd.getAllStudent();
//		System.out.println(allStudent);
		//����ID��ѯ
//		Student studentInfoBysId = sd.getStudentInfoBysId("2");
//		System.out.println(studentInfoBysId);
		
//		�γ̹���
		CourseDao cd = new CourseDaoImpl(connection);
		//����
//		Course course = new Course(5, "javaSE");
//		cd.addOneCourse(course);
		//�޸�
//		Course course = new Course(5, "javaEE");
//		cd.updateOneCourse(course);
		//ɾ��
//		cd.delOneCourse(5);
//		System.out.println("ɾ���ɹ�");
		//��ѯ
//		List<Course> allCourse = cd.getAllCourse();
//		System.out.println(allCourse);
		//ͨ���γ̺ţ���ӡ��ǰ�γ�����ѧ����Ϣ
//		List<Student> studentInfoBycId = cd.getStudentInfoBycId(1);
//		System.out.println(studentInfoBycId);
		//���ѡ���ſγ̵�ѧ��
//		cd.addStudentInfoByCouId(1, 2);
		//ɾ��ѡ�����ſγ̵�ѧ��
//		cd.deleteStudentInfoByCouId(1);
	}
	
}