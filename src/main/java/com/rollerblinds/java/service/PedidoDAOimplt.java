package com.rollerblinds.java.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.rollerblinds.java.entidades.Pedido;
import com.rollerblinds.java.service.dto.PedidoDTO;

@Service
public class PedidoDAOimplt {

	@PersistenceContext
	private EntityManager em;

	public List<PedidoDTO> getPedidoDTO() {
		return em.createQuery("select new com.rollerblinds.java.service.dto.PedidoDTO(c.id, c.tipo, c.tela, c.color, c.ancho, c.alto, c.cantidad, c.ladoCadena, c.tipoCadena, c.envio, c.total) from Pedido c", PedidoDTO.class).getResultList();
	}

	public List<Pedido> listarPedido(Integer id) {
		Query query = em.createQuery("select Pedido from Pedido p where p.clienteId = :id");
		query.setParameter("id", id);
		return query.getResultList();
	}
}
