package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		List<Student> studentList = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select stu_no as stuNo, stu_name as stuName, stu_sex as stuSex, "
					+ "stu_brithday as stuBrithday, cla_no as claNo from shl_student";
			rs = conn.createStatement().executeQuery(sql);
			studentList = new BeanListHandler<>(Student.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt, rs);
		}
		return studentList;
	}

	@Override
	public boolean AddStudent(Student stu) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "insert into shl_student values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,stu.getClaNo());
			pstmt.setString(2, stu.getStuName());
			pstmt.setString(3,stu.getStuSex());
			pstmt.setString(4,stu.getStuBirthday());
			pstmt.setString(5,stu.getClaNo());
			return pstmt.executeUpdate(sql)>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

	@Override
	public boolean DeleteStudent(int id) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "delete from shl_student where stu_no=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

	@Override
	public boolean UpdateStudent(Student stu) {
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
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

}
