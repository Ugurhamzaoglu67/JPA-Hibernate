package com.ugurhmz.petclinic.model;



import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table( name = "t_pet")
@SequenceGenerator(name="seqGen", sequenceName="pet_sequence")
public class MyPet {
	
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(generator="seqGen")
	private Long id;
	
	
	@Basic (optional = false)
	@Column( name = "pet_name", nullable = false)
	private String petName;

	
	@Column(name = "pet_birth_date")
	private Date petBirthOfDate;
	
	
	//CONSTRUCTOR - Paket d�zeyinde G�r�n�rl��e sahip olcak bo� 1 tane olmal�.
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
