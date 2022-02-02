package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.LocationNotFOundException;

public interface SeriesService {

	public String addSeries(Series series);

	public Optional<Series> getSeriesById(String id)
			throws IdNotFoundException, InvalidIdLengthException, LocationNotFOundException;

	public Optional<List<Series>> getSeries() throws InvalidIdLengthException, LocationNotFOundException;

	public String deleteSeries(String id) throws IdNotFoundException;

}
