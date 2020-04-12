package com.nagarro.nagp.microservice.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.microservice.user.model.UserModel;
import com.nagarro.nagp.microservice.user.services.DefaultUserService;

@RestController
public class UserDetailController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserDetailController.class);
	
	@Autowired
	private DefaultUserService userServiceImpl;
	
	@GetMapping("/user/{userId}")
	public UserModel getUserDetail(@PathVariable("userId") String id)
	{
		LOG.info("receiving data from user service" + id);
		return userServiceImpl.getUserDetail(id);
	}
	
	@GetMapping("/alluser")
	public List<UserModel> getAllUserDetail()
	{
		LOG.info("receiving data of all user");
		return userServiceImpl.getAllUserDetail();
	}

}
