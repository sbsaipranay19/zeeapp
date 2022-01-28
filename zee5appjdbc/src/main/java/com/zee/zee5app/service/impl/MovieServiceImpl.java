package com.zee.zee5app.service.impl;

import java.util.HashSet;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.MovieNotFoundException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.impl.MovieRepositoryImpl;
import com.zee.zee5app.service.MovieService;

public class MovieServiceImpl implements MovieService {
	
	private MovieServiceImpl() {
		
	}
	
	private MovieRepository repository = MovieRepositoryImpl.getInstance();
	private static MovieService  service = null;
	
	public static MovieService getInstance() {
		if(service==null)
		service = new MovieServiceImpl();
		return service;
		
	}

	@Override
	public String addMovie(Movie movie) {
		return this.repository.addMovie(movie);
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
		return repository.getMovieById(id);
	}

	@Override
	public HashSet<Movie> getMovies() {
		return repository.getAllMovies();
	}

	@Override
	public Optional<Movie> updateMovie(String id, String newId) throws IdNotFoundException, InvalidIdLengthException {
		return repository.updateMovie(id,newId);
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		return repository.deleteMovieById(id);
	}

	@Override
	public Optional<Movie> getMovie(String movieName) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		return repository.getMovie(movieName);
	}

}
