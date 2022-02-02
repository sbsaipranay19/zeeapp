package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface SubscriptionService {

	public String addSubscription(Subscription subscription);

	public Optional<Subscription> getSubscriptionById(String id)
			throws IdNotFoundException, InvalidAmountException, InvalidIdLengthException;

	public Optional<List<Subscription>> getAllSubscriptions() throws InvalidIdLengthException, InvalidAmountException;

	public String deleteSubscriptionById(String id) throws IdNotFoundException;

}
