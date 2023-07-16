package com.mindtree.carproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.carproject.dto.LibraryDto;
import com.mindtree.carproject.entity.Library;
import com.mindtree.carproject.service.LibraryService;

@Controller
public class LibraryController {
	@Autowired
	private LibraryService libraryService;
	@RequestMapping(value = "/library")
	public String library()  {
		return "library";
	}
	
	@ResponseBody
	@RequestMapping(value = "/createlibrary")
	public Library addLibrary(LibraryDto libraryDto) {
		return libraryService.createLibrary(libraryDto);
	}
}
