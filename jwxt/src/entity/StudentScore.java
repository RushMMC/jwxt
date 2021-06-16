package entity;

public class StudentScore {
	private Integer teamNo;
	private String stuNo;
	private String courNo;
	private Integer scoPeacetime;
	private Integer scoTeamEnd;
	private Double scoOverall;
	
	
	public StudentScore() {
	}


	public Integer getTeamNo() {
		return teamNo;
	}


	public void setTeamNo(Integer teamNo) {
		this.teamNo = teamNo;
	}


	public String getStuNo() {
		return stuNo;
	}


	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}


	public String getCourNo() {
		return courNo;
	}


	public void setCourNo(String courNo) {
		this.courNo = courNo;
	}


	public Integer getScoPeacetime() {
		return scoPeacetime;
	}


	public void setScoPeacetime(Integer scoPeacetime) {
		this.scoPeacetime = scoPeacetime;
	}


	public Integer getScoTeamEnd() {
		return scoTeamEnd;
	}


	public void setScoTeamEnd(Integer scoTeamEnd) {
		this.scoTeamEnd = scoTeamEnd;
	}


	public Double getScoOverall() {
		return scoOverall;
	}


	public void setScoOverall(Double scoOverall) {
		this.scoOverall = scoOverall;
	}
	
	
}
