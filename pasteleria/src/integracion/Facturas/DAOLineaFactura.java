package integracion.Facturas;

import java.util.Collection;

import negocio.Facturas.TLineaFactura;

public interface DAOLineaFactura {
	public boolean modificarLineaFactura(TLineaFactura f);

	public TLineaFactura buscarLineaFactura(int id);

	public int crearLineaFactura(TLineaFactura f);

	public void eliminarLineaFactura(TLineaFactura f);

	public Collection<TLineaFactura> mostrarLineasFactura();
}
