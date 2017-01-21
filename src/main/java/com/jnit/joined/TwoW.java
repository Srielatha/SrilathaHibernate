package com.jnit.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.DiscriminatorValue;

@Entity
@Table(name = "TWO_WHEEL")
@DiscriminatorValue("Bike")
public class TwoW extends Veh {
	@Column(name = "STEERING_TYPE")
	private String steeringTwoWheeler;

	public String getSteeringTwoWheeler() {
		return steeringTwoWheeler;
	}

	public void setSteeringTwoWheeler(String steeringTwoWheeler) {
		this.steeringTwoWheeler = steeringTwoWheeler;
	}
}
