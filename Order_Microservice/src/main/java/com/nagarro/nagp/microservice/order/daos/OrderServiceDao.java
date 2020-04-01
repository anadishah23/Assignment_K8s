package com.nagarro.nagp.microservice.order.daos;

import java.util.List;

import com.nagarro.nagp.microservice.order.model.OrderModel;

public interface OrderServiceDao {

	public void createData();
	
	public OrderModel getOrderDetail(int orderId);

	public List<OrderModel> getOrderDetailByUserId(String userId);
	
	public List<OrderModel> getAllOrderDetail();
}
