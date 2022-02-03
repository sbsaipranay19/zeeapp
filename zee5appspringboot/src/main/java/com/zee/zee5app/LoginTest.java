package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.service.LoginService;

public class LoginTest {
	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);
		LoginService service = applicationContext.getBean(LoginService.class);

		for (int i = 0; i < 9; i++) {
			System.out.println("Adding User" + i);
			Login login = new Login("sai9649" + i + "@gmail.com", "1234567", "sai9149"+i, ROLE.ROLE_USER);
			System.out.println(service.addCredentials(login));
			System.out.println("Added User: " + login.getRegId());
		}

		System.out.println("Delete User: sai96491@gmail.com " + service.deleteCredentials("sai96491@gmail.com"));

		applicationContext.close();
	}
}
