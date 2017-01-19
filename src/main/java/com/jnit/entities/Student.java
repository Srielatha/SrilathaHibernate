package com.jnit.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(region = "student", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stdId;
	private String name;
	private String gender;
	private String dateOfJoing;
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address1 address;
	private LocalDateTime createdDateTime;

	public Student() {

	}

	public Student(String name, String gender, String dateOfJoing) {
		super();

		this.name = name;
		this.gender = gender;
		this.dateOfJoing = dateOfJoing;

	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfJoing() {
		return dateOfJoing;
	}

	public void setDateOfJoing(String dateOfJoing) {
		this.dateOfJoing = dateOfJoing;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Address1 getAddress() {
		return address;
	}

	public void setAddress(Address1 address) {
		this.address = address;

	}

}
