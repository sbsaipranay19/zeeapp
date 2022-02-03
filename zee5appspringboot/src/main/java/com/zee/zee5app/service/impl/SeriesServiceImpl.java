package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.LocationNotFOundException;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.service.SeriesService;

@Service
public class SeriesServiceImpl implements SeriesService {

	@Autowired
	private SeriesRepository repository;

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		Series result = repository.save(series);
		if (result != null)
			return "success";
		return "fail";
	}

	@Override
	public Optional<Series> getSeriesById(String id)
			throws IdNotFoundException, InvalidIdLengthException, LocationNotFOundException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.getById(id));
	}

	@Override
	public Optional<List<Series>> getSeries() throws InvalidIdLengthException, LocationNotFOundException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		Optional<Series> register3 = repository.findById(id);
		if (register3.isEmpty())
			return "fail";
		else {
			repository.deleteById(id);
			return "success";
		}
	}

}
