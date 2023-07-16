package com.mindtree.entity;

public class Album_Song {
	private String albumId;
	private String songId;
	public String getAlbumId() {
		return albumId;
	}
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	public String getSongId() {
		return songId;
	}
	public void setSongId(String songId) {
		this.songId = songId;
	}
	public Album_Song(String albumId, String songId) {
		this.albumId = albumId;
		this.songId = songId;
	}
}
