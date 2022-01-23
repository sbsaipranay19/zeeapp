package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService;

public class UserServiceImpl implements UserService {
	
	public static UserService getInstance() {
		
		if(service== null) {
			service = new UserServiceImpl();
		}
		return service;
		
	}
	
	UserRepository userRepository = UserRepositoryImpl.getInstance();
	private static UserService service;
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return userRepository.addUser(register);
	}

	@Override
	public Optional<Register> updateUser(String id, String newId) throws IdNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return userRepository.updateUser(id, newId);
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	public List<Register> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.deleteUserById(id);
	}

}
