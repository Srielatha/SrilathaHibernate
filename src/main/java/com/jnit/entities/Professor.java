package com.jnit.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int professorId;
	private String name;
	private String department;
	@Enumerated(EnumType.ORDINAL)
	private SkillLevel level;
	private String description;
	private String prereqs;
	private BigDecimal fee;
	private String endGoal;
	private String type;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "classprofessor", joinColumns = @JoinColumn(name = "professorid", referencedColumnName = "professorId"), inverseJoinColumns = @JoinColumn(name = "classid", referencedColumnName = "classId"))
	private List<Classes> registeredUsers = new ArrayList<Classes>();
	private LocalDateTime createdDateTime;

	public List<Classes> getRegisteredUsers() {
		return registeredUsers;
	}

	public void setRegisteredUsers(List<Classes> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}

	@Version
	private LocalDateTime updatedDateTime;

	public Professor() {

	}

	public Professor(int professorId, String name, String department, SkillLevel level, String description,
			String prereqs, BigDecimal fee, String endGoal, String type) {
		super();
		this.professorId = professorId;
		this.name = name;
		this.department = department;
		this.level = level;
		this.description = description;
		this.prereqs = prereqs;
		this.fee = fee;
		this.endGoal = endGoal;
		this.type = type;
		this.createdDateTime = LocalDateTime.now();
		this.updatedDateTime = LocalDateTime.now();
	}

	public Professor(int professorId, String name, String department, List<Classes> classes) {
		super();
		this.professorId = professorId;
		this.name = name;
		this.department = department;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public SkillLevel getLevel() {
		return level;
	}

	public void setLevel(SkillLevel level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrereqs() {
		return prereqs;
	}

	public void setPrereqs(String prereqs) {
		this.prereqs = prereqs;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public String getEndGoal() {
		return endGoal;
	}

	public void setEndGoal(String endGoal) {
		this.endGoal = endGoal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public List<Classes> getClasses() {
		return registeredUsers;
	}

	public void setClasses(List<Classes> classes) {
		this.registeredUsers = classes;
	}

}
