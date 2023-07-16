package com.mindtree.entity;

import java.util.List;

public class Album {
	private String id;
	private String name;
	private int price;
	private float rating;
	private List<Song> songList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public List<Song> getSongList() {
		return songList;
	}
	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}
	public Album(String id, String name, int price, float rating) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
	}
}
