package integracion.Factoria;

import integracion.Marca.DAOMarca;
import integracion.Marca.DAOMarcaProveedor;
import integracion.Facturas.DAOFactura;
import integracion.Facturas.DAOLineaFactura;
import negocio.Facturas.SAFactura;

public abstract class FactoriaAbstractaIntegracion {

	private static FactoriaAbstractaIntegracion instancia = null;

	public static FactoriaAbstractaIntegracion getInstace() { // creacion perezosa
		if (instancia == null) {
			instancia = new FactoriaIntegracion();
		}
		return instancia;
	}

	// metodos para crear DAOS

	public abstract DAOFactura crearDAOFactura();
	public abstract DAOLineaFactura crearDAOLineaFactura();
	public abstract DAOMarca crearDAOMarca();
	public abstract DAOMarcaProveedor crearDAOMarcaProveedor();
}
