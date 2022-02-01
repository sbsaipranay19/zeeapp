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

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.utils.PasswordUtils;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	DataSource dataSource;
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	PasswordUtils passwordUtils;

	UserRepositoryImpl() throws IOException {
		// TODO Auto-generated constructor stub

	}

	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into register" + " (regId,firstname,lastname,email,contactNumber,password)"
				+ " values(?,?,?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, register.getId());
			preparedStatement.setString(2, register.getFirstName());
			preparedStatement.setString(3, register.getLastName());
			preparedStatement.setString(4, register.getEmail());
			preparedStatement.setBigDecimal(5, register.getContactNumber());
			String salt = passwordUtils.getSalt(30);
			String encryptedPassword = passwordUtils.generateSecurePassword(register.getPassword(), salt);
			preparedStatement.setString(6, encryptedPassword);

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
//				connection.commit();
				Login login = new Login();
				login.setUserName(register.getEmail());
				login.setPassword(encryptedPassword);
				login.setRegId(register.getId());
				login.setRole(ROLE.ROLE_USER);
				String res = loginRepository.addCredentials(login);
				if (res.equals("success")) {
					return "success";
				} else {
					connection.rollback();
					return "Fail";
				}
			} else {
				connection.rollback();
				return "Fail";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			try {
////				connection.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			return "fail";
		}

	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from register where regId=?";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Register register = new Register();
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactNumber(resultSet.getBigDecimal("contactNumber"));
				return Optional.of(register);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.empty();
	}

	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Optional<List<Register>> optional = getAllUserDetails();
		if (optional.isEmpty()) {
			return null;
		} else {

			List<Register> list = optional.get();
			Register[] registers = new Register[list.size()];
			return list.toArray(registers);
		}

	}

	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Register> arrayList = new ArrayList<>();
		String selectStatement = "select * from register";
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Register register = new Register();
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactNumber(resultSet.getBigDecimal("contactNumber"));
				arrayList.add(register);

			}
			return Optional.ofNullable(arrayList);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.empty();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteStatement = "delete from register where regId=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				return "success";
			} else
				return "fail";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

}