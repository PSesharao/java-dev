package com.mindtree.springJpa1toMany.service;

import java.util.List;

import com.mindtree.springJpa1toMany.dto.DepartmentDto;
import com.mindtree.springJpa1toMany.entity.Department;
import com.mindtree.springJpa1toMany.exception.serviceexception.DepartmentServiceException;

public interface DepartmentService {
	public Department createDepartment(DepartmentDto departmentDto) throws DepartmentServiceException;
	public List<Department>  getAllDept() throws DepartmentServiceException;
	public Department getDeptById(long deptId) throws DepartmentServiceException;
}
