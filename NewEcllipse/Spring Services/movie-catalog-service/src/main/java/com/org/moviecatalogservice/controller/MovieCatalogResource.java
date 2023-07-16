package com.org.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.org.moviecatalogservice.models.CatalogItem;
import com.org.moviecatalogservice.models.Movie;
import com.org.moviecatalogservice.models.Rating;
import com.org.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private WebClient.Builder builder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating userRating =

				restTemplate.getForObject("http://RATINGS-DATA-SERVICE/ratingsdata/users/" + userId, UserRating.class);
		List<Rating> ratings = userRating.getUserRating();
		return ratings.stream().map(rating -> {

			Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
//			Movie movie = 
//			builder.build().
//			get().
//			uri("http://localhost:8081/movies/" + rating.getMovieId()).
//			retrieve().
//			bodyToMono(Movie.class).block();
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());

	}
}
