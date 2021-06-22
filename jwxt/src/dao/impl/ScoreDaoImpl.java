package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.ScoreDao;
import util.DBCPUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import entity.StudentScore;

public class ScoreDaoImpl implements ScoreDao {
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	@Override
	public List<StudentScore> queryAllStudentScore() {
		List<StudentScore> scorelist = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select * from shl_score";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			scorelist = new BeanListHandler<>(StudentScore.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst, rs);
		}
		return scorelist;
	}

	@Override
	public StudentScore queryStudentScoreByNo(int teamNo, String stuNo, String sourNo) {
		StudentScore score = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select * from shl_score where team_no=? and stu_no = ? and sour_no = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, teamNo);
			pst.setString(2, stuNo);
			pst.setString(3, sourNo);
			rs = pst.executeQuery();
			score = new BeanHandler<>(StudentScore.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return score;
	}
	

	@Override
	public int addStudentScore(StudentScore stuS) {
		Connection conn = null;
		PreparedStatement pst = null;
		int rows = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "insert into shl_score(team_no,stu_no,sour_no,sco_peacetime,sco_team_end,sco_overall) values(?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, stuS.getTeamNo());
			pst.setString(2, stuS.getStuNo());
			pst.setString(3, stuS.getCourNo());
			pst.setInt(4, stuS.getScoPeacetime());
			pst.setInt(5, stuS.getScoTeamEnd());
			pst.setDouble(6, stuS.getScoOverall());
			rows = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return rows;
	}

	@Override
	public int updateStudentScore(StudentScore stuS, int teamNo, String stuNo, String sourNo) {
		Connection conn = null;
		PreparedStatement pst = null;
		int rows = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "UPDATE shl_score SET sco_peacetime=?,sco_team_end=?,sco_overall=? WHERE team_no=? and stu_no = ? and sour_no = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, stuS.getScoPeacetime());
			pst.setInt(2, stuS.getScoTeamEnd());
			pst.setDouble(3, stuS.getScoOverall());
			pst.setInt(4, teamNo);
			pst.setString(5, stuNo);
			pst.setString(6, sourNo);
			
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return rows;
	}

	@Override
	public int deleteStudentScore(int teamNo, String stuNo, String sourNo) {
		Connection conn = null;
		PreparedStatement pst = null;
		int rows = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "DELETE FROM shl_score WHERE team_no=? and stu_no = ? and sour_no = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, teamNo);
			pst.setString(2, stuNo);
			pst.setString(3, sourNo);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pst);
		}
		return rows;
	}

}