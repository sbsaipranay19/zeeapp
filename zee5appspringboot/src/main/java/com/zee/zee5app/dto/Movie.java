package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "movie", uniqueConstraints = { @UniqueConstraint(columnNames = "movieName") })
public class Movie implements Comparable<Movie> {

	public Movie() {

	}

	@Id
	@Column(name = "id")
	private String id;
	@NotBlank
	private String movieName;
	@NotNull
	@Max(value = 70)
	private int ageLimit;
	@NotBlank
	private String cast;
	@NotBlank
	private String genre;
	@NotNull
	private double length;
//	@Lob
//	private byte[] trailer;
	@NotBlank
	private String trailer;
	@NotBlank
	private String releaseDate;
	@NotBlank
	private String language;

	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}