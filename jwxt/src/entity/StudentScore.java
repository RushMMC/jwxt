package entity;

public class StudentScore {
	private int teamNo;
	private String stuNo;
	private String courNo;
	private int scoPeacetime;
	private int scoTeamEnd;
	private double scoOverall;
	
	
	public StudentScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentScore(int teamNo, String stuNo, String courNo, int scoPeacetime, int scoTeamEnd, double scoOverall) {
		super();
		this.teamNo = teamNo;
		this.stuNo = stuNo;
		this.courNo = courNo;
		this.scoPeacetime = scoPeacetime;
		this.scoTeamEnd = scoTeamEnd;
		this.scoOverall = scoOverall;
	}

	public int getTeamNo() {
		return teamNo;
	}
	public void setTeamNo(int teamNo) {
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
	public int getScoPeacetime() {
		return scoPeacetime;
	}
	public void setScoPeacetime(int scoPeacetime) {
		this.scoPeacetime = scoPeacetime;
	}
	public int getScoTeamEnd() {
		return scoTeamEnd;
	}
	public void setScoTeamEnd(int scoTeamEnd) {
		this.scoTeamEnd = scoTeamEnd;
	}
	public double getScoOverall() {
		return scoOverall;
	}
	public void setScoOverall(double scoOverall) {
		this.scoOverall = scoOverall;
	}
	@Override
	public String toString() {
		return "StudentScore [teamNo=" + teamNo + ", stuNo=" + stuNo + ", courNo=" + courNo + ", scoPeacetime="
				+ scoPeacetime + ", scoTeamEnd=" + scoTeamEnd + ", scoOverall=" + scoOverall + "]";
	}
	
}
