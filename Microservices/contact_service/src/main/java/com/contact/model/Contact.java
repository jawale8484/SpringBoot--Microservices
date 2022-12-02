package com.contact.model;



//@Entity
public class Contact {
	

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cId;
	private String email;
	private String phoneNuber;
	
	private Long userId;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(Long cId, String email, String phoneNuber, Long userId) {
		super();
		this.cId = cId;
		this.email = email;
		this.phoneNuber = phoneNuber;
		this.userId = userId;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNuber() {
		return phoneNuber;
	}

	public void setPhoneNuber(String phoneNuber) {
		this.phoneNuber = phoneNuber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	
}
