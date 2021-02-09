/**
 * 
 */
package com.ma.pedidos.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ma.pedidos.entity.PedidoDetalle;

/**
 * @author jonatan.moreira
 *
 */
@Repository
public interface PedidoDetalleRepository extends CrudRepository<PedidoDetalle, String>{

	@Query("select pd from PedidoDetalle pd where pd.pedidoCabecera.fechaAlta = :fecha")
	Iterable<PedidoDetalle> findPorFecha(@Param("fecha") LocalDate fecha);
	
}
