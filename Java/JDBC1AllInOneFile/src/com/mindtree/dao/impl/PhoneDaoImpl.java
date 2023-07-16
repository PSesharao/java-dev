package com.mindtree.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.dao.PhoneDao;
import com.mindtree.entity.Phone;
import com.mindtree.exception.daoexception.DataBaseEmptyException;
import com.mindtree.exception.daoexception.PhoneDaoException;
import com.mindtree.utility.DBUtil;

public class PhoneDaoImpl implements PhoneDao {
	private DBUtil dbUtil = new DBUtil();

	@Override
	public boolean insertPhoneToDB(Phone phone) throws PhoneDaoException {

		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = "insert into phones values(?,?,?);";
			ps = con.prepareStatement(insertQuery);

			ps.setInt(1, phone.getId());
			ps.setString(2, phone.getName());
			ps.setDouble(3, phone.getPrice());

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
	public List<Phone> getAllPhonesFromDB() throws PhoneDaoException {
		List<Phone> phones = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "select * from phones;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);

			while (rs.next()) {
				Phone phone = new Phone(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				phones.add(phone);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}
		if(phones.size()==0) {
			throw new DataBaseEmptyException("DB is empty");
		}

		return phones;
	}

}
