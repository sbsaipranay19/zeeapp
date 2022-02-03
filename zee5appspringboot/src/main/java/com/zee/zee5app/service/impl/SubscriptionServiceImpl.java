package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	@Autowired
	private SubscriptionRepository repository;

	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		Subscription result = repository.save(subscription);
		if (result != null)
			return "success";
		return "fail";
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id)
			throws IdNotFoundException, InvalidAmountException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.getById(id));
	}

	@Override
	public Optional<List<Subscription>> getAllSubscriptions() throws InvalidIdLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

	@Override
	public String deleteSubscriptionById(String id) throws IdNotFoundException {
		Optional<Subscription> register3 = repository.findById(id);
		if (register3.isEmpty())
			return "fail";
		else {
			repository.deleteById(id);
			return "success";
		}
	}

}
