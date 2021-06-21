package dao;

import java.util.List;

import entity.StudentScore;

/**
 * 成绩表DAO层接口
 * @author lixingsheng
 * @date 2021/06/21
 *
 */
public interface ScoreDao {

	List<StudentScore> queryAllStudentScore();

	StudentScore queryStudentScoreByNo(int teamNo, String stuNo, String sourNo);

	int addStudentScore(StudentScore stuS);

	int updateStudentScore(StudentScore stuS, int teamNo, String stuNo, String sourNo);

	int deleteStudentScore(int teamNo, String stuNo, String sourNo);

}