package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;

public interface UserService {

	public String addUser(Register register) throws AlreadyExistsException;

//	public String updateUser(String id, Register register);

	public Optional<Register> getUserById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;

	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException;

	public String deleteUserById(String id) throws IdNotFoundException;

	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException;
}