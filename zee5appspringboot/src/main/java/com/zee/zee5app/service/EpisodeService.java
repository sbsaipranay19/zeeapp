package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Episodes;

public interface EpisodeService {
	
	public Optional<Episodes> getEpisodeById(String id);

	public Optional<List<Episodes>> getAllEpisodes();

	public String deleteEpisodeById(String id);

	public String addEpisode(Episodes episode);
	
}
