package Factoria;

import Negocio.SAMarca;

public abstract class FactoriaAbstractaNegocio {
	
	private static FactoriaAbstractaNegocio instance = null;
	
	public static FactoriaAbstractaNegocio getInstance() {
		if (instance == null) instance = new FactoriaNegocio();
		return instance;
	}
	
	public abstract SAMarca crearMarca();
}

