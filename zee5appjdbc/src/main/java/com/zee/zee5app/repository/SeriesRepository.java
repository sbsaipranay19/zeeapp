package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface SeriesRepository {

	public String addSeries(Series series);
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException;
	public Optional<Series> updateSeries(String id, String newId) throws IdNotFoundException, InvalidIdLengthException;
	public List<Series> getAllSeriess();
	public String deleteSeriesById(String id) throws IdNotFoundException;
	
}
