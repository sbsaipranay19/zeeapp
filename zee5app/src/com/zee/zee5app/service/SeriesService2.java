//package com.zee.zee5app.service;
//
//import com.zee.zee5app.dto.Series;
//import com.zee.zee5app.repository.SeriesRepository;
//import com.zee.zee5app.repository.UserRepository;
//public class SeriesService2 {
//private SeriesRepository repository = SeriesRepository.getInstance();
//	
//	private SeriesService() {
//	}
//	
//	private static SeriesService  service = null;
//	
//	public static SeriesService getInstance() {
//		if(service==null)
//		service = new SeriesService();
//		return service;
//		
//	}
//	public String addSeries(Series series) {
//		return this.repository.addSeries(series);
//	}
//	public Series getSeriesById(String id) {
//		return repository.getSeriesById(id);
//	}
//	public Series[] getSeries() {
//		return repository.getSeries();
//	}
//	public String delUser(String id) {
//		return repository.deleteSeries(id);
//	}
//	public String updateUser(String id , String newId) {
//		return repository.updateSeries(id,newId);
//	}
//	
//}
//
//
//
