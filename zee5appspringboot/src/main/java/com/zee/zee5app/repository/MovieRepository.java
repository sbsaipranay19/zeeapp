package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
	
	Optional<Movie> findByMovieNameAndLanguage(String movieName,String language);
	Optional<Movie> findByMovieName (String movieName);
	Optional<Movie> findByMovieNameAndReleaseDate (String movieName, String releaseDate);
	Optional<Movie> findBycast (String cast);
	
}
