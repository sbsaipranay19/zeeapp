package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {

	@Autowired
	private static EpisodeRepository repository;

	@Override
	public Optional<Episodes> getEpisodeById(String id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.getById(id));
	}

	@Override
	public Optional<List<Episodes>> getAllEpisodes() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

	@Override
	public String deleteEpisodeById(String id) {
		Optional<Episodes> register3 = repository.findById(id);
		if (register3.isEmpty())
			return "fail";
		else {
			repository.deleteById(id);
			return "success";
		}
	}

	@Override
	public String addEpisode(Episodes episode) {
		// TODO Auto-generated method stub
		Episodes result = repository.save(episode);
		if (result != null)
			return "success";
		return "fail";
	}

}
