package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Entity(name = "---") here it will change the entity name
//@Table (name = "---") here it will change the table name
public class Song {
	@Id
	private String songId;
	//@Column(name = "---") it will change the attribute name
	//@Transient it will not consider the attribute
	private String songName;

	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public Song(String songId, String songName) {
		this.songId = songId;
		this.songName = songName;
	}

	public Song()
	{
		
	}
	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + "]";
	}
}
