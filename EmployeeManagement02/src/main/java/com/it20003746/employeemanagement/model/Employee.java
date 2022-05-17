package com.it20003746.employeemanagement.model;

public class Employee {
	
	private int id;
	private String name;
	private String gender;
	private String dob;
	private String email;
	private int contact;
	
	
	
	
	public Employee(int id, String name, String gender, String dob, String email, int contact) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.contact = contact;
	}
	
	
	
	
	public Employee(String name, String gender, String dob, String email, int contact) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.contact = contact;
	}




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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	
	

}
