package negocio.Factoria;

import negocio.Facturas.SAFactura;
import negocio.Facturas.SAFacturaImp;
import negocio.Marca.SAMarca;
import negocio.Marca.SAMarcaImp;
import negocio.Producto.SAProducto;
import negocio.Producto.SAProductoImp;

public class FactoriaNegocio extends FactoriaAbstractaNegocio {

	@Override
	public SAFactura crearSAFactura() {
		return new SAFacturaImp();
	}
	
	public SAMarca crearMarca() {
		return new SAMarcaImp();
	}
	
	public SAProducto creaSAProducto() {
		return new SAProductoImp();
	}

}
