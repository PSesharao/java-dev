package com.mindtree.entity;

import java.util.List;

public class Song {
	private String id;
	private String name;
	private int likes;
	private String language;
	private List<Artist> artistList;

	public Song(String id, String name, int likes, String language) {
		this.id = id;
		this.name = name;
		this.likes = likes;
		this.language = language;
	}

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

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Artist> getArtistList() {
		return artistList;
	}

	public void setArtistList(List<Artist> artistList) {
		this.artistList = artistList;
	}

}
