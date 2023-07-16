package com.mindtree.service.impl;

import java.util.List;

import com.mindtree.dao.AlbumDAO;
import com.mindtree.dao.impl.AlbumDAOImpl;
import com.mindtree.entity.Album;
import com.mindtree.entity.Artist;
import com.mindtree.entity.Song;
import com.mindtree.exception.daoexception.AlbumDAOException;
import com.mindtree.exception.serviceexception.AlbumServiceException;
import com.mindtree.service.AlbumService;

public class AlbumServiceImpl implements AlbumService {
	private static AlbumDAO albumDao = new AlbumDAOImpl();

	public List<Song> getAllSongsByArtist(String artist_Id) throws AlbumServiceException {
		
		try {
			return albumDao.getAllSongsByArtist(artist_Id);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB",e);
		}
	}

	public List<Album> getMostExpensiveAlbumByArtist(String artist_Id) throws AlbumServiceException {
		
		try {
			return albumDao.getMostExpensiveAlbumByArtist(artist_Id);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB",e);
		}
	}

	public int getNoOfLangByArtist(String artist_Id) throws AlbumServiceException {
		
		try {
			return albumDao.getNoOfLangByArtist(artist_Id);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB",e);
		}
	}

	public List<Album> sortAlbumsByPriceAndRating() throws AlbumServiceException {
		
		try {
			return albumDao.sortAlbumsByPriceAndRating();
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB",e);
		}
	}

	public List<Album> sortAlbumsByName() throws AlbumServiceException {
		
		try {
			return albumDao.sortAlbumsByName();
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB",e);
		}
	}

	public boolean insertIntoAlbumDB(Album album) throws AlbumServiceException {
		try {
			return albumDao.insertIntoAlbumDB(album);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB",e);
		}
	}

	public boolean insertIntoSongDB(Song song) throws AlbumServiceException {
		try {
			return albumDao.insertIntoSongDB(song);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB",e);
		}
	}

	public boolean insertIntoArtistDB(Artist artist) throws AlbumServiceException {
		try {
			return albumDao.insertIntoArtistDB(artist);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB",e);
		}
	}
	
}
