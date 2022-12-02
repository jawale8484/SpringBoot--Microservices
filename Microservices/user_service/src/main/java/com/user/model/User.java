package com.user.model;

import java.util.ArrayList;
import java.util.List;

//@Entity 
public class User {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String name;
	
	List<Contact> contacts= new ArrayList<Contact>();

//	@OneToOne
//	private Contact contact;
//	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String name, List<Contact> contacts) {
		super();
		this.userId = userId;
		this.name = name;
		this.contacts = contacts;
	}

	public User(Long userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + "]";
	}
	
		

}
