package com.mindtree.doa;

import java.sql.ResultSet;

import com.mindtree.entity.Album;
import com.mindtree.entity.Album_Song;
import com.mindtree.entity.Artist;
import com.mindtree.entity.Song;
import com.mindtree.entity.Song_Artist;
import com.mindtree.exception.daoexception.AlbumDAOException;

public interface AlbumDAO {
	boolean insertIntoDB(Artist artist) throws AlbumDAOException;
	boolean insertIntoDB(Song song) throws AlbumDAOException;
	boolean insertIntoDB(Album album) throws AlbumDAOException;
	boolean insertIntoDB(Song_Artist song_artist) throws AlbumDAOException;
	boolean insertIntoDB(Album_Song album_song) throws AlbumDAOException;
	ResultSet getAllSongsByArtist(String artist_Id) throws AlbumDAOException;
	ResultSet getMostExpensiveAlbumByArtist(String artist_Id) throws AlbumDAOException;
	ResultSet getNoOfLangByArtist(String artist_Id) throws AlbumDAOException;
	ResultSet sortAlbumsByPriceAndRating() throws AlbumDAOException;
	ResultSet sortAlbumsByName() throws AlbumDAOException;
}
