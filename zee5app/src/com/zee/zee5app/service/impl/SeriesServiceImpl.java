package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.impl.SeriesRepositoryImpl;
import com.zee.zee5app.service.SeriesService;

public class SeriesServiceImpl implements SeriesService {
	
	private SeriesServiceImpl() {
		
	}
	
	SeriesRepository repository = SeriesRepositoryImpl.getInstance();
	private static SeriesService  service = null;
	
	public static SeriesService getInstance() {
		
		if(service==null)
		service = new SeriesServiceImpl();
		return service;
		
	}

	@Override
	public String addSeries(Series series) {
		return this.repository.addSeries(series);
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
		return repository.getSeriesById(id);
	}

	@Override
	public List<Series> getSeries() {
		return repository.getAllSeriess();
	}

	@Override
	public Optional<Series> updateSeries(String id, String newId) throws IdNotFoundException, InvalidIdLengthException {
		return repository.updateSeries(id,newId);
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		return repository.deleteSeriesById(id);
	}

}
