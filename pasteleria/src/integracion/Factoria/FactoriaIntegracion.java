package integracion.Factoria;

import integracion.Marca.DAOMarca;

import integracion.Marca.DAOMarcaImp;
import integracion.Marca.DAOMarcaProveedor;
import integracion.Marca.DAOMarcaProveedorImp;
import integracion.Producto.DAOProducto;
import integracion.Producto.DAOProductoImp;
import integracion.Cliente.DAOCliente;
import integracion.Cliente.DAOClienteImp;
import integracion.Facturas.DAOFactura;
import integracion.Facturas.DAOFacturaImp;
import integracion.Facturas.DAOLineaFactura;
import integracion.Facturas.DAOLineaFacturaImp;
import negocio.Facturas.SAFactura;
import negocio.Facturas.SAFacturaImp;

public class FactoriaIntegracion extends FactoriaAbstractaIntegracion {

	@Override
	public DAOFactura crearDAOFactura() {
		return new DAOFacturaImp();
	}
	
	@Override
	public DAOLineaFactura crearDAOLineaFactura() {
		return new DAOLineaFacturaImp();
	}
	
	@Override
	public DAOMarca crearDAOMarca() {
		return new DAOMarcaImp();
	}

	@Override
	public DAOMarcaProveedor crearDAOMarcaProveedor() {
		return new DAOMarcaProveedorImp();
	}

	@Override
	public DAOProducto crearDAOProducto() {
		return new DAOProductoImp();
	}

	@Override
	public DAOCliente crearDAOCliente() {
		return new DAOClienteImp();
	}

}