package com.rollerblinds.java.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.rollerblinds.java.service.dto.ClienteDTO;

@Service
public class ClienteDAOimplt {

	@PersistenceContext
	private EntityManager em;
	
	public List<ClienteDTO> getPersonaDTO() {
		return em.createQuery("select new com.rollerblinds.java.service.dto.ClienteDTO(c.id, c.name, c.lastname, c.dni, c.mail, c.phone, c.state) from Cliente c", ClienteDTO.class).getResultList();
	}
}
