package negocio.Facturas;

public class TLineaFactura {
	private String id_producto;
	private int cantidad;
	private String id_factura;
	private int id;
	private boolean activa;

// CONSTRUCTORA
	// no hay constructora por defecto porque exigimos que la venta tenga datos

	public TLineaFactura(String id_prod, String id_fact, int id, int cant) {
		this.id_producto = id_prod;
		this.cantidad = cant;
		this.id_factura = id_fact;
		this.id = id;
		this.activa = true;
	}

//GETTERS
	public String getIdProducto() {
		return this.id_producto;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public String getIdFactura() {
		return this.id_factura;
	}

	public int getId() {
		return this.id;
	}

	public boolean getActivo() {
		return this.activa;
	}

//SETTERS
	public void setIdProducto(String id_prod) {
		this.id_producto = id_prod;
	}

	public void setCantidadProducto(int cant) {
		this.cantidad = cant;
	}

	public void setIdFactura(String id_fact) {
		this.id_factura = id_fact;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setActivo(boolean activo) {
		this.activa = activo;
	}
}
