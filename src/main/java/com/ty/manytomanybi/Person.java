package com.ty.manytomanybi;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long mobile;
	private String address;
	@ManyToMany
	@JoinTable(name = "my_person_cab", joinColumns = @JoinColumn(name = "my_personId"), inverseJoinColumns = @JoinColumn(name = "my_cabId"))
	private List<Cab> cab;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Cab> getCab() {
		return cab;
	}

	public void setCab(List<Cab> cab) {
		this.cab = cab;
	}

}
