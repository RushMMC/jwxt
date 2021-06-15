package entity;

public class Teacher {
	private String teacherNo;
	private String teacherName;
	private String teacherProfessional;
	private String deptNo;
	
	
	public Teacher() {
		super();
	}
	public Teacher(String teacherNo, String teacherName, String teacherProfessional, String deptNo) {
		super();
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.teacherProfessional = teacherProfessional;
		this.deptNo = deptNo;
	}
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherProfessional() {
		return teacherProfessional;
	}
	public void setTeacherProfessional(String teacherProfessional) {
		this.teacherProfessional = teacherProfessional;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	@Override
	public String toString() {
		return "Teacher [teacherNo=" + teacherNo + ", teacherName=" + teacherName + ", teacherProfessional="
				+ teacherProfessional + ", deptNo=" + deptNo + "]";
	}
	
}
