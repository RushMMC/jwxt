package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.CourseTypeDao;
import entity.CourseType;
import util.DBCPUtil;

public class CourseTypeDaoImpl implements CourseTypeDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	@Override
	public List<CourseType> FetchAllTypes() {
		List<CourseType> courseTypeList = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select cty_no as ctyNo,cty_name as ctyName from shl_course_type";
			rs=conn.createStatement().executeQuery(sql);
			courseTypeList = new BeanListHandler<>(CourseType.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt, rs);
		}
		return courseTypeList;
	}

	@Override
	public boolean AddCourseType(CourseType cou) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "insert into shl_course_type values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cou.getCtyName());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

	@Override
	public boolean DeleteCourseType(int id) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "delete from shl_course_type where cty_no=?";

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
	public boolean UpdateCourseType(CourseType cou) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "update set shl_course_type "
					     +"cty_name=? where cty_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cou.getCtyName());
			pstmt.setInt(2, cou.getCtyNo());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

}
