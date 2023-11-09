package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.game.GameRunner;
import com.example.demo.game.GamingConsole;
import com.example.demo.game.MarioGame;
import com.example.demo.game.SuperContraGame;




@SpringBootApplication
public class TightlyCoupledRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Spring Boot Application");
		GamingConsole game=new MarioGame();
		//SuperContraGame game=new SuperContraGame();
		//GameRunner class is tightly coupled with game runner class
		GameRunner runner=new GameRunner(game);
		runner.runGame();
		
	}

}