/**
 * 
 */
package com.ma.pedidos.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

/**
 * @author jonatan.moreira
 *
 */
public class SolicitudProductoDTO {
	
	private String producto;
		
	@NotNull(message = "Falta ingresar la cantidad.")
	private Integer cantidad;

	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
