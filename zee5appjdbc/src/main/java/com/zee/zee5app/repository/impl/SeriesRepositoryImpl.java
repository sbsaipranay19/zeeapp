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

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.LocationNotFOundException;
import com.zee.zee5app.repository.SeriesRepository;

@Repository
public class SeriesRepositoryImpl implements SeriesRepository {

	@Autowired
	DataSource dataSource;

	private SeriesRepositoryImpl() throws IOException {

	}

	@Override
	public String addSeries(Series series) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into series(seriesId,seriesName,ageLimit,cast,genre,length,trailerLink,releaseDate,language,no_of_episodes) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, series.getSeriesId());
			preparedStatement.setString(2, series.getSeriesName());
			preparedStatement.setInt(3, series.getAgeLimit());
			preparedStatement.setString(4, series.getCast());
			preparedStatement.setString(5, series.getGenre());
			preparedStatement.setDouble(6, series.getLength());
			preparedStatement.setString(7, series.getTrailerLink());
			preparedStatement.setString(8, series.getReleaseDate());
			preparedStatement.setString(9, series.getLanguage());
			preparedStatement.setInt(10, series.getNo_of_episodes());
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

	@Override
	public Optional<Series> getSeriesById(String id)
			throws IdNotFoundException, InvalidIdLengthException, LocationNotFOundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from series where seriesId=?";

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
				Series series = new Series();
				series.setSeriesId(resultSet.getString("seriesId"));
				series.setAgeLimit(resultSet.getInt("ageLimit"));
				series.setCast(resultSet.getString("cast"));
				series.setGenre(resultSet.getString("genre"));
				series.setLanguage(resultSet.getString("language"));
				series.setLength(resultSet.getDouble("length"));
				series.setNo_of_episodes(resultSet.getInt("no_of_episodes"));
				series.setTrailerLink(resultSet.getString("trailerLink"));
				series.setReleaseDate(resultSet.getString("releaseDare"));
				series.setSeriesName(resultSet.getString("seriesName"));
				return Optional.of(series);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.empty();
	}

	@Override
	public Optional<Series> updateSeries(String id, Series series)
			throws IdNotFoundException, InvalidIdLengthException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateStatement = "update series set seriesId=? , seriesName= ?, ageLimit =?, cast=?, genre=?, length=?,trailerLink = ? , releaseDate=?, language=?, no_of_episodes=? where (seriesId=?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, series.getSeriesId());
			preparedStatement.setString(2, series.getSeriesName());
			preparedStatement.setInt(3, series.getAgeLimit());
			preparedStatement.setString(4, series.getCast());
			preparedStatement.setString(5, series.getGenre());
			preparedStatement.setDouble(6, series.getLength());
			preparedStatement.setString(7, series.getTrailerLink());
			preparedStatement.setString(8, series.getReleaseDate());
			preparedStatement.setString(9, series.getLanguage());
			preparedStatement.setInt(10, series.getNo_of_episodes());
			preparedStatement.setString(11, id);
			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return Optional.of(series);
			} else {
				return Optional.ofNullable(series);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Series>> getAllSeriess() throws InvalidIdLengthException, LocationNotFOundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Series> arrayList = new ArrayList<>();
		String selectStatement = "select * from series";

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
				Series series = new Series();
				series.setSeriesId(resultSet.getString("seriesId"));
				series.setAgeLimit(resultSet.getInt("ageLimit"));
				series.setCast(resultSet.getString("cast"));
				series.setGenre(resultSet.getString("genre"));
				series.setLanguage(resultSet.getString("language"));
				series.setLength(resultSet.getDouble("length"));
				series.setNo_of_episodes(resultSet.getInt("no_of_episodes"));
				series.setTrailerLink(resultSet.getString("trailerLink"));
				series.setReleaseDate(resultSet.getString("releaseDare"));
				series.setSeriesName(resultSet.getString("seriesName"));
				arrayList.add(series);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.ofNullable(arrayList);
	}

	@Override
	public String deleteSeriesById(String id) throws IdNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteStatement = "delete from series where seriesId=?";
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

}
