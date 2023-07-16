package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Album;
import com.mindtree.entity.Song;
import com.mindtree.exception.serviceexception.AlbumServiceException;

public interface AlbumService {
	boolean insertIntoAlbumDB(String albumId,String albumName ,int albumPrice , float albumRating) throws AlbumServiceException;
	boolean insertIntoSongDB(String songId,String songName, int likes ,String langauge) throws AlbumServiceException;
	boolean insertIntoArtistDB(String artistId, String artistName , String artistGender , int artistAge) throws AlbumServiceException;
	boolean insertIntoSongArtistDB(String songId ,String artistId ) throws AlbumServiceException;
	boolean insertIntoAlbumSongDB(String albumId , String songId) throws AlbumServiceException;
	List<Song> getAllSongsByArtist(String artist_Id) throws AlbumServiceException;
	List<Album> getMostExpensiveAlbumByArtist(String artist_Id) throws AlbumServiceException;
	int getNoOfLangByArtist(String artist_Id) throws AlbumServiceException;
	List<Album> sortAlbumsByPriceAndRating() throws AlbumServiceException;
	List<Album> sortAlbumsByName() throws AlbumServiceException;
}
