package com.mindtree.doa;

import java.util.List;

import com.mindtree.entity.Album;
import com.mindtree.entity.Song;
import com.mindtree.exception.daoexception.AlbumDAOException;

public interface AlbumDAO {
	boolean insertIntoAlbumDB(String albumId,String albumName ,int albumPrice , float albumRating) throws AlbumDAOException;
	boolean insertIntoSongDB(String songId,String songName, int likes ,String langauge) throws AlbumDAOException;
	boolean insertIntoArtistDB(String artistId, String artistName , String artistGender , int artistAge) throws AlbumDAOException;
	boolean insertIntoSongArtistDB(String songId ,String artistId ) throws AlbumDAOException;
	boolean insertIntoAlbumSongDB(String albumId , String songId) throws AlbumDAOException;
	List<Song> getAllSongsByArtist(String artist_Id) throws AlbumDAOException;
	List<Album> getMostExpensiveAlbumByArtist(String artist_Id) throws AlbumDAOException;
	int getNoOfLangByArtist(String artist_Id) throws AlbumDAOException;
	List<Album> sortAlbumsByPriceAndRating() throws AlbumDAOException;
	List<Album> sortAlbumsByName() throws AlbumDAOException;
}
