package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.impl.MovieRepositoryImpl;
import com.zee.zee5app.repository.impl.SeriesRepositoryImpl;
import com.zee.zee5app.service.MovieService;
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
	public Series getSeriesById(String id) {
		return repository.getSeriesById(id);
	}

	@Override
	public Series[] getSeries() {
		return repository.getSeries();
	}

	@Override
	public String updateSeries(String id, String newId) {
		return repository.updateSeries(id,newId);
	}

	@Override
	public String deleteSeries(String id) {
		return repository.deleteSeries(id);
	}

}
