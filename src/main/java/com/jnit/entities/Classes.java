package com.jnit.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity

public class Classes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classId;
	private String coursename;
	private int numofstudents;

	private LocalDateTime createdDateTime;

	@Version
	private LocalDateTime updatedDateTime;
	@ManyToMany(mappedBy = "registeredUsers", cascade = CascadeType.ALL)
	private List<Professor> Professor = new ArrayList<Professor>();

	public Classes(int classId, String coursename, int numofstudents, List<Professor> professor) {
		super();
		this.classId = classId;
		this.coursename = coursename;
		this.numofstudents = numofstudents;

	}

	public Classes(int classid, String coursename, int numofstudents, LocalDate of) {
		super();
		this.classId = classid;
		this.coursename = coursename;
		this.numofstudents = numofstudents;
		this.createdDateTime = LocalDateTime.now();
		this.updatedDateTime = LocalDateTime.now();

	}

	public Classes() {

	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getNumofstudents() {
		return numofstudents;
	}

	public void setNumofstudents(int numofstudents) {
		this.numofstudents = numofstudents;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public List<Professor> getProfessor() {
		return Professor;
	}

	public void setProfessor(List<Professor> professor) {
		this.Professor = professor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setRegisteredUsers(List<Classes> classes) {
	}

}
