package com.ugurhmz.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;




@Entity
@Table( name = "t_vet")
public class Vet  extends Person{
	
	
	@Column ( name="works_full_time")
	private boolean worksFullTime;

	
	
	// GETTER &SETTER
	public boolean isWorksFullTime() {
		return worksFullTime;
	}

	public void setWorksFullTime(boolean worksFullTime) {
		this.worksFullTime = worksFullTime;
	}

	
}
