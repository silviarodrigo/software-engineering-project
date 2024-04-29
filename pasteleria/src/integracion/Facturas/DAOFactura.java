package integracion.Facturas;

import java.util.Collection;

import negocio.Facturas.TFactura;
import negocio.Facturas.TLineaFactura;

public interface DAOFactura {
	public boolean modificarFactura(TLineaFactura linea);

	public TFactura buscarFactura(String id_factura);

	public boolean crearFactura(TFactura f);

	public Collection<TFactura> listarFacturas();
}
