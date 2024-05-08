package negocio.Facturas;

public class TFactura {
	private TDatosVenta datos;
	private double precio_total;
	private boolean activo;
	private int id_factura;

	public TFactura(int id, double total, TDatosVenta datos, boolean Activo) {
		this.id_factura = id;
		this.precio_total = total;
		this.datos = datos;
		this.activo = Activo;
	}

//GETTERS	
	public int getIdFactura() {
		return this.id_factura;
	}

	public TDatosVenta getDatosVentas() {
		return this.datos;
	}

	public double getPrecio_total() {
		return this.precio_total;
	}

	public boolean getActivo() {
		return this.activo;
	}

//SETTERS
	public void setIdFactura(int Id) {
		this.id_factura = Id;
	}

	public void setDatosVentas(TDatosVenta datos) {
		this.datos = datos;
	}

	public void setPrecio_total(double Precio_total) {
		this.precio_total = Precio_total;
	}

	public void setActivo(boolean Activo) {
		this.activo = Activo;
	}

}
