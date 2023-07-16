package com.mindtree.service.impl;

import java.util.List;

import com.mindtree.dao.EmployeeDao;
import com.mindtree.dao.impl.EmployeeDaoImpl;
import com.mindtree.entity.Employee;
import com.mindtree.exception.daoexception.EmployeeDaoException;
import com.mindtree.exception.serviceexception.EmployeeServiceException;
import com.mindtree.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private static EmployeeDao empDao = new EmployeeDaoImpl();

	@Override
	public boolean insertEmployeeIntoDB(Employee empl) throws EmployeeServiceException {
		try {
			return empDao.insertEmployeeIntoDB(empl);
		} catch (EmployeeDaoException e) {
			throw new EmployeeServiceException("Something is wrong in DB", e);
		}
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeServiceException {
		try {
			return empDao.getAllEmployees();
		} catch (EmployeeDaoException e) {
			throw new EmployeeServiceException("Something is wrong in DB", e);
		}
	}
}
