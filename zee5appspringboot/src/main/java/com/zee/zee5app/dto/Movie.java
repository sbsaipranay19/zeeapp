package com.zee.zee5app.dto;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode

public class Movie implements Comparable<Movie> {

	public Movie() {

	}

	public Movie(String id, String movieName, int ageLimit, String cast, String genre, double length,
			String trailerLink, String releaseDate, String language) throws InvalidIdLengthException {
		// TODO Auto-generated constructor stub
		super();
		this.setCast(cast);
		this.setMovieName(movieName);
		this.setGenre(genre);
		this.setAgeLimit(ageLimit);
		this.setId(id);
		this.setReleaseDate(releaseDate);
		this.setTrailerLink(trailerLink);
		this.setLength(length);
		this.setLanguage(language);
	}

	private String movieName;
	private int ageLimit;
	private String genre;
	private String language;
	private String releaseDate;
	private String trailerLink;
	private String cast;
	private double length;
	@Setter(value = AccessLevel.NONE)
	private String id;

	public void setId(String id) throws InvalidIdLengthException {

		if (id.length() <= 6) {
			throw new InvalidIdLengthException("id length is lessthan or equal to 6");
		}
		this.id = id;

	}

	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}
