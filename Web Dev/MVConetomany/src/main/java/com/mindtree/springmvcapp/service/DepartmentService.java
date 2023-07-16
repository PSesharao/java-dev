package com.mindtree.springmvcapp.service;

import java.util.List;

import com.mindtree.springmvcapp.dto.DepartmentDto;
import com.mindtree.springmvcapp.entity.Department;
import com.mindtree.springmvcapp.exception.serviceexception.DepartmentServiceException;

public interface DepartmentService {
	public Department createDepartment(DepartmentDto departmentDto) throws DepartmentServiceException;
	public List<Department>  getAllDept() throws DepartmentServiceException;
	public Department getDeptById(long deptId) throws DepartmentServiceException;
}
