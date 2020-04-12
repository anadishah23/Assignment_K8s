package com.nagarro.nagp.microservice.aggregate.model;

import java.util.List;

public class AggregateModel {

	UserModel user;
	
	List<OrderModel> orders;

	public AggregateModel() {
		
	}
	
	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public List<OrderModel> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderModel> orders) {
		this.orders = orders;
	}
	
}
