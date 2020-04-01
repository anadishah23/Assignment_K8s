package com.nagarro.nagp.microservice.user.dao;

import java.util.List;

import com.nagarro.nagp.microservice.user.model.UserModel;

public interface UserDetailDao {

	public void createUserDetailData();
	public UserModel getUserDetail(String id) ;
	
	public List<UserModel> getAllUserDetail();
	
}
