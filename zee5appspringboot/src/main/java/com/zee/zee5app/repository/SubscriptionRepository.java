package com.zee.zee5app.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface SubscriptionRepository {

	public String addSubscription(Subscription subscription);

	public Optional<Subscription> getSubscriptionById(String id)
			throws IdNotFoundException, InvalidAmountException, InvalidIdLengthException;

	public Optional<Subscription> updateSubscription(String id, Subscription subscription)
			throws IdNotFoundException, InvalidIdLengthException;

	public String deleteSubscriptionById(String id) throws IdNotFoundException;

	public Optional<ArrayList<Subscription>> getAllSubscriptions()
			throws InvalidIdLengthException, InvalidAmountException;

}
