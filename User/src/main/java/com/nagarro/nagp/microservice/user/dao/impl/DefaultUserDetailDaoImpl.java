package com.nagarro.nagp.microservice.user.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nagarro.nagp.microservice.user.dao.UserDetailDao;
import com.nagarro.nagp.microservice.user.model.UserModel;

@Component
public class DefaultUserDetailDaoImpl implements UserDetailDao{

	List<UserModel> userList = new ArrayList<UserModel>();

	public void createUserDetailData() {
		UserModel user1 = new UserModel("1", "john", 32, "john@gmail.com", "8735654222");
		UserModel user2 = new UserModel("2", "henry", 26, "henry22@gmail.com", "9488647645");
		UserModel user3 = new UserModel("3", "mark", 29, "mark8@gmail.com", "9589734561");
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
	}

	DefaultUserDetailDaoImpl(){
		createUserDetailData();
	}
	
	@Override
	public UserModel getUserDetail(String id) {
		
	Optional<UserModel> result = userList.stream().filter(user -> user.getId().equalsIgnoreCase(id)).findFirst();
		
		if(result.isPresent()) {
			return result.get();
		}
		else {
			return getDummyUserId(id);
		}
	}
	private UserModel getDummyUserId(String id) {
		// TODO Auto-generated method stub
		return new UserModel(id,"dummy-username",44,"dummy@gmail.com","dummy-number");
	}

	@Override
	public List<UserModel> getAllUserDetail()
	{
		return userList;
	}

}
