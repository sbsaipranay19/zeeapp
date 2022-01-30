package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Episodes {
	public Episodes(String episodeId, String seriesId, String episodeName, double episodeLength, String location, String trailer) {
		// TODO Auto-generated constructor stub
		this.setEpisodeId(episodeId);
		this.setEpisodeLength(episodeLength);
		this.setEpisodeName(episodeName);
		this.setLocation(location);
		this.setSeriesId(seriesId);
		this.setTrailer(trailer);
	}
	public Episodes() {
		// TODO Auto-generated constructor stub
	}
	private String episodeId;
	private String episodeName;
	private double episodeLength;
	private String location;
	private String trailer;
	private String seriesId;
}
