package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface SeriesService {
	
	public String addSeries(Series series);
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException;
	public List<Series> getSeries();
	public Optional<Series> updateSeries(String id, String newId) throws IdNotFoundException, InvalidIdLengthException;
	public String deleteSeries(String id) throws IdNotFoundException;

}
