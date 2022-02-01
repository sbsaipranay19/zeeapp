package com.zee.zee5app.dto;

import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.LocationNotFOundException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Series implements Comparable<Series> {

	private String seriesName;
	private String genre;
	private int ageLimit;
	private String language;
	private int no_of_episodes;
	private String releaseDate;
	@Setter(value = AccessLevel.NONE)
	private String trailerLink;
	private String cast;
	private double length;
	@Setter(value = AccessLevel.NONE)
	private String seriesId;

	public void setSeriesId(String id) throws InvalidIdLengthException {

		if (id.length() <= 6) {
			throw new InvalidIdLengthException("id length is lessthan or equal to 6");
		}
		this.seriesId = id;

	}

	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.seriesId.compareTo(o.getSeriesId());
	}

	public void setTrailerLink(String trailerLink) throws LocationNotFOundException {
		if (trailerLink == null) {
			throw new LocationNotFOundException("Location Trailer Invalid");
		}
		this.trailerLink = trailerLink;
	}

	public Series(String seriesId, String seriesName, int ageLimit, String cast, String genre, double length,
			String trailerLink, String releaseDate, String language, int no_of_episodes)
			throws InvalidIdLengthException, LocationNotFOundException {
		// TODO Auto-generated constructor stub
		this.setAgeLimit(ageLimit);
		this.setCast(cast);
		this.setGenre(genre);
		this.setLanguage(language);
		this.setLength(length);
		this.setNo_of_episodes(no_of_episodes);
		this.setReleaseDate(releaseDate);
		this.setSeriesId(seriesId);
		this.setTrailerLink(trailerLink);
		this.setSeriesName(seriesName);
	}

	public Series() {
		// TODO Auto-generated constructor stub
	}

}
