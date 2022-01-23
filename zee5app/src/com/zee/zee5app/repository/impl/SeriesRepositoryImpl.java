package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.SeriesRepository;

public class SeriesRepositoryImpl implements SeriesRepository {
	
	private TreeSet<Series> series1 = new TreeSet<>();
	
	private SeriesRepositoryImpl(){
		
	}
	
	private static SeriesRepository repository;
	public static SeriesRepository getInstance() {
		
		if(repository== null) {
			repository = new SeriesRepositoryImpl();
		}
		return repository;
		
	}
	
	@Override
	public String addSeries(Series series) {
		
		boolean result = this.series1.add(series);
		if(result) {
			return "success";
		}
		return "fail";
		
	}
	
	@Override
	public String deleteSeriesById(String id) throws IdNotFoundException {
		
			Optional<Series> optional = this.getSeriesById(id);
			if(optional.isPresent()) {
				boolean result =series1.remove(optional.get());
				if(result) {
					return "Deletion Success";
				}else {
					return "Failure";
				}
			}else {
				throw new IdNotFoundException("ID Not Found");
			}	
	}
	
	@Override
	public List<Series> getAllSeriess() {
		return new ArrayList<>(series1);
	}
	
	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
		
		Series series2 = null;
		for (Series series : series1) {
			if(series.getId().equals(id)) {
				series2= series;
				break;
			}
		}
		return Optional.ofNullable(Optional.ofNullable(series2).orElseThrow(()-> new IdNotFoundException("ID Not Found")));
		
	}
	
	@Override
	public Optional<Series> updateSeries(String id, String newId) throws IdNotFoundException, InvalidIdLengthException {
		Series series2 = null;
		for (Series series : series1) {
			if(series.getId().equals(id)) {
				series2 = series;
				series.setId(newId);
				System.out.println("Update Success");
				break;
			}
		}
		return Optional.ofNullable(Optional.ofNullable(series2).orElseThrow(()-> new IdNotFoundException("ID Not Found")));
		}

}



