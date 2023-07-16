package com.mindtree.service;
import java.util.List;
import com.mindtree.entity.Album;
import com.mindtree.entity.Artist;
import com.mindtree.entity.Song;
import com.mindtree.exception.serviceexception.AlbumServiceException;

public interface AlbumService {
	boolean insertIntoAlbumDB(Album album) throws AlbumServiceException;
	boolean insertIntoSongDB(Song song) throws AlbumServiceException;
	boolean insertIntoArtistDB(Artist artist) throws AlbumServiceException;
	List<Song> getAllSongsByArtist(String artist_Id) throws AlbumServiceException;
	List<Album> getMostExpensiveAlbumByArtist(String artist_Id) throws AlbumServiceException;
	int getNoOfLangByArtist(String artist_Id) throws AlbumServiceException;
	List<Album> sortAlbumsByPriceAndRating() throws AlbumServiceException;
	List<Album> sortAlbumsByName() throws AlbumServiceException;
}
