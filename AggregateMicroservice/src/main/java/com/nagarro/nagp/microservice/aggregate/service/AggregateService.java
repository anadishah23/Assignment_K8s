package com.nagarro.nagp.microservice.aggregate.service;

import com.nagarro.nagp.microservice.aggregate.model.AggregateModel;

public interface AggregateService {

	public AggregateModel getOrderDetailsForUser(String userId);
	
}
