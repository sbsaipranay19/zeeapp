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
		
		for (int i = 0; i < 9; i++) {
			System.out.println("Adding Series" + i);
			Series series = new Series("series05"+1, "loser", 18, "Priyadarshi", "Sports",
					"https://www.youtube.com/watch?v=W_ZxZ0X8GDw", "2022-01-27", "telugu", 6);
			System.out.println(service.addSeries(series));
			System.out.println("Added Series: " + series.getSeriesId());
		}

		try {
			System.out.println("SeriesId: movie01 isPresent()=" + service.getSeriesById("subs0071").isPresent());
			System.out.println("Delete Series: movie01 " + service.deleteSeries("subs0071"));
			System.out.println("All Series Details: \n" + service.getSeries());
		} catch (IdNotFoundException | InvalidIdLengthException |LocationNotFOundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		applicationContext.close();
	}
}
