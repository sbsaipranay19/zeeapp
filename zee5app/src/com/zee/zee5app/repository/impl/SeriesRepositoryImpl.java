package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.SeriesRepository;

public class SeriesRepositoryImpl implements SeriesRepository {
	
	private Series[] series1 = new Series[10];
	private static int count=0;
	
	private SeriesRepositoryImpl() {
		// TODO Auto-generated constructor stub
		
	}
	
	private static SeriesRepository seriesRepository;
	public static SeriesRepository getInstance() {
		if(seriesRepository==null)
			seriesRepository = new SeriesRepositoryImpl();
		return seriesRepository;
	}

	@Override
	public String addSeries(Series series) {
		
		if(count==series1.length) {
			Series temp[] = new Series[series1.length*2];		
			System.arraycopy(series1, 0, temp, 0, series1.length);
			series1= temp;
			series1[count++] = series;			
			return "success";			
		}
		series1[count++] = series;
		return "success";
		
	}

	@Override
	public Series getSeriesById(String id) {

		for (Series series : series1) {
			if(series!=null && series.getId().equals(id) ) {
				return series;
			}
		}
		return null;
		
	}

	@Override
	public Series[] getSeries() {
		return series1;
	}

	@Override
	public String updateSeries(String id, String newId) {
			
		for (Series series : series1) {
			if(series!=null && series.getId().equals(id) ) {
				series.setId(newId);	
				return "Update Success";
				}
		}
		return "No ID found";
		
	}

	@Override
	public String deleteSeries(String id) {
		
		Series temp[] = new Series[series1.length-1];
		int index=0;
		for (Series series : series1) {
			if(series!=null && series.getId().equals(id) ) {
				break;
			}
			index++;
		}
		int rem = series1.length - (index+1);
		System.arraycopy(series1, 0, temp, 0, index);
		System.arraycopy(series1, index+1, temp, index, rem);
		series1 = temp;
		return "Deletion Success";
		
	}

}
