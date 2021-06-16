package dao;

import java.util.List;

import entity.Department;
import entity.Team;

public class TeamDaoImpl implements TeamDao {

	@Override
	public List<Team> queryAllTeam() {
		return null;
	}

	@Override
	public Team queryTeamByTeamNo(String no) {
		return null;
	}

	@Override
	public boolean addTeam(Department department) {
		return false;
	}

	@Override
	public boolean updateTeamByTeamNo(String no) {
		return false;
	}

	@Override
	public boolean deleteTeamByTeamNo(String no) {
		return false;
	}

}
