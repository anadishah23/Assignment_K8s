package com.nagarro.nagp.microservice.aggregate.model;

public class OrderModel {
	
	private int orderId;
	
	private double orderAmount;
	
	private String orderDate;
	
	private String userId;

	public OrderModel(){
		
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public OrderModel(int orderId, double orderAmount, String orderDate,String userId) {
		super();
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
		this.userId = userId;
		
	}
	

}
