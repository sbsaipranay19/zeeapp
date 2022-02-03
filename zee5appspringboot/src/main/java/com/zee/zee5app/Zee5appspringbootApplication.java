package com.zee.zee5app;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		System.out.println(dataSource != null);
		UserService service = applicationContext.getBean(UserService.class);
//		for (int i = 0; i < 9; i++) {
//			System.out.println("Adding User" + i);
//			Register register = new Register("sai9149" + i, "Sai Pranay", "SB", "sai9649" + i + "@gmail.com", "123456",
//					new BigDecimal("987654" + i + "210"));
//			try {
//				System.out.println(service.addUser(register));
//			} catch (AlreadyExistsException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("Added User: " + register.getId());
//		}
//
//		try {
//			System.out.println("UserId: sai91491 " + service.getUserById("sai91491"));
//			System.out.println("Delete User: sai91491 " + service.deleteUserById("sai91491"));
//			System.out.println("All User Details: \n" + service.getAllUserDetails());
//		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		applicationContext.close();
	}

}
