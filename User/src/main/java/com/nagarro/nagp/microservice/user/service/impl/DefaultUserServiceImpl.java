package com.nagarro.nagp.microservice.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.microservice.user.dao.impl.DefaultUserDetailDaoImpl;
import com.nagarro.nagp.microservice.user.model.UserModel;
import com.nagarro.nagp.microservice.user.services.DefaultUserService;

@Service
public class DefaultUserServiceImpl implements DefaultUserService{
	
	@Autowired
	private DefaultUserDetailDaoImpl userDetailDaoImpl;
	
	
	@Override
	public UserModel getUserDetail(String id)
	{
		return userDetailDaoImpl.getUserDetail(id);
	}
	@Override
	public List<UserModel> getAllUserDetail()
	{
		return userDetailDaoImpl.getAllUserDetail();
	}

}
