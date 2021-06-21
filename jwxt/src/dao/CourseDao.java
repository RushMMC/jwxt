package dao;

import java.util.List;

import entity.Course;

/**
 * �γ̱�DAO��ӿ�
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
