package negocio.Factoria;

import negocio.Facturas.SAFactura;
import negocio.Marca.SAMarca;

public abstract class FactoriaAbstractaNegocio {

private static FactoriaAbstractaNegocio instance = null;
	
	public static FactoriaAbstractaNegocio getInstance() {
		if(instance == null) {
			instance = new FactoriaNegocio();
		}
		return instance;
	}
	public abstract SAFactura crearSAFactura();
	public abstract SAMarca crearMarca();


}
