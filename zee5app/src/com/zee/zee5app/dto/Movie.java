package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Movie {
	
	private String movieName;
	private String category;
	private String releaseDate;
	private String trailerLink;
	private String[] cast;
	private double length;
	private String id;
	
}
