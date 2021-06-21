package dao;

import java.util.List;

import entity.CourseType;

/**
 * 课程类别表DAO层接口
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
