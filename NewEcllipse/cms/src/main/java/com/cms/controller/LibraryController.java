package com.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.model.Library;
import com.cms.service.LibraryLoginService;


@RestController
@RequestMapping("/library")
@CrossOrigin(origins = "http://localhost:4200")
public class LibraryController {

	@Autowired
	private LibraryLoginService repo;

	@PostMapping("/login")
	public ResponseEntity<?> libraryLogin(@RequestBody Library libraryData) {

		Library library = repo.getLibraryByLibrary(libraryData.getLusername());
		if (library.getLpassword().equals(libraryData.getLpassword()))
			return ResponseEntity.ok(library);
     
		return (ResponseEntity<?>) ResponseEntity.internalServerError();

	}
}
