package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;

public interface UserService {

	public User addUser(User register) throws AlreadyExistsException;

//	public String updateUser(String id, Register register);

	public Optional<User> getUserById(Long id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;

	public User[] getAllUsers() throws InvalidIdLengthException, InvalidNameException;

	public String deleteUserById(Long id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;

	public Optional<List<User>> getAllUserDetails();
}