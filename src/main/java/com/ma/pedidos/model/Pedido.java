/**
 * 
 */
package com.ma.pedidos.model;

import java.time.LocalTime;
import java.util.List;

/**
 * @author jonatan.moreira
 *
 */
public class Pedido {

	private String direccion;
	
	private String email;
	
	private String telefono;
	
	private LocalTime horario;
	
	private List<SolicitudProducto> detalle;
	
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
	 * @return the detalle
	 */
	public List<SolicitudProducto> getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<SolicitudProducto> detalle) {
		this.detalle = detalle;
	}
		
}
