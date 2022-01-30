package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.impl.MovieRepositoryImpl;
import com.zee.zee5app.service.MovieService;

public class MovieServiceImpl implements MovieService {

	private MovieServiceImpl() throws IOException {

	}

	private MovieRepository repository = MovieRepositoryImpl.getInstance();
	private static MovieService service = null;

	public static MovieService getInstance() throws IOException {
		if (service == null)
			service = new MovieServiceImpl();
		return service;

	}

	@Override
	public String addMovie(Movie movie) {
		return this.repository.addMovie(movie);
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException {
		return repository.getMovieById(id);
	}

	@Override
	public Optional<List<Movie>> getMovies() throws InvalidIdLengthException {
		return repository.getAllMovies();
	}

	@Override
	public Optional<Movie> updateMovie(String id, Movie movie) throws IdNotFoundException, InvalidIdLengthException {
		return repository.updateMovie(id, movie);
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		return repository.deleteMovieById(id);
	}

}
