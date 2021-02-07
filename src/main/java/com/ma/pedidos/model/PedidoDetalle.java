/**
 * 
 */
package com.ma.pedidos.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author jonatan.moreira
 *
 */
@Entity
@Table(name="pedidos_detalle")
public class PedidoDetalle {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedido_cabecera_id", referencedColumnName = "id", insertable = true, updatable = true)
	private PedidoCabecera pedidoCabecera;

	@ManyToOne
	@JoinColumn(name = "producto_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Producto producto;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="precioUnitario")
	private BigDecimal precioUnitario;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	 * @return the productos
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
