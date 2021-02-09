package com.ma.pedidos.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ma.pedidos.dto.RespuestaPedidoDTO;
import com.ma.pedidos.dto.RespuestaProductoDTO;
import com.ma.pedidos.entity.PedidoCabecera;
import com.ma.pedidos.entity.PedidoDetalle;
import com.ma.pedidos.entity.Producto;


public class PedidosUtil {

	private static double DESCUENTO = 0.7;
	
	public static RespuestaPedidoDTO getRespuestaPedido(PedidoCabecera pedidoCabecera, List<RespuestaProductoDTO> listRespuestaProducto, boolean descuento) {
		
		RespuestaPedidoDTO respuestaPedido = new RespuestaPedidoDTO();
		
		respuestaPedido.setFecha(pedidoCabecera.getFechaAlta());
		respuestaPedido.setDireccion(pedidoCabecera.getDireccion());
		respuestaPedido.setEmail(pedidoCabecera.getEmail());
		respuestaPedido.setTelefono(pedidoCabecera.getTelefono());
		respuestaPedido.setHorario(pedidoCabecera.getHorario());
		
		respuestaPedido.setDetalle(listRespuestaProducto);
		
		respuestaPedido.setDescuento(descuento);
		
		if(descuento) {
			respuestaPedido.setTotal(pedidoCabecera.getMontoTotal().multiply(new BigDecimal(DESCUENTO).setScale(2, BigDecimal.ROUND_UP)) );
		} else {
			respuestaPedido.setTotal(pedidoCabecera.getMontoTotal().setScale(2, BigDecimal.ROUND_UP));	
		}
		
		respuestaPedido.setEstado(pedidoCabecera.getEstado());
		
		return respuestaPedido;
	}
	
	/**
	 * Retorna una lista de pedidos.
	 * 
	 * @param pedidos
	 * @return
	 */
	public static List<RespuestaPedidoDTO> getRespuestaPedidoDTO(List<PedidoDetalle> pedidos) {
		
		if (pedidos==null)
			return null;
		
		List<RespuestaPedidoDTO> listaRespuestaPedidoDTO = new ArrayList<RespuestaPedidoDTO>();
		
		for(PedidoDetalle pedidoDetalle: pedidos) {
		
			RespuestaPedidoDTO respuestaPedidoDTO = new RespuestaPedidoDTO();
			
			PedidoCabecera pedidoCabecera = pedidoDetalle.getPedidoCabecera();				
					
			respuestaPedidoDTO.setDireccion(pedidoCabecera.getDireccion());
			respuestaPedidoDTO.setEmail(pedidoCabecera.getEmail());
			respuestaPedidoDTO.setEstado(pedidoCabecera.getEmail());		
			respuestaPedidoDTO.setFecha(pedidoCabecera.getFechaAlta());
			respuestaPedidoDTO.setHorario(pedidoCabecera.getHorario());
			respuestaPedidoDTO.setTelefono(pedidoCabecera.getTelefono());
			respuestaPedidoDTO.setTotal(pedidoCabecera.getMontoTotal());		
			respuestaPedidoDTO.setDescuento(pedidoCabecera.isAplicoDescuento() );

			List<RespuestaProductoDTO> detalle = new ArrayList<RespuestaProductoDTO>();
			pedidos.forEach(pedido -> detalle.add( getRespuestaProductoDTO(pedido.getProducto(), pedido.getCantidad(), pedido.getPrecioUnitario()) ) );
				
			respuestaPedidoDTO.setDetalle(detalle);
			
			listaRespuestaPedidoDTO.add(respuestaPedidoDTO);
		}
		
		return listaRespuestaPedidoDTO;
		
	}

	private static RespuestaProductoDTO getRespuestaProductoDTO(Producto producto, Integer cantidad, BigDecimal precioUnitario) {
		
		RespuestaProductoDTO respuestaProductoDTO = new RespuestaProductoDTO(); 
		
		if(producto!=null) {
			respuestaProductoDTO.setProducto(producto.getId());
			respuestaProductoDTO.setNombre(producto.getNombre());
		}
		respuestaProductoDTO.setCantidad(cantidad);
		respuestaProductoDTO.setImporte(precioUnitario.multiply(new BigDecimal(cantidad)).setScale(2));
		
		return respuestaProductoDTO;
	}
	
}
