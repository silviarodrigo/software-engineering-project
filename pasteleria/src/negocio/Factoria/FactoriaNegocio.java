package negocio.Factoria;

import negocio.Facturas.SAFactura;
import negocio.Facturas.SAFacturaImp;

public class FactoriaNegocio extends FactoriaAbstractaNegocio {

	@Override
	public SAFactura crearSAFactura() {
		return new SAFacturaImp();
	}
	
	public SAMarca crearMarca() {
		return new SAMarcaImp();
	}

}
