package com.mindtree.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.dao.EmployeeDao;
import com.mindtree.entity.Employee;
import com.mindtree.exception.daoexception.DataBaseEmptyException;
import com.mindtree.exception.daoexception.DatabaseConnectionFailedException;
import com.mindtree.exception.daoexception.EmployeeDaoException;
import com.mindtree.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	private DBUtil dbUtil = new DBUtil();

	@Override
	public boolean insertEmployeeIntoDB(Employee empl) throws EmployeeDaoException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = "insert into employee values(?,?,?);";
			ps = con.prepareStatement(insertQuery);

			ps.setInt(1, empl.getId());
			ps.setString(2, empl.getName());
			ps.setDouble(3, empl.getSalary());

			ps.execute();
			isInserted = true;

		} catch (SQLException e) {
			throw new DatabaseConnectionFailedException("Database not connected ", e);
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;

	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeDaoException {
		List<Employee> empList = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "select * from employee;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);

			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				empList.add(employee);
			}

		} catch (SQLException e) {
			throw new DatabaseConnectionFailedException("Database not connected ", e);
		} finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}
		if (empList.size() == 0) {
			throw new DataBaseEmptyException("Database of employees is empty");
		}

		return empList;
	}

}
