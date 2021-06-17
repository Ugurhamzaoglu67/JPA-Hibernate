package com.ugurhmz.petclinic.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name = "t_pet")
public class MyPet {
	
	
	@Id
	private Long id;
	
	@Basic
	@Column( name = "pet_name")
	private String petName;

	
	
	// GETTER & SETTER
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	
	
}
