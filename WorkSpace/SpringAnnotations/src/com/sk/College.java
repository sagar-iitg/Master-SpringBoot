package com.sk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("collegeBean")
public class College {


	@Value("${college.Name}")
	private String collegeName;
	
	
	@SuppressWarnings("deprecation")
	@Required
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Autowired
	private Principal principal;
	private Teacher teacher;
	
	
	
	@Autowired
	@Qualifier("scienceTeacher")
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public College(Principal principal)
	{
		this.principal=principal;
		System.out.println("Constructor College");
	}
	
	public void test()
	{
		
		principal.principalInfo();
		System.out.println("clg name"+ collegeName);
		 teacher.teach();
	}
}
