package com.ugurhmz.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import javax.persistence.SecondaryTable;
import javax.persistence.Table;



@SecondaryTable(name = "t_address", pkJoinColumns = @PrimaryKeyJoinColumn(name="owner_id"))
@Entity
@Table( name="t_owner")
public class Owner extends Person {
	
	
	@Embedded		//iki tarafada koyduk,bunu koyduðumuza göre, diðerini koymadabiliriz.
	private Address address;

	
	// GETTER  & SETTER
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	
}
