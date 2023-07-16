package com.mindtree.carproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.carproject.converter.LibraryConverter;
import com.mindtree.carproject.dto.LibraryDto;
import com.mindtree.carproject.entity.Library;
import com.mindtree.carproject.repository.LibraryRepository;
import com.mindtree.carproject.service.LibraryService;
@Service
public class LibraryServiceImpl implements LibraryService {
	@Autowired
	private LibraryRepository libraryRepository;
	@Autowired
	private LibraryConverter libraryConverter;
	@Override
	public Library createLibrary(LibraryDto libraryDto) {
		
		return libraryRepository.save(libraryConverter.dtoToEntity(libraryDto));
	}

}
