package com.ugurhmz.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table( name="t_owner")
public class Owner {
	

	@Id
	@GeneratedValue
	private Long id;
	
	@Column( name = "first_name")
	private String ownerFirstName;
	
	
	@Column( name = "last_name")
	private String ownerLastName;
	
	@Embedded		//iki tarafada koyduk,bunu koyduðumuza göre, diðerini koymadabiliriz.
	private Address address;

	
	
	// GETTER  & SETTER
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
	
	
	
	
}
