package com.zee.zee5app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.SeriesService;


public class EpisodeTest {
	public static void main(String[] args) {
		

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);
		EpisodeService service = applicationContext.getBean(EpisodeService.class);
		SeriesService service1 =applicationContext.getBean(SeriesService.class);
		List<Episodes> al = new ArrayList<>();
		Series series = new Series("series050", "loser0", 18, "Priyadarshi", "Sports",
				"https://www.youtube.com/watch?v=W_ZxZ0X8GDw", "2022-01-27", "telugu", 6, al);
		for (int i = 0; i < 9; i++) {
			System.out.println("Adding Episode" + i);
			Episodes episodes = new Episodes("episode0"+i, "episode"+i, 29.57, "dfsggf",
					"https://www.youtube.com/watch?v=W_ZxZ0X8GDw", series);
			al.add(episodes);
			System.out.println(service.addEpisode(episodes));
			System.out.println("Added Episode: " + episodes.getEpisodeId());
		}
		service1.addSeries(series);
		

//		System.out.println("EpisodeId: episode01 isPresent()=" + service.getEpisodeById("episode01").isPresent());
//		System.out.println("Deleting Episode: episode01 " + service.deleteEpisodeById("episode01"));
//		System.out.println("All Series Details: \n" + service.getAllEpisodes());

		applicationContext.close();
	}
}
