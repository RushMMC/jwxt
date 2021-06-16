package dao;

import java.util.List;

import entity.Major;

public interface MajorDao {

	boolean addMajor(Major major);

	List<Major> queryAllMajor();

	Major queryMajorByMajNo(String no);

	boolean deleteMajorByMajNo(String no);

	boolean updateMajor(Major major);
}
