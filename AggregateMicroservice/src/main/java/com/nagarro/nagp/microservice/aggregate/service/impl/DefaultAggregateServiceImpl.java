package com.nagarro.nagp.microservice.aggregate.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.nagp.microservice.aggregate.model.OrderListModel;
import com.nagarro.nagp.microservice.aggregate.model.OrderModel;
import com.nagarro.nagp.microservice.aggregate.model.UserModel;
import com.nagarro.nagp.microservice.aggregate.service.AggregateService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DefaultAggregateServiceImpl implements AggregateService {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultAggregateServiceImpl.class);
	
	@Value("${user.url}")
	private String userUrl;
	
	@Value("${order.url}")
	private String orderUrl;
	
	@Resource(name = "restTemp")
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="getfallbackDetailInfoForAggregate")
	public UserModel getUserDetailsForAggregator(String userId) {
		// TODO Auto-generated method stub

		
		UserModel user = null;
		try {
			
			String user_Url = userUrl + "/user/" + userId;
			ResponseEntity<UserModel> responseUserEntity = restTemplate.exchange(user_Url, HttpMethod.GET, null, UserModel.class);
			
			user = responseUserEntity.getBody();
			
			LOG.info("receiving data from user service" + user.getId());
			
			} catch (Exception ex) {
				System.out.println(ex);
			}
;
			return user;
	}

	public UserModel getfallbackDetailInfoForAggregate(String userId) {
		
		return getAggregateDetails(userId);
	}

	private UserModel getAggregateDetails(String userId) {
		// TODO Auto-generated method stub
		
		UserModel user = new UserModel();
		user.setId(userId);
		return user;
	}

	@Override
	@HystrixCommand(fallbackMethod="getfallbackOrderDetailInfoForAggregate")
	public OrderModel[] getOrderDetailsForAggregator(String userId) {
		// TODO Auto-generated method stub
		
		OrderModel[] orderForUser = null;
		String order_Url = orderUrl+"/order/user/" + userId;
		  ResponseEntity<OrderModel[]> responseOrderEntity = restTemplate.exchange(order_Url, HttpMethod.GET, null, OrderModel[].class);
		  
		  orderForUser = responseOrderEntity.getBody();
		  
		  LOG.info("receiving data from order service" + orderForUser);
		  /*
			 * ResponseEntity<OrderListModel> responseOrderEntity = new RestTemplate()
			 * .getForEntity(orderUrl+"/order/user/" + userId, OrderListModel.class);
			 * 
			 * orderForUser = responseOrderEntity.getBody();*/
			 
		return orderForUser;
	}

	public OrderListModel getfallbackOrderDetailInfoForAggregate(String userId) {
		
		return null;
	}
	
}
