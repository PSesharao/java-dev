package com.mindtree.springJpa1toMany.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.springJpa1toMany.dto.DepartmentDto;
import com.mindtree.springJpa1toMany.entity.Department;


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
