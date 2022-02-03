package com.zee.zee5app;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.service.SubscriptionService;

public class SubscriptionTest {
public static void main(String[] args) {


	
	ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
			args);
	SubscriptionService service =applicationContext.getBean(SubscriptionService.class);
	
	for (int i = 0; i < 9; i++) {
		System.out.println("Adding Subscription" + i);
		Subscription subscription = new Subscription("subs007"+i, Date.valueOf("2022-01-23") ,Date.valueOf("2023-01-23"), 1000, "Credit", "active",
				"annual", "no", "sai9149" + i);
		System.out.println(service.addSubscription(subscription));
		System.out.println("Added Subscription: " + subscription.getId());
	}

	try {
		System.out.println("SubscriptionId: subs0071 isPresent()=" + service.getSubscriptionById("subs0071").isPresent());
		System.out.println("Delete Subsription: subs0071 " + service.deleteSubscriptionById("subs0071"));
		System.out.println("All Subscription Details: \n" + service.getAllSubscriptions());
	} catch (IdNotFoundException | InvalidIdLengthException |InvalidAmountException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	applicationContext.close();
}
}
