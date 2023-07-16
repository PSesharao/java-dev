package com.mindtree.doa.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.doa.AlbumDAO;
import com.mindtree.entity.Album;
import com.mindtree.entity.Song;
import com.mindtree.exception.daoexception.AlbumDAOException;
import com.mindtree.utility.DBUtil;

public class AlbumDAOImpl implements AlbumDAO {
	private DBUtil dbUtil = new DBUtil();

	@Override
	public boolean insertIntoAlbumDB(String albumId, String albumName, int albumPrice, float albumRating)
			throws AlbumDAOException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = "insert into album (id ,name , price , rating ) values(?,?,?,?);";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, albumId);
			ps.setString(2, albumName);
			ps.setInt(3, albumPrice);
			ps.setDouble(4, albumRating);
			ps.execute();
			isInserted = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;
	}

	@Override
	public boolean insertIntoSongDB(String songId, String songName, int likes, String langauge)
			throws AlbumDAOException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = " insert into song (id ,name ,likes , language ) values(?,?,?,?);";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, songId);
			ps.setString(2, songName);
			ps.setInt(3, likes);
			ps.setString(4, langauge);
			ps.execute();
			isInserted = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;
	}

	@Override
	public boolean insertIntoArtistDB(String artistId, String artistName, String artistGender, int artistAge)
			throws AlbumDAOException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = "insert into artist (id , name , gender , age ) values(?,?,?,?);";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, artistId);
			ps.setString(2, artistName);
			ps.setString(3, artistGender);
			ps.setInt(4, artistAge);
			ps.execute();
			isInserted = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;
	}

	@Override
	public boolean insertIntoSongArtistDB(String songId, String artistId) throws AlbumDAOException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = "insert into song_artist (songId ,artistId ) values(?,?);";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, songId);
			ps.setString(2, artistId);
			ps.execute();
			isInserted = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;
	}

	@Override
	public boolean insertIntoAlbumSongDB(String albumId, String songId) throws AlbumDAOException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = "insert into album_song (albumId ,songId ) values(?,?);";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, albumId);
			ps.setString(2, songId);
			ps.execute();
			isInserted = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;
	}

	@Override
	public List<Song> getAllSongsByArtist(String artist_Id) throws AlbumDAOException {
		List<Song> songRec = new ArrayList<Song>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "select song.name from song_artist "
					+ "inner join song on(song_artist.songId = song.id) " + "where song_artist.artistId =" + "\'"
					+ (artist_Id) + "\'" + ";";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);

			while (rs.next()) {
				
				//Song song = new Song(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				Song song = new Song(null, rs.getString(1), -1, null);
				songRec.add(song);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}
		return songRec;
	}

	@Override
	public List<Album> getMostExpensiveAlbumByArtist(String artist_Id) throws AlbumDAOException {
		List<Album> albRec = new ArrayList<Album>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "select album.name "
					+ "from album inner join album_song on (album.id = album_song .albumId ) "
					+ "inner join song_artist on (song_artist.songId = album_song.songId)"
					+ "where song_artist.artistId = " + "\'" + (artist_Id) + "\'"
					+ " and album.price >= all (select album .price from album);";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);
			while (rs.next()) {
				//Album album = new Album(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getFloat(4));
				Album album = new Album(null, rs.getString(1), -1, -1);
				albRec.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}

		return albRec;
	}

	@Override
	public int getNoOfLangByArtist(String artist_Id) throws AlbumDAOException {
		int noOfLang = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "select count(distinct language) "
					+ "from song inner join song_artist on(song.id = song_artist.songId ) "
					+ "where song_artist.artistId =" + "\'" + (artist_Id) + "\'" + ";";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);
			if(rs.next())
				noOfLang = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}

		return noOfLang;
	}

	@Override
	public List<Album> sortAlbumsByPriceAndRating() throws AlbumDAOException {
		List<Album> albRec = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "select album.name " + "from album " + "order by  price,rating ;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);
			while (rs.next()) {
				//Album album = new Album(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getFloat(4));
				Album album = new Album(null, rs.getString(1), -1, -1);
				albRec.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}

		return albRec;
	}

	@Override
	public List<Album> sortAlbumsByName() throws AlbumDAOException {
		List<Album> albRec = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "select album.name " + "from album " + "order by name desc;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);
			while (rs.next()) {
				//Album album = new Album(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getFloat(4));
				Album album = new Album(null, rs.getString(1), -1, -1);
				albRec.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}

		return albRec;
	}

}
