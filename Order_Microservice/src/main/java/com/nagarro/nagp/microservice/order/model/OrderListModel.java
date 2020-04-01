package com.nagarro.nagp.microservice.order.model;

import java.util.List;

public class OrderListModel {

	private List<OrderModel> orderList;

	public OrderListModel(){
		
	}
	
	public OrderListModel(List<OrderModel> orders){
		this.orderList=orders;
	}
	
	public List<OrderModel> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderModel> orderList) {
		this.orderList = orderList;
	}
	
}
