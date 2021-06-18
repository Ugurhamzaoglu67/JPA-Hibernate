package com.ugurhmz.petclinic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_owner_withComposite")
public class OwnerWithCompositePK {
	
	
	

	@Embeddable
	public static class OwnerId implements Serializable {
		
		@Column(name="owner_firstname", nullable = false)
		private String firstName;
		
		@Column(name="owner_lastname", nullable=false)
		private String lastName;
		
		
		// GETTER && SETTER
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	
	}
	
	@Id
	private OwnerId id;

	public OwnerId getId() {
		return id;
	}

	public void setId(OwnerId id) {
		this.id = id;
	}
	
	
	
	
}
