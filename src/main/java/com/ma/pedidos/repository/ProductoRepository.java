/**
 * 
 */
package com.ma.pedidos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ma.pedidos.entity.Producto;

/**
 * @author jonatan.moreira
 *
 */
@Repository
public interface ProductoRepository extends CrudRepository<Producto, String> {

}
