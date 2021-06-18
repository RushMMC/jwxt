package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	/*
	 * 获取所有课程 111
	 */
	public List<Course> FetchAllCourse() {
		List<Course> courseList = new ArrayList<Course>();
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select*from shl_course";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				courseList = new BeanListHandler<>(Course.class).handle(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	/*
	 * 添加课程
	 */
	public boolean AddCourse(Course cou) {
		int num = 0;
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
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num > 0;
	}

	@Override
	/*
	 * 删除课程
	 */
	public boolean DeleteCourse(int id) {
		int num = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "delete from shl_course where cour_no=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			num = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num > 0;
	}

	@Override
	/*
	 * 更新课程
	 */
	public boolean UpdateCourse(Course cou) {
		int num = 0;
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
			num = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num > 0;
	}

}
