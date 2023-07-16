package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Album;
import com.mindtree.entity.Artist;
import com.mindtree.entity.Song;
import com.mindtree.exception.daoexception.AlbumDAOException;

public interface AlbumDAO {
	boolean insertIntoAlbumDB(Album album) throws AlbumDAOException;
	boolean insertIntoSongDB(Song song) throws AlbumDAOException;
	boolean insertIntoArtistDB(Artist artist) throws AlbumDAOException;
	List<Song> getAllSongsByArtist(String artist_Id) throws AlbumDAOException;
	List<Album> getMostExpensiveAlbumByArtist(String artist_Id) throws AlbumDAOException;
	int getNoOfLangByArtist(String artist_Id) throws AlbumDAOException;
	List<Album> sortAlbumsByPriceAndRating() throws AlbumDAOException;
	List<Album> sortAlbumsByName() throws AlbumDAOException;
}
