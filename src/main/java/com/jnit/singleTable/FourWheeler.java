package com.jnit.singleTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.DiscriminatorValue;

@Entity
@Table(name = "FOUR_WHEELER")
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
	@Column(name = "STEERING_TYPE")
	private String steeringFourWheeler;

	public String getSteeringFourWheeler() {
		return steeringFourWheeler;
	}

	public void setSteeringFourWheeler(String steeringFourWheeler) {
		this.steeringFourWheeler = steeringFourWheeler;
	}
}