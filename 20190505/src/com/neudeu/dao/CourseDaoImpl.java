package com.neudeu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neudeu.entity.Course;
import com.neudeu.entity.Student;

public class CourseDaoImpl implements CourseDao {
	private Connection conn;
	public CourseDaoImpl(Connection conn) 
	{
		this.conn = conn;
	}
	//����
	@Override
	public void addOneCourse(Course course) {
		String sql = "INSERT INTO cou VALUES (?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			pstmt.setInt(1, course.getcId());
			pstmt.setString(2, course.getcName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//�޸�
	@Override
	
	public void updateOneCourse(Course course) {
		String sql = "UPDATE cou SET cName=? WHERE cId = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, course.getcName());
			pstmt.setInt(2, course.getcId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//ɾ��
	@Override
	public void delOneCourse(Integer cId) {
		String sql = "DELETE FROM cou WHERE cId=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cId);
			int executeUpdate = pstmt.executeUpdate();
			if(executeUpdate != 0) {
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//��ѯ
	@Override
	public List<Course> getAllCourse(){
		List<Course> cou = new ArrayList<>();
		String sql = "SELECT * FROM cou";
		try (PreparedStatement ps = conn.prepareStatement(sql);){
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("cId");
				String name = rs.getString("cName");
				Course course = new Course(id,name);
				cou.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cou;
	}
	//ͨ���γ̺ţ���ӡ��ǰ�γ�����ѧ����Ϣ
	@Override
	public List<Student> getStudentInfoBycId(Integer cId) {
		List<Student> students = new ArrayList<Student>();
		String sql = "SELECT * FROM stu s JOIN stuandcou sd ON s.sId = sd.sId WHERE cId = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);){
			
			pstmt.setInt(1, cId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("sId");
				String name = rs.getString("sName");
				int age = rs.getInt("sAge");
				String sex = rs.getString("sSex");
				Student student = new Student(id, name, age, sex);
				students.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
		
	}
	//���ѡ���ſγ̵�ѧ��
	@Override
	public void addStudentInfoByCouId(int cId, int sId) {
		String sql = "INSERT INTO stuandcou(sId,cId) VALUES(?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setInt(1, sId);
			pstmt.setInt(2, cId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//ɾ��ѡ�����ſγ̵�ѧ��
	@Override
	public void deleteStudentInfoByCouId(int cId) {
		String sql = "DELETE FROM stuandcou WHERE cId=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setInt(1, cId);
			int executeUpdate = pstmt.executeUpdate();
			if(executeUpdate != 0) {
				System.out.println("ɾ���ɹ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	
	

	

}
