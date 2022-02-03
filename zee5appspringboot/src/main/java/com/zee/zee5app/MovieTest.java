package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.service.MovieService;

public class MovieTest {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);
		MovieService service =applicationContext.getBean(MovieService.class);
		
		for (int i = 0; i < 9; i++) {
			System.out.println("Adding Movie" + i);
			Movie movie = new Movie("movie0"+i, "loser"+i, 18, "Priyadarshi", "Sports", 39.57,
					"https://www.youtube.com/watch?v=W_ZxZ0X8GDw", "2022-01-27", "telugu");
			System.out.println(service.addMovie(movie));
			System.out.println("Added Movie: " + movie.getId());
		}

		try {
			System.out.println("MovieId: movie01 " + service.getMovieById("movie00").isPresent());
			System.out.println("Delete Movie: movie01 " + service.deleteMovie("movie01"));
			System.out.println("All Movie Details: \n" + service.getMovies());
		} catch (IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applicationContext.close();
		
		
	
		

	}
}
