package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.repository.EpisodeRepository;

@Repository
public class EpisodeRepositoryImpl implements EpisodeRepository {

	@Autowired
	DataSource dataSource;

	EpisodeRepositoryImpl() throws IOException {

	}

	@Override
	public Optional<Episodes> getEpisodeById(String id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from episodes where episodeId=?";

		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Episodes episodes = new Episodes();
				episodes.setEpisodeId(resultSet.getString("episodeId"));
				episodes.setEpisodeLength(resultSet.getDouble("episodeLength"));
				episodes.setLocation(resultSet.getString("location"));
				episodes.setTrailer(resultSet.getString("trailer"));
				episodes.setEpisodeName(resultSet.getString("episodeName"));
				episodes.setSeriesId(resultSet.getString("seriesId"));
				return Optional.of(episodes);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.empty();
	}

	@Override
	public Optional<List<Episodes>> getAllEpisodes() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Episodes> arrayList = new ArrayList<>();
		String selectStatement = "select * from episodes";

		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Episodes episodes = new Episodes();
				episodes.setEpisodeId(resultSet.getString("episodeId"));
				episodes.setEpisodeLength(resultSet.getDouble("length"));
				episodes.setLocation(resultSet.getString("location"));
				episodes.setTrailer(resultSet.getString("trailer"));
				episodes.setEpisodeName(resultSet.getString("episodeName"));
				episodes.setSeriesId(resultSet.getString("seriesId"));
				arrayList.add(episodes);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return Optional.ofNullable(arrayList);
	}

	@Override
	public String deleteEpisodeById(String id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteStatement = "delete from episodes where episodeId=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		} 
	}

	@Override
	public String addEpisode(Episodes episode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into episodes(episodeId,seriesId,episodeName,episodeLength,location,trailer) values(?,?,?,?,?,?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, episode.getEpisodeId());
			preparedStatement.setString(2, episode.getEpisodeName());
			preparedStatement.setString(3, episode.getSeriesId());
			preparedStatement.setDouble(4, episode.getEpisodeLength());
			preparedStatement.setString(5, episode.getLocation());

			preparedStatement.setString(6, episode.getTrailer());
			System.out.println("here");
			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				return "fail";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "success";
	}

}
