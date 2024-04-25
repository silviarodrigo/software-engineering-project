package integracion.Facturas;

import java.util.Collection;

import negFactura.TLineaFactura;

public interface DAOLineaFactura {
	public boolean modificarLineaFactura(TLineaFactura f);

	public TLineaFactura buscarLineaFactura(String id);

	public void crearLineaFactura(TLineaFactura f);
	
	public void eliminarLineaFactura(TLineaFactura f);

	public Collection<TLineaFactura> mostrarLineasFactura();
}
