package negocio.Facturas;

import java.util.Collection;

import integracion.Factoria.FactoriaAbstractaIntegracion;
import integracion.Facturas.*;

public class SAFacturaImp implements SAFactura {

	public TFactura buscarFactura(String id) {
		DAOFactura daoFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOFactura();
		return daoFactura.buscarFactura(id);
	}

	public Collection<TFactura> listarFacturas() {
////////////////////////////////////////////////////////FALTA LA FACTORIA
		DAOFactura daoFactura = null;
		return daoFactura.listarFacturas();
	}

	public boolean crearFactura(TDatosVenta datos) {
////////////////////////////////////////////////////////FALTA LA FACTORIA
		DAOFactura daoFactura = null;
		// Tdatosventa??????
		return daoFactura.crearFactura();
	}

	public void anadirProducto(TLineaFactura linea, Carrito c) {
		c.anadirProducto(linea);
	}

}
