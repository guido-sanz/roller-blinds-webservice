package com.rollerblinds.java.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.rollerblinds.java.entidades.Cliente;
import com.rollerblinds.java.entidades.Pedido;
import com.rollerblinds.java.pedidoImplt.ImplementacionPedido;
import com.rollerblinds.java.service.ClienteDAO;
import com.rollerblinds.java.service.ClienteDAOimplt;
import com.rollerblinds.java.service.PedidoDAO;
import com.rollerblinds.java.service.PedidoDAOimplt;
import com.rollerblinds.java.service.dto.ClienteDTO;
import com.rollerblinds.java.service.dto.PedidoDTO;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	ClienteDAO clienteDAO;
	
	@Autowired
	PedidoDAO pedidoDAO;
	
	@Autowired
	ClienteDAOimplt clienteDAOimplt;
	
	@Autowired
	PedidoDAOimplt pedidoDAOimplt;
	
	@Autowired
	ImplementacionPedido pedidoCoti;
	
	
	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClienteDTO> listaCliente(){
		List<ClienteDTO> listaClientes = new ArrayList<>();
		listaClientes = clienteDAOimplt.getPersonaDTO();
		List<ClienteDTO> sinFinalizar = new ArrayList<>();
		for(int i=0; i<listaClientes.size(); i++) {
			ClienteDTO cliente = listaClientes.get(i);
			if(cliente.getState().equals("false")) {
				sinFinalizar.add(cliente);
			}
		}
		return sinFinalizar;
	}
	
	@PostMapping(value = "/save")
	public void save(@RequestBody Cliente c) {
		c.setState("false");
		clienteDAO.save(c);
		System.out.println("se agrego el cliente");
	}
	
	@GetMapping(value = "/finalizados", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClienteDTO> finalizados(){
		List<ClienteDTO> listaClientes = new ArrayList<>();
		listaClientes = clienteDAOimplt.getPersonaDTO();
		List<ClienteDTO> finalizado = new ArrayList<>();
		for(int i=0; i<listaClientes.size(); i++) {
			ClienteDTO cliente = listaClientes.get(i);
			if(cliente.getState().equals("true")) {
				finalizado.add(cliente);
			}
		}
		System.out.println(finalizado.toString());
		return finalizado;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void pedidos(@PathVariable("id") Integer id) {
		if (id != null) {
			clienteDAO.deleteById(id);
		}
	}
	
	@GetMapping(value = "/findClienteId/{id}")
	public Cliente getClienteId(@PathVariable("id") Integer id) {
		Cliente c = clienteDAO.findById(id).get();
		return c;
	}
	
	@PutMapping(value = "/edit/{id}")
	public void editar(@RequestBody Cliente c ,@PathVariable("id") Integer id) {
		List<Pedido> pedidos = pedidoDAO.findByclienteId(id);
		for(int i=0; i<pedidos.size(); i++) {
			Pedido p = pedidos.get(i);
			c.agregaPedido(p);
		}
		clienteDAO.save(c);
	}
	
	@PutMapping(value = "/finalizar/{id}")
	public void finalizar(@RequestBody Cliente c ,@PathVariable("id") Integer id) {
				c.setId(id);
				c.setState("true");
				clienteDAO.save(c);
			}
	
	@GetMapping(value = "/findPedidoId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> listarPedido(@PathVariable("id") Integer id) {
		List<Pedido> listaClientes = new ArrayList<>();
		 listaClientes= pedidoDAO.findByclienteId(id);
		return listaClientes;
	}
	
	@GetMapping(value="/find/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> find(@PathVariable("id") Integer id){
		List<Pedido> listaClientes = new ArrayList<>();
		listaClientes = pedidoDAO.findByclienteId(id);
		System.out.println(listaClientes);
		return listaClientes;
	}
	
	@PostMapping(value = "/agregarPedido/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void agregarPedido(@RequestBody Pedido p,@PathVariable("id") Integer id){
	Cliente c = clienteDAO.findById(id).get();
	Pedido pedido = new Pedido();
	
	double ancho = p.getAncho();
	double alto = p.getAlto();
	int cantidad = p.getCantidad();
	String tela = p.getTela();
	double precio = pedidoCoti.cotizacion(ancho, alto, cantidad, tela);
	System.out.println(precio);
	p.setTotal(precio);
	
	pedido = p;
	c.agregaPedido(pedido);
	clienteDAO.save(c);
	}
	
	@GetMapping(value="/buscarPedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  Pedido buscarPedido(@PathVariable("id") Integer id) {
		Pedido p = pedidoDAO.findById(id).get();
		return p;
	}
	
	@PutMapping(value="/editarPedido/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void editarPedido(@RequestBody Pedido p ,@PathVariable("id") Integer id) {
		p.setId(id);
		pedidoDAO.save(p);
	}
	
	@DeleteMapping(value="/deletePedido/{id}/{cliente}")
	public void eliminarPedido(@PathVariable("id") Integer id,@PathVariable("cliente") Integer clienteid) {
		Cliente c = clienteDAO.findById(clienteid).get();
		Pedido p = pedidoDAO.findById(id).get();
		c.removePedido(p);
		clienteDAO.save(c);
	}
	

	
	
	
	
//	Pedido pedido = pedidoDAO.findById(id).get();
//	pedido.setId(id);
//	pedido.setTipo(p.getTipo());
//	pedido.setTela(p.getTela());
//	pedido.setColor(p.getColor());
//	pedido.setAlto(p.getAlto());
//	pedido.setAncho(p.getAncho());
//	pedido.setCantidad(p.getCantidad());
//	pedido.setLadoCadena(p.getLadoCadena());
//	pedido.setTipoCadena(p.getTipoCadena());
//	pedido.setEnvio(p.getEnvio());
//	pedido.setTotal(p.getTotal());
//	pedidoDAO.save(pedido);
}
