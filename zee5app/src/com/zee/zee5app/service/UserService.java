package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface UserService {
	
	public String addUser(Register register);
	public Optional<Register> updateUser(String id, String newId) throws IdNotFoundException, InvalidIdLengthException;
	public Optional<Register> getUserById(String id) throws IdNotFoundException;
	public List<Register> getAllUsers();
	public String deleteUserById(String id) throws IdNotFoundException;
	
}
