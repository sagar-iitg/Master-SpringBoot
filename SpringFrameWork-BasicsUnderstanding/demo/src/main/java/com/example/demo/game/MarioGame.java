package com.example.demo.game;

public class MarioGame implements GamingConsole {
	
	
	@Override
	public void up()
	{
		System.out.println("Up");
	}
	
	@Override
	public void down()
	{
		System.out.println("Down");
	}
	
	
	@Override
	public void left() 
	{
		System.out.println("left");
	}
	
	@Override
	public void  right() 
	{
		System.out.println("right");
	}
	

}
