package dao;

import java.util.List;

import entity.CourseType;

/**
 * �γ�����DAO��ӿ�
 * @author AndrewLiu
 * @date 2021/06/21
 *
 */
public interface CourseTypeDao {
	
	List<CourseType>FetchAllTypes();
	int AddCourseType(CourseType cou);
	boolean DeleteCourseType(int id);
	boolean UpdateCourseType(CourseType cou);
	
}
