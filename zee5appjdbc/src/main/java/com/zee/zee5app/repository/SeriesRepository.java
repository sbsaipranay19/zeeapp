package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.LocationNotFOundException;

public interface SeriesRepository {

	public String addSeries(Series series);

	public Optional<Series> getSeriesById(String id)
			throws IdNotFoundException, InvalidIdLengthException, LocationNotFOundException;

	public Optional<Series> updateSeries(String id, Series series) throws IdNotFoundException, InvalidIdLengthException;

	public Optional<List<Series>> getAllSeriess() throws InvalidIdLengthException, LocationNotFOundException;

	public String deleteSeriesById(String id) throws IdNotFoundException;

}
