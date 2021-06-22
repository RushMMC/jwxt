package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.CourseDao;
import entity.Course;
import util.DBCPUtil;

public class CourseDaoImpl implements CourseDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public List<Course> FetchAllCourse() {
		List<Course> courseList = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select cour_no as courNo, cty_no as ctyNo, "
					+ "cour_name as courName, cour_credit as courCredit, "
					+ "cour_ctime as courCtime, cour_open_team as courOpenTeam, "
					+ "cour_is_require as courIsTequire, dept_no as deptNo, "
					+ "cour_remark as courRemark from shl_course";
			rs = conn.createStatement().executeQuery(sql);
			courseList = new BeanListHandler<>(Course.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt, rs);
		}
		return courseList;
	}

	@Override
	public boolean AddCourse(Course cou) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "insert into shl_course values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cou.getCourNo());
			pstmt.setInt(2, cou.getCtyNo());
			pstmt.setString(3, cou.getCourName());
			pstmt.setDouble(4, cou.getCourCredit());
			pstmt.setInt(5, cou.getCourCtime());
			pstmt.setString(6, cou.getCourOpenTeam());
			pstmt.setString(7, cou.getCourIsTequire());
			pstmt.setString(8, cou.getDeptNo());
			pstmt.setString(9, cou.getCourRemark());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

	@Override
	public boolean DeleteCourse(int id) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "delete from shl_course where cour_no=?";

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
	public boolean UpdateCourse(Course cou) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "update set shl_course where " + "cty_no=? and" + "cour_name=? and" + "cour_credit=? and"
					+ "cour_ctime=? and" + "cour_open_team=? and" + "cour_is_require=? and" + "dept_no=? and"
					+ "cour_reamrk=? where cour_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cou.getCtyNo());
			pstmt.setString(2, cou.getCourName());
			pstmt.setDouble(3, cou.getCourCredit());
			pstmt.setInt(4, cou.getCourCtime());
			pstmt.setString(5, cou.getCourOpenTeam());
			pstmt.setString(6, cou.getCourIsTequire());
			pstmt.setString(7, cou.getDeptNo());
			pstmt.setString(8, cou.getCourRemark());
			pstmt.setString(9, cou.getCourNo());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

}
