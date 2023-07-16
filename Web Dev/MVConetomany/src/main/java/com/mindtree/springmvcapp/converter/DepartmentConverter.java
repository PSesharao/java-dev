package com.mindtree.springmvcapp.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.springmvcapp.dto.DepartmentDto;
import com.mindtree.springmvcapp.entity.Department;

@Component
public class DepartmentConverter {
	public DepartmentDto entityToDto(Department department)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(department ,DepartmentDto.class );
	}
	
	public Department dtoToEntity(DepartmentDto departmentDto)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(departmentDto , Department.class);
	}
}
