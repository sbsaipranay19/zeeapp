package com.zee.zee5app;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;

public class Main2 {
 public static void main(String[]args) throws InvalidEmailException, InvalidPasswordException {
	 try {
		Register register = new Register("sai00001","pranay","bala sai","sai@gmail.com","123456");
		System.out.println(register);
		System.out.println(register.toString());
		System.out.println(register.hashCode());
		Register register2 = new Register("sai00001","pranay","bala sai","sai@gmail.com","123456");
		System.out.println(register2);
		System.out.println(register2.toString());
		System.out.println(register2.hashCode());
		System.out.println("equals method call "+register.equals(register2));
	} catch (InvalidNameException | InvalidIdLengthException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }

	
}