package com.nagarro.nagp.microservice.aggregate.service;

import com.nagarro.nagp.microservice.aggregate.model.OrderModel;
import com.nagarro.nagp.microservice.aggregate.model.UserModel;

public interface AggregateService {

	public UserModel getUserDetailsForAggregator(String userId);
	
	public OrderModel[] getOrderDetailsForAggregator(String userId);
	
}
