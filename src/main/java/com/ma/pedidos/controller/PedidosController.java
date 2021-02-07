/**
 * 
 */
package com.ma.pedidos.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author jonatan.moreira
 *
 */
@RestController
@RequestMapping("pedidos")
public class PedidosController {

	private static final Log log = LogFactory.getLog(PedidosController.class);
	
	@RequestMapping("/hello")
	@ResponseBody
	String home() {
		
		log.info("Hola Pedidos!!");
		
		return "Hola Pedidos!!";
	}	
	
}
