package com.nagarro.nagp.microservice.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.microservice.order.model.OrderListModel;
import com.nagarro.nagp.microservice.order.model.OrderModel;
import com.nagarro.nagp.microservice.order.services.OrderService;

@RestController
public class OrderServiceController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order/{orderId}")
	public OrderModel getOrderDetail(@PathVariable("orderId") int orderId)
	{
		return orderService.getOrderDetail(orderId);
	}
	
	@GetMapping("/order/user/{userId}")
	public OrderListModel getOrderDetail(@PathVariable("userId") String userId)
	{
		OrderListModel orderList = new OrderListModel(orderService.getOrderDetailByUserId(userId));
		
		return orderList;
	}
	
	
	@GetMapping("/allorder")
	public List<OrderModel> getAllOrderDetail()
	{
		return orderService.getAllOrderDetail();
	}

}