package com.nagarro.nagp.microservice.aggregate.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.nagp.microservice.aggregate.model.AggregateModel;
import com.nagarro.nagp.microservice.aggregate.model.OrderModel;
import com.nagarro.nagp.microservice.aggregate.model.UserModel;
import com.nagarro.nagp.microservice.aggregate.service.AggregateService;

@RestController
@RequestMapping(value = "/orderDetails")
public class AggregateController {

private static final Logger LOG = LoggerFactory.getLogger(AggregateController.class);
	
	@Resource(name = "restTemp")
	private RestTemplate restTemplate;
	
	@Resource
	private AggregateService aggregateService;
	
	@GetMapping(value = "/{userId}")
	public AggregateModel getOrderDetailsForUser(@PathVariable(name = "userId") String userId) {
		
		 LOG.info("Inside Aggregator application in getOrderDetailsForUser()");
		 AggregateModel aggregate = new AggregateModel();
		 
		 UserModel user = aggregateService.getUserDetailsForAggregator(userId);
		 LOG.info("Saving userModel with userId" + user + " in aggregatorService");
		 
		 aggregate.setUser(user);
		 
		 OrderModel[] orders = aggregateService.getOrderDetailsForAggregator(userId);
		 LOG.info("Saving orderListModel with orders" + orders + " in aggregatorService");
		 List<OrderModel> orderList = Arrays.asList(orders);
		 aggregate.setOrders(orderList);
		 return aggregate;
	}
	
	@GetMapping(value = "/test")
	public String testapi() {
		
		return "Successfully returning data";
	}
	
	
}
