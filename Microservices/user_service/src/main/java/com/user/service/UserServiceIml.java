package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.model.User;

@Service
public class UserServiceIml implements UserService {

	// fake Data
	List<User> list = List.of(new User(1l, "Vaibhav"), 
							  new User(2l, "Sagar"));

	@Override
	public User getUser(Long id) {
		return (User) list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
				
	}

}
