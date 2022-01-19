package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Movie;

public class MovieRepository {
	private Movie[] movies = new Movie[10];
	private static int count=0;
	private MovieRepository() {
		// TODO Auto-generated constructor stub
		
	}
	private static MovieRepository movieRepository;
	public static MovieRepository getInstance() {
		if(movieRepository==null)
			movieRepository = new MovieRepository();
		return movieRepository;
	}

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

	public Movie getMovieById(String id) {
		for (Movie movie : movies) {
			if(movie!=null && movie.getId().equals(id) ) {
				return movie;
			}
		}
		return null;
	}

	public Movie[] getMovie() {
		return movies;
	}

	public String updateMovie(String id, String newId) {
		for (Movie movie : movies) {
			if(movie!=null && movie.getId().equals(id) ) {
				movie.setId(newId);	
				return "success";
				}
		}
		return "No ID found";
	}

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
		return "here";
	}

}



