package com.synotech.hos.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "patient")
public class Patient implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="title_id", referencedColumnName = "id")
	private Title title;
	
	@Column(nullable = false, length = 20)
	private String firstName;
	
	@Column(nullable = false, length = 20)
	private String lastName;
	
	@Column(nullable = false, length = 10)
	private String nic;
	
	@Column(nullable = false, length = 20)
	private String dob;
	
	@Column(nullable = false, length = 20)
	private String adress;
	
	@Column(nullable = false, length = 3)
	private int mStat;
	
	@Column(nullable = false, length = 20)
	private String nationality;
	
	@Column(nullable = false, length = 20)
	private String religion;
	
	@Column(nullable = false, length = 10)
	private int gender;
	
		
	@Column (unique = true)
	private String email;
	
	
	@Column(nullable = false, length = 10)
	private String phone;

	

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Patient(Long id, Title title, String firstName, String lastName, String nic, String dob, String adress,
			int mStat, String nationality, String religion, int gender, String email, String phone) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.dob = dob;
		this.adress = adress;
		this.mStat = mStat;
		this.nationality = nationality;
		this.religion = religion;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}


	public Patient(Title title, String firstName, String lastName, String nic, String dob, String adress, int mStat,
			String nationality, String religion, int gender, String email, String phone) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.dob = dob;
		this.adress = adress;
		this.mStat = mStat;
		this.nationality = nationality;
		this.religion = religion;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}

	public Patient(String firstName) {
		this.firstName = firstName;
	}

	public Title getTitle() {
		return title;
	}

	public Long getId() {
		return id;
	}

	public void setTitle(Title title) {
		this.title = title;
	}


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


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public int getmStat() {
		return mStat;
	}


	public void setmStat(int mStat) {
		this.mStat = mStat;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getReligion() {
		return religion;
	}


	public void setReligion(String religion) {
		this.religion = religion;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Patient [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", nic=" + nic + ", dob=" + dob + ", adress=" + adress + ", mStat=" + mStat + ", nationality="
				+ nationality + ", religion=" + religion + ", gender=" + gender + ", email=" + email + ", phone="
				+ phone + "]";
	}

}
