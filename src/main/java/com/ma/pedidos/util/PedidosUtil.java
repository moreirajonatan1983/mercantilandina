package com.ma.pedidos.util;

import java.math.BigDecimal;
import java.util.List;

import com.ma.pedidos.model.PedidoCabecera;
import com.ma.pedidos.model.RespuestaPedido;
import com.ma.pedidos.model.RespuestaProducto;

public class PedidosUtil {

	private static double DESCUENTO = 0.7;
	
	public static RespuestaPedido getRespuestaPedido(PedidoCabecera pedidoCabecera, List<RespuestaProducto> listRespuestaProducto, boolean descuento) {
		
		RespuestaPedido respuestaPedido = new RespuestaPedido();
		
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
	
}
