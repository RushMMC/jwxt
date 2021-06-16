package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.Department;
import util.DBCPUtil;

public class DepartmentDaoImpl implements DepartmentDao{

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public List<Department> queryAllDept() {
		List<Department> classlist = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select * from shl_dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			classlist = new BeanListHandler<>(Department.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt, rs);
		}
		return classlist;
	}

	@Override
	public Department queryDeptByDeptNo(String no) {
		Department dept = null;
		try {
			conn = DBCPUtil.getConnection();
			String sql = "select * from shl_dept where dept_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			dept = new BeanHandler<>(Department.class).handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return dept;
	}

	@Override
	public boolean addDept(Department department) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "insert into shl_dept values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, department.getDeptNo());
			pstmt.setString(2, department.getDeptName());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

	@Override
	public boolean updateDeptByDeptNo(String no) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "update shl_dept set dept_name=? where dept_no=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(2, no);
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.release(conn, pstmt);
		}
		return false;
	}

	@Override
	public boolean deleteDeptByDeptNo(String no) {
		try {
			conn = DBCPUtil.getConnection();
			String sql = "delete from shl_dept where dept_no=?";
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

}
