package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Subscription;

public class SubscriptionRepository {
	private Subscription[] subscriptions = new Subscription[10];
	private static int count=0;
	private SubscriptionRepository() {
		// TODO Auto-generated constructor stub
		
	}
	private static SubscriptionRepository subscriptionRepository;
	public static SubscriptionRepository getInstance() {
		if(subscriptionRepository==null)
			subscriptionRepository = new SubscriptionRepository();
		return subscriptionRepository;
	}

	public String addSubscription(Subscription subscription) {
		if(count==subscriptions.length) {
			Subscription temp[] = new Subscription[subscriptions.length*2];		
			System.arraycopy(subscriptions, 0, temp, 0, subscriptions.length);
			subscriptions= temp;
			subscriptions[count++] = subscription;			
			return "success";			
		}
		subscriptions[count++] = subscription;
		return "success";
	}

	public Subscription getSubscriptionById(String id) {
		for (Subscription subscription : subscriptions) {
			if(subscription!=null && subscription.getId().equals(id) ) {
				return subscription;
			}
		}
		return null;
	}

	public Subscription[] getSubscription() {
		return subscriptions;
	}

	public String updateSubscription(String id, String newId) {
		for (Subscription subscription : subscriptions) {
			if(subscription!=null && subscription.getId().equals(id) ) {
				subscription.setId(newId);	
				return "success";
				}
		}
		return "No ID found";
	}

	public String deleteSubscription(String id) {
		Subscription temp[] = new Subscription[subscriptions.length-1];
		int index=0;
		for (Subscription subscription : subscriptions) {
			if(subscription!=null && subscription.getId().equals(id) ) {
				break;
			}
			index++;
		}
		int rem = subscriptions.length - (index+1);
		System.arraycopy(subscriptions, 0, temp, 0, index);
		System.arraycopy(subscriptions, index+1, temp, index, rem);
		subscriptions = temp;
		return "here";
	}

}
