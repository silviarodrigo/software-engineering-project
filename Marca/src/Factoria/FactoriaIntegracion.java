package Factoria;

import Integracion.DAOMarca;
import Integracion.DAOMarcaProveedor;
import Integracion.DAOMarcaImp;
import Integracion.DAOMarcaProveedorImp;

public class FactoriaIntegracion extends FactoriaAbstractaIntegracion {

	@Override
	public DAOMarca crearDAOMarca() {
		return new DAOMarcaImp();
	}

	@Override
	public DAOMarcaProveedor crearDAOMarcaProveedor() {
		return new DAOMarcaProveedorImp();
	}
}
