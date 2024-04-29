package negocio.Facturas;

import java.util.Collection;

public interface SAFactura {
	public TFactura buscarFactura(String id);

	public Collection<TFactura> listarFacturas();

	public int crearFactura(TDatosVenta datos);

	void anadirProducto(TLineaFactura linea, Carrito c);

	void eliminarProducto(TLineaFactura linea, Carrito c);
}
