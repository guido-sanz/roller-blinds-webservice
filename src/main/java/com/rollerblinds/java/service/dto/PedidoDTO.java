package com.rollerblinds.java.service.dto;

import com.rollerblinds.java.entidades.Cliente;

public class PedidoDTO {

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
	private Cliente cliente;
	
	public PedidoDTO() {

	}

	public PedidoDTO(Integer id, String tipo, String tela, String color, double ancho, double alto, int cantidad,
			String ladoCadena, String tipoCadena, String envio, double total) {
		this.id = id;
		this.tipo = tipo;
		this.tela = tela;
		this.color = color;
		this.ancho = ancho;
		this.alto = alto;
		this.cantidad = cantidad;
		this.ladoCadena = ladoCadena;
		this.tipoCadena = tipoCadena;
		this.envio = envio;
		this.total = total;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PedidoDTO [id=" + id + ", tipo=" + tipo + ", tela=" + tela + ", color=" + color + ", ancho=" + ancho
				+ ", alto=" + alto + ", cantidad=" + cantidad + ", ladoCadena=" + ladoCadena + ", tipoCadena="
				+ tipoCadena + ", envio=" + envio + ", total=" + total + "]";
	}
	
	
	
	
	
}
