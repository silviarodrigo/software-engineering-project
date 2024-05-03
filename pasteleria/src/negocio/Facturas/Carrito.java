package negocio.Facturas;

import java.util.ArrayList;

import integracion.Factoria.FactoriaAbstractaIntegracion;
import integracion.Facturas.DAOLineaFactura;

public class Carrito {
	private ArrayList<TLineaFactura> lista_productos;

	public Carrito() {
		this.lista_productos = new ArrayList<TLineaFactura>();
	}

	public ArrayList<TLineaFactura> getProductos() {
		return lista_productos;
	}

	public void anadirProducto(TLineaFactura linea) {
		int i = buscarEnLista(linea);
		if (i == -1) {
			this.lista_productos.add(linea);
		} else {
			this.lista_productos.get(i)
					.setCantidadProducto(this.lista_productos.get(i).getCantidad() + linea.getCantidad());
		}
	}

	public boolean eliminarProducto(TLineaFactura linea) {
		int i = buscarEnLista(linea);
		if (i == -1) {
			return false;
		} else {
//			DAOLineaFactura daoLineaFactura = FactoriaAbstractaIntegracion.getInstance().crearDAOLineaFactura();
//			// mas adelante podremos simplemente modificar la linea de factura, hasta
//			// entonces:
//			daoLineaFactura.eliminarLineaFactura(lista_productos.get(i));
			this.lista_productos.get(i)
					.setCantidadProducto(this.lista_productos.get(i).getCantidad() - linea.getCantidad());
			if (this.lista_productos.get(i).getCantidad() <= 0) {
				this.lista_productos.get(i).setActivo(false);
			}
			//daoLineaFactura.crearLineaFactura(lista_productos.get(i));
			return true;
		}
	}

	private int buscarEnLista(TLineaFactura linea) {
		boolean encontrado = false;
		int i = 0;
		while (i < this.lista_productos.size() && !encontrado) {
			if (linea.getIdProducto() == this.lista_productos.get(i).getIdProducto()) {
				encontrado = true;
			}
			i++;
		}
		if (encontrado)
			return i - 1;
		else
			return -1;
	}
}
