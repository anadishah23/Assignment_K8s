package com.nagarro.nagp.microservice.order.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.microservice.order.model.OrderListModel;
import com.nagarro.nagp.microservice.order.model.OrderModel;
import com.nagarro.nagp.microservice.order.services.OrderService;

@RestController
public class OrderServiceController {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderServiceController.class);
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order/{orderId}")
	public OrderModel getOrderDetail(@PathVariable("orderId") int orderId)
	{
		LOG.info("receiving data from orderService for given orderId");
		return orderService.getOrderDetail(orderId);
	}
	
	@GetMapping("/order/user/{userId}")
	public List<OrderModel> getOrderDetail(@PathVariable("userId") String userId)
	{
		LOG.info("receiving data from orderService for aggregator");	
		return orderService.getOrderDetailByUserId(userId);
	}
	
	
	@GetMapping("/allorder")
	public List<OrderModel> getAllOrderDetail()
	{
		LOG.info("receiving all order from order service");
		return orderService.getAllOrderDetail();
	}

}
