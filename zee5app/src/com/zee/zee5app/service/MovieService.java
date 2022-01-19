package com.zee.zee5app.service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.repository.MovieRepository;
public class MovieService {
private MovieRepository repository = MovieRepository.getInstance();
	
	private MovieService() {
	}
	
	private static MovieService  service = null;
	
	public static MovieService getInstance() {
		if(service==null)
		service = new MovieService();
		return service;
		
	}
	public String addMovie(Movie movie) {
		return this.repository.addMovie(movie);
	}
	public Movie getMovieById(String id) {
		return repository.getMovieById(id);
	}
	public Movie[] getMovie() {
		return repository.getMovie();
	}
	public String delUser(String id) {
		return repository.deleteMovie(id);
	}
	public String updateUser(String id , String newId) {
		return repository.updateMovie(id,newId);
	}
	
}



