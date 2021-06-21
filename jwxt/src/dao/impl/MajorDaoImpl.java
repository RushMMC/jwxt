package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.MajorDao;
import entity.Major;
import util.DBCPUtil;

/**
 * 
 * @author RushMMC
 * @date 2021/06/21
 *
 */
public class MajorDaoImpl implements MajorDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	@Override
	public boolean addMajor(Major major) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "insert into shl_major values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, major.getMajNo());
			pstmt.setString(2, major.getMajName());
			pstmt.setString(3, major.getDeptNo());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

	@Override
	public List<Major> queryAllMajor() {
		List<Major> phonelist = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select maj_no as majNo, maj_name as majName, dept_no as deptNo from shl_major";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			phonelist = new BeanListHandler<>(Major.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt, rs);
		}
		return phonelist;
	}

	@Override
	public Major queryMajorByMajNo(String no) {
		Major phone = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select maj_no as majNo, maj_name as majName, dept_no as deptNo from shl_major where maj_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			phone = new BeanHandler<>(Major.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return phone;
	}

	@Override
	public boolean deleteMajorByMajNo(String no) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "delete from shl_major where maj_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			return pstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

	@Override
	public boolean updateMajor(Major major) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "update shl_major set maj_name=?,dept_no=? where maj_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, major.getMajName());
			pstmt.setString(2, major.getDeptNo());
			pstmt.setString(3, major.getMajNo());
			return pstmt.executeUpdate()>0;	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

}
