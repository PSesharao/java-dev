package com.mindtree.entity;

public class Player {
	private int id;
	private String name;
	private String categeory;
	private int highestScore;
	private String bestFigures;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategeory() {
		return categeory;
	}
	public void setCategeory(String categeory) {
		this.categeory = categeory;
	}
	public int getHighestScore() {
		return highestScore;
	}
	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}
	public String getBestFigures() {
		return bestFigures;
	}
	public void setBestFigures(String bestFigures) {
		this.bestFigures = bestFigures;
	}
	public Player(int id, String name, String categeory, int highestScore, String bestFigures) {
		this.id = id;
		this.name = name;
		this.categeory = categeory;
		this.highestScore = highestScore;
		this.bestFigures = bestFigures;
	}
}
