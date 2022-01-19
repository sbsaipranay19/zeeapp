package com.zee.zee5app.service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepository;

public class SubscriptionService {
private SubscriptionRepository repository = SubscriptionRepository.getInstance();
	
	private SubscriptionService() {
	}
	
	private static SubscriptionService  service = null;
	
	public static SubscriptionService getInstance() {
		if(service==null)
		service = new SubscriptionService();
		return service;
		
	}
	public String addSubscription(Subscription subscription) {
		return this.repository.addSubscription(subscription);
	}
	public Subscription getSubscriptionById(String id) {
		return repository.getSubscriptionById(id);
	}
	public Subscription[] getSubscription() {
		return repository.getSubscription();
	}
	public String delUser(String id) {
		return repository.deleteSubscription(id);
	}
	public String updateUser(String id , String newId) {
		return repository.updateSubscription(id,newId);
	}
	
}
