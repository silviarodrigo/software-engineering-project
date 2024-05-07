package negocio.Facturas;

import java.util.Collection;

import integracion.Cliente.DAOCliente;
import integracion.Empleado.DAOEmpleado;
import integracion.Factoria.FactoriaAbstractaIntegracion;
import integracion.Facturas.*;
import integracion.Producto.DAOProducto;
import negocio.Cliente.TCliente;
import negocio.Empleados.TEmpleado;
import negocio.Producto.TProducto;

import java.util.ArrayList;

public class SAFacturaImp implements SAFactura {

	public TFactura buscarFactura(int id) {
		DAOFactura daoFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOFactura();
		return daoFactura.buscarFactura(id);
	}

	public Collection<TFactura> listarFacturas() {
		DAOFactura daoFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOFactura();
		return daoFactura.listarFacturas();
	}

	public Collection<TFactura> listarFacturasPorCliente(int id_cliente) {
		DAOCliente daoCliente = FactoriaAbstractaIntegracion.getInstance().crearDAOCliente();
		TCliente cliente = daoCliente.buscarCliente(id_cliente);
		if (cliente != null) {// si el cliente existe
			DAOFactura daoFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOFactura();
			return daoFactura.listarFacturasPorCliente(id_cliente);
		} else
			return null;
	}

	public TFacturasCliente listarFacturasConCliente(int id_cliente) {
		DAOCliente daoCliente = FactoriaAbstractaIntegracion.getInstance().crearDAOCliente();
		TCliente cliente = daoCliente.buscarCliente(id_cliente);
		if (cliente != null) {
			DAOFactura daoFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOFactura();
			// creamos nuestro TFacturasCliente para poder devolver la coleccion y el
			// TCliente a la vez
			return new TFacturasCliente(cliente, daoFactura.listarFacturasPorCliente(id_cliente));
		} else
			return null;
	}

	public int crearFactura(TDatosVenta datos) {
		// creamos los dao
		DAOFactura daoFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOFactura();
		DAOLineaFactura daoLineaFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOLineaFactura();
		DAOCliente daoCliente = FactoriaAbstractaIntegracion.getInstance().crearDAOCliente();
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		DAOEmpleado daoEmpleado = FactoriaAbstractaIntegracion.getInstance().crearDAOEmpleado();

		// Creamos variables auxiliares
		ArrayList<TLineaFactura> lineas_factura_definitivas = new ArrayList<TLineaFactura>();
		int precio_total = 0;
		int id_factura = -1;
		boolean exito = true;

		// buscamos el cliente y el vendedor
		TCliente cliente = daoCliente.buscarCliente(datos.getIdCliente());
		TEmpleado vendedor = daoEmpleado.buscarEmpleado(datos.getIdVendedor());

		// solo si existen y estan activos podemos crear la factura
		if (cliente != null && cliente.getActivo() && vendedor != null && vendedor.getActivo()) {
			int i = 0;
			// Recorremos las lineas de factura de nuestra nueva factura
			ArrayList<TLineaFactura> lineas_factura_por_comprobar = datos.getProductos();
			while (i < lineas_factura_por_comprobar.size() && exito) {
				TLineaFactura linea_factura = lineas_factura_por_comprobar.get(i);
				// comprobamos que es una linea válida
				TProducto producto = daoProducto.buscarProducto(linea_factura.getIdProducto());
				if (producto == null || linea_factura.getCantidad() < 0 || producto.getStock() < 0
						|| producto.getPrecio() < 0) {
					exito = false;
				} else {
					if (producto.getStock() < linea_factura.getCantidad()) {
						linea_factura.setCantidadProducto(producto.getStock());
					}
					precio_total += producto.getPrecio() * linea_factura.getCantidad();
					// Actualizamos la informacion del producto
					producto.setStock(producto.getStock() - linea_factura.getCantidad());
					daoProducto.actualizarProducto(producto);
					// guardamos la linea de factura
					lineas_factura_definitivas.add(linea_factura);
				}
				i++;
			}
		}
		if (lineas_factura_definitivas.size() > 0 && exito) {// si hay lineas válidas y no hay problemas en la factura
			// Creamos la factura
			TDatosVenta datos_comprobados = new TDatosVenta(datos.getFecha(), datos.getIdCliente(),
					datos.getIdVendedor(), lineas_factura_definitivas);
			id_factura = daoFactura.crearFactura(new TFactura(0, precio_total, datos_comprobados, true));
			// Creamos las lineas de factura
			for (TLineaFactura lf : lineas_factura_definitivas) {
				lf.setIdFactura(id_factura);
				daoLineaFactura.crearLineaFactura(lf);
			}
			// Actualizamos la informacion del vendedor
			vendedor.setNumVentas(vendedor.getNumVentas() + 1);
			daoEmpleado.actualizarEmpleado(vendedor);
		}
		return id_factura;
	}

	public boolean anadirProducto(TLineaFactura linea, Carrito c) {
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		TProducto producto = daoProducto.buscarProducto(linea.getIdProducto());
		// si el producto existe y se puede comprar:
		if (producto != null && producto.getActivo()) {
			c.anadirProducto(linea);
		} else {
			return false;
		}
		return true;
	}

	public boolean eliminarProducto(TLineaFactura linea, Carrito c) {
		boolean exito = true;
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		TProducto producto = daoProducto.buscarProducto(linea.getIdProducto());
		// si el producto existe y se puede comprar:
		if (producto != null && producto.getActivo()) {
			exito = c.eliminarProducto(linea);
		} else {
			exito = false;
		}
		return exito;
	}

	public int cerrarVenta(Carrito c, int id_cliente, int id_vendedor, String fecha) {
		return crearFactura(new TDatosVenta(fecha, id_cliente, id_vendedor, c.getProductos()));
	}

	public Carrito abrirVenta() {
		return new Carrito();
	}

	public boolean modificarFactura(int id_f, int id_c, int id_v, String fecha) {
		DAOFactura daoFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOFactura();
		return daoFactura.modificarFactura(id_f, id_c, id_v, fecha);
	}

	public boolean devolucionFactura(TLineaFactura lf) {
		// creamos los DAO
		DAOFactura daoFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOFactura();
		DAOLineaFactura daol = FactoriaAbstractaIntegracion.getInstance().crearDAOLineaFactura();
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		// buscamos la factura
		TFactura factura = buscarFactura(lf.getIdFactura());
		if (factura != null) {
			int cantidad_quitada = daol.modificarLineaFactura(lf, factura.getDatosVentas().getProductos());
			if (cantidad_quitada != -1) {
				TProducto producto = daoProducto.buscarProducto(lf.getIdProducto());
				//sabemos que el producto existe porque la 
				producto.setStock(producto.getStock() + cantidad_quitada);
				daoProducto.actualizarProducto(producto);
				double nuevo_precio = factura.getPrecio_total() - (cantidad_quitada * producto.getPrecio());
				factura.setPrecio_total(nuevo_precio);
				return daoFactura.devolucionFactura(factura);
			}
		}
		return false;
	}

}
