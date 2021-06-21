package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.ClassDao;
import entity.Class;
import util.DBCPUtil;

public class ClassDaoImpl implements ClassDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public List<Class> queryAllClass() {
		List<Class> classlist = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select * from shl_class";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			classlist = new BeanListHandler<>(Class.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt, rs);
		}
		return classlist;
	}

	@Override
	public boolean addClass(Class cla) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "insert into shl_class values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cla.getClaNo());
			pstmt.setShort(2, cla.getClaGrade());
			pstmt.setString(3, cla.getClaName());
			pstmt.setString(4, cla.getClaLevel());
			pstmt.setString(5, cla.getClaStype());
			pstmt.setString(6, cla.getMajNo());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

	@Override
	public boolean deleteClassByClaNo(String no) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "delete from shl_major where cla_no=?";
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
	public Class queryClassByClaNo(String no) {
		Class cla = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select * from shl_class where cla_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			cla = new BeanHandler<>(Class.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return cla;
	}

	@Override
	public boolean updateClass(Class cla) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "update shl_class set cla_grade=?,cla_name=?,cla_level=?,cla_stype=?,maj_no=? where cla_no=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setShort(1, cla.getClaGrade());
			pstmt.setString(2, cla.getClaName());
			pstmt.setString(3, cla.getClaLevel());
			pstmt.setString(4, cla.getClaStype());
			pstmt.setString(5, cla.getMajNo());
			pstmt.setString(6, cla.getClaNo());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}


}
