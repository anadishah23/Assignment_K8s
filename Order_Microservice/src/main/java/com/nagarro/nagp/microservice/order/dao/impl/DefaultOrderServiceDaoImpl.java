package com.nagarro.nagp.microservice.order.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.nagarro.nagp.microservice.order.daos.OrderServiceDao;
import com.nagarro.nagp.microservice.order.model.OrderModel;

@Repository
public class DefaultOrderServiceDaoImpl implements OrderServiceDao {
	
	List<OrderModel> orderList = new ArrayList<OrderModel>();
	
	public void createData()
	{
		OrderModel order1 = new OrderModel(1,250,"1-Mar-2020","1");
		OrderModel order2 = new OrderModel(2,400,"15-Mar-2020","1");
		OrderModel order3 = new OrderModel(3,315,"17-Mar-2020","2");
		OrderModel order4 = new OrderModel(4,353,"19-Mar-2020","2");
		OrderModel order5 = new OrderModel(5,515,"27-Mar-2020","3");
		OrderModel order6 = new OrderModel(6,853,"29-Mar-2020","3");
		orderList.add(order1);
		orderList.add(order2);
		orderList.add(order3);
		orderList.add(order4);
		orderList.add(order5);
		orderList.add(order6);
	}
	
	DefaultOrderServiceDaoImpl(){
		createData();
	}
	
	public OrderModel getOrderDetail(int orderId)
	{
		Optional<OrderModel> result = orderList.stream().filter(o -> o.getOrderId() == orderId).findFirst();
		
		if(result.isPresent()) {
			return result.get();
		}
		else {
			return getDummyProduct(orderId);
		}
	}
	
	private OrderModel getDummyProduct(int orderId) {
		// TODO Auto-generated method stub
		return new OrderModel(orderId,493,"31-03-20","dummy-order");
	}

	public List<OrderModel> getAllOrderDetail()
	{
		return orderList;
	}

	@Override
	public List<OrderModel> getOrderDetailByUserId(String userId) {
		// TODO Auto-generated method stub
		List<OrderModel> result = orderList.stream().filter(o -> o.getUserId().equalsIgnoreCase(userId)).collect(Collectors.toList());
		
		return result;
	}

}
