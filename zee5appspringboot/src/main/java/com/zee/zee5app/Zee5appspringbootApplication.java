package com.zee.zee5app;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.repository.UserRepository;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		System.out.println(dataSource != null);
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
//		try {
//			Register register = new Register("sai9149", "Sai Pranay", "SB", "sai96492@gmail.com", "123456");
//
//			register.setContactNumber(new BigDecimal("9876543210"));
//
//			Register result = userRepository.save(register);
//			System.out.println(result!=null);
//
//		} catch (InvalidIdLengthException | InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(dataSource != null);
		applicationContext.close();
	}

}
