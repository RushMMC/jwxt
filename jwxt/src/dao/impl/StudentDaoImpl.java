package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.StudentDao;
import entity.Student;
import util.DBCPUtil;

public class StudentDaoImpl implements StudentDao{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	@Override
	public List<Student> FetchAllStudents() {
		List<Student> studentList = new ArrayList<Student>();
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select*from shl_student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				studentList = new BeanListHandler<>(Student.class).handle(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public int AddStudent(Student stu) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "insert into shl_student values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,stu.getClaNo());
			pstmt.setString(2, stu.getStuName());
			pstmt.setString(3,stu.getStuSex());
			
			pstmt.setString(4,stu.getStuBirthday());
			pstmt.setString(5,stu.getClaNo());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(stu.getStuNo());
	}

	@Override
	public boolean DeleteStudent(int id) {
		int num = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "delete from shl_student where stu_no=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			num = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num > 0;
	}

	@Override
	public boolean UpdateStudent(Student stu) {
		int num = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "update set shl_student "
					     +"stu_name=?,stu_sex=?,stu_birthday=?,cla_no=?"
					     + "where stu_no=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,stu.getStuName());
			pstmt.setString(2,stu.getStuSex());
			pstmt.setString(3,stu.getStuBirthday());
			pstmt.setString(4,stu.getClaNo());
			pstmt.setString(5,stu.getStuName());
			
			num = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num > 0;
	}

}
