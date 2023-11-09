package com.sk;

import org.springframework.beans.factory.annotation.Value;

public class JDBCConnection {

	@Value("${mysql.driver}")
	private String driver;
	
	@Value("${mysql.url}")
	private String url;
	
	@Value("${mysql.username}")
	private String username;
	
	@Value("${mysql.password}")
	private String password;
	
	
	public void display()
	{
		
		System.out.println(username+" \n"+password+"\n "+driver+"\n "+url);
	}
	
}
