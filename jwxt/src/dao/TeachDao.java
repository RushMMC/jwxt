package dao;

import java.util.List;

import entity.Teach;

public interface TeachDao {

	List<Teach> queryAllTeacher();

	Teach queryTeacherByNo(String teaNo, int teamNo, String courNo, String claNo);

	int addTeach(Teach tea);

	int updateTeach(Teach tea, String teaNo, int teamNo, String courNo, String claNo);

	int deleteTeach(String teaNo, int teamNo, String courNo, String claNo);

}