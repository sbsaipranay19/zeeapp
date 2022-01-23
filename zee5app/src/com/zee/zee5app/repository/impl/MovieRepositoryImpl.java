package com.zee.zee5app.repository.impl;

import java.util.HashSet;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.MovieNotFoundException;
import com.zee.zee5app.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {
	
	private HashSet<Movie> movies = new HashSet<>();
	private MovieRepositoryImpl(){
		
	}
	
	private static MovieRepository repository;
	public static MovieRepository getInstance() {
		
		if(repository== null) {
			repository = new MovieRepositoryImpl();
		}
		return repository;
		
	}
	
	@Override
	public String addMovie(Movie movie) {
		
		boolean result = this.movies.add(movie);
		if(result) {
			return "success";
		}
		return "fail";
		
	}
	
	@Override
	public String deleteMovieById(String id) throws IdNotFoundException {
		
			Optional<Movie> optional = this.getMovieById(id);
			if(optional.isPresent()) {
				boolean result =movies.remove(optional.get());
				if(result) {
					return "Deletion Success";
				}else {
					return "Failure";
				}
			}else {
				throw new IdNotFoundException("ID Not Found");
			}			
	}
	
	@Override
	public HashSet<Movie> getAllMovies() {
		return  movies;
	}
	
	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
		
		Movie movie2 = null;
		for (Movie movie : movies) {
			if(movie.getId().equals(id)) {
				movie2= movie;
				break;
			}
		}
		return Optional.ofNullable(Optional.ofNullable(movie2).orElseThrow(()-> new IdNotFoundException("ID Not Found")));
		
	}
	
	@Override
	public Optional<Movie> updateMovie(String id, String newId) throws IdNotFoundException, InvalidIdLengthException {
		Movie movie2 = null;
		for (Movie movie : movies) {
			if(movie.getId().equals(id)) {
				movie2 = movie;
				movie.setId(newId);
				System.out.println("Update Success");
				break;
			}
		}
		
		return Optional.ofNullable(Optional.ofNullable(movie2).orElseThrow(()-> new IdNotFoundException("ID Not Found")));
	}
	
	@Override
	public Optional<Movie> getMovie(String movieName) throws MovieNotFoundException {
		Movie movie2 = null;
		for (Movie movie : movies) {
			if(movie.getMovieName().equals(movieName)) {
				movie2= movie;
				break;
			}
		}
		return Optional.ofNullable(Optional.ofNullable(movie2).orElseThrow(()-> new MovieNotFoundException("Movie Not Found")));	
	}
	
}





