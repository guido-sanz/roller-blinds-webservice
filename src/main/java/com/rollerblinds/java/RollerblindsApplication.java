package com.rollerblinds.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rollerblinds.java.entidades.Cliente;
import com.rollerblinds.java.entidades.Pedido;
import com.rollerblinds.java.service.ClienteDAO;
import com.rollerblinds.java.service.PedidoDAO;
import com.rollerblinds.java.service.PedidoDAOimplt;

@SpringBootApplication
public class RollerblindsApplication implements CommandLineRunner  {
	
	@Autowired
	ClienteDAO clienteDAO;
	
	@Autowired
	PedidoDAO pedidoDAO;
	
	@Autowired
	PedidoDAOimplt pedidoDAOimplt;

	public static void main(String[] args) {
		SpringApplication.run(RollerblindsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
//		Cliente c = new Cliente();
//		c.setName("fabian");
//		c.setLastname("vidal");
//		c.setDni("17896532");
//		c.setMail("faiban.vidal@hotmail.com");
//		c.setPhone("1669852234");
//		c.setState("true");
//		
//		clienteDAO.save(c);
		
		
//		clienteDAO.deleteById(4);
		
//		Cliente c = new Cliente();
//		c.setId(2);
//		c.setName("guido");
//		c.setLastname("sanz");
//		c.setDni("40539606");
//		c.setMail("guido.sanz@hotmail.com");
//		c.setPhone("1169702907");
//		c.setState("false");
//	
//		Pedido p = new Pedido();
//		p.setId(7);
//		p.setTipo("simple");
//		p.setTela("blackout premiun");
//		p.setColor("negro");
//		p.setAncho(220);
//		p.setAlto(120);
//		p.setCantidad(2);
//		p.setTipoCadena("metalica");
//		p.setLadoCadena("derecha");
//		p.setEnvio("no");
//		p.setTotal(1000.00);
	
//		
//		Pedido p2 = new Pedido();
//		p2.setTipo("simple");
//		p2.setTela("blackout premiun");
//		p2.setColor("gris");
//		p2.setAncho(200);
//		p2.setAlto(130);
//		p2.setCantidad(1);
//		p2.setTipoCadena("metalica");
//		p2.setLadoCadena("derecha");
//		p2.setEnvio("no");
//		p2.setTotal(1000.00);
//		
//		Pedido p3 = new Pedido();
//		p3.setTipo("simple");
//		p3.setTela("screen 5%");
//		p3.setColor("blanco");
//		p3.setAncho(170);
//		p3.setAlto(130);
//		p3.setCantidad(3);
//		p3.setTipoCadena("plastica");
//		p3.setLadoCadena("derecha");
//		p3.setEnvio("no");
//		p3.setTotal(1000.00);
//		
//		
//		  c.agregaPedido(p);
//		  c.agregaPedido(p2);
//		  c.agregaPedido(p3);
////
////
////		  
//		  clienteDAO.save(c);
		
		
//		System.out.println(clienteDAO.findAll());
		
//		clienteDAO.deleteById(1);

		
	}
	
}
