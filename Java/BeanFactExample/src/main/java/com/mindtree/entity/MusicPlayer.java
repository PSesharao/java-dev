package com.mindtree.entity;

import org.springframework.stereotype.Component;

@Component  // ("mp") to be used when qualifier annotation used
public class MusicPlayer {
	public MusicPlayer() {
		System.out.println("I'm just placed in the car");
	}

	public void play() {
		System.out.println("Enjoy the song!!");
	}
}
