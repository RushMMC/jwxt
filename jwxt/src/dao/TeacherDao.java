package dao;

import java.util.List;

import entity.Teacher;

public interface TeacherDao {

	List<Teacher> queryAllTeacher();

	Teacher queryTeacherByTeaNo(String teaNo);

	int addTeacher(Teacher tea);

	int updateTeacher(Teacher tea, String Id);

	int deleteTeacher(String tno);

}