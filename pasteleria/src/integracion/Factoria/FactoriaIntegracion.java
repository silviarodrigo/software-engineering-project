package integracion.Factoria;

import integracion.Marca.DAOMarca;
import integracion.Marca.DAOMarcaImp;
import integracion.Marca.DAOMarcaProveedor;
import integracion.Marca.DAOMarcaProveedorImp;
import integracion.Facturas.DAOFactura;
import integracion.Facturas.DAOFacturaImp;
import integracion.Facturas.DAOLineaFactura;
import integracion.Facturas.DAOLineaFacturaImp;
import negocio.Facturas.SAFactura;
import negocio.Facturas.SAFacturaImp;

public class FactoriaIntegracion extends FactoriaAbstractaIntegracion {

	public DAOFactura crearDAOFactura() {
		return new DAOFacturaImp();
	}
	
	public DAOLineaFactura crearDAOLineaFactura() {
		return new DAOLineaFacturaImp();
	}
	
	public DAOMarca crearDAOMarca() {
		return new DAOMarcaImp();
	}

	public DAOMarcaProveedor crearDAOMarcaProveedor() {
		return new DAOMarcaProveedorImp();
	}

}