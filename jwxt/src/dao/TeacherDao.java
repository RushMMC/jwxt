package dao;

import java.util.List;

import entity.Teacher;

/**
 * 教师表DAO层接口
 * @author lixingsheng
 * @date 2021/06/21
 *
 */
public interface TeacherDao {

	List<Teacher> queryAllTeacher();

	Teacher queryTeacherByTeaNo(String teaNo);

	int addTeacher(Teacher tea);

	int updateTeacher(Teacher tea);

	int deleteTeacher(String tno);

}