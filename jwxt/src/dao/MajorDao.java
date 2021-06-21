package dao;

import java.util.List;

import entity.Major;

/**
 * 专业表DAO层接口
 * @author RushMMC
 * @date 2021/06/21
 *
 */
public interface MajorDao {

	boolean addMajor(Major major);

	List<Major> queryAllMajor();

	Major queryMajorByMajNo(String no);

	boolean deleteMajorByMajNo(String no);

	boolean updateMajor(Major major);
}
