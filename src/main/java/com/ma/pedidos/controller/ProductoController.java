/**
 * 
 */
package com.ma.pedidos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ma.pedidos.entity.Producto;
import com.ma.pedidos.service.ProductoService;

/**
 * @author jonatan.moreira
 *
 */
@RestController
public class ProductoController {

	private static final Log log = LogFactory.getLog(ProductoController.class);
	
    @Autowired
    ProductoService personService;

    @GetMapping("/productos")
    private List<Producto> getAllProductos() {
        return personService.getAllProductos();
    }

    @GetMapping("/productos/{id}")    
    private ResponseEntity<Object> getProducto(@PathVariable("id") String id) {

    	log.info("Consultando el producto con id: " + id);
    	
    	Map<String, String> errors = new HashMap<String, String>();
    	errors.put("error", "Producto no encontrado");
    	
    	Producto producto = null;
    	
    	try {
    		producto = personService.getProductoById(id);
    		
    		if(producto != null)
    			return ResponseEntity.status(HttpStatus.OK).body(producto);
    		
    	} catch (Exception e) {
    		    		
    		log.error("Error al consultar el producto con id: " + id, e);
    	}    	
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    	
    }

    @DeleteMapping("/productos/{id}")
    private ResponseEntity<Object> deleteProducto(@PathVariable("id") String id) {
        
    	log.info("Eliminando el Producto con id: " + id);
    	
    	Map<String, String> errors = new HashMap<String, String>();
    	errors.put("error", "Producto no encontrado");
    	
    	try {    		
    		personService.delete(id);
    	} catch (Exception e) {
    		
    		log.error("Error al intentar eliminar un producto. id: " + id , e);
    		
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    	}
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PostMapping("/productos")
    @ResponseStatus(code = HttpStatus.CREATED)
    private void saveProducto(@RequestBody Producto producto) {
    	
    	log.info("Guardando un Producto: " + producto.toString());
    	
        personService.saveOrUpdate(producto);
    }	
	
    @PutMapping("/productos/{id}")    
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    private void putProducto(@PathVariable("id") String id, @RequestBody Producto producto) {
    	
    	log.info("Modificando el producto: " + producto.toString());
    	
    	producto.setId(id);
        personService.saveOrUpdate(producto);
    }
    
}
