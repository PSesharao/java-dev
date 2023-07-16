package com.mindtree.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // It will make it a spring Bean
//@Scope(value = "prototype") // It will create object when needed . 
// otherwise it'll be in singleton mode (only one object created as bean)
public class Car {
	@Autowired
	//@Qualifier("mp")   To search by the name 
 	private MusicPlayer musicplayer ;
	public Car() {
		System.out.println("I'm just built");
	}
	
	public void show() {
		System.out.println("Hi !! ,I'm a car ");
	}
	
	public void play()
	{
		musicplayer.play();
	}
}
