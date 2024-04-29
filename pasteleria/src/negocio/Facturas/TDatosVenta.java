package negocio.Facturas;

import java.util.ArrayList;

public class TDatosVenta {
	private String fecha;
	private int id_cliente;
	private int id_vendedor;
	private ArrayList<TLineaFactura> productos;

//CONSTRUCTORA
	// no hay constructora por defecto porque exigimos que la venta tenga datos

	public TDatosVenta(String f, int id_c, int id_v, ArrayList<TLineaFactura> prod) {
		this.fecha = f;
		this.id_cliente = id_c;
		this.id_vendedor = id_v;
		this.productos = prod;
	}

//GETTERS
	public int getIdCliente() {
		return this.id_cliente;
	}

	public int getIdVendedor() {
		return this.id_vendedor;
	}

	public String getFecha() {
		return this.fecha;
	}

	public ArrayList<TLineaFactura> getProductos() {
		return this.productos;
	}

//SETTERS
	public void setIdCliente(int IdCliente) {
		this.id_cliente = IdCliente;
	}

	public void setIdVendedor(int IdVendedor) {
		this.id_vendedor = IdVendedor;
	}

	public void setFecha(String Fecha) {
		this.fecha = Fecha;
	}

	public void setProductos(ArrayList<TLineaFactura> prods) {
		this.productos = prods;
	}
}
