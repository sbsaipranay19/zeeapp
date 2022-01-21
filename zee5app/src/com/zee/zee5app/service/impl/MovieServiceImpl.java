package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Movie;
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
	public Movie getMovieById(String id) {
		return repository.getMovieById(id);
	}

	@Override
	public Movie[] getMovies() {
		return repository.getMovies();
	}

	@Override
	public String updateMovie(String id, String newId) {
		return repository.updateMovie(id,newId);
	}

	@Override
	public String deleteMovie(String id) {
		return repository.deleteMovie(id);
	}

}
