package com.nagarro.nagp.microservice.aggregate.model;

import java.util.List;

public class AggregateModel {

	UserModel user;
	
	OrderListModel orders;

	public AggregateModel() {
		
	}
	
	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public OrderListModel getOrders() {
		return orders;
	}

	public void setOrders(OrderListModel orders) {
		this.orders = orders;
	}
	
}
