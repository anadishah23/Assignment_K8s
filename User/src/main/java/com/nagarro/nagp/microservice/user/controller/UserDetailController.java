package com.nagarro.nagp.microservice.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.microservice.user.model.UserModel;
import com.nagarro.nagp.microservice.user.services.DefaultUserService;

@RestController
public class UserDetailController {
	
	@Autowired
	private DefaultUserService userServiceImpl;
	
	@GetMapping("/user/{userId}")
	public UserModel getUserDetail(@PathVariable("userId") String id)
	{
		return userServiceImpl.getUserDetail(id);
	}
	
	@GetMapping("/alluser")
	public List<UserModel> getAllUserDetail()
	{
		return userServiceImpl.getAllUserDetail();
	}

}
