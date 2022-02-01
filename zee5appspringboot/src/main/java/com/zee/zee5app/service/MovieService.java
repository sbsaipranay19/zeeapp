package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface MovieService {

	public String addMovie(Movie movie);

	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException;

	public Optional<List<Movie>> getMovies() throws InvalidIdLengthException;

	public Optional<Movie> updateMovie(String id, Movie movie) throws IdNotFoundException, InvalidIdLengthException;

	public String deleteMovie(String id) throws IdNotFoundException;

}
