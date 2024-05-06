package negocio.Proveedor;

import java.util.Collection;

import integracion.Factoria.FactoriaAbstractaIntegracion;
import integracion.Proveedor.DAOProveedor;

public class SAProveedorImp implements SAProveedor{

	@Override
	public int altaProveedor(TProveedor proveedor) throws IllegalArgumentException {
		DAOProveedor daoProveedor = FactoriaAbstractaIntegracion.getInstance()	}

	@Override
	public int bajaProveedor(String nombre) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarProveedor(TProveedor proveedor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TProveedor buscarProveedor(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TProveedor> listarProveedores() {
		// TODO Auto-generated method stub
		return null;
	}

}
