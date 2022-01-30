package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.utils.DBUtils;

public class LoginRepositoryImpl implements LoginRepository {

	DBUtils dbUtils = DBUtils.getInstance();

	private LoginRepositoryImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	private static LoginRepository repository;

	public static LoginRepository getInstance() throws IOException {
		if (repository == null) {
			repository = new LoginRepositoryImpl();
		}
		return repository;
	}

	@Override
	public String addCredentials(Login login) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into login" + " (userName,password,regId,role)" + " values(?,?,?,?)";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, login.getUserName());
			preparedStatement.setString(2, login.getPassword());
			preparedStatement.setString(3, login.getRegId());
			preparedStatement.setString(4, login.getRole().toString());

//			connection.commit();
			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "success";
			} else
				return "fail";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}

	}

	@Override
	public String deleteCredentials(String userName) {
		Connection connection;
		PreparedStatement preparedStatement;

		String deleteStatement = "DELETE FROM login WHERE username=?";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, userName);

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "Success";
			} else {
				connection.rollback();
				return "Fail";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		} finally {
			dbUtils.closeConnection(connection);
		}

	}

	@Override
	public String changePassword(String userName, String password) {
		Connection connection;
		PreparedStatement preparedStatement;
		String updateStatement = "UPDATE login SET password=? WHERE username=?";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, userName);

			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
				return "Success";
			} else {
				connection.rollback();
				return "Fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		} finally {
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public String changeRole(String userName, ROLE role) {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		String updateStatement = "UPDATE login SET role=? WHERE username=?";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, role.toString());
			preparedStatement.setString(2, userName);

			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
				return "Success";
			} else {
				connection.rollback();
				return "Fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		} finally {
			dbUtils.closeConnection(connection);
		}
	}

}
