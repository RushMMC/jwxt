package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DBCPUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import entity.Teacher;

public class TeacherDao {

	public ArrayList<Teacher> select(String where) {
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "SELECT tea_no,tea_name,tea_professional,dept_no from shl_teacher";
			if (!where.equals("")) {
				sql += " where " + where;
			}
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Teacher tea = new Teacher();
				tea.setTeacherNo(rs.getString(1));
				tea.setTeacherName(rs.getString(2));
				tea.setTeacherProfessional(rs.getString(3));
				tea.setDeptNo(rs.getString(4));
				list.add(tea);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return list;
	}

	public int add(Teacher tea) {
		Connection conn = null;
		PreparedStatement pst = null;
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

	public int update(Teacher tea, String Id) {
		Connection conn = null;
		PreparedStatement pst = null;
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

	public int delete(String tno) {
		Connection conn = null;
		PreparedStatement pst = null;
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