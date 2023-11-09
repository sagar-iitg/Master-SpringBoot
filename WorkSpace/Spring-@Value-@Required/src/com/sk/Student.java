package com.sk;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

public class Student {


	private int rollNo;
	private String name;
	private String hobbies;
	
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int rollNo, String name, String hobbies) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.hobbies = hobbies;
	}

	public int getRollNo() {
		return rollNo;
	}
	
	
	@Value("${student.rollNo}")
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public String getName() {
		return name;
	}
	
	
	@Value("${student.name}")
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHobbies() {
		return hobbies;
	}
	@Value("${student.hobbies}")
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", hobbies=" + hobbies + "]";
	}
	
	
	
	
}
