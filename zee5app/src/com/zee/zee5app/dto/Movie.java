package com.zee.zee5app.dto;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode

public class Movie implements Comparable<Movie> {
	
	public Movie(String movieName,String category,String releaseDate,String trailerLink,String[] cast,double length,String id) throws InvalidIdLengthException {
		
		super();
		this.setCast(cast);
		this.setMovieName(movieName);
		this.setCategory(category);
		this.setId(id);
		this.setReleaseDate(releaseDate);
		this.setTrailerLink(trailerLink);
		this.setLength(length);
	}
	
	public Movie() {
		
	}
	
	private String movieName;
	private String category;
	private int ageLimit;
	private String genre;
	private String language;
	private String releaseDate;
	private String trailerLink;
	private String[] cast;
	private double length;
	@Setter(value = AccessLevel.NONE)
	private String id;
	
	public void setId(String id) throws InvalidIdLengthException {
		
		if(id.length()<=6) {
			throw new InvalidIdLengthException("id length is lessthan or equal to 6");
		}
		this.id = id;
		
	}
	
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
			
}
