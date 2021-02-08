/**
 * 
 */
package com.ma.pedidos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.pedidos.entity.Producto;
import com.ma.pedidos.repository.ProductoRepository;

/**
 * @author jonatan.moreira
 *
 */
@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        List<Producto> productos = new ArrayList<Producto>();
        productoRepository.findAll().forEach(producto -> productos.add(producto));
        return productos;
    }

    public Producto getProductoById(String id) {
    	
    	Optional<Producto> producto = productoRepository.findById(id);
    	
    	if(producto != null)
    		return producto.get();
    	else
    		return null;
    }

    public void saveOrUpdate(Producto producto) {
        productoRepository.save(producto);
    }

    public void delete(String id) {
        
   		productoRepository.deleteById(id);
    	
    }	
}
