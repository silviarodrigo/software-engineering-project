package Factoria;

import Integracion.DAOMarca;
import Integracion.DAOMarcaProveedor;

public abstract class FactoriaAbstractaIntegracion { //singleton
	private static FactoriaAbstractaIntegracion instance = null;
	
	public static FactoriaAbstractaIntegracion getInstance() {
		if (instance == null) instance = new FactoriaIntegracion();
			
		return instance;
	}
	
	public abstract DAOMarca crearDAOMarca();
	public abstract DAOMarcaProveedor crearDAOMarcaProveedor();

}