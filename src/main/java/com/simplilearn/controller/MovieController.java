package com.simplilearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Movie;
import com.simplilearn.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	@PostMapping("/movies")
	public int saveMovie(@RequestBody Movie movie) {
		movieService.saveMovie(movie);
		return movie.getId();
	}

	@DeleteMapping("/movies/{id}")
	public void deleteMoveById(@PathVariable("id") int id) {
		movieService.delete(id);
	}

	@GetMapping("/movies/director/{directorName}")
	public List<String> getMoviesByDirectorName(@PathVariable("directorName") String directorName) {

		List<String> movieNames = new ArrayList<String>();
		List<Movie> movies = movieService.getMovieByDirectorName(directorName);

		if (movies != null && movies.size() > 0) {
			movies.forEach(m -> movieNames.add(m.getName()));
		}
		return movieNames;
	}
}
