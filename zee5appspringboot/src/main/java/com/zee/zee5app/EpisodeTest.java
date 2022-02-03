package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.service.EpisodeService;

public class EpisodeTest {
	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);
		EpisodeService service = applicationContext.getBean(EpisodeService.class);

		for (int i = 0; i < 9; i++) {
			System.out.println("Adding Episode" + i);
			Episodes episodes = new Episodes("episode0"+i, "episode1", 29.57, "dfsggf",
					"https://www.youtube.com/watch?v=W_ZxZ0X8GDw", "series050");
			System.out.println(service.addEpisode(episodes));
			System.out.println("Added Episode: " + episodes.getSeriesId());
		}

		System.out.println("EpisodeId: episode01 isPresent()=" + service.getEpisodeById("episode01").isPresent());
		System.out.println("Deleting Episode: episode01 " + service.deleteEpisodeById("episode01"));
		System.out.println("All Series Details: \n" + service.getAllEpisodes());

		applicationContext.close();
	}
}
