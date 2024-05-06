package negocio.Proveedor;

import java.util.Collection;

import integracion.Factoria.FactoriaAbstractaIntegracion;
import integracion.Marca.DAOMarca;
import integracion.Proveedor.DAOProveedor;
import negocio.Marca.TMarca;

public class SAProveedorImp implements SAProveedor{

	@Override
	public int altaProveedor(TProveedor proveedor) throws IllegalArgumentException {
		DAOProveedor daoProveedor = FactoriaAbstractaIntegracion.getInstance().crearDAOProveedor();
		int id = -1;
		
		TProveedor prov = daoProveedor.buscarProveedor(proveedor.getNombre());
		if (prov == null) { //no existía previamente
			id = daoProveedor.altaProveedor(proveedor);	
		}
		else if (!prov.getActivo()) { //sí existía pero no activo
			prov.setID(proveedor.getID());
			prov.setActivo(true);
			id = daoProveedor.actualizarProveedor(proveedor);
		}
		else throw new IllegalArgumentException("Proveedor ya existe.");
		return id;
	}

	@Override
	public int bajaProveedor(String nombre) {
		DAOProveedor daoProveedor = FactoriaAbstractaIntegracion.getInstance().crearDAOProveedor();
		TProveedor proveedor = daoProveedor.buscarProveedor(nombre);
		
		//no se puede realizar la acción si el proveedor no existe o no está activo
		if (proveedor == null ) {
			throw new IllegalArgumentException("Proveedor no existente.");
		}
		else if (!proveedor.getActivo()) {
			throw new IllegalArgumentException("El proveedor ya ha sido dada de baja.");
		}
		
		daoProveedor.bajaProveedor(proveedor.getID());
		return proveedor.getID();
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
