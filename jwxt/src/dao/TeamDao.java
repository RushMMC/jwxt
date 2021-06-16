package dao;

import java.util.List;

import entity.Department;
import entity.Team;

public interface TeamDao {

	List<Team> queryAllTeam();
	Team queryTeamByTeamNo(String no);
	boolean addTeam(Department department);
	boolean updateTeamByTeamNo(String no);
	boolean deleteTeamByTeamNo(String no);
}
