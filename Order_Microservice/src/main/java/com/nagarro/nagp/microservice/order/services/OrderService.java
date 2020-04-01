package com.nagarro.nagp.microservice.order.services;

import java.util.List;

import com.nagarro.nagp.microservice.order.model.OrderModel;

public interface OrderService {

	public OrderModel getOrderDetail(int orderId);
	
	public List<OrderModel> getOrderDetailByUserId(String userId);
	
	public List<OrderModel> getAllOrderDetail();
	
}
