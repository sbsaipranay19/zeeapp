package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.repository.impl.SubscriptionRepositoryImpl;
import com.zee.zee5app.service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService {
	
	SubscriptionRepository repository = SubscriptionRepositoryImpl.getInstance();
	private static SubscriptionService  service = null;
	
	public static SubscriptionService getInstance() {
		
		if(service==null)
		service = new SubscriptionServiceImpl();
		return service;
		
	}
	
	@Override
	public String addSubscription(Subscription subscription) {
		return this.repository.addSubscription(subscription);
	}

	@Override
	public Subscription getSubscriptionById(String id) {
		return repository.getSubscriptionById(id);
	}

	@Override
	public Subscription[] getSubscription() {
		return repository.getSubscription();
	}

	@Override
	public String updateSubscription(String id, String newId) {
		return repository.updateSubscription(id,newId);
	}

	@Override
	public String deleteSubscription(String id) {
		return repository.deleteSubscription(id);
	}

}
