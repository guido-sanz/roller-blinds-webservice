package com.rollerblinds.java.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rollerblinds.java.entidades.Cliente;

@Repository
public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
	
}
