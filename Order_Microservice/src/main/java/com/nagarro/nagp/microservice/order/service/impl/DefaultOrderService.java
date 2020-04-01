package com.nagarro.nagp.microservice.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nagarro.nagp.microservice.order.daos.OrderServiceDao;
import com.nagarro.nagp.microservice.order.model.OrderModel;
import com.nagarro.nagp.microservice.order.services.OrderService;

@Service
public class DefaultOrderService implements OrderService{

	@Resource
	private OrderServiceDao OrderServiceDao;
	@Override
	public OrderModel getOrderDetail(int orderId) {
		// TODO Auto-generated method stub
		return OrderServiceDao.getOrderDetail(orderId);
	}

	@Override
	public List<OrderModel> getOrderDetailByUserId(String userId) {
		// TODO Auto-generated method stub
		return OrderServiceDao.getOrderDetailByUserId(userId);
	}

	@Override
	public List<OrderModel> getAllOrderDetail() {
		// TODO Auto-generated method stub
		return OrderServiceDao.getAllOrderDetail();
	}

}
