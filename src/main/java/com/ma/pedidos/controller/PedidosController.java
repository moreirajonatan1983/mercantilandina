/**
 * 
 */
package com.ma.pedidos.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ma.pedidos.dto.PedidoDTO;
import com.ma.pedidos.dto.RespuestaPedidoDTO;
import com.ma.pedidos.entity.PedidoDetalle;
import com.ma.pedidos.service.PedidoService;



/**
 * @author jonatan.moreira
 *
 */
@RestController
public class PedidosController {

	private static final Log log = LogFactory.getLog(PedidosController.class);
	
    @Autowired
    PedidoService pedidoService;	
	
	@RequestMapping("/hello")
	@ResponseBody
	String home() {
		
		log.info("Hola Pedidos!!");
		
		return "Hola Pedidos!!";
	}	
	
    @GetMapping("/pedidos/{id}")    
    private ResponseEntity<Object> getPedido(@PathVariable("id") String id) {

    	log.info("Consultando el pedido con id: " + id);
    	
    	Map<String, String> errors = new HashMap<String, String>();
    	errors.put("error", "Pedido no encontrado");
    	
    	PedidoDetalle pedido = null;
    	
    	try {
    		pedido = pedidoService.getPedidoById(id);
    		
    		if(pedido != null)
    			return ResponseEntity.status(HttpStatus.OK).body(pedido);
    		
    	} catch (Exception e) {
    		    		
    		log.error("Error al consultar el pedido con id: " + id, e);
    	}    	
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    	
    }

    @DeleteMapping("/pedidos/{id}")
    private ResponseEntity<Object> deleteProducto(@PathVariable("id") String id) {
        
    	log.info("Eliminando el PedidoDetalle con id: " + id);
    	
    	Map<String, String> errors = new HashMap<String, String>();
    	errors.put("error", "PedidoDetalle no encontrado");
    	
    	try {    		
    		pedidoService.delete(id);
    	} catch (Exception e) {
    		
    		log.error("Error al intentar eliminar un pedido. id: " + id , e);
    		
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    	}
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    /**
     * 
     * @param pedido
     * @param bindingResult
     * @return
     */
    @PostMapping("/pedidos")
    @ResponseStatus(code = HttpStatus.CREATED)
    private ResponseEntity<Object>  savePedido(@Valid @RequestBody PedidoDTO pedido, BindingResult bindingResult) {
    	
		if(bindingResult.hasErrors()){
			//handle errors and return
	    	
	    	Map<String, List<Map>> errors = new HashMap<>();
	    	List<Map> list = new ArrayList<>();
	    	errors.put("errores", list);
	    	
			for (Object object : bindingResult.getAllErrors()) {
			    
				if(object instanceof FieldError) {
			        FieldError fieldError = (FieldError) object;
			        
			        Map<String, String> error = new HashMap<>();
			        error.put("error", fieldError.getDefaultMessage());
			        
			        errors.get("errores").add(error);
			    }

			}			
									
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		}
    	
    	log.info("Creando un Pedido: " + pedido.toString());
    	
    	Map<String, String> errors = new HashMap<String, String>();
    	errors.put("error", "Error al crear un Pedido");    	
    	
    	RespuestaPedidoDTO respuestaPedido = null;                
        
        try {
        	
        	respuestaPedido = pedidoService.saveOrUpdate(pedido);
        	
        	if(respuestaPedido != null)
        		return ResponseEntity.status(HttpStatus.CREATED).body(respuestaPedido);
        	
        } catch(Exception e) {
        	
        	log.error("Error al crear el pedido: " + pedido, e);
        	
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(respuestaPedido);        
        
    }	
	   
    /**
     * Listar pedidos por fecha
	 * 	Method: GET
	 * Path: /pedidos?fecha=2020-05-26
	 * Response 200
     * 
     * @param fecha
     * @return listado de pedidos. Array Json 
     */
    @GetMapping("/pedidos")
    private ResponseEntity<Object> getPedidosByFecha( @RequestParam("fecha") String fecha) {
    	
    	log.info("Buscando pedido por fecha = " + fecha);
    	
    	LocalDate localDate = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yy-MM-dd"));
    	
    	List<RespuestaPedidoDTO> listaRespuestaPedidoDTO = pedidoService.getPedidosByFecha(localDate);
    	    	
    	return ResponseEntity.status(HttpStatus.OK).body(listaRespuestaPedidoDTO);
    	
    }
    
}
