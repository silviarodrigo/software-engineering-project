package negocio.Marca;

import negocio.Proveedor.TProveedor;

public class TMarcaProveedor {

	private int id;
	private TMarca marca;
	private TProveedor proveedor;
	private boolean activo;
	
	private String nombreMarca;
	private String nombreProv;

	
	public TMarcaProveedor(TMarca marca,  TProveedor proveedor){
		this.id = 0;
		this.marca = marca;
		this.proveedor = proveedor;
		this.activo = true;
	}
	
	public TMarcaProveedor(int id, String nombreMarca,  String nombreProv, boolean activo){
		this.id = id;
		this.nombreMarca = nombreMarca;
		this.nombreProv = nombreProv;
		this.activo = activo;
	}
	
	public TMarcaProveedor(int id, TMarca marca,  TProveedor proveedor, boolean activo){
		this.id = id;
		this.marca = marca;
		this.proveedor = proveedor;
		this.activo = activo;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
		
	public TMarca getTMarca() {
		return this.marca;
	}
	
	public void setTMarca(TMarca marca) {
		this.marca = marca;
	}
	
	public TProveedor getTProveedor() {
		return this.proveedor;
	}
	
	public void setTProveedor(TProveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
