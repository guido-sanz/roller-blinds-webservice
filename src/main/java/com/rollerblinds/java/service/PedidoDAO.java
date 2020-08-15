package com.rollerblinds.java.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rollerblinds.java.entidades.Pedido;

@Repository
public interface PedidoDAO extends CrudRepository<Pedido, Integer> {

	public  List<Pedido> findByclienteId(Integer id);
	
}
