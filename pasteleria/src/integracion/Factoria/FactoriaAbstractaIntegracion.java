package integracion.Factoria;

import intFactura.DAOFactura;
import intFactura.DAOLineaFactura;
import negFactura.SAFactura;

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
}
