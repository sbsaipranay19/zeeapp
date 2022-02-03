package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.ERole;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.repository.RoleRepository;
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
		
		RoleService roleService = applicationContext.getBean(RoleService.class);
		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
		
		System.out.println(roleService.addRole(role));
		System.out.println(roleService.addRole(role2));
//		UserRepository repository = applicationContext.getBean(UserRepository.class);
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findById(1).get());
		roles.add(roleRepository.findById(2).get());
		UserService service = applicationContext.getBean(UserService.class);
		Register register = new Register("sai15381", "Sai Pranay", "SB", "sai02452@gmail.com", "123456",
				new BigDecimal("987654290"), roles);
		try {
		System.out.println(service.addUser(register));
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applicationContext.close();
	}

}
