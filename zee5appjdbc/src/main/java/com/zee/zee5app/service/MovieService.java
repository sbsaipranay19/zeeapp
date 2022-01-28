package com.zee.zee5app.service;

import java.util.HashSet;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.MovieNotFoundException;

public interface MovieService {
	
	public String addMovie(Movie movie);
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException;
	public HashSet<Movie> getMovies();
	public Optional<Movie> updateMovie(String id, String newId) throws IdNotFoundException, InvalidIdLengthException;
	public String deleteMovie(String id) throws IdNotFoundException;
	public Optional<Movie> getMovie(String movieName) throws MovieNotFoundException;
	
}
