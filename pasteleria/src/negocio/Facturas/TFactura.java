package negFactura;

import java.util.ArrayList;

public class TFactura {
	private String id_factura;
	private TDatosVenta datos;
	private double precio_total;
	private boolean activo;

//CONSTRUCTORAS
	public TFactura() {
		
	}

	public TFactura(String id, double total, TDatosVenta datos, boolean Activo) {
		this.id_factura = id;
		this.precio_total = total;
		this.datos = datos;
		this.activo = Activo;
	}
	
//GETTERS	
	public String getIdFactura() {
		return this.id_factura;
	}
	
	public String getIdCliente() {
		return this.datos.getIdCliente();
	}
	
	public String getIdVendedor() {
		return this.datos.getIdVendedor();
	}
	
	public double getPrecio_total() {
		return this.precio_total;
	}
	
	public String getFecha() {
		return this.datos.getFecha();
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	
	public ArrayList<TLineaFactura> getProductos(){
		return this.datos.getProductos();
	}
	
	
//SETTERS
	public void setId(String Id) {
		this.id_factura = Id;
	}
	
	public void setIdCliente(String IdCliente) {
		this.datos.setIdCliente(IdCliente);
	}
	
	public void setIdVendedor(String IdVendedor) {
		this.datos.setIdVendedor(IdVendedor);
	}
	
	public void setPrecio_total(double Precio_total) {
		this.precio_total = Precio_total;
	}
	
	public void setFecha(String Fecha) {
		this.datos.setFecha(Fecha);
	}
	
	public void setActivo(boolean Activo) {
		this.activo = Activo;
	}
	
	public void setProductos(ArrayList<TLineaFactura> prods){
		this.datos.setProductos(prods);
	}
}
