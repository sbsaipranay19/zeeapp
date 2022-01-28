package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface SubscriptionService {
	
	public String addSubscription(Subscription subscription);
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException;
	public ArrayList<Subscription> getAllSubscriptions();
	public Optional<Subscription> updateSubscription(String id, String newId) throws IdNotFoundException, InvalidIdLengthException;
	public String deleteSubscriptionById(String id) throws IdNotFoundException;
	
}
