package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.LocationNotFOundException;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "series", uniqueConstraints = { @UniqueConstraint(columnNames = "seriesName") })
public class Series implements Comparable<Series> {

	@Id
	@Column(name = "seriesId")
	private String seriesId;
	@NotBlank
	private String seriesName;
	@NotNull
	@Max(value = 70)
	private int ageLimit;
	@NotBlank
	private String cast;
	@NotBlank
	private String genre;
	@NotBlank
	private String trailerLink;
	@NotBlank
	private String releaseDate;
	@NotBlank
	private String language;
	@NotNull
	@Min(value = 1)
	private int noOfEpisodes;

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

	public Series() {
		// TODO Auto-generated constructor stub
	}

}
