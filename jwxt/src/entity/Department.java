package entity;

public class Department {
	private String deptNo;
	private String deptName;
	
	public Department() {
		super();
	}
	public Department(String deptNo, String deptName) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
}
