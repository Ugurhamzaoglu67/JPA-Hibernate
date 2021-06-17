package com.ugurhmz.petclinic.model;



import java.util.Date;

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

	
	@Column(name = "pet_birth_date")
	private Date petBirthOfDate;
	
	
	//CONSTRUCTOR - Paket düzeyinde Görünürlüðe sahip olcak boþ 1 tane olmalý.
	public MyPet() {
		
	}
	
	public MyPet(String petName, Date petBirthOfDate) {
		this.petName = petName;
		this.petBirthOfDate = petBirthOfDate;
		
	}

	
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

	
	@Override
	public String toString() {
		return "MyPet [id=" + id + ", petName=" + petName + ", petBirthOfDate=" + petBirthOfDate + "]";
	}
	
}
