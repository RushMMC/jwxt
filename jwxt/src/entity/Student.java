package entity;

public class Student {
	private String stuNo;
	private String stuName;
	private String stuSex;
	private String stuBirthday;
	private String claNo;
	
	public Student() {
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public String getStuBirthday() {
		return stuBirthday;
	}

	public void setStuBirthday(String stuBirthday) {
		this.stuBirthday = stuBirthday;
	}

	public String getClaNo() {
		return claNo;
	}

	public void setClaNo(String claNo) {
		this.claNo = claNo;
	}
}
