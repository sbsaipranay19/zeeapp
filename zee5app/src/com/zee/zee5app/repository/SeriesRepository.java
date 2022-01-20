package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Series;

public interface SeriesRepository {

	public String addSeries(Series series);
	public Series getSeriesById(String id);
	public Series[] getSeries();
	public String updateSeries(String id, String newId);
	public String deleteSeries(String id);
	
}
