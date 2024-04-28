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

	public TFactura buscarFactura(String id) {
		DAOFactura daoFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOFactura();
		return daoFactura.buscarFactura(id);
	}

	public Collection<TFactura> listarFacturas() {
		DAOFactura daoFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOFactura();
		return daoFactura.listarFacturas();
	}

	public boolean crearFactura(TDatosVenta datos) {
		DAOFactura daoFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOFactura();
		DAOCliente daoCliente = FactoriaAbstractaIntegracion.getInstance().crearDAOCliente();
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		DAOLineaFactura daoLineaFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOLineaFactura();
		TFactura factura;
		ArrayList<TLineaFactura> lineas_factura = new ArrayList<TLineaFactura>();

		int precio_total = 0;
		int id_lineaFactura = 0;
		String id_factura;
		TCliente cliente = daoCliente.buscarCliente(datos.getIdCliente());

		if (cliente != null) {
			for (TLineaFactura linea_factura : datos.getProductos()) {
				TProducto producto = daoProducto.buscarProducto(linea_factura.getIdProducto());
				id_lineaFactura = linea_factura.getId();
				id_factura = linea_factura.getIdFactura();
				precio_total += producto.getPrecio() * linea_factura.getCantidad();
				TLineaFactura linea_factura2 = daoLineaFactura.buscarLineaFactura(id_lineaFactura);
				if (linea_factura2 == null) {
					lineas_factura.add(linea_factura);
					daoLineaFactura.crearLineaFactura(linea_factura);
				}
			}
			factura = daoFactura.buscarFactura(id_factura);
			if (factura == null) {
				factura = new TFactura(id_factura, precio_total, datos, false);
			} else
				return false;
		} else
			return false;

		return true;

		return daoFactura.crearFactura(factura);
	}

	public void anadirProducto(TLineaFactura linea, Carrito c) {
		c.anadirProducto(linea);
	}

}
