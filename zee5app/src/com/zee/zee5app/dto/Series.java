package com.zee.zee5app.dto;

import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.LocationNotFOundException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Series implements Comparable<Series> {
	
	private String seriesName;
	private String seriesCategory;
	private String releaseDate;
	@Setter(value = AccessLevel.NONE)
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
	
	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
	public void setTrailerLink(String trailerLink) throws LocationNotFOundException {
		if(trailerLink == null) {
			throw new LocationNotFOundException("Location Trailer Invalid");
		}
		this.trailerLink = trailerLink;
	}
	
}
