package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.TeachDao;
import entity.Teach;
import util.DBCPUtil;

public class TeachDaoImpl implements TeachDao {

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	@Override
	public List<Teach> queryAllTeacher() {
		List<Teach> teachlist = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select tea_no as teaNo, team_no as teamNo, cour_no as courNo, "
					+ "cla_no as claNo, te_lession_time as teLessionTime, "
					+ "te_lession_addr as teLessionaddr from shl_teach";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			teachlist = new BeanListHandler<>(Teach.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst, rs);
		}
		return teachlist;
	}

	@Override
	public Teach queryTeacherByNo(String teaNo, int teamNo, String courNo, String claNo) {
		Teach teach = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select tea_no as teaNo, team_no as teamNo, cour_no as courNo, cla_no as claNo, "
					+ "te_lession_time as teLessionTime, te_lession_addr as teLessionaddr "
					+ "from shl_teach where tea_no=? and team_no=? and cour_no=? and cla_no=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, teaNo);
			pst.setInt(2, teamNo);
			pst.setString(3, courNo);
			pst.setString(4, claNo);
			rs = pst.executeQuery();
			teach = new BeanHandler<>(Teach.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return teach;
	}
	@Override
	public int addTeach(Teach tea) {
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

	@Override
	public int updateTeach(Teach tea, String teaNo, int teamNo, String courNo, String claNo) {
		int rows = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "UPDATE shl_teach SET te_lession_time=?,te_lession_addr=? WHERE tea_no=? and team_no=? and cour_no=? and cla_no=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, tea.getTeLessionTime());
			pst.setString(2, tea.getTeLessionaddr());
			pst.setString(3, teaNo);
			pst.setInt(4, tea.getTeamNo());
			pst.setString(5, tea.getCourNo());
			pst.setString(6, tea.getClaNo());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return rows;
	}

	@Override
	public int deleteTeach(String teaNo, int teamNo, String courNo, String claNo) {
		int rows = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "DELETE FROM shl_teach WHERE tea_no=? and team_no=? and cour_no=? and cla_no=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, teaNo);
			pst.setInt(2, teamNo);
			pst.setString(3, courNo);
			pst.setString(4, claNo);;
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return rows;
	}
}
