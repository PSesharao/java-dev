package com.mindtree.service.impl;

import java.util.List;

import com.mindtree.doa.AlbumDAO;
import com.mindtree.doa.impl.AlbumDAOImpl;
import com.mindtree.entity.Album;
import com.mindtree.entity.Song;
import com.mindtree.exception.daoexception.AlbumDAOException;
import com.mindtree.exception.serviceexception.AlbumServiceException;
import com.mindtree.service.AlbumService;

public class AlbumServiceImpl implements AlbumService {
	private static AlbumDAO albumDao = new AlbumDAOImpl();

	@Override
	public boolean insertIntoAlbumDB(String albumId, String albumName, int albumPrice, float albumRating)
			throws AlbumServiceException {
		
		try {
			return albumDao.insertIntoAlbumDB(albumId, albumName, albumPrice, albumRating);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB");
		}
	}

	@Override
	public boolean insertIntoSongDB(String songId, String songName, int likes, String langauge)
			throws AlbumServiceException {
		
		try {
			return albumDao.insertIntoSongDB(songId, songName, likes, langauge);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB");
		}
	}

	@Override
	public boolean insertIntoArtistDB(String artistId, String artistName, String artistGender, int artistAge)
			throws AlbumServiceException {
		
		try {
			return albumDao.insertIntoArtistDB(artistId, artistName, artistGender, artistAge);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB");
		}
	}

	@Override
	public boolean insertIntoSongArtistDB(String songId, String artistId) throws AlbumServiceException {
		
		try {
			return albumDao.insertIntoSongArtistDB(songId, artistId);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB");
		}
	}

	@Override
	public boolean insertIntoAlbumSongDB(String albumId, String songId) throws AlbumServiceException {
		
		try {
			return albumDao.insertIntoAlbumSongDB(albumId, songId);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB");
		}
	}

	@Override
	public List<Song> getAllSongsByArtist(String artist_Id) throws AlbumServiceException {
		
		try {
			return albumDao.getAllSongsByArtist(artist_Id);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB");
		}
	}

	@Override
	public List<Album> getMostExpensiveAlbumByArtist(String artist_Id) throws AlbumServiceException {
		
		try {
			return albumDao.getMostExpensiveAlbumByArtist(artist_Id);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB");
		}
	}

	@Override
	public int getNoOfLangByArtist(String artist_Id) throws AlbumServiceException {
		
		try {
			return albumDao.getNoOfLangByArtist(artist_Id);
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB");
		}
	}

	@Override
	public List<Album> sortAlbumsByPriceAndRating() throws AlbumServiceException {
		
		try {
			return albumDao.sortAlbumsByPriceAndRating();
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB");
		}
	}

	@Override
	public List<Album> sortAlbumsByName() throws AlbumServiceException {
		
		try {
			return albumDao.sortAlbumsByName();
		} catch (AlbumDAOException e) {
			throw new AlbumServiceException("There is problem in DB");
		}
	}
	
}
