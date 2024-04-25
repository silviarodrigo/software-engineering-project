package negFactura;

public class TLineaFactura {
	private String id_producto;
	private int cantidad;

// CONSTRUCTORA
	// no hay constructora por defecto porque exigimos que la venta tenga datos

	public TLineaFactura(String id_prod, int cant) {
		this.id_producto = id_prod;
		this.cantidad = cant;
	}

//GETTERS
	public String getIdProducto() {
		return this.id_producto;
	}

	public int getCantidadProducto() {
		return this.cantidad;
	}

//SETTERS
	public void setIdProducto(String id_prod) {
		this.id_producto = id_prod;
	}

	public void setCantidadProducto(int cant) {
		this.cantidad = cant;
	}
}
