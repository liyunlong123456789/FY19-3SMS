package com.neudeu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neudeu.entity.Course;
import com.neudeu.entity.Student;
/*
 * 接口实现
 */
public class StudentDaoImpl implements StudentDao {
	private Connection conn;
	public StudentDaoImpl(Connection conn) 
	{
		this.conn = conn;
	}
	//添加
	@Override
	public void addOneStudent(Student student) {
		String sql = "INSERT INTO stu VALUES (?,?,?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			pstmt.setString(1, student.getsId());
			pstmt.setString(2, student.getsName());
			pstmt.setInt(3, student.getsAge());
			pstmt.setString(4, student.getsSex());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//修改
	@Override
	public void updateOneStudent(Student student) {
		String sql = "UPDATE stu SET sName = ?,sAge = ?,sSex = ? WHERE sId = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			pstmt.setString(1, student.getsName());
			pstmt.setInt(2, student.getsAge());
			pstmt.setString(3, student.getsSex());
			pstmt.setString(4, student.getsId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//删除
	@Override
	public void delOneStuden(String sId) {
		String sql = "DELETE FROM stu WHERE sId = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			pstmt.setString(1, sId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//查询
	@Override
	public List<Student> getAllStudent() {
		List<Student> stu = new ArrayList<>();
		String sql = "SELECT * FROM stu";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();)
		{
			
			while(rs.next()) 
			{
				String id = rs.getString("sId");
				String sName = rs.getString("sName");
				int sAge = rs.getInt("sAge");
				String sSex = rs.getString("sSex");
				Student string = new Student(id,sName,sAge,sSex);
				stu.add(string);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}
	//根据ID查询
	@Override
	public Student getStudentInfoBysId(String sId) 
	{
		String sql = "SELECT * FROM stu WHERE sId = ?";
		Student student = new Student();
		try (PreparedStatement pstmt = conn.prepareStatement(sql);
				)
		{
			pstmt.setString(1, sId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				String id = rs.getString("sId");
				String sName = rs.getString("sName");
				int sAge = rs.getInt("sAge");
				String sSex = rs.getString("sSex");
				Student string = new Student(id,sName,sAge,sSex);
				return string;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
//	通过学生学号查询课程信息
	@Override
	public List<String> getCourseInfoBysId(String sId) {
		List<String> cName = new ArrayList<String>();
		String sql = "SELECT cName FROM stuandcou JOIN cou ON stuandcou.cId = cou.cId WHERE sId = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);
				)
		{
			pstmt.setString(1, sId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				String string = rs.getString("cName");
				cName.add(string);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cName;
	}



}

