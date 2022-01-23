package com.zee.zee5app.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
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
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException {
		return repository.getSubscriptionById(id);
	}

	@Override
	public ArrayList<Subscription> getAllSubscriptions() {
		return repository.getAllSubscriptions();
	}

	@Override
	public Optional<Subscription> updateSubscription(String id, String newId) throws IdNotFoundException, InvalidIdLengthException {
		return repository.updateSubscription(id,newId);
	}

	@Override
	public String deleteSubscriptionById(String id) throws IdNotFoundException {
		return repository.deleteSubscriptionById(id);
	}

}
