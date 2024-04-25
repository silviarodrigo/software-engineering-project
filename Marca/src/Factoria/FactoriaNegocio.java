package Factoria;

import Negocio.SAMarca;
import Negocio.SAMarcaImp;

public class FactoriaNegocio extends FactoriaAbstractaNegocio {

	@Override
	public SAMarca crearMarca() {
		return new SAMarcaImp();
	}

}
