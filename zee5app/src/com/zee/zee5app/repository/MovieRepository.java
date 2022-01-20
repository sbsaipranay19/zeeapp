package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Movie;

public interface MovieRepository {

	public String addMovie(Movie movie);
	public Movie getMovieById(String id);
	public Movie[] getMovies();
	public String updateMovie(String id, String newId);
	public String deleteMovie(String id);
	
}
