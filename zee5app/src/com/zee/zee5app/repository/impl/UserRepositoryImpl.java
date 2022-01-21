package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
	
//	private Register[] registers = new Register[10];
	private ArrayList<Register> registers = new ArrayList<Register>();
//	private static int count=0;
	
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
	public String deleteUserById(String id) {
			return null;
	}
	@Override
	public ArrayList<Register> getAllUsers() {
				return registers;
	}
	@Override
	public Optional<Register> getUserById(String id) {
		
		Register register2 = null;
		for (Register register : registers) {
			if(register.getId().equals(id)) {
				register2= register;
			}
		}
		return Optional.ofNullable(register2);
		
	}
	@Override
	public String updateUser(String id, String newId) {
			return null;
		}

}
