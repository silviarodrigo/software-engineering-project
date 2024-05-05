package negocio.Facturas;

import java.util.Collection;

public interface SAFactura {
	public TFactura buscarFactura(int id);

	public Collection<TFactura> listarFacturas();

	public int crearFactura(TDatosVenta datos);

	public boolean anadirProducto(TLineaFactura linea, Carrito c);

	public boolean eliminarProducto(TLineaFactura linea, Carrito c);

	public int cerrarVenta(Carrito c, int id_cliente, int id_vendedor, String fecha);

	public Carrito abrirVenta();

	public boolean modificarFactura(int id_f, int id_c, int id_v, String fecha);

	public Collection<TFactura> listarFacturasPorCliente(int id_cliente);
}
