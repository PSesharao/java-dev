package com.mindtree.entity;

import java.util.List;

public class Hotel {
	private String id;
	private String name ;
	private String location;
	private List<Room> roomList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLication() {
		return location;
	}
	public void setLication(String lication) {
		this.location = lication;
	}
	public List<Room> getRoomList() {
		return roomList;
	}
	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Hotel(String id, String name, String lication) {
		this.id = id;
		this.name = name;
		this.location = lication;
	}
}
