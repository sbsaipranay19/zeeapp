package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {
	
	private Movie[] movies = new Movie[2];
	private static int count=0;

	private MovieRepositoryImpl() {
		// TODO Auto-generated constructor stub
		
	}
	
	private static MovieRepository movieRepository;
	public static MovieRepository getInstance() {
		
		if(movieRepository==null)
			movieRepository = new MovieRepositoryImpl();
		return movieRepository;
		
	}
	
	@Override
	public String addMovie(Movie movie) {
		
		if(count==movies.length) {
			Movie temp[] = new Movie[movies.length*2];		
			System.arraycopy(movies, 0, temp, 0, movies.length);
			movies= temp;
			movies[count++] = movie;			
			return "success";			
		}
		movies[count++] = movie;
		return "success";
		
	}

	@Override
	public Movie getMovieById(String id) {
		
		for (Movie movie : movies) {
			if(movie!=null && movie.getId().equals(id) ) {
				return movie;
			}
		}
		return null;
		
	}

	@Override
	public Movie[] getMovies() {
		return movies;
	}

	@Override
	public String updateMovie(String id, String newId) {
		
		for (Movie movie : movies) {
			if(movie!=null && movie.getId().equals(id) ) {
				movie.setId(newId);	
				return "Update Success";
				}
		}
		return "No ID found";
		
	}

	@Override
	public String deleteMovie(String id) {
		
		Movie temp[] = new Movie[movies.length-1];
		int index=0;
		for (Movie movie : movies) {
			if(movie!=null && movie.getId().equals(id) ) {
				break;
			}
			index++;
		}
		int rem = movies.length - (index+1);
		System.arraycopy(movies, 0, temp, 0, index);
		System.arraycopy(movies, index+1, temp, index, rem);
		movies = temp;
		return "Deletion Success";
		
	}

}
