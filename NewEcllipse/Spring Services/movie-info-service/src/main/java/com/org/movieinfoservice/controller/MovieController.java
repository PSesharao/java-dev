package com.org.movieinfoservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		
		return new Movie(movieId, "Transformers", "Sci-FI");
	}
}
