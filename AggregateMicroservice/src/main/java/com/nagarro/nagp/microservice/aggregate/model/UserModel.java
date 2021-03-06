package com.nagarro.nagp.microservice.aggregate.model;

public class UserModel {

	private String id;

	private String name;

	private int age;

	
	public UserModel() {
		
	}
	
	public UserModel(String id, String name, int age, String email, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	private String email;

	private String phoneNumber;

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}
