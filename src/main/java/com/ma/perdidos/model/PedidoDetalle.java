/**
 * 
 */
package com.ma.perdidos.model;

import java.math.BigDecimal;

/**
 * @author jonatan.moreira
 *
 */
public class PedidoDetalle {

	private Integer id;
	
	private PedidoCabecera pedidoCabecera;
	
	private Producto producto;
	
	private int cantidad;
	
	private BigDecimal precioUnitario;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the pedidoCabecera
	 */
	public PedidoCabecera getPedidoCabecera() {
		return pedidoCabecera;
	}

	/**
	 * @param pedidoCabecera the pedidoCabecera to set
	 */
	public void setPedidoCabecera(PedidoCabecera pedidoCabecera) {
		this.pedidoCabecera = pedidoCabecera;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the precioUnitario
	 */
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * @param precioUnitario the precioUnitario to set
	 */
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
}
