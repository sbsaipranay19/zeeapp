package com.zee.zee5app;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zee.zee5app.config.Config;
import com.zee.zee5app.repository.UserRepository;

public class MainSpring {
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		DataSource userRepository = applicationContext.getBean("ds",DataSource.class);
//		System.out.println(userRepository);
		DataSource userRepository2 = applicationContext.getBean("ds",DataSource.class);
//		System.out.println(userRepository2);
		System.out.println(userRepository.hashCode());
		System.out.println(userRepository2.hashCode());
		System.out.println(userRepository2.equals(userRepository));
//		DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
//		try {
//			Register register = new Register("sai91301", "Sai Pranay", "SB", "sai91301@gmail.com", "123456");
//
//			register.setContactNumber(new BigDecimal("9876543210"));
//
//			String result = userRepository.addUser(register);
//			System.out.println(result);
//
//		} catch (InvalidIdLengthException | InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(dataSource != null);
		applicationContext.close();
	}
}
