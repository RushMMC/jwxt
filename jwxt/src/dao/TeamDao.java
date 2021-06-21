package dao;

import java.util.List;

import entity.Team;

/**
 *  学期表DAO层接口
 * @author RushMMC
 * @date 2021/06/21
 *
 */
public interface TeamDao {

	List<Team> queryAllTeam();
	Team queryTeamByTeamNo(String no);
	boolean addTeam(Team team);
	boolean updateTeam(Team team);
	boolean deleteTeamByTeamNo(int no);
}
