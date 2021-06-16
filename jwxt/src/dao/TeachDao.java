package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Teach;
import util.DBCPUtil;

// 对shl_teach表的操作
public class TeachDao {

	public ArrayList<Teach> select(String where) {
		ArrayList<Teach> list = new ArrayList<Teach>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "SELECT tea_no,team_no,cour_no,cla_no,te_lession_time,te_lession_addr from shl_teach";
			if (!where.equals("")) {
				sql += " where " + where;
			}
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Teach tea = new Teach();
				tea.setTeaNo(rs.getString(1));
				tea.setTeamNo(rs.getInt(2));
				tea.setCourNo(rs.getString(3));
				tea.setClaNo(rs.getString(4));
				tea.setTeLessionTime(rs.getString(5));
				tea.setTeLessionaddr(rs.getString(6));
				list.add(tea);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return list;
	}

	public int add(Teach tea) {
		Connection conn = null;
		PreparedStatement pst = null;
		int rows = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "insert into shl_teach(tea_no,team_no,cour_no,cla_no,te_lession_time,te_lession_addr) values(?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, tea.getTeaNo());
			pst.setInt(2, tea.getTeamNo());
			pst.setString(3, tea.getCourNo());
			pst.setString(4, tea.getClaNo());
			pst.setString(5, tea.getTeLessionTime());
			pst.setString(6, tea.getTeLessionaddr());
			rows = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return rows;
	}

	public int update(Teach tea, String Id) {
		Connection conn = null;
		PreparedStatement pst = null;
		int rows = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "UPDATE shl_teach SET team_no=?,cour_no=?,cla_no=?,te_lession_time=?,te_lession_addr=? WHERE tea_no=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, tea.getTeamNo());
			pst.setString(2, tea.getCourNo());
			pst.setString(3, tea.getClaNo());
			pst.setString(4, tea.getTeLessionTime());
			pst.setString(5, tea.getTeLessionaddr());
			pst.setString(6, Id);
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
			String sql = "DELETE FROM shl_teach WHERE tea_no=?";
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
