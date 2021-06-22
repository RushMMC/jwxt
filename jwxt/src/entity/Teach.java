package entity;

public class Teach {
	private String teaNo;
	private Integer teamNo;
	private String courNo;
	private String claNo;
	private String teLessionTime;
	private String teLessionaddr;
	
	
	public Teach() {
	}


	public Teach(String teaNo, Integer teamNo, String courNo, String claNo, String teLessionTime,
			String teLessionaddr) {
		super();
		this.teaNo = teaNo;
		this.teamNo = teamNo;
		this.courNo = courNo;
		this.claNo = claNo;
		this.teLessionTime = teLessionTime;
		this.teLessionaddr = teLessionaddr;
	}


	public String getTeaNo() {
		return teaNo;
	}


	public void setTeaNo(String teaNo) {
		this.teaNo = teaNo;
	}


	public Integer getTeamNo() {
		return teamNo;
	}


	public void setTeamNo(Integer teamNo) {
		this.teamNo = teamNo;
	}


	public String getCourNo() {
		return courNo;
	}


	public void setCourNo(String courNo) {
		this.courNo = courNo;
	}


	public String getClaNo() {
		return claNo;
	}


	public void setClaNo(String claNo) {
		this.claNo = claNo;
	}


	public String getTeLessionTime() {
		return teLessionTime;
	}


	public void setTeLessionTime(String teLessionTime) {
		this.teLessionTime = teLessionTime;
	}


	public String getTeLessionaddr() {
		return teLessionaddr;
	}


	public void setTeLessionaddr(String teLessionaddr) {
		this.teLessionaddr = teLessionaddr;
	}


	@Override
	public String toString() {
		return "Teach [teaNo=" + teaNo + ", teamNo=" + teamNo + ", courNo=" + courNo + ", claNo=" + claNo
				+ ", teLessionTime=" + teLessionTime + ", teLessionaddr=" + teLessionaddr + "]";
	}

}

