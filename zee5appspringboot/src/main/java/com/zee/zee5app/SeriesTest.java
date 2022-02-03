package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.LocationNotFOundException;
import com.zee.zee5app.service.SeriesService;

public class SeriesTest {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);
		SeriesService service =applicationContext.getBean(SeriesService.class);
		
		for (int i = 0; i < 6; i++) {
			System.out.println("Adding Series" + i);
			Series series = new Series("series05"+i, "loser"+i, 18, "Priyadarshi", "Sports",
					"https://www.youtube.com/watch?v=W_ZxZ0X8GDw", "2022-01-27", "telugu", 6, null);
			System.out.println(service.addSeries(series));
			System.out.println("Added Series: " + series.getSeriesId());
		}

		try {
			System.out.println("SeriesId: series0051 isPresent()=" + service.getSeriesById("series051").isPresent());
			System.out.println("Delete Series: series051 " + service.deleteSeries("series051"));
//			System.out.println("All Series Details: \n" + service.getSeries());
		} catch (IdNotFoundException | InvalidIdLengthException |LocationNotFOundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		applicationContext.close();
	}
}
