package dao;

import java.util.List;

import entity.Course;

/**
 * 课程表DAO层接口
 * @author AndrewLiu
 * @date 2021/06/21
 *
 */
public interface CourseDao {
    List<Course>FetchAllCourse();
    boolean AddCourse(Course cou);
    boolean DeleteCourse(int id);
    boolean UpdateCourse(Course cou); 
}
