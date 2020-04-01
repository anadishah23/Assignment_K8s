package com.nagarro.nagp.microservice.aggregate.model;

import java.util.List;

public class OrderListModel {

	private List<OrderModel> orderList;

	public OrderListModel(){
		
	}
	
	public List<OrderModel> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderModel> orderList) {
		this.orderList = orderList;
	}
	
	
}
