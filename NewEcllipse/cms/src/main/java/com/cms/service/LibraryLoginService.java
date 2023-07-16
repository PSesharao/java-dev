package com.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cms.model.Library;
import com.cms.repo.LibraryRepo;


@Service
public class LibraryLoginService {

	@Autowired
	LibraryRepo libraryRepo;
	
	public Library getLibraryByLibrary(String username) {
		return libraryRepo.findByLusername(username);
	}
}
