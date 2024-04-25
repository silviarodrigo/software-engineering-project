package integracion.Factoria;

import intFactura.DAOFactura;
import intFactura.DAOFacturaImp;
import intFactura.DAOLineaFactura;
import intFactura.DAOLineaFacturaImp;
import negFactura.SAFactura;
import negFactura.SAFacturaImp;

public class FactoriaIntegracion extends FactoriaAbstractaIntegracion {

	public DAOFactura crearDAOFactura() {
		return new DAOFacturaImp();
	}
	
	public DAOLineaFactura crearDAOLineaFactura() {
		return new DAOLineaFacturaImp();
	}
}