package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		Movie result = repository.save(movie);
		if (result != null)
			return "success";
		return "fail";
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.getById(id));
	}

	@Override
	public Optional<List<Movie>> getMovies() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		Optional<Movie> register3 = repository.findById(id);
		if (register3.isEmpty())
			return "fail";
		else {
			repository.deleteById(id);
			return "success";
		}
	}

}
