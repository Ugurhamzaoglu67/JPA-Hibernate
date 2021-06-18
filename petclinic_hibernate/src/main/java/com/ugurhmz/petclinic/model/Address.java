package com.ugurhmz.petclinic.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private String phone;
	
	// GETTER & SETTER
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
