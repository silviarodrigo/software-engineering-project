package integracion.Facturas;

import java.util.Collection;

import negocio.Facturas.TFactura;
import negocio.Facturas.TLineaFactura;

public interface DAOFactura {
	public boolean modificarFactura(int id_f, int id_c, int id_v, String fechaF);

	public TFactura buscarFactura(int id_factura);

	public int crearFactura(TFactura f);

	public Collection<TFactura> listarFacturas();
	
	public Collection<TFactura> listarFacturasPorCliente(int id_cliente);
}
