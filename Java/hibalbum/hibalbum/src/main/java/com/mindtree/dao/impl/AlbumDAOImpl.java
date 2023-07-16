package com.mindtree.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mindtree.dao.AlbumDAO;
import com.mindtree.entity.Album;
import com.mindtree.entity.Artist;
import com.mindtree.entity.Song;
import com.mindtree.exception.daoexception.AlbumDAOException;
import com.mindtree.exception.daoexception.DataBaseEmptyException;
import com.mindtree.exception.daoexception.DatabaseConnectionFailedException;
import com.mindtree.utility.SessionUtil;

public class AlbumDAOImpl implements AlbumDAO {
	private static SessionUtil hbutil = new SessionUtil();

	@Override
	public boolean insertIntoAlbumDB(Album album) throws AlbumDAOException {
		boolean isInserted = false;
		Session sessionObj = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			sessionObj.save(album);
			sessionObj.getTransaction().commit();
			isInserted = true;
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");
		} catch (Exception e) {
			throw new DatabaseConnectionFailedException("Could not establish a session", e);
		} finally {
			hbutil.closeResource(sessionObj);
		}
		return isInserted;
	}

	@Override
	public boolean insertIntoSongDB(Song song) throws AlbumDAOException {
		boolean isInserted = false;
		Session sessionObj = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			sessionObj.save(song);
			sessionObj.getTransaction().commit();
			isInserted = true;
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");
		} catch (Exception e) {
			throw new DatabaseConnectionFailedException("Could not establish a session", e);
		} finally {
			hbutil.closeResource(sessionObj);
		}
		return isInserted;
	}

	@Override
	public boolean insertIntoArtistDB(Artist artist) throws AlbumDAOException {
		boolean isInserted = false;
		Session sessionObj = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			sessionObj.save(artist);
			sessionObj.getTransaction().commit();
			isInserted = true;
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");
		} catch (Exception e) {
			throw new DatabaseConnectionFailedException("Could not establish a session", e);
		} finally {
			hbutil.closeResource(sessionObj);
		}
		return isInserted;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Song> getAllSongsByArtist(String artist_Id) throws AlbumDAOException {
		Session sessionObj = null;
		List<Song> songList = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			String queryString = "select album.songList"
					+ " from Album album join album.songList songlist"
					+ " join songlist.artistList artlist where artlist.id=:i";
			Query<Song> query = sessionObj.createQuery(queryString);
			query.setParameter("i",artist_Id );
			songList = query.list();
			sessionObj.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseConnectionFailedException("Could not establish a session", e);
		} finally {
			hbutil.closeResource(sessionObj);
		}
		if(songList.size()==0)
			throw new DataBaseEmptyException("The song list is empty");
		return songList;
	}

	@Override
	public List<Album> getMostExpensiveAlbumByArtist(String artist_Id) throws AlbumDAOException {
		Session sessionObj = null;
		List<Album> albumList = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			String queryString = "select album"
					+ " from Album album join album.songList songlist"
					+ " join songlist.artistList artlist where artlist.id=:i "
					+ " and album.price >= all (select album .price from album)";
			@SuppressWarnings("unchecked")
			Query<Album> query = sessionObj.createQuery(queryString);
			query.setParameter("i",artist_Id );
			albumList = query.list();
			sessionObj.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseConnectionFailedException("Could not establish a session", e);
		} finally {
			hbutil.closeResource(sessionObj);
		}
		if(albumList.size()==0)
			throw new DataBaseEmptyException("The album list is empty");
		return albumList;
	}

	@Override
	public int getNoOfLangByArtist(String artist_Id) throws AlbumDAOException {
		Session sessionObj = null;
		long noOfLang = 0 ; 
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			String queryString = "select count(distinct songlist.language)"
					+ " from Album album join album.songList songlist"
					+ " join songlist.artistList artlist where artlist.id=:i ";
			@SuppressWarnings("unchecked")
			Query<Long> query = sessionObj.createQuery(queryString);
			query.setParameter("i",artist_Id );
			noOfLang = query.uniqueResult();
		}catch (Exception e) {
			throw new DatabaseConnectionFailedException("Could not establish a session", e);
		} finally {
			hbutil.closeResource(sessionObj);
		}
		return (int) noOfLang;
	}

	@Override
	public List<Album> sortAlbumsByPriceAndRating() throws AlbumDAOException {
		Session sessionObj = null;
		List<Album> albumList = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			String queryString = "select album"
					+ " from Album album "
					+ "order by album.price,album.rating";
			@SuppressWarnings("unchecked")
			Query<Album> query = sessionObj.createQuery(queryString);
			albumList = query.list();
			sessionObj.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseConnectionFailedException("Could not establish a session", e);
		} finally {
			hbutil.closeResource(sessionObj);
		}
		if(albumList.size()==0)
			throw new DataBaseEmptyException("The album list is empty");
		return albumList;
	}

	@Override
	public List<Album> sortAlbumsByName() throws AlbumDAOException {
		Session sessionObj = null;
		List<Album> albumList = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			String queryString = "select album"
					+ " from Album album "
					+ " order by album.name desc";
			@SuppressWarnings("unchecked")
			Query<Album> query = sessionObj.createQuery(queryString);
			albumList = query.list();
			sessionObj.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseConnectionFailedException("Could not establish a session", e);
		} finally {
			hbutil.closeResource(sessionObj);
		}
		if(albumList.size()==0)
			throw new DataBaseEmptyException("The album list is empty");
		return albumList;
	}
}
