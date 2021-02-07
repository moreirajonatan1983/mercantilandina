/**
 * 
 */
package com.ma.pedidos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jonatan.moreira
 *
 */
@Entity
@Table(name="pedidos_cabecera")
public class PedidoCabecera {
		
	@Id	
	private int id;
	
	@Column(name="direccion", nullable=true, length=50)
	private String direccion;
	
	@Column(name="email", nullable=true, length=50)
	private String email;
	
	@Column(name="telefono", nullable=true, length=50)
	private String telefono;
	
	@Column(name="horario")
	private LocalTime horario;
	
	@Column(name="fecha_alta")
	private LocalDate fechaAlta;
	
	@Column(name="monto_total")
	private BigDecimal montoTotal;
	
	@Column(name="aplico_descuento")
	private boolean aplicoDescuento;
	
	@Column(name="estado")
	private String estado;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the horario
	 */
	public LocalTime getHorario() {
		return horario;
	}

	/**
	 * @param horario the horario to set
	 */
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	/**
	 * @return the fechaAlta
	 */
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * @return the montoTotal
	 */
	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	/**
	 * @param montoTotal the montoTotal to set
	 */
	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	/**
	 * @return the aplicoDescuento
	 */
	public boolean isAplicoDescuento() {
		return aplicoDescuento;
	}

	/**
	 * @param aplicoDescuento the aplicoDescuento to set
	 */
	public void setAplicoDescuento(boolean aplicoDescuento) {
		this.aplicoDescuento = aplicoDescuento;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
		
}
