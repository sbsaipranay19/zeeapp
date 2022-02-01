package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	private static SubscriptionRepository repository = null;

	public SubscriptionServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	private static SubscriptionService service = null;

	public static SubscriptionService getInstance() throws IOException {

		if (service == null)
			service = new SubscriptionServiceImpl();
		return service;

	}

	@Override
	public String addSubscription(Subscription subscription) {
		return this.repository.addSubscription(subscription);
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id)
			throws IdNotFoundException, InvalidAmountException, InvalidIdLengthException {
		return repository.getSubscriptionById(id);
	}

	@Override
	public Optional<ArrayList<Subscription>> getAllSubscriptions()
			throws InvalidIdLengthException, InvalidAmountException {
		return repository.getAllSubscriptions();
	}

	@Override
	public Optional<Subscription> updateSubscription(String id, Subscription subscription)
			throws IdNotFoundException, InvalidIdLengthException {
		return repository.updateSubscription(id, subscription);
	}

	@Override
	public String deleteSubscriptionById(String id) throws IdNotFoundException {
		return repository.deleteSubscriptionById(id);
	}

}
