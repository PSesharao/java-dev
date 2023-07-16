package com.mindtree.entity;

public class Song_Artist {
	private String songId;
	private String artistId;

	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public Song_Artist(String songId, String artistId) {
		this.songId = songId;
		this.artistId = artistId;
	}
}
