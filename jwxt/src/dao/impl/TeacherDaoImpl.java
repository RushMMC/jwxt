package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.TeacherDao;
import util.DBCPUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import entity.Teacher;

public class TeacherDaoImpl implements TeacherDao {

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	@Override
	public List<Teacher> queryAllTeacher() {
		List<Teacher> teacherlist = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select * from shl_teacher";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			teacherlist = new BeanListHandler<>(Teacher.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst, rs);
		}
		return teacherlist;
	}

	@Override
	public Teacher queryTeacherByTeaNo(String teaNo) {
		Teacher teacher = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select * from shl_teacher where tea_no=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, teaNo);
			rs = pst.executeQuery();
			teacher = new BeanHandler<>(Teacher.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return teacher;
	}
	

	@Override
	public int addTeacher(Teacher tea) {
		int rows = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "insert into shl_teacher(tea_no,tea_name,tea_professional,dept_no) values(?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, tea.getTeacherNo());
			pst.setString(2, tea.getTeacherName());
			pst.setString(3, tea.getTeacherProfessional());
			pst.setString(4, tea.getDeptNo());
			rows = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return rows;
	}

	@Override
	public int updateTeacher(Teacher tea, String Id) {
		int rows = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "UPDATE shl_teacher SET tea_name=?,tea_professional=?,dept_no=? WHERE tea_no=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, tea.getTeacherName());
			pst.setString(2, tea.getTeacherProfessional());
			pst.setString(3, tea.getDeptNo());
			pst.setString(4, Id);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return rows;
	}

	@Override
	public int deleteTeacher(String tno) {
		int rows = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "DELETE FROM shl_teacher WHERE tea_no=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, tno);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return rows;
	}

}