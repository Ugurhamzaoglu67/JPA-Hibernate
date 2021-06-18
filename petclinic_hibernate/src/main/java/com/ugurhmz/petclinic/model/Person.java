package com.ugurhmz.petclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public abstract class Person extends BaseEntity{

	
	@Column( name = "first_name")
	private String ownerFirstName;
	
	
	@Column( name = "last_name")
	private String ownerLastName;
	
	
	// GETTER & SETTER
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
	
}
