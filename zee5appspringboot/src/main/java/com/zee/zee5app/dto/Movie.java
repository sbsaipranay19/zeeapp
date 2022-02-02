package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "movie", uniqueConstraints = { @UniqueConstraint(columnNames = "movieName") })
public class Movie implements Comparable<Movie> {

	public Movie() {

	}

	@NotBlank
	private String movieName;
	@NotNull
	@Max(value = 70)
	private int ageLimit;
	@NotBlank
	private String genre;
	@NotBlank
	private String language;
	@NotBlank
	private String releaseDate;
	@NotBlank
	private String trailerLink;
	@NotBlank
	private String cast;
	@NotNull
	private double length;
	@Id
	@Column(name = "id")
	@Setter(value = AccessLevel.NONE)
	private String id;

	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}
