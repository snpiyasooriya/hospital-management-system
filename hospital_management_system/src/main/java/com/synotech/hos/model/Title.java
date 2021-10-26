package com.synotech.hos.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "title")
public class Title {
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	
	@Column(nullable = false, length = 20)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "title")
	private List<Patient> patient = new ArrayList<>();

	public Title(int id, String name, List<Patient> patient) {
		super();
		this.id = id;
		this.name = name;
		this.patient = patient;
	}

	public Title(int id) {
		super();
		this.id = id;
	}
	
	
	

	public Title() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Title [id=" + id + ", Name=" + name + ", patient=" + patient + "]";
	}
	
	
}
