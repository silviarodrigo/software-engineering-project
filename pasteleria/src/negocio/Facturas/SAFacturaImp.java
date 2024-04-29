package negocio.Facturas;

import java.util.Collection;

import integracion.Cliente.DAOCliente;
import integracion.Factoria.FactoriaAbstractaIntegracion;
import integracion.Facturas.*;
import integracion.Producto.DAOProducto;
import negocio.Cliente.TCliente;
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
		DAOEmpleados daoEmpleado = FactoriaAbstractaIntegracion.getInstance().crearDAOEmpleado();

		TFactura factura;
		ArrayList<TLineaFactura> lineas_factura_definitivas = new ArrayList<TLineaFactura>();

		int precio_total = 0;
		int id_lineaFactura = 0;
		int id_factura = -1;
		TCliente cliente = daoCliente.buscarCliente(datos.getIdCliente());
		TEmpleado vendedor = daoEmpleado.buscarEmpleado(datos.getIdVendedor());
		boolean exito = true;
		if (cliente != null && vendedor != null) {
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
					id_lineaFactura = linea_factura.getIdLinea();
					precio_total += producto.getPrecio() * linea_factura.getCantidad();
					producto.setStock(producto.getStock() - linea_factura.getCantidad());
					// guardamos la linea de factura
					lineas_factura_definitivas.add(linea_factura);
				}
				i++;
			}

		}
		if (lineas_factura_definitivas.size() > 0 && exito) {// si hay lineas válidas y no hay problemas en la factura
			id_factura = daoFactura.crearFactura(new TFactura(0, precio_total, datos, false));
			for (TLineaFactura lf : lineas_factura_definitivas) {
				lf.setIdFactura(id_factura);
				daoLineaFactura.crearLineaFactura(lf);
			}
			vendedor.setNumVentas(vendedor.getNumVentas + 1);
			vendedor.update();
		}
		return id_factura;
	}

	public void anadirProducto(TLineaFactura linea, Carrito c) {
		c.anadirProducto(linea);
	}

	public void eliminarProducto(TLineaFactura linea, Carrito c) {
		c.eliminarProducto(linea);
	}
	
	public void cerrarVenta() {
		
	}
	public void abrirVenta() {
		
	}

}
