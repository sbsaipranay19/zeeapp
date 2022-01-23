package com.zee.zee5app.repository;

import java.util.HashSet;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.MovieNotFoundException;

public interface MovieRepository {

	public Optional<Movie> getMovieById(String id) throws IdNotFoundException;
	public Optional<Movie> updateMovie(String id, String newId) throws IdNotFoundException, InvalidIdLengthException;
	public HashSet<Movie> getAllMovies();
	public String deleteMovieById(String id) throws IdNotFoundException;
	public String addMovie(Movie movie);
	public Optional<Movie> getMovie(String movieName) throws MovieNotFoundException;
	
}
