//package com.zee.zee5app.service;
//
//import com.zee.zee5app.dto.Register;
//import com.zee.zee5app.repository.UserRepository;
//
//public class UserService1 {
//	private UserRepository repository = UserRepository.getInstance();
//	
//	private UserService() {
//	}
//	
//	private static UserService  service = null;
//	
//	public static UserService getInstance() {
//		if(service==null)
//		service = new UserService();
//		return service;
//		
//	}
//	public String addUser(Register register) {
//		return this.repository.addUser(register);
//	}
//	public Register getUserById(String id) {
//		return repository.getUserById(id);
//	}
//	public Register[] getUsers() {
//		return repository.getUsers();
//	}
//	public String delUser(String id) {
//		return repository.deleteUser(id);
//	}
//	public String updateUser(String id , String newId) {
//		return repository.updateUser(id,newId);
//	}
//}
