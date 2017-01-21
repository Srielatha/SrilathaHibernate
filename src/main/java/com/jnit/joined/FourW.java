package com.jnit.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.DiscriminatorValue;

@Entity
@Table(name = "FOUR_WHEEL")
@DiscriminatorValue("Car")
public class FourW extends Veh {
	@Column(name = "STEERING_TYPE")
	private String steeringFourWheeler;

	public String getSteeringFourWheeler() {
		return steeringFourWheeler;
	}

	public void setSteeringFourWheeler(String steeringFourWheeler) {
		this.steeringFourWheeler = steeringFourWheeler;
	}
}