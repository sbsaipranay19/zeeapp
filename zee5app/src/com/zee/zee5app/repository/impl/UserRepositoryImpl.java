package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
	
	private Register[] registers = new Register[10];
	private static int count=0;
	
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
		
		if(count==registers.length) {
			Register temp[] = new Register[registers.length*2];		
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers= temp;
			registers[count++] = register;			
			return "success";			
		}
		registers[count++] = register;
		return "success";
		
	}

	@Override
	public String updateUser(String id, String newId) {
		
		for (Register register : registers) {
			if(register!=null && register.getId().equals(id) ) {
				register.setId(newId);	
				return "Update Success";
				}
		}
		return "No ID found";
		
	}

	@Override
	public Register getUserById(String id) {
		
		for (Register register : registers) {
			if(register!=null && register.getId().equals(id) ) {
				return register;
			}
		}
		return null;
		
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return registers;
	}

	@Override
	public String deleteUserById(String id) {
		
		Register temp[] = new Register[registers.length-1];
		int index=0;
		for (Register register : registers) {
			if(register!=null && register.getId().equals(id) ) {
				break;
			}
			index++;
		}
		int rem = registers.length - (index+1);
		System.arraycopy(registers, 0, temp, 0, index);
		System.arraycopy(registers, index+1, temp, index, rem);
		registers = temp;
		return "Deletion Success";
		
	}

}
