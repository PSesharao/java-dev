package com.mindtree.service.impl;

import java.sql.ResultSet;

import com.mindtree.doa.AlbumDAO;
import com.mindtree.doa.impl.AlbumDAOImpl;
import com.mindtree.entity.Album;
import com.mindtree.entity.Album_Song;
import com.mindtree.entity.Artist;
import com.mindtree.entity.Song;
import com.mindtree.entity.Song_Artist;
import com.mindtree.exception.AlbumException;
import com.mindtree.service.AlbumService;

public class AlbumServiceImpl implements AlbumService {
	private static AlbumDAO albumDao = new AlbumDAOImpl();
	@Override
	public boolean insertIntoDB(Artist artist) throws AlbumException {
		return albumDao.insertIntoDB(artist);
	}

	@Override
	public boolean insertIntoDB(Song song) throws AlbumException {
		return albumDao.insertIntoDB(song);
	}

	@Override
	public boolean insertIntoDB(Album album) throws AlbumException {
	
		 return albumDao.insertIntoDB(album);
	}

	@Override
	public boolean insertIntoDB(Song_Artist song_artist) throws AlbumException {
		
		return albumDao.insertIntoDB(song_artist);
	}

	@Override
	public boolean insertIntoDB(Album_Song album_song) throws AlbumException {
		return albumDao.insertIntoDB(album_song);
	}

	@Override
	public ResultSet getAllSongsByArtist(String artist_Id) throws AlbumException {
		
		return albumDao.getAllSongsByArtist(artist_Id);
	}

	@Override
	public ResultSet getMostExpensiveAlbumByArtist(String artist_Id) throws AlbumException {
		return albumDao.getMostExpensiveAlbumByArtist(artist_Id);
	}

	@Override
	public ResultSet getNoOfLangByArtist(String artist_Id) throws AlbumException {
		return albumDao.getNoOfLangByArtist(artist_Id);
	}

	@Override
	public ResultSet sortAlbumsByPriceAndRating() throws AlbumException {
		return albumDao.sortAlbumsByPriceAndRating();
	}

	@Override
	public ResultSet sortAlbumsByName() throws AlbumException {
		return albumDao.sortAlbumsByName();
	}

}
