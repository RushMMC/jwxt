package dao;

import java.util.List;

import entity.Course;

public interface CourseDao {
    List<Course>FetchAllCourse();
    boolean AddCourse(Course cou);
    boolean DeleteCourse(int id);
    boolean UpdateCourse(Course cou); 
}
