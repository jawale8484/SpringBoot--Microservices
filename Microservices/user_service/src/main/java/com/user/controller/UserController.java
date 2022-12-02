package com.user.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.model.Contact;
import com.user.model.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String home() {
		return ("Wecome User");
	}

	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Long userId) {
		User user = this.userService.getUser(userId);
		// http://localhost:8082/contact/user/1

		List cotactlist = this.restTemplate.getForObject("http://localhost:8082/contact/user/" + user.getUserId(),
				List.class);
		user.setContacts( cotactlist);
		return user;
	}
}
