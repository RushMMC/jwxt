package dao;

import java.util.List;

import entity.Department;

/**
 * 部门表DAO层接口
 * @author RushMMC
 * @date 2021/06/21
 *
 */
public interface DepartmentDao {

	List<Department> queryAllDept();
	Department queryDeptByDeptNo(String no);
	boolean addDept(Department department);
	boolean updateDeptByDeptNo(String no);
	boolean deleteDeptByDeptNo(String no);
}
