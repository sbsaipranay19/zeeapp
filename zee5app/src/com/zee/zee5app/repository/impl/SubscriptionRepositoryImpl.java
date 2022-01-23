package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.SubscriptionRepository;

public class SubscriptionRepositoryImpl implements SubscriptionRepository {
	
	private List<Subscription> subscriptions = new ArrayList<>();
	private SubscriptionRepositoryImpl(){
		
	}
	
	private static SubscriptionRepository repository;
	public static SubscriptionRepository getInstance() {
		
		if(repository== null) {
			repository = new SubscriptionRepositoryImpl();
		}
		return repository;
		
	}
	
	@Override
	public String addSubscription(Subscription subscription) {
		
		boolean result = this.subscriptions.add(subscription);
		if(result) {
			return "success";
		}
		return "fail";
		
	}
	
	@Override
	public String deleteSubscriptionById(String id) throws IdNotFoundException {
		
			Optional<Subscription> optional = this.getSubscriptionById(id);
			if(optional.isPresent()) {
				boolean result =subscriptions.remove(optional.get());
				if(result) {
					return "Deletion Success";
				}else {
					return "Failure";
				}
			}else {
				throw new IdNotFoundException("ID Not Found");
			}
	}
	
	public ArrayList<Subscription> getAllSubscriptions() {
		Collections.sort(subscriptions);
		return  (ArrayList<Subscription>) subscriptions;
	}
	
	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException {
		
		Subscription subscription2 = null;
		for (Subscription subscription : subscriptions) {
			if(subscription.getId().equals(id)) {
				subscription2= subscription;
				break;
			}
		}
		return Optional.ofNullable(Optional.ofNullable(subscription2).orElseThrow(()-> new IdNotFoundException("ID Not Found")));
		
	}
	
	@Override
	public Optional<Subscription> updateSubscription(String id, String newId) throws IdNotFoundException, InvalidIdLengthException {
		Subscription subscription2 = null;
		for (Subscription subscription : subscriptions) {
			if(subscription.getId().equals(id)) {
				subscription2 = subscription;
				subscription.setId(newId);
				System.out.println("Update Success");
				break;
			}
		}	
		return Optional.ofNullable(Optional.ofNullable(subscription2).orElseThrow(()-> new IdNotFoundException("ID Not Found")));
	}
	
}







