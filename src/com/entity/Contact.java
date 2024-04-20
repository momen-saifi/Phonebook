package com.entity;

public class Contact {
	private int id;
	private String name;
	private String phno;

	public Contact(String name, String phno) {
		super();
		this.name = name;
		this.phno = phno;
	}

	public Contact() {
		super();
	}

	public Contact(int id, String name, String phno) {
		super();
		this.id = id;
		this.name = name;
		this.phno = phno;
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

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

}
