package com.zee.zee5app.repository;

import com.zee.zee5app.dto.*;
public interface UserRepository {
	
	public String addUser(Register register);
	public String updateUser(String id, String newId);
	public Register getUserById(String id);
	public Register[] getAllUsers();
	public String deleteUserById(String id);
	
}
