package com.mindtree.carproject.service;

import com.mindtree.carproject.dto.LibraryDto;
import com.mindtree.carproject.entity.Library;

public interface LibraryService {
	Library createLibrary(LibraryDto libraryDto);
}
