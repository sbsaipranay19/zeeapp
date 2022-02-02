package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private static UserRepository userRepository = null;
//	private static UserService service;

	// UserRepository userRepository ;

	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		Register register2 = userRepository.save(register);
		if (register2 != null)
			return "success";
		else
			return "fail";
	}

	@Override
	public Optional<Register> getUserById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Optional<Register> register3 = userRepository.findById(id);
		return register3;
	}

	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		List<Register> list = userRepository.findAll();
		Register[] result = new Register[list.size()];

		return list.toArray(result);
	}

	@Override
	public String deleteUserById(String id) {
		Optional<Register> register3 = userRepository.findById(id);
		if (register3.isEmpty())
			return "fail";
		else {
			userRepository.deleteById(id);
			return "success";
		}
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}

}