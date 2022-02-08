package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private LoginServiceImpl service;

	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public Register addUser(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		// make exception for the next line
		if (userRepository.existsByEmailAndContactNumber(register.getEmail(), register.getContactNumber()) == true) {
			throw new AlreadyExistsException("User already exists");
		}
		Register register2 = userRepository.save(register);
//		if (register2 != null) {
//					Login login = new Login(register.getEmail(), register.getPassword(), register.getId());
//					if(loginRepository.existsByUserName(register.getEmail()))
//					{
//						throw new AlreadyExistsException("Username already exists");
//					}
//					String result = service.addCredentials(login);
//					if(result.equals("success")) {
//						return "success";
//					}
//					else {
//						return "fail";
//					}
//		} else {
//			return null;
//		}
		return register2;
	}

	

	@Override
	public Register getUserById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Optional<Register> register3 = userRepository.findById(id);
		if(register3.isEmpty()) {
			throw new IdNotFoundException("ID does not exists");
		}else
		return register3.get();
	}

	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		List<Register> list = userRepository.findAll();
		Register[] result = new Register[list.size()];

		return list.toArray(result);
	}

	@Override
	public String deleteUserById(String id) throws InvalidIdLengthException, InvalidNameException, IdNotFoundException {
		Register optional;
		try {
			optional = this.getUserById(id);
			if(optional==null) {
				throw new IdNotFoundException("Record Not Found");
			}else {
				userRepository.deleteById(id);
				return "Register Record Deleted";
			}
		}catch (IdNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}

}