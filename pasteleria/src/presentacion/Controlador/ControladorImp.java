package presentacion.Controlador;

import presentacion.Evento;
import presentacion.factoria.FactoriaAbstractaPresentacion;
import negocio.Producto.TProducto;
import negocio.Marca.TMarca;

import java.util.Collection;

import javax.swing.JOptionPane;

import negocio.Factoria.FactoriaAbstractaNegocio;
import negocio.Facturas.SAFactura;
import negocio.Producto.SAProducto;
import negocio.Marca.SAMarca;
import negocio.Facturas.*;

public class ControladorImp extends Controlador {
	private Carrito carrito;

	public void accion(Evento evento, Object datos) {
		switch (evento) {
		case MAIN_WINDOW:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.MAIN_WINDOW);
			break;
		// PRODUCTO
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
		// FACTURAS
		case VISTA_PRINCIPAL_FACTURAS:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_PRINCIPAL_FACTURAS);
			break;
		case VISTA_MODIFICAR_FACTURA:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_MODIFICAR_FACTURA);
			break;
		case VISTA_ANADIR_PRODUCTO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ANADIR_PRODUCTO);
			break;
		case VISTA_ELIMINAR_PRODUCTO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ELIMINAR_PRODUCTO);
			break;
		case VISTA_CERRAR_VENTA:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_CERRAR_VENTA);
			break;
		case ABRIR_VENTA:
			abrirVenta(datos);
			break;
		case CERRAR_VENTA:
			cerrarVenta(datos);
			break;
		case VISTA_BUSCAR_FACTURA:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_FACTURA);
			break;
		case MODIFICAR_FACTURA:
			modificarFactura(datos);
			break;
		case VISTA_LISTAR_FACTURAS:
			listarFacturas(datos);
			break;
		case BUSCAR_FACTURA:
			buscarFactura(datos);
			break;
		// MARCA
		case VISTA_PRINCIPAL_MARCA:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_PRINCIPAL_MARCA);
			break;
		case VISTA_ALTA_MARCA:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ALTA_MARCA);
			break;
		case VISTA_BAJA_MARCA:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BAJA_MARCA);
			break;
		case VISTA_ACTUALIZAR_MARCA:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_MARCA);
			break;
		case VISTA_BUSCAR_MARCA:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_MARCA);
			break;
		case VISTA_LISTAR_MARCAS:
			listarMarcas(datos);
			break;
		case ACTUALIZAR_MARCA:
			actualizarMarca(datos);
			break;
		case ALTA_MARCA:
			altaMarca(datos);
			break;
		case BAJA_MARCA:
			bajaMarca(datos);
			break;
		case BUSCAR_MARCA:
			buscarMarca(datos);
		case ANADIR_PRODUCTO:
			anadirProducto(datos);
			break;
		case ELIMINAR_PRODUCTO:
			eliminarProducto(datos);

			break;
		}
	}

//PRODUCTO
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
		// No se si hay que crear nueva vista o tenerla guardada en el controlador (o en
		// la factoria)
		if (producto != null) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_PRODUCTO)
					.actualizar(Evento.BUSCAR_PRODUCTO_SUCCESS, producto);
		} else {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_PRODUCTO)
					.actualizar(Evento.BUSCAR_PRODUCTO_ERROR, "Producto no encontrado.");
		}
	}

	private void listarProducto(Object datos) {
		SAProducto saProducto = FactoriaAbstractaNegocio.getInstance().creaSAProducto();
		Collection<TProducto> productos = saProducto.listarProductos();
		FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_LISTAR_PRODUCTO)
				.actualizar(Evento.LISTAR_PRODUCTO, productos);
	}

//FACTURAS
	private void modificarFactura(Object datos) {
		SAFactura saFactura = FactoriaAbstractaNegocio.getInstance().crearSAFactura();
		TFactura factura = (TFactura) datos;
		TDatosVenta datos_venta = factura.getDatosVentas();
		try {
			boolean exito = saFactura.modificarFactura(factura.getIdFactura(), datos_venta.getIdCliente(),
					datos_venta.getIdVendedor(), datos_venta.getFecha());
			if (exito) {
				FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_MODIFICAR_FACTURA)
						.actualizar(Evento.MODIFICAR_FACTURA_SUCCESS, factura.getIdFactura());
			} else {
				FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_MODIFICAR_FACTURA)
						.actualizar(Evento.MODIFICAR_FACTURA_ERROR, factura.getIdFactura());
			}
		} catch (IllegalArgumentException e) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_MODIFICAR_FACTURA)
					.actualizar(Evento.MODIFICAR_FACTURA_ERROR, e.getMessage());
		}

	}

	private void listarFacturas(Object datos) {
		SAFactura saFactura = FactoriaAbstractaNegocio.getInstance().crearSAFactura();
		Collection<TFactura> facturas = saFactura.listarFacturas();
		FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_LISTAR_FACTURAS)
				.actualizar(Evento.LISTAR_FACTURAS, facturas);
	}

	private void buscarFactura(Object datos) {
		SAFactura saFactura = FactoriaAbstractaNegocio.getInstance().crearSAFactura();
		int id_factura = (int) datos;
		TFactura factura = saFactura.buscarFactura(id_factura);
		// No se si hay que crear nueva vista o tenerla guardada en el controlador (o en
		// la factoria)
		if (factura != null) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_FACTURA)
					.actualizar(Evento.BUSCAR_FACTURA_SUCCESS, factura);
		} else {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_FACTURA)
					.actualizar(Evento.BUSCAR_FACTURA_ERROR, "factura no encontrada.");
		}
	}
	
	
	
	//MARCAS
	private void altaMarca(Object datos) {
		SAMarca SAMarca = FactoriaAbstractaNegocio.getInstance().crearSAMarca();
		TMarca marca = (TMarca) datos;
		try {
			int id = SAMarca.altaMarca(marca);
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ALTA_MARCA)
					.actualizar(Evento.ALTA_MARCA_SUCCESS, id);
		} catch (IllegalArgumentException e) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ALTA_MARCA)
					.actualizar(Evento.ALTA_MARCA_ERROR, e.getMessage());
		}
	}

	private void bajaMarca(Object datos) {
		SAMarca SAMarca = FactoriaAbstractaNegocio.getInstance().crearSAMarca();
		int id = (int) datos;
		try {
			boolean eliminada = SAMarca.bajaMarca(id);
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BAJA_MARCA)
					.actualizar(Evento.BAJA_MARCA_SUCCESS, id);
		} catch (IllegalArgumentException e) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BAJA_MARCA)
					.actualizar(Evento.BAJA_MARCA_ERROR, e.getMessage());
		}
	}
	
	private void actualizarMarca(Object datos) {
		SAMarca SAMarca = FactoriaAbstractaNegocio.getInstance().crearSAMarca();
		TMarca marca = (TMarca) datos;
		try {
			boolean actualizada = SAMarca.actualizarMarca(marca);
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_MARCA)
					.actualizar(Evento.ACTUALIZAR_MARCA_SUCCESS, id);
		} catch (IllegalArgumentException e) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_MARCA)
					.actualizar(Evento.ACTUALIZAR_MARCA_ERROR, e.getMessage());
		}
	}

	private void buscarMarca(Object datos) {
		SAMarca SAMarca = FactoriaAbstractaNegocio.getInstance().crearSAMarca();
		int id = (int) datos;
		TMarca marca = SAMarca.buscarMarca(id);
		if (marca != null) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_MARCA)
					.actualizar(Evento.BUSCAR_MARCA_SUCCESS, marca);
		} else {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_MARCA)
					.actualizar(Evento.BUSCAR_MARCA_ERROR, "Producto no encontrado.");
		}
	}

	private void listarMarcas(Object datos) {
		SAMarca SAMarca = FactoriaAbstractaNegocio.getInstance().crearSAMarca();
		Collection<TMarca> marcas = SAMarca.listarMarcas();
		FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_LISTAR_MARCAS)
				.actualizar(Evento.LISTAR_MARCAS, marcas);
	}
	
	


	private void abrirVenta(Object datos) {
		if (this.carrito != null) {
			JOptionPane.showMessageDialog(null, "Ya hay una venta en curso, por favor cierre la venta primero",
					"Abrir Venta", 0);
		} else {
			SAFactura saFactura = FactoriaAbstractaNegocio.getInstance().crearSAFactura();
			this.carrito = saFactura.abrirVenta();
			JOptionPane.showMessageDialog(null, "Carrito creado con exito", "Abrir Venta", 1);
		}

	}

	private void anadirProducto(Object datos) {
		if (this.carrito == null) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ANADIR_PRODUCTO)
					.actualizar(Evento.ANADIR_PRODUCTO_ERROR, "por favor abra una venta primero");
		}
		SAFactura saFactura = FactoriaAbstractaNegocio.getInstance().crearSAFactura();
		if (saFactura.anadirProducto((TLineaFactura) datos, this.carrito)) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ANADIR_PRODUCTO)
					.actualizar(Evento.ANADIR_PRODUCTO_SUCCESS, "producto anadido al carrito con exito");
		} else {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ANADIR_PRODUCTO)
					.actualizar(Evento.ANADIR_PRODUCTO_ERROR, "producto no encontrado.");
		}
	}

	private void eliminarProducto(Object datos) {
		if (this.carrito == null) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ELIMINAR_PRODUCTO)
					.actualizar(Evento.ELIMINAR_PRODUCTO_ERROR, "por favor abra una venta primero");
		}
		SAFactura saFactura = FactoriaAbstractaNegocio.getInstance().crearSAFactura();
		if (saFactura.eliminarProducto((TLineaFactura) datos, this.carrito)) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ELIMINAR_PRODUCTO)
					.actualizar(Evento.ELIMINAR_PRODUCTO_SUCCESS, "producto eliminado del carrito con exito");
		} else {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ELIMINAR_PRODUCTO)
					.actualizar(Evento.ELIMINAR_PRODUCTO_ERROR, "producto no encontrado.");
		}
	}

	private void cerrarVenta(Object datos) {
		if (this.carrito == null) {
			JOptionPane.showMessageDialog(null, "por favor abra una venta primero", "Cerrar Venta", 0);
		} else {
			SAFactura saFactura = FactoriaAbstractaNegocio.getInstance().crearSAFactura();
			TFactura factura = (TFactura) datos;
			TDatosVenta datos_venta = factura.getDatosVentas();
			int id_factura = saFactura.cerrarVenta(this.carrito, datos_venta.getIdCliente(),
					datos_venta.getIdVendedor(), datos_venta.getFecha());
			if (id_factura == -1) {
				FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_CERRAR_VENTA)
						.actualizar(Evento.CERRAR_VENTA_SUCCESS, "venta cerrada con exito");
			} else {
				FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_CERRAR_VENTA)
						.actualizar(Evento.CERRAR_VENTA_ERROR, "la venta no se ha podido cerrar");
			}
		}

	}
}
