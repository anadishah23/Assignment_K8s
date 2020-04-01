package com.nagarro.nagp.microservice.user.services;

import java.util.List;

import com.nagarro.nagp.microservice.user.model.UserModel;

public interface DefaultUserService {

	public List<UserModel> getAllUserDetail();
	
	public UserModel getUserDetail(String id);
	
	
}
