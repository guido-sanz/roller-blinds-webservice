package com.rollerblinds.java.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Component
public class Pedido{

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipo;
	private String tela;
	private String color;
	private double ancho;
	private double alto;
	private int cantidad;
	private String ladoCadena;
	private String tipoCadena;
	private String envio;
	private double total;
	

	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;

	public Pedido() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTela() {
		return tela;
	}

	public void setTela(String tela) {
		this.tela = tela;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getLadoCadena() {
		return ladoCadena;
	}

	public void setLadoCadena(String ladoCadena) {
		this.ladoCadena = ladoCadena;
	}

	public String getTipoCadena() {
		return tipoCadena;
	}

	public void setTipoCadena(String tipoCadena) {
		this.tipoCadena = tipoCadena;
	}

	public String getEnvio() {
		return envio;
	}

	public void setEnvio(String envio) {
		this.envio = envio;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", tipo=" + tipo + ", tela=" + tela + ", color=" + color + ", ancho=" + ancho
				+ ", alto=" + alto + ", cantidad=" + cantidad + ", ladoCadena=" + ladoCadena + ", tipoCadena="
				+ tipoCadena + ", envio=" + envio + ", total=" + total + ", cliente=" + cliente + "]";
	}




}	
