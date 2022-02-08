package com.zee.zee5app;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.ERole;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Main2 {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);
		Role role = new Role();
		role.setRoleName(ERole.ROLE_ADMIN);
		
		Role role2 = new Role();
		role2.setRoleName(ERole.ROLE_USER); 
		LoginService service2 = applicationContext.getBean(LoginService.class);
		RoleService roleService = applicationContext.getBean(RoleService.class);
		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
		Login login = new Login("sai9649@gmail.com", "1234567", null);
		Subscription subscription = new Subscription("subs0007", Date.valueOf("2022-01-23") ,Date.valueOf("2023-01-23"), 1000, "Credit", "active",
				"annual", "no", null);
		System.out.println(service2.addCredentials(login));
		System.out.println(roleService.addRole(role));
		System.out.println(roleService.addRole(role2));
//		UserRepository repository = applicationContext.getBean(UserRepository.class);
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findById(1).get());
		roles.add(roleRepository.findById(2).get());
		UserService service = applicationContext.getBean(UserService.class);
//		Register register = new Register("sai15381", "Sai Pranay", "SB", "sai02452@gmail.com", "123456",
//				new BigDecimal("987654290"), roles,subscription,login);
//		try {
//		System.out.println(service.addUser(register));
//		} catch (AlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		applicationContext.close();
	}

}
