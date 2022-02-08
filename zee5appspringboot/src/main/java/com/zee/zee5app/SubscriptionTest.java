package com.zee.zee5app;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.ERole;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;

public class SubscriptionTest {
public static void main(String[] args) {


	
	ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
			args);
	SubscriptionService service =applicationContext.getBean(SubscriptionService.class);
	UserService service1 = applicationContext.getBean(UserService.class);
	Role role = new Role();
	role.setRoleName(ERole.ROLE_ADMIN);
	
	Role role2 = new Role();
	role2.setRoleName(ERole.ROLE_USER); 
	
	RoleService roleService = applicationContext.getBean(RoleService.class);
	RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
	
	System.out.println(roleService.addRole(role));
	System.out.println(roleService.addRole(role2));
//	UserRepository repository = applicationContext.getBean(UserRepository.class);
	Set<Role> roles = new HashSet<>();
	roles.add(roleRepository.findById(1).get());
	roles.add(roleRepository.findById(2).get());
//	
//	for (int i = 0; i < 9; i++) {
//		Register register = new Register("sai1538"+i, "Sai Pranay", "SB", "sai0"+i+"452@gmail.com", "123456",
//				new BigDecimal("987654290"), roles, null);
//		try {
//			System.out.println(service1.addUser(register));
//		} catch (AlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Subscription subscription = new Subscription("subs007"+i, Date.valueOf("2022-01-23") ,Date.valueOf("2023-01-23"), 1000, "Credit", "active",
//				"annual", "no", register);
//		System.out.println(service.addSubscription(subscription));
//		System.out.println("Added Subscription: " + subscription.getId());
//	}
//
//	try {
//		System.out.println("SubscriptionId: subs0071 isPresent()=" + service.getSubscriptionById("subs0071").isPresent());
//		System.out.println("Delete Subsription: subs0071 " + service.deleteSubscriptionById("subs0071"));
////		System.out.println("All Subscription Details: \n" + service.getAllSubscriptions());
//	} catch (IdNotFoundException | InvalidIdLengthException |InvalidAmountException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} 
	applicationContext.close();
}
}
