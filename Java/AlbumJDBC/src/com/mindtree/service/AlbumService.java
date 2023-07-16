package com.mindtree.service;

import java.sql.ResultSet;

import com.mindtree.entity.Album;
import com.mindtree.entity.Album_Song;
import com.mindtree.entity.Artist;
import com.mindtree.entity.Song;
import com.mindtree.entity.Song_Artist;
import com.mindtree.exception.AlbumException;

public interface AlbumService {
	boolean insertIntoDB(Artist artist) throws AlbumException;
	boolean insertIntoDB(Song song) throws AlbumException;
	boolean insertIntoDB(Album album) throws AlbumException;
	boolean insertIntoDB(Song_Artist song_artist) throws AlbumException;
	boolean insertIntoDB(Album_Song album_song) throws AlbumException;
	ResultSet getAllSongsByArtist(String artist_Id) throws AlbumException;
	ResultSet getMostExpensiveAlbumByArtist(String artist_Id) throws AlbumException;
	ResultSet getNoOfLangByArtist(String artist_Id) throws AlbumException;
	ResultSet sortAlbumsByPriceAndRating() throws AlbumException;
	ResultSet sortAlbumsByName() throws AlbumException;
}
