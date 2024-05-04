package presentacion.Controlador;

import presentacion.Evento;

import presentacion.factoria.FactoriaAbstractaPresentacion;
import negocio.Producto.TProducto;
import negocio.Marca.TMarca;

import java.util.Collection;

import javax.swing.JOptionPane;

import negocio.Cliente.*;
import negocio.Factoria.FactoriaAbstractaNegocio;
import negocio.Facturas.SAFactura;
import negocio.Producto.SAProducto;
import negocio.Marca.SAMarca;
import negocio.Facturas.*;
import negocio.Empleados.*;

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
		case ANADIR_PRODUCTO:
			anadirProducto(datos);
			break;
		case ELIMINAR_PRODUCTO:
			eliminarProducto(datos);
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
		case ALTA_MARCA:
			altaMarca(datos);
			break;
		case BAJA_MARCA:
			bajaMarca(datos);
			break;
		case ACTUALIZAR_MARCA:
			actualizarMarca(datos);
			break;
		case BUSCAR_MARCA:
			buscarMarca(datos);
			break;

			// EMPLEADOS
		case VISTA_PRINCIPAL_EMPLEADOS:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_PRINCIPAL_EMPLEADOS);
			break;
		case VISTA_ALTA_EMPLEADO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ALTA_EMPLEADO);
			break;
		case VISTA_BAJA_EMPLEADO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BAJA_EMPLEADO);
			break;
		case VISTA_ACTUALIZAR_EMPLEADO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_EMPLEADO);
			break;
		case VISTA_BUSCAR_EMPLEADO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_EMPLEADO);
			break;
		case VISTA_LISTAR_EMPLEADOS:
			listarEmpleados(datos);
			break;
		case ACTUALIZAR_EMPLEADO:
			actualizarEmpleado(datos);
			break;
		case ALTA_EMPLEADO:
			altaEmpleado(datos);
			break;
		case BAJA_EMPLEADO:
			bajaEmpleado(datos);
			break;
		case BUSCAR_EMPLEADO:
			buscarEmpleado(datos);

			// CLIENTE
		case VISTA_PRINCIPAL_CLIENTE:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_PRINCIPAL_CLIENTE);
			break;
		case VISTA_ALTA_CLIENTE:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ALTA_CLIENTE);
			break;
		case VISTA_BAJA_CLIENTE:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BAJA_CLIENTE);
			break;
		case VISTA_ACTUALIZAR_CLIENTE:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_CLIENTE);
			break;
		case VISTA_BUSCAR_CLIENTE:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_CLIENTE);
			break;
		case VISTA_LISTAR_CLIENTES:
			this.listarClientes(datos);
			break;
		case ALTA_CLIENTE:
			this.altaCliente(datos);
			break;
		case BAJA_CLIENTE:
			this.bajaCliente(datos);
			break;
		case ACTUALIZAR_CLIENTE:
			this.actualizarCliente(datos);
			break;
		case BUSCAR_CLIENTE:
			this.buscarCliente(datos);
			break;
		default:
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
			if (id_factura != -1) {
				FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_CERRAR_VENTA)
						.actualizar(Evento.CERRAR_VENTA_SUCCESS, id_factura);
			} else {
				FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_CERRAR_VENTA)
						.actualizar(Evento.CERRAR_VENTA_ERROR, "la venta no se ha podido cerrar");
			}
		}

	}

	// MARCAS
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
		String nombre = (String) datos;
		try {
			int id = SAMarca.bajaMarca(nombre);
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
			int id = SAMarca.actualizarMarca(marca);
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_MARCA)
					.actualizar(Evento.ACTUALIZAR_MARCA_SUCCESS, id);
		} catch (IllegalArgumentException e) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_MARCA)
					.actualizar(Evento.ACTUALIZAR_MARCA_ERROR, e.getMessage());
		}
	}
	

	private void buscarMarca(Object datos) {
		SAMarca SAMarca = FactoriaAbstractaNegocio.getInstance().crearSAMarca();
		String nombre = (String) datos;
		TMarca marca = SAMarca.buscarMarca(nombre);
		if (marca != null) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_MARCA)
					.actualizar(Evento.BUSCAR_MARCA_SUCCESS, marca);
		} else {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_MARCA)
					.actualizar(Evento.BUSCAR_MARCA_ERROR, "Marca no encontrada.");
		}
	}
	

	private void listarMarcas(Object datos) {
		SAMarca SAMarca = FactoriaAbstractaNegocio.getInstance().crearSAMarca();
		Collection<TMarca> marcas = SAMarca.listarMarcas();
		FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_LISTAR_MARCAS)
				.actualizar(Evento.LISTAR_MARCAS, marcas);
	}
	
	// CLIENTE
	private void altaCliente(Object datos) {
		SACliente saCliente = FactoriaAbstractaNegocio.getInstance().crearSACliente();
		TCliente tcliente = (TCliente) datos;
		try {
			int id = saCliente.altaCliente(tcliente);
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ALTA_CLIENTE)
					.actualizar(Evento.ALTA_CLIENTE_SUCCESS, id);
		} catch (IllegalArgumentException e) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ALTA_CLIENTE)
					.actualizar(Evento.ALTA_CLIENTE_ERROR, e.getMessage());
		}
	}
	
	private void bajaCliente(Object datos) {
		SACliente saCliente = FactoriaAbstractaNegocio.getInstance().crearSACliente();
		String dni = (String) datos;
		try {
			int id = saCliente.bajaCliente(dni);
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BAJA_CLIENTE)
					.actualizar(Evento.BAJA_CLIENTE_SUCCESS, id);
		} catch (IllegalArgumentException e) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BAJA_CLIENTE)
					.actualizar(Evento.BAJA_CLIENTE_ERROR, e.getMessage());
		}
	}
	
	private void actualizarCliente(Object datos) {
		SACliente saCliente = FactoriaAbstractaNegocio.getInstance().crearSACliente();
		TCliente tcliente = (TCliente) datos;
		try {
			int id = saCliente.actualizarCliente(tcliente);
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_CLIENTE)
					.actualizar(Evento.ACTUALIZAR_CLIENTE_SUCCESS, id);
		} catch (IllegalArgumentException e) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_CLIENTE)
					.actualizar(Evento.ACTUALIZAR_CLIENTE_ERROR, e.getMessage());
		}
	}
	
	private void buscarCliente(Object datos) {
		SACliente saCliente = FactoriaAbstractaNegocio.getInstance().crearSACliente();
		String dni = (String) datos;
		TCliente tcliente = saCliente.buscarCliente(dni);
		if (tcliente == null) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_CLIENTE).actualizar(Evento.BUSCAR_CLIENTE_ERROR, "Cliente no encontrado.");
		}
		else {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_CLIENTE).actualizar(Evento.BUSCAR_CLIENTE_SUCCESS, tcliente);
		}
	}

	private void listarClientes(Object datos) {
		SACliente saCliente = FactoriaAbstractaNegocio.getInstance().crearSACliente();
		Collection<TCliente> clientes = saCliente.listarClientes();
		FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_LISTAR_CLIENTES)
				.actualizar(Evento.LISTAR_CLIENTES, clientes);
	}

	// EMPLEADOS
	private void altaEmpleado(Object datos) {
		SAEmpleado saEmpleado = FactoriaAbstractaNegocio.getInstance().crearSAEmpleado();
		TEmpleado tEmpleado = (TEmpleado) datos;
		try {
			int id = saEmpleado.altaEmpleado(tEmpleado);
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ALTA_EMPLEADO)
					.actualizar(Evento.ALTA_EMPLEADO_EXITO, id);
		} catch (IllegalArgumentException e) {
			//no se habria podido dar de alta al empleado
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ALTA_EMPLEADO)
					.actualizar(Evento.ALTA_EMPLEADO_ERROR, e.getMessage());
		}
	}
	
	private void bajaEmpleado(Object datos) {
		SAEmpleado saEmpleado = FactoriaAbstractaNegocio.getInstance().crearSAEmpleado();
		String dni = (String) datos;
		try {
			int id = saEmpleado.bajaEmpleado(dni);
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BAJA_EMPLEADO)
					.actualizar(Evento.BAJA_EMPLEADO_EXITO, id);
		} catch (IllegalArgumentException e) {
			//no se ha podido dar de baja al empleado
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BAJA_EMPLEADO)
					.actualizar(Evento.BAJA_EMPLEADO_ERROR, e.getMessage());
		}
	}
	
	private void actualizarEmpleado(Object datos) {
		SAEmpleado saEmpleado = FactoriaAbstractaNegocio.getInstance().crearSAEmpleado();
		TEmpleado tEmpleado = (TEmpleado) datos;
		try {
			int id = saEmpleado.actualizarEmpleado(tEmpleado);
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_EMPLEADO)
					.actualizar(Evento.ACTUALIZAR_EMPLEADO_EXITO, id);
		} catch (IllegalArgumentException e) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_EMPLEADO)
					.actualizar(Evento.ACTUALIZAR_EMPLEADO_ERROR, e.getMessage());
		}
	}
	
	private void buscarEmpleado(Object datos) {
		SAEmpleado saEmpleado = FactoriaAbstractaNegocio.getInstance().crearSAEmpleado();
		String dni = (String) datos;
		TEmpleado tEmpleado = saEmpleado.buscarEmpleado(dni);
		if (tEmpleado == null) {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_EMPLEADO).actualizar(Evento.BUSCAR_EMPLEADO_ERROR, "Empleado no encontrado.");
		}
		else {
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_EMPLEADO).actualizar(Evento.BUSCAR_EMPLEADO_EXITO, tEmpleado);
		}
	}

	private void listarEmpleados(Object datos) {
		SAEmpleado saEmpleado = FactoriaAbstractaNegocio.getInstance().crearSAEmpleado();
		Collection<TEmpleado> empleados = saEmpleado.listarEmpleados();
		FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_LISTAR_EMPLEADOS)
				.actualizar(Evento.LISTAR_EMPLEADOS, empleados);
	}
	

}
