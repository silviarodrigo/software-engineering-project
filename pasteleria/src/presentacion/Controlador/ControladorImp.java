package presentacion.Controlador;

import presentacion.Evento;
import presentacion.factoria.FactoriaAbstractaPresentacion;
import negocio.Producto.TProducto;

import java.util.Collection;

import negocio.Factoria.FactoriaAbstractaNegocio;
import negocio.Producto.SAProducto;

public class ControladorImp extends Controlador {
	public void accion(Evento evento, Object datos) {
		switch (evento) {
		case MAIN_WINDOW:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.MAIN_WINDOW);
			break;
		case VISTA_PRINCIPAL_PRODUCTO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_PRINCIPAL_PRODUCTO);
			break;
		case VISTA_ALTA_PRODUCTO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ALTA_PRODUCTO);
			break;
		case VISTA_BAJA_PRODUCTO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BAJA_PRODUCTO);
			break;
		case VISTA_ACTUALIZAR_PRODUCTO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_PRODUCTO);
			break;
		case VISTA_BUSCAR_PRODUCTO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_PRODUCTO);
			break;
		case VISTA_LISTAR_PRODUCTO:
			listarProducto(datos);
			break;
		case ACTUALIZAR_PRODUCTO:
			actualizarProducto(datos);
			break;
		case ALTA_PRODUCTO:
			altaProducto(datos);
			break;
		case BAJA_PRODUCTO:
			bajaProducto(datos);
			break;
		case BUSCAR_PRODUCTO:
			buscarProducto(datos);
			break;
		}
	}
	
	private void actualizarProducto(Object datos) {
		SAProducto saProducto = FactoriaAbstractaNegocio.getInstance().creaSAProducto();
		TProducto producto = (TProducto) datos;
		try {
			int id = saProducto.actualizarProducto(producto);
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_PRODUCTO)
			.actualizar(Evento.ACTUALIZAR_PRODUCTO_SUCCESS, id);
		} catch (IllegalArgumentException e) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_PRODUCTO)
			.actualizar(Evento.ACTUALIZAR_PRODUCTO_ERROR, e.getMessage());
		}
	}
	
	private void altaProducto(Object datos) {
		SAProducto saProducto = FactoriaAbstractaNegocio.getInstance().creaSAProducto();
		TProducto producto = (TProducto) datos;
		try {
			int id = saProducto.altaProducto(producto);
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ALTA_PRODUCTO)
			.actualizar(Evento.ALTA_PRODUCTO_SUCCESS, id);
		} catch (IllegalArgumentException e) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ALTA_PRODUCTO)
			.actualizar(Evento.ALTA_PRODUCTO_ERROR, e.getMessage());
		}
	}
	
	private void bajaProducto(Object datos) {
		SAProducto saProducto = FactoriaAbstractaNegocio.getInstance().creaSAProducto();
		String nombre = (String) datos;
		try {
			int id = saProducto.bajaProducto(nombre);
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BAJA_PRODUCTO)
			.actualizar(Evento.BAJA_PRODUCTO_SUCCESS, id);
		} catch (IllegalArgumentException e) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BAJA_PRODUCTO)
			.actualizar(Evento.BAJA_PRODUCTO_ERROR, e.getMessage());
		}
	}
	
	private void buscarProducto(Object datos) {
		SAProducto saProducto = FactoriaAbstractaNegocio.getInstance().creaSAProducto();
		String nombre = (String) datos;
		TProducto producto = saProducto.buscarProducto(nombre);
		// No se si hay que crear nueva vista o tenerla guardada en el controlador (o en la factoria)
		if (producto != null) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_PRODUCTO)
					.actualizar(Evento.BUSCAR_PRODUCTO_SUCCESS, producto);
		}
		else {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_PRODUCTO)
			.actualizar(Evento.BUSCAR_PRODUCTO_ERROR, "Producto no encontrado.");
		}
	}
	
	private void listarProducto(Object datos) {
		SAProducto saProducto = FactoriaAbstractaNegocio.getInstance().creaSAProducto();
		Collection<TProducto> productos = saProducto.listarProductos();
		FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_LISTAR_PRODUCTO).actualizar(Evento.LISTAR_PRODUCTO, productos);
	}
}
