/**
 * 
 */
package com.ma.pedidos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ma.pedidos.entity.PedidoDetalle;

/**
 * @author jonatan.moreira
 *
 */
@Repository
public interface PedidoDetalleRepository extends CrudRepository<PedidoDetalle, String>{

		
	
}
