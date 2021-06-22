package entity;

public class Course {

	private String courNo;
	private int ctyNo;
	private String courName;
	private double courCredit;
	private int courCtime;
	private String courOpenTeam;
	private String courIsTequire;
	private String deptNo;
	private String courRemark;

	public Course() {
	}

	public String getCourNo() {
		return courNo;
	}

	public void setCourNo(String courNo) {
		this.courNo = courNo;
	}

	public int getCtyNo() {
		return ctyNo;
	}

	public void setCtyNo(int ctyNo) {
		this.ctyNo = ctyNo;
	}

	public String getCourName() {
		return courName;
	}

	public void setCourName(String courName) {
		this.courName = courName;
	}

	public double getCourCredit() {
		return courCredit;
	}

	public void setCourCredit(double courCredit) {
		this.courCredit = courCredit;
	}

	public int getCourCtime() {
		return courCtime;
	}

	public void setCourCtime(int courCtime) {
		this.courCtime = courCtime;
	}

	public String getCourOpenTeam() {
		return courOpenTeam;
	}

	public void setCourOpenTeam(String courOpenTeam) {
		this.courOpenTeam = courOpenTeam;
	}

	public String getCourIsTequire() {
		return courIsTequire;
	}

	public void setCourIsTequire(String courIsTequire) {
		this.courIsTequire = courIsTequire;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getCourRemark() {
		return courRemark;
	}

	public void setCourRemark(String courRemark) {
		this.courRemark = courRemark;
	}

}
