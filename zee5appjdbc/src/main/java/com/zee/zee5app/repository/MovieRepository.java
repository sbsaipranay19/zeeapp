package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface MovieRepository {

	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException;

	public Optional<Movie> updateMovie(String id, Movie movie) throws IdNotFoundException, InvalidIdLengthException;

	public Optional<List<Movie>> getAllMovies() throws InvalidIdLengthException;

	public String deleteMovieById(String id) throws IdNotFoundException;

	public String addMovie(Movie movie);

}
