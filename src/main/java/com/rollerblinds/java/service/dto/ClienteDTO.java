package com.rollerblinds.java.service.dto;

public class ClienteDTO {
	
	private Integer id;
	private String name;
	private String lastname;
	private String dni;
	private String mail;
	private String phone;
	private String state;
	
	public ClienteDTO() {
	}

	public ClienteDTO(Integer id, String name, String lastname, String dni, String mail, String phone, String state) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.dni = dni;
		this.mail = mail;
		this.phone = phone;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ClienteDTO [id=" + id + ", name=" + name + ", lastname=" + lastname + ", dni=" + dni + ", mail=" + mail
				+ ", phone=" + phone + ", state=" + state + "]";
	}
	
	
	
	
}
