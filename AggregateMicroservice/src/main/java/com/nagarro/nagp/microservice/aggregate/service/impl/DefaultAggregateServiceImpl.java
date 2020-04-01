package com.nagarro.nagp.microservice.aggregate.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.nagp.microservice.aggregate.model.AggregateModel;
import com.nagarro.nagp.microservice.aggregate.model.OrderListModel;
import com.nagarro.nagp.microservice.aggregate.model.UserModel;
import com.nagarro.nagp.microservice.aggregate.service.AggregateService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DefaultAggregateServiceImpl implements AggregateService {

	
	@Value("${user.url}")
	private String userUrl;
	
	@Value("${order.url}")
	private String orderUrl;
	
	@Resource(name = "restTemp")
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="getfallbackDetailInfoForAggregate")
	public AggregateModel getOrderDetailsForUser(String userId) {
		// TODO Auto-generated method stub

			//String url = "/productInventory/productPrice?productCode=" + productCode;
		AggregateModel aggregateObj = new AggregateModel();
		OrderListModel orderForUser = null;
		UserModel user = null;
		try {
			
			ResponseEntity<UserModel> responseUserEntity = new RestTemplate()
					.getForEntity(userUrl+"/user/" + userId, UserModel.class); 

			user = responseUserEntity.getBody();
			
			ResponseEntity<OrderListModel> responseOrderEntity = new RestTemplate()
					.getForEntity(orderUrl+"/order/user/" + userId, OrderListModel.class); 

			orderForUser =  responseOrderEntity.getBody();
			
			/*
			 * String baseOrderUrl = "http://localhost:8085/order/order/user/" + userId;
			 * orderForUser = (List<OrderModel>) restTemplate.getForObject(baseOrderUrl,
			 * OrderModel.class);
			 */
				//productDetails = populateProductDetailsByInventory(inventory, productDetails);
			} catch (Exception ex) {
				System.out.println(ex);
			}
			
			aggregateObj.setUser(user);
			aggregateObj.setOrders(orderForUser);
			return aggregateObj;
	}

	public AggregateModel getfallbackDetailInfoForAggregate(String userId) {
		
		return getAggregateDetails(userId);
	}

	private AggregateModel getAggregateDetails(String userId) {
		// TODO Auto-generated method stub
		
		AggregateModel aggregate = new AggregateModel();
		
		aggregate.getUser().setId(userId);
		OrderListModel orderList = new OrderListModel();
		aggregate.setOrders(orderList);
		return aggregate;
	}

	
	
}
