package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.TeamDao;
import entity.Team;
import util.DBCPUtil;

/**
 * 
 * @author RushMMC
 * @date 2021/06/21
 *
 */
public class TeamDaoImpl implements TeamDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	@Override
	public List<Team> queryAllTeam() {
		List<Team> teamlist = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select team_no as teamNo, team_year as teamYear, team_team as teamTeam from shl_team";
			rs= conn.createStatement().executeQuery(sql);
			teamlist = new BeanListHandler<>(Team.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt, rs);
		}
		return teamlist;
	}

	@Override
	public Team queryTeamByTeamNo(String no) {
		Team team = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select team_no as teamNo, team_year as teamYear, team_team as teamTeam from shl_team"
					+ "where team_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			team = new BeanHandler<>(Team.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt, rs);
		}
		return team;
	}

	@Override
	public boolean addTeam(Team team) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "insert into shl_team values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, team.getTeamNo());
			pstmt.setString(2, team.getTeamYear());
			pstmt.setString(3, team.getTeamTeam());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

	@Override
	public boolean updateTeam(Team team) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "update shl_team set team_year=?, team_team=? where team_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, team.getTeamYear());
			pstmt.setString(2, team.getTeamTeam());
			pstmt.setInt(3, team.getTeamNo());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

	@Override
	public boolean deleteTeamByTeamNo(int no) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "delete from shl_team where team_id=no";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

}
