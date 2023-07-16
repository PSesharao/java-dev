package com.mindtree.dao;


import java.util.List;

import com.mindtree.entity.Employee;
import com.mindtree.exception.daoexception.EmployeeDaoException;

public interface EmployeeDao {
	boolean insertEmployeeIntoDB(Employee empl) throws EmployeeDaoException; 
	List<Employee> getAllEmployees() throws EmployeeDaoException;
}
