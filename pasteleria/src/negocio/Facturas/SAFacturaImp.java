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

	public int crearFactura(TDatosVenta datos) {
		// creamos los dao
		DAOFactura daoFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOFactura();
		DAOLineaFactura daoLineaFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOLineaFactura();
		DAOCliente daoCliente = FactoriaAbstractaIntegracion.getInstance().crearDAOCliente();
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		DAOEmpleado daoEmpleado = FactoriaAbstractaIntegracion.getInstance().crearDAOEmpleado();

		TFactura factura;
		ArrayList<TLineaFactura> lineas_factura_definitivas = new ArrayList<TLineaFactura>();

		int precio_total = 0;
		// int id_lineaFactura = 0;
		int id_factura = -1;

		TCliente cliente = daoCliente.buscarCliente(datos.getIdCliente());
		TEmpleado vendedor = daoEmpleado.buscarEmpleado(datos.getIdVendedor());

		boolean exito = true;
		if (cliente != null /* && vendedor != null */) {
			int i = 0;
			// Recorremos las lineas de factura de nuestra nueva factura
			ArrayList<TLineaFactura> lineas_factura_por_comprobar = datos.getProductos();
			while (i < lineas_factura_por_comprobar.size() && exito) {
				TLineaFactura linea_factura = lineas_factura_por_comprobar.get(i);
				// comprobamos el producto
				TProducto producto = daoProducto.buscarProducto(linea_factura.getIdProducto());
				if (producto == null || linea_factura.getCantidad() < 0 || producto.getStock() < 0
						|| producto.getPrecio() < 0) {
					exito = false;
				} else {
					if (producto.getStock() < linea_factura.getCantidad()) {
						linea_factura.setCantidadProducto(producto.getStock());
					}
					// id_lineaFactura = linea_factura.getIdLinea();
					precio_total += producto.getPrecio() * linea_factura.getCantidad();
					producto.setStock(producto.getStock() - linea_factura.getCantidad());
					daoProducto.actualizarProducto(producto);
					// guardamos la linea de factura
					lineas_factura_definitivas.add(linea_factura);
				}
				i++;
			}

		}
		if (lineas_factura_definitivas.size() > 0 && exito) {// si hay lineas válidas y no hay problemas en la factura
			TDatosVenta datos_comprobados = new TDatosVenta(datos.getFecha(), datos.getIdVendedor(), 0,
					lineas_factura_definitivas);
			id_factura = daoFactura.crearFactura(new TFactura(0, precio_total, datos_comprobados, true));
			for (TLineaFactura lf : lineas_factura_definitivas) {
				lf.setIdFactura(id_factura);
				daoLineaFactura.crearLineaFactura(lf);
			}
			// vendedor.setNumVentas(vendedor.getNumVentas() + 1);
			// daoEmpleado.actualizarEmpleado(vendedor);
		}
		return id_factura;
	}

	public boolean anadirProducto(TLineaFactura linea, Carrito c) {
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		TProducto producto = daoProducto.buscarProducto(linea.getIdProducto());
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

}
