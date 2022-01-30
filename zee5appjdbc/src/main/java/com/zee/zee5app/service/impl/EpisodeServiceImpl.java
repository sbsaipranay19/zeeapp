package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.repository.impl.EpisodeRepositoryImpl;
import com.zee.zee5app.service.EpisodeService;

public class EpisodeServiceImpl implements EpisodeService {
	
	private EpisodeServiceImpl() throws IOException {

	}

	private EpisodeRepository repository = EpisodeRepositoryImpl.getInstance();
	private static EpisodeService service = null;

	public static EpisodeService getInstance() throws IOException {
		if (service == null)
			service = new EpisodeServiceImpl();
		return service;

	}

	@Override
	public Optional<Episodes> getEpisodeById(String id) {
		// TODO Auto-generated method stub
		return repository.getEpisodeById(id);
	}

	@Override
	public Optional<List<Episodes>> getAllEpisodes() {
		// TODO Auto-generated method stub
		return repository.getAllEpisodes();
	}

	@Override
	public String deleteEpisodeById(String id) {
		// TODO Auto-generated method stub
		return repository.deleteEpisodeById(id);
	}

	@Override
	public String addEpisode(Episodes episode) {
		// TODO Auto-generated method stub
		return repository.addEpisode(episode);
	}

}
