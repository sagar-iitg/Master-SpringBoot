package com.sk.mvc.model;




public class Student {
	
	private String name;
	private int empId;
	private int phNo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getPhNo() {
		return phNo;
	}
	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", empId=" + empId + ", phNo=" + phNo + "]";
	}
	

}
