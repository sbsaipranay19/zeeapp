package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
	
	private TreeSet<Register> registers = new TreeSet<>();
	private UserRepositoryImpl(){
		
	}
	
	private static UserRepository repository;
	public static UserRepository getInstance() {
		
		if(repository== null) {
			repository = new UserRepositoryImpl();
		}
		return repository;	
	}
	
	@Override
	public String addUser(Register register) {
		
		boolean result = this.registers.add(register);
		if(result) {
			return "success";
		}
		return "fail";
		
	}
	
	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		
			Optional<Register> optional = this.getUserById(id);
			if(optional.isPresent()) {
				boolean result =registers.remove(optional.get());
				if(result) {
					return "Deletion Success";
				}else {
					return "Failure";
				}
			}else {
				throw new IdNotFoundException("ID Not Found");
			}
			
	}
	
	@Override
	public List<Register> getAllUsers() {
		return new ArrayList<>(registers.descendingSet());
	}
	
	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		
		Register register2 = null;
		for (Register register : registers) {
			if(register.getRegId().equals(id)) {
				register2= register;
				break;
			}
		}
		return Optional.ofNullable(Optional.ofNullable(register2).orElseThrow(()-> new IdNotFoundException("ID Not Found")));
	}
	
	@Override
	public Optional<Register> updateUser(String id, String newId) throws IdNotFoundException, InvalidIdLengthException {
		Register register2 = null;
		for (Register register : registers) {
			if(register.getRegId().equals(id)) {
				register2 = register;
				register.setId(newId);
				System.out.println("Update Success");
				break;
			}
		}
		return Optional.ofNullable(Optional.ofNullable(register2).orElseThrow(()-> new IdNotFoundException("ID Not Found")));
	
	}

}
