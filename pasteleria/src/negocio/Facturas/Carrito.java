package negocio.Facturas;

import java.util.ArrayList;

public class Carrito {
	private ArrayList<TLineaFactura> lista_productos;

	public Carrito() {
		this.lista_productos = new ArrayList<TLineaFactura>();
	}

	public ArrayList<TLineaFactura> getProductos() {
		return lista_productos;
	}

	public void anadirProducto(TLineaFactura linea) {
		this.lista_productos.add(linea);
	}

	public void eliminarProducto(TLineaFactura linea) {
		this.lista_productos.remove(linea);
	}

	public void cerrarVenta(TDatosVenta dt) {
		dt.setProductos(lista_productos);
	}
}
