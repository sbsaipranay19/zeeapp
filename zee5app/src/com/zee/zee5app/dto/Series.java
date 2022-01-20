package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Series {
	
	private String seriesName;
	private String seriesCategory;
	private String releaseDate;
	private String trailerLink;
	private String[] cast;
	private double length;
	private String id;
	
}
