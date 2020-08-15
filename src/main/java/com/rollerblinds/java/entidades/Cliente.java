package com.rollerblinds.java.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Cliente implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String lastname;
	private String dni;
	private String mail;
	private String phone;
	private String state;
	
	@JsonBackReference
	@OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Pedido> pedidos = new ArrayList<>();
	
	public void agregaPedido(Pedido pedido) {
		pedidos.add(pedido);
		pedido.setCliente(this);
	}
	
	public void removePedido(Pedido pedido) {
		pedidos.remove(pedido);
		pedido.setCliente(null);
	}

	public Cliente() {
	}



	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Cliente(Integer id, String name, String lastname, String dni, String mail, String phone, String state) {
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
		return "Cliente [id=" + id + ", name=" + name + ", lastname=" + lastname + ", dni=" + dni + ", mail=" + mail
				+ ", phone=" + phone + ", state=" + state + "]";
	}

	
	
	
	
	

}
