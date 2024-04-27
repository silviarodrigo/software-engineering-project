package integracion;

import integracion.Facturas.DAOFactura;
import integracion.Facturas.DAOLineaFactura;
import integracion.Cliente.DAOCliente;
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
	public abstract DAOCliente crearDAOCliente();
}
