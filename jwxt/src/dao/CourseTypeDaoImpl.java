package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.CourseTypeDao;
import entity.Course;
import entity.CourseType;
import util.DBCPUtil;

public class CourseTypeDaoImpl implements CourseTypeDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	@Override
	/*
	 * 获取所有课程类型
	 */
	public List<CourseType> FetchAllTypes() {
		List<CourseType> courseTypeList = new ArrayList<CourseType>();
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select*from shl_course_type";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				courseTypeList = new BeanListHandler<>(CourseType.class).handle(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseTypeList;
	}

	@Override
	/*
	 * 添加课程
	 */
	public int AddCourseType(CourseType cou) {
		int num = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "insert into shl_course_type values(null,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cou.getCtyName());
			
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public boolean DeleteCourseType(int id) {
		int num = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "delete from shl_course_type where cty_no=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			num = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num > 0;
	}

	@Override
	public boolean UpdateCourseType(CourseType cou) {
		int num = 0;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "update set shl_course_type "
					     +"cty_name=? where cty_no=?";
				

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cou.getCtyName());
			pstmt.setInt(2, cou.getCtyNo());
			num = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num > 0;
	}

}
