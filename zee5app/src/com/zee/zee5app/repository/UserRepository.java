package com.zee.zee5app.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.*;
public interface UserRepository {
	
	public String addUser(Register register);
	public String updateUser(String id, String newId);
	public Optional<Register> getUserById(String id);
	public ArrayList<Register> getAllUsers();
	public String deleteUserById(String id);
	
}
