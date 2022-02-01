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

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@Autowired
	DataSource dataSource;

	private MovieRepositoryImpl() throws IOException {

	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from movies where id=?";

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
				Movie movie = new Movie();
				movie.setId(resultSet.getString("id"));
				movie.setAgeLimit(resultSet.getInt("ageLimit"));
				movie.setCast(resultSet.getString("cast"));
				movie.setGenre(resultSet.getString("genre"));
				movie.setLanguage(resultSet.getString("language"));
				movie.setLength(resultSet.getDouble("length"));
				movie.setTrailerLink(resultSet.getString("trailer"));
				movie.setReleaseDate(resultSet.getString("releaseDare"));
				movie.setMovieName(resultSet.getString("movieName"));
				return Optional.of(movie);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.empty();
	}

	@Override
	public Optional<Movie> updateMovie(String id, Movie movie) throws IdNotFoundException, InvalidIdLengthException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateStatement = "update movies set id=? , movieName= ?, ageLimit =?, cast=?, genre=?, length=?,trailer = ? , releaseDate=?, language=? where (id=?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, movie.getId());
			preparedStatement.setString(2, movie.getMovieName());
			preparedStatement.setInt(3, movie.getAgeLimit());
			preparedStatement.setString(4, movie.getCast());
			preparedStatement.setString(5, movie.getGenre());
			preparedStatement.setDouble(6, movie.getLength());
			preparedStatement.setString(7, movie.getTrailerLink());
			preparedStatement.setString(8, movie.getReleaseDate());
			preparedStatement.setString(9, movie.getLanguage());
			preparedStatement.setString(10, id);
			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return Optional.of(movie);
			} else {
				return Optional.ofNullable(movie);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Movie>> getAllMovies() throws InvalidIdLengthException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Movie> arrayList = new ArrayList<>();
		String selectStatement = "select * from movies where id=?";

		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Movie movie = new Movie();
				movie.setId(resultSet.getString("Id"));
				movie.setAgeLimit(resultSet.getInt("ageLimit"));
				movie.setCast(resultSet.getString("cast"));
				movie.setGenre(resultSet.getString("genre"));
				movie.setLanguage(resultSet.getString("language"));
				movie.setLength(resultSet.getDouble("length"));
				movie.setTrailerLink(resultSet.getString("trailer"));
				movie.setReleaseDate(resultSet.getString("releaseDare"));
				movie.setMovieName(resultSet.getString("movieName"));
				arrayList.add(movie);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.ofNullable(arrayList);
	}

	@Override
	public String deleteMovieById(String id) throws IdNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteStatement = "delete from movies where id=?";
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
	public String addMovie(Movie movie) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into movies(Id,movieName,ageLimit,cast,genre,length,trailer,releaseDate,language) values(?,?,?,?,?,?,?,?,?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, movie.getId());
			preparedStatement.setString(2, movie.getMovieName());
			preparedStatement.setInt(3, movie.getAgeLimit());
			preparedStatement.setString(4, movie.getCast());
			preparedStatement.setString(5, movie.getGenre());
			preparedStatement.setDouble(6, movie.getLength());
			preparedStatement.setString(7, movie.getTrailerLink());
			preparedStatement.setString(8, movie.getReleaseDate());
			preparedStatement.setString(9, movie.getLanguage());
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
