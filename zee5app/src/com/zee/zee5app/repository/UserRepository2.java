//package com.zee.zee5app.repository;
//
//import com.zee.zee5app.dto.Register;
//
//public class UserRepository2 {
//	private Register[] registers = new Register[10];
//	private static int count=0;
//	private UserRepository() {
//		// TODO Auto-generated constructor stub
//		
//	}
//	public Register getUserById(String id) {
//		for (Register register : registers) {
//			if(register!=null && register.getId().equals(id) ) {
//				return register;
//			}
//		}
//		return null;
//	}
//	
//	public String addUser(Register register) {
//
//		if(count==registers.length) {
//			Register temp[] = new Register[registers.length*2];		
//			System.arraycopy(registers, 0, temp, 0, registers.length);
//			registers= temp;
//			registers[count++] = register;			
//			return "success";			
//		}
//		registers[count++] = register;
//		return "success";
//	}
//	
//	private static UserRepository userRepository;
//	public static UserRepository getInstance() {
//		
//		if(userRepository==null)
//			userRepository = new UserRepository();
//		return userRepository;
//		
//	}
//	public Register[] getUsers() {
//		return registers;
//	}
//	public String deleteUser(String id) {
//		Register temp[] = new Register[registers.length-1];
//		int index=0;
//		for (Register register : registers) {
//			if(register!=null && register.getId().equals(id) ) {
//				break;
//			}
//			index++;
//		}
//		int rem = registers.length - (index+1);
//		System.arraycopy(registers, 0, temp, 0, index);
//		System.arraycopy(registers, index+1, temp, index, rem);
//		registers = temp;
//		return "success";
//	}
//	public String updateUser(String id, String newId) {
//		for (Register register : registers) {
//			if(register!=null && register.getId().equals(id) ) {
//				register.setId(newId);	
//				return "success";
//				}
//		}
//		return "No ID found";
//		
//	}
//}
