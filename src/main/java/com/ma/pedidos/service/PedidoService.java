/**
 * 
 */
package com.ma.pedidos.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.pedidos.model.Pedido;
import com.ma.pedidos.model.PedidoCabecera;
import com.ma.pedidos.model.PedidoDetalle;
import com.ma.pedidos.model.Producto;
import com.ma.pedidos.model.RespuestaPedido;
import com.ma.pedidos.model.RespuestaProducto;
import com.ma.pedidos.model.SolicitudProducto;
import com.ma.pedidos.repository.PedidoCabeceraRepository;
import com.ma.pedidos.repository.PedidoDetalleRepository;
import com.ma.pedidos.repository.ProductoRepository;
import com.ma.pedidos.util.PedidosUtil;

/**
 * @author jonatan.moreira
 *
 */
@Service
public class PedidoService {

	private static final Log log = LogFactory.getLog(PedidoService.class);
	
    @Autowired
    PedidoDetalleRepository pedidoDetalleRepository;
    
    @Autowired
    ProductoRepository productoRepository;
    
    @Autowired
    PedidoCabeceraRepository pedidoCabeceraRepository;
    

    public List<PedidoDetalle> getAllPedidos() {
        List<PedidoDetalle> pedidos = new ArrayList<PedidoDetalle>();
        pedidoDetalleRepository.findAll().forEach(pedido -> pedidos.add(pedido));
        return pedidos;
    }

    public PedidoDetalle getPedidoById(String id) {
    	
    	Optional<PedidoDetalle> pedido = pedidoDetalleRepository.findById(id);
    	
    	if(pedido != null)
    		return pedido.get();
    	else
    		return null;
    }

    public RespuestaPedido saveOrUpdate(Pedido pedido) {
    	
    	log.info("Crea el pedido: " + pedido.toString());
    	    	
    	PedidoCabecera pedidoCabecera = new PedidoCabecera();
    	
    	pedidoCabecera.setDireccion(pedido.getDireccion());
    	pedidoCabecera.setEmail(pedido.getEmail());
    	pedidoCabecera.setTelefono(pedido.getTelefono());
    	pedidoCabecera.setHorario(pedido.getHorario());
    	pedidoCabecera.setFechaAlta(LocalDate.now());
    	
    	pedidoCabeceraRepository.save(pedidoCabecera);
    	    	

		Double montoTotal = new Double(0);		
    	
		int countProductos = 0;
		
    	for(SolicitudProducto p: pedido.getDetalle() ) {    	
    		
    		Optional<Producto> p1 = productoRepository.findById(p.getProducto());
    		if(p1 != null) {
    	
    			PedidoDetalle pedidoDetalle = new PedidoDetalle();
    			
    			pedidoDetalle.setProducto(p1.get());
    			
    			pedidoDetalle.setCantidad(p.getCantidad());    			
    			pedidoDetalle.setPrecioUnitario(p1.get().getPrecioUnitario());    			
    			pedidoDetalle.setPedidoCabecera(pedidoCabecera);
    			
    			pedidoDetalleRepository.save(pedidoDetalle);
    			    		
    			montoTotal = montoTotal + pedidoDetalle.getPrecioUnitario().doubleValue()*pedidoDetalle.getCantidad();

    			countProductos = countProductos + pedidoDetalle.getCantidad();
    		}    		
    	}

    	// Actualizo pedidoCabecera
    	pedidoCabecera.setMontoTotal(new BigDecimal(montoTotal));
    	pedidoCabecera.setAplicoDescuento(countProductos>3);
    	pedidoCabecera.setEstado("PENDIENTE");
    	
    	pedidoCabeceraRepository.save(pedidoCabecera);
  	    	    	    	
    	List<RespuestaProducto> listProductos = new ArrayList<RespuestaProducto>();
    	
    	for(PedidoDetalle pd :pedidoDetalleRepository.findAll()) {

    		RespuestaProducto respuestaProducto = new RespuestaProducto();
    		
    		if(pedidoCabecera.equals(pd.getPedidoCabecera())) {
    			
	    		respuestaProducto.setProducto(pd.getProducto().getId());
	    		respuestaProducto.setNombre(pd.getProducto().getNombre());
	    		respuestaProducto.setCantidad(pd.getCantidad());
	    		
	    		respuestaProducto.setImporte(pd.getPrecioUnitario());
	    		    		
	    		listProductos.add(respuestaProducto);
    		}
    	}
    	
    	log.info("Creacion de pedido OK: " + pedido.toString());
    	    	                
        return PedidosUtil.getRespuestaPedido(pedidoCabecera, listProductos, pedidoCabecera.isAplicoDescuento());
    }

    public void delete(String id) {
        	
   		pedidoDetalleRepository.deleteById(id);
    	
    }	
		
}
