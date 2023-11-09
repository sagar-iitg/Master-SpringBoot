package com.sk;

public class Student {

	
	
	private int rollNo;


	private Address add;

	
	public Student() {
		System.out.println("Student object created");
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public String fun() {
		System.out.println(rollNo+" "+add);
		System.out.println(add.toString());
		return "student class";
	}
	
	
	
	
}
