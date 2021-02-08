/**
 * 
 */
package com.ma.pedidos.dto;

import java.time.LocalTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

/**
 * @author jonatan.moreira
 *
 */
public class PedidoDTO {
	
	@NotBlank(message = "La direccion no puede estar nula.")
	private String direccion;
	
	@NotBlank(message = "El email es obligatorio.")
	private String email;
	
	private String telefono;
	
	private LocalTime horario;
	
	@Valid
	private List<SolicitudProductoDTO> detalle;
	
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
	public List<SolicitudProductoDTO> getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<SolicitudProductoDTO> detalle) {
		this.detalle = detalle;
	}
		
}
