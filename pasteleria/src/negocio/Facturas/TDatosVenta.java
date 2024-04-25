package negFactura;

import java.util.ArrayList;

public class TDatosVenta {
	private String fecha;
	private String id_cliente;
	private String id_vendedor;
	private ArrayList<TLineaFactura> productos;

//CONSTRUCTORA
	// no hay constructora por defecto porque exigimos que la venta tenga datos

	public TDatosVenta(String f, String id_c, String id_v, ArrayList<TLineaFactura> prod) {
		this.fecha = f;
		this.id_cliente = id_c;
		this.id_vendedor = id_v;
		this.productos = prod;
	}

//GETTERS
	public String getIdCliente() {
		return this.id_cliente;
	}

	public String getIdVendedor() {
		return this.id_vendedor;
	}

	public String getFecha() {
		return this.fecha;
	}

	public ArrayList<TLineaFactura> getProductos() {
		return this.productos;
	}

//SETTERS
	public void setIdCliente(String IdCliente) {
		this.id_cliente = IdCliente;
	}

	public void setIdVendedor(String IdVendedor) {
		this.id_vendedor = IdVendedor;
	}

	public void setFecha(String Fecha) {
		this.fecha = Fecha;
	}

	public void setProductos(ArrayList<TLineaFactura> prods) {
		this.productos = prods;
	}
}
