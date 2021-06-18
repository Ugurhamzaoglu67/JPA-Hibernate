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
public class MyPet extends BaseEntity {
	
	
	@Basic (optional = false)
	@Column( name = "pet_name", nullable = false)
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
	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	
	@Override
	public String toString() {
		return "MyPet id="+getId()+"  petName=" + petName + ", petBirthOfDate=" + petBirthOfDate;
	}
	
}
