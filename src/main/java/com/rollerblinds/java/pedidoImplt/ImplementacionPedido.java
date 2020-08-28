package com.rollerblinds.java.pedidoImplt;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rollerblinds.java.entidades.Pedido;

@Service
public class ImplementacionPedido {

	
	public double cotizacion(double ancho, double alto, int cantidad, String tela) {
		DecimalFormat df = new DecimalFormat("#.00");
		String tela1 = "Blackout premiun";
		String tela2 = "Blackout smart";
		String tela3 = "Screen 5% premiun";
		String tela4 = "Screen 5% smart";
		double precio = 0;
		if(tela.equals(tela1)) {
			 precio = (((ancho*(alto+30))/10000)*899)*cantidad;
		}else if(tela.equals(tela2)) {
			precio = (((ancho*(alto+30))/10000)*600)*cantidad;
		}else if(tela.equals(tela3)) {
			precio = (((ancho*(alto+30))/10000)*1200)*cantidad;
		}else if(tela.equals(tela4)) {
			precio = (((ancho*(alto+30))/10000)*950)*cantidad;
		}
		return ((double)Math.round(precio * 100d) / 100d);
		
	}
	
	public double sumaPedidos(List<Pedido> pedidos) {
		double sumaPedidos = 0;
		
		for(Pedido p : pedidos) {
			sumaPedidos = sumaPedidos + p.getTotal();
		}
		return sumaPedidos;

	}
	
	
}
