package integracion.Facturas;

import java.util.Collection;

import negFactura.TFactura;
import negFactura.TLineaFactura;

public interface DAOFactura {
	public boolean modificarFactura(TLineaFactura linea);

	public TFactura buscarFactura(String id);

	public boolean crearFactura(TFactura f);

	public Collection<TFactura> listarFacturas();
}
