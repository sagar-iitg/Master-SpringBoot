package com.sk;

import org.springframework.stereotype.Component;

@Component
public class Principal {
	
	public Principal()
	{
		
		System.out.println("Principal constructor");
	}
	
	public void principalInfo()
	{
		System.out.println("I am your principal");
		System.out.println("principal Info method ");
	}

}
