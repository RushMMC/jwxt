package dao;

import java.util.List;

import entity.CourseType;

public interface CourseTypeDao {
	
	List<CourseType>FetchAllTypes();
	int AddCourseType(CourseType cou);
	boolean DeleteCourseType(int id);
	boolean UpdateCourseType(CourseType cou);
	
}
