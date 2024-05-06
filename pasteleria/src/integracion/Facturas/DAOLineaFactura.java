package integracion.Facturas;

import java.util.ArrayList;
import java.util.Collection;

import negocio.Facturas.TLineaFactura;

public interface DAOLineaFactura {
	public int modificarLineaFactura(TLineaFactura lf, ArrayList<TLineaFactura> lineas_factura);

	public TLineaFactura buscarLineaFactura(int id);

	public int crearLineaFactura(TLineaFactura f);

	public Collection<TLineaFactura> mostrarLineasFactura();
}
