package entity;

public class Teach {
	private String teaNo;
	private int teamNo;
	private String courNo;
	private String calNo;
	private String teLessionTime;
	private String teLessionaddr;
	
	
	public Teach() {
		super();
	}
	
	public Teach(String teaNo, int teamNo, String courNo, String calNo, String teLessionTime, String teLessionaddr) {
		super();
		this.teaNo = teaNo;
		this.teamNo = teamNo;
		this.courNo = courNo;
		this.calNo = calNo;
		this.teLessionTime = teLessionTime;
		this.teLessionaddr = teLessionaddr;
	}

	public String getTeaNo() {
		return teaNo;
	}
	public void setTeaNo(String teaNo) {
		this.teaNo = teaNo;
	}
	public int getTeamNo() {
		return teamNo;
	}
	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}
	public String getCourNo() {
		return courNo;
	}
	public void setCourNo(String courNo) {
		this.courNo = courNo;
	}
	public String getCalNo() {
		return calNo;
	}
	public void setCalNo(String calNo) {
		this.calNo = calNo;
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
		return "Teach [teaNo=" + teaNo + ", teamNo=" + teamNo + ", courNo=" + courNo + ", calNo=" + calNo
				+ ", teLessionTime=" + teLessionTime + ", teLessionaddr=" + teLessionaddr + "]";
	}
	
}

