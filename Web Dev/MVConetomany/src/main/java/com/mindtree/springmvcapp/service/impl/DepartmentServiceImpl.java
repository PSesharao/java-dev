package com.mindtree.springmvcapp.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindtree.springmvcapp.converter.DepartmentConverter;
import com.mindtree.springmvcapp.dto.DepartmentDto;
import com.mindtree.springmvcapp.entity.Department;
import com.mindtree.springmvcapp.exception.serviceexception.DepartmentServiceException;
import com.mindtree.springmvcapp.repository.DepartmentRepository;
import com.mindtree.springmvcapp.service.DepartmentService;

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

		return this.departmentRepository.findById(deptId).orElse(null);

	}

}
