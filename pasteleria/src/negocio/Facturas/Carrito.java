package negFactura;

import java.util.ArrayList;

public class Carrito {
	private ArrayList<TLineaFactura> lista_productos;
	private int last_id;

	public Carrito() {
		this.lista_productos=new ArrayList<TLineaFactura>();
		last_id = -1;
	}

	public ArrayList<TLineaFactura> getProductos() {
		return lista_productos;
	}
	
	public void anadirProducto(TLineaFactura linea) {
		this.lista_productos.add(linea);
		last_id++;
	}

	public void eliminarProducot(TLineaFactura linea) {
		this.lista_productos.remove(linea);
		last_id--;
	}
	
	public void cerrarVenta(TDatosVenta dt){
		dt.setProductos(lista_productos);
	}
}
