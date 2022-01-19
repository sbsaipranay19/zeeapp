package com.zee.zee5app;

import java.util.Iterator;

import com.zee.zee5app.service.*;
import com.zee.zee5app.dto.*;

public class Main {
	public static void main(String[] args) {
		Register register = new Register();
		register.setFirstName("Sai");
		register.setLastName("pranay");
		register.setEmail("sai@gmail.com");
		System.out.println(register);
		Login login = new Login();
		login.setUserName("sb19");
		login.setPassword("qwerty");
		System.out.println(login);
		UserService service = UserService.getInstance();
		for(int i=1;i<=15;i++) {
			Register register2 = new Register();
			register2.setId("ab00"+i);
			register2.setFirstName("abhi"+i);
			register2.setLastName("sai"+i);
			register2.setPassword("Sai");
			String result = service.addUser(register2);
			System.out.println(result+" "+i);
		}
		Register register2 = service.getUserById("ab01");
		System.out.println(register2!=null);
		String register4 = service.delUser("ab0010");
		System.out.println(register4);
		
		String register5 = service.updateUser("ab006","ab007");
		System.out.println(register5);
		for(Register register3 : service.getUsers()) {
			if(register3 !=null)
			System.out.println(register3);
		}
		
	}
}
