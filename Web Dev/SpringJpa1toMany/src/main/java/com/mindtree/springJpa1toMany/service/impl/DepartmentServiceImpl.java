package com.mindtree.springJpa1toMany.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.springJpa1toMany.converter.DepartmentConverter;
import com.mindtree.springJpa1toMany.dto.DepartmentDto;
import com.mindtree.springJpa1toMany.entity.Department;
import com.mindtree.springJpa1toMany.exception.daoexception.ResourceNotFoundException;
import com.mindtree.springJpa1toMany.exception.serviceexception.DepartmentServiceException;
import com.mindtree.springJpa1toMany.repository.DepartmentRepository;
import com.mindtree.springJpa1toMany.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentConverter departmentConverter;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department createDepartment(DepartmentDto departmentDto) throws DepartmentServiceException {
		Department department = departmentConverter.dtoToEntity(departmentDto);
		return this.departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDept() throws DepartmentServiceException {

		return this.departmentRepository.findAll();
	}

	@Override
	public Department getDeptById(long deptId) throws DepartmentServiceException {
		Department department = null;
		try {
			department = departmentRepository.findById(deptId)
					.orElseThrow(() -> new ResourceNotFoundException("Department not found with id :" + deptId));
		} catch (ResourceNotFoundException e) {
			throw new DepartmentServiceException(e);
		}
		return department;

	}

}
