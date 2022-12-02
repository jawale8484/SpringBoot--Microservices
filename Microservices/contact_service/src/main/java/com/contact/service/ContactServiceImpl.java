package com.contact.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.model.Contact;

@Service
public class ContactServiceImpl implements ContactService{

	List<Contact> list = List.of(
			new Contact(11l, "v@gmail.com", "363782", 1l),
			new Contact(12l, "s@gmail.com", "547388", 2l)
			
			);
	
	
	@Override
	public List<Contact> getContactOfUser(Long userId) {
		return (List<Contact>) this.list.stream().
				filter(contact->contact.
						getUserId().
						equals(userId)).collect(Collectors.toList());
	}

}
