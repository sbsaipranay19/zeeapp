package com.zee.zee5app.service;

import com.zee.zee5app.dto.Series;

public interface SeriesService {
	
	public String addSeries(Series series);
	public Series getSeriesById(String id);
	public Series[] getSeries();
	public String updateSeries(String id, String newId);
	public String deleteSeries(String id);

}
