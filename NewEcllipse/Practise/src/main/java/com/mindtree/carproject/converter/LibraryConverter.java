package com.mindtree.carproject.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.carproject.dto.LibraryDto;
import com.mindtree.carproject.entity.Library;

@Component
public class LibraryConverter {
	public LibraryDto entityToDto(Library library) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(library, LibraryDto.class);
	}

	public Library dtoToEntity(LibraryDto libraryDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(libraryDto, Library.class);

	}
}
