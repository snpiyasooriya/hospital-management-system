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

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "location_id", referencedColumnName = "id")
	private Location location;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ward_id", referencedColumnName = "id")
	private Ward ward;

	@Column(nullable = false, length = 20)
	private String firstName;
	
	@Column(nullable = false, length = 20)
	private String lastName;
	
	@Column(nullable = false, length = 10)
	private String nic;
	
	@Column(nullable = false, length = 20)
	private String dob;
	
	@Column(nullable = false)
	private String address;
	
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

	@Column(length = 10, nullable = true, columnDefinition = "Integer default 2")
	private int admit;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(Long id, Title title, Location location, Ward ward, String firstName, String lastName, String nic, String dob, String address, int mStat, String nationality, String religion, int gender, String email, String phone, int admit) {
		this.id = id;
		this.title = title;
		this.location = location;
		this.ward = ward;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.dob = dob;
		this.address = address;
		this.mStat = mStat;
		this.nationality = nationality;
		this.religion = religion;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.admit = admit;
	}

	public Patient(int admit) {
		this.admit = admit;
	}

	public Patient(Long id, Title title, Location location, String firstName, String lastName, String nic, String dob, String adress, int mStat, String nationality, String religion, int gender, String email, String phone) {
		this.id = id;
		this.title = title;
		this.location = location;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.dob = dob;
		this.address = adress;
		this.mStat = mStat;
		this.nationality = nationality;
		this.religion = religion;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}

	public Patient(Long id, Title title, Location location, Ward ward, String firstName, String lastName, String nic, String dob, String address, int mStat, String nationality, String religion, int gender, String email, String phone) {
		this.id = id;
		this.title = title;
		this.location = location;
		this.ward = ward;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.dob = dob;
		this.address = address;
		this.mStat = mStat;
		this.nationality = nationality;
		this.religion = religion;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}

	public Patient(Ward ward) {
		this.ward = ward;
	}

	public Patient(Location location) {
		this.location = location;
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
		this.address = adress;
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
		this.address = adress;
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

	public void setId(Long id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public int getAdmit() {
		return admit;
	}

	public void setAdmit(int admit) {
		this.admit = admit;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String adress) {
		this.address = adress;
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

	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	@Override
	public String toString() {
		return "Patient{" +
				"id=" + id +
				", title=" + title +
				", location=" + location +
				", ward=" + ward +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", nic='" + nic + '\'' +
				", dob='" + dob + '\'' +
				", address='" + address + '\'' +
				", mStat=" + mStat +
				", nationality='" + nationality + '\'' +
				", religion='" + religion + '\'' +
				", gender=" + gender +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}
}
