package com.mindtree.doa.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.doa.AlbumDAO;
import com.mindtree.entity.Album;
import com.mindtree.entity.Album_Song;
import com.mindtree.entity.Artist;
import com.mindtree.entity.Song;
import com.mindtree.entity.Song_Artist;
import com.mindtree.exception.daoexception.AlbumDAOException;
import com.mindtree.utility.DBUtil;

public class AlbumDAOImpl implements AlbumDAO {
	private DBUtil dbUtil = new DBUtil();
	
	@Override
	public boolean insertIntoDB(Artist artist) throws AlbumDAOException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = "insert into artist (id , name , gender , age ) values(?,?,?,?);";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1,artist.getId());
			ps.setString(2, artist.getName());
			ps.setString(3,artist.getGender());
			ps.setInt(4, artist.getAge());
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
	public boolean insertIntoDB(Song song) throws AlbumDAOException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = " insert into song (id ,name ,likes , language ) values(?,?,?,?);";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1,song.getId());
			ps.setString(2, song.getName());
			ps.setInt(3, song.getLikes());
			ps.setString(4, song.getLanguage());
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
	public boolean insertIntoDB(Album album) throws AlbumDAOException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = "insert into album (id ,name , price , rating ) values(?,?,?,?);";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1,album.getId());
			ps.setString(2, album.getName());
			ps.setInt(3, album.getPrice());
			ps.setDouble(4, album.getRating());
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
	public boolean insertIntoDB(Song_Artist song_artist) throws AlbumDAOException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = "insert into song_artist (songId ,artistId ) values(?,?);";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1,song_artist.getSongId());
			ps.setString(2, song_artist.getArtistId());
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
	public boolean insertIntoDB(Album_Song album_song) throws AlbumDAOException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = "insert into album_song (albumId ,songId ) values(?,?);";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1,album_song.getAlbumId());
			ps.setString(2, album_song.getSongId());
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
	public ResultSet getAllSongsByArtist(String artist_Id) throws AlbumDAOException{

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "select song.name from song_artist "
					+ "inner join song on(song_artist.songId = song.id) "
					+ "where song_artist.artistId ="+"\'"+(artist_Id)+"\'"+";";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//dbUtil.closeResource(rs);
			//dbUtil.closeResource(stmt);
			//dbUtil.closeResource(con);
		}
		return rs;
	}

	@Override
	public ResultSet getMostExpensiveAlbumByArtist(String artist_Id) throws AlbumDAOException{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "select album.name "
					+ "from album inner join album_song on (album.id = album_song .albumId ) "
					+ "inner join song_artist on (song_artist.songId = album_song.songId)"
					+ "where song_artist.artistId = "+"\'"+(artist_Id)+"\'"+" and album.price >= all (select album .price from album);";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		} /*finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}*/
		return rs;
	}

	@Override
	public ResultSet getNoOfLangByArtist(String artist_Id) throws AlbumDAOException{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "select count(distinct language)"
					+ "from song inner join song_artist on(song.id = song_artist.songId )"
					+ "where song_artist.artistId ="+"\'"+(artist_Id)+"\'"+";";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		} /*finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}*/
		return rs;
	}

	@Override
	public ResultSet sortAlbumsByPriceAndRating() throws AlbumDAOException{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "select album.name "
					+ "from album "
					+ "order by  price,rating ;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}/* finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}*/
		return rs;
	}

	@Override
	public ResultSet sortAlbumsByName() throws AlbumDAOException{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "select album.name "
					+ "from album "
					+ "order by name desc;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}/* finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}*/
		return rs;
	}

}
