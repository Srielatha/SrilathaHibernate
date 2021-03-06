package com.jnit.singleTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.DiscriminatorValue;

@Entity
@Table(name = "TWO_WHEELER")
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
	@Column(name = "STEERING_TYPE")
	private String steeringTwoWheeler;

	public String getSteeringTwoWheeler() {
		return steeringTwoWheeler;
	}

	public void setSteeringTwoWheeler(String steeringTwoWheeler) {
		this.steeringTwoWheeler = steeringTwoWheeler;
	}
}
