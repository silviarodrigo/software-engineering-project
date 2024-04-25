package negocio;

import negFactura.SAFactura;

public abstract class FactoriaAbstractaNegocio {

private static FactoriaAbstractaNegocio instance = null;
	
	public static FactoriaAbstractaNegocio getInstace() {
		if(instance == null) {
			instance = new FactoriaNegocio();
		}
		return instance;
	}
	public abstract SAFactura crearSAFactura();

}
