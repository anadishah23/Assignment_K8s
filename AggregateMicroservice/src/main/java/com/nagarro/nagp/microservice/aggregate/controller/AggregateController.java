package com.nagarro.nagp.microservice.aggregate.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.nagp.microservice.aggregate.model.AggregateModel;
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
	public AggregateModel getOderDetailsForUser(@PathVariable(name = "userId") String userId) {
		
		return aggregateService.getOrderDetailsForUser(userId);
	}
	
	@GetMapping(value = "/test")
	public String testapi() {
		
		return "sadfsdfsdfdsfasd";
	}
	
	
}
