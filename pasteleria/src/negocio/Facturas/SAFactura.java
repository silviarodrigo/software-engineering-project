package negocio.Facturas;

import java.util.Collection;

public interface SAFactura {
	public TFactura buscarFactura(String id);

	public Collection<TFactura> listarFacturas();

	public boolean crearFactura(TDatosVenta datos);

	void anadirProducto(TLineaFactura linea, Carrito c);
}
