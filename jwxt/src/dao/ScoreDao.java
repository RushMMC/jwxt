package dao;

import java.util.List;

import entity.Score;

/**
 * 成绩表DAO层接口
 * @author lixingsheng
 * @date 2021/06/21
 *
 */
public interface ScoreDao {

	List<Score> queryAllStudentScore();

	Score queryStudentScoreByNo(int teamNo, String stuNo, String sourNo);

	int addStudentScore(Score stuS);

	int updateStudentScore(Score stuS, int teamNo, String stuNo, String sourNo);

	int deleteStudentScore(int teamNo, String stuNo, String sourNo);

}