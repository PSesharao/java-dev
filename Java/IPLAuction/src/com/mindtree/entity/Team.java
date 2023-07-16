package com.mindtree.entity;

import java.util.List;

public class Team {
	private int id;
	private String name;
	private List<Player> playerList ;
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
	public List<Player> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	public Team(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
