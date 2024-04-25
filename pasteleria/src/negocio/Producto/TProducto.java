package negocio.Producto;

public class TProducto {
	private String nombre;
	private double precio;
	private String alergenos;
	private int stock;
	private String tipo;
	private String marca;
	
	TProducto(String nombre, double precio, String alergenos, int stock,String tipo, String marca ){
		this.nombre= nombre;
		this.precio= precio;
		this.alergenos = alergenos;
		this.stock = stock;
		this.tipo = tipo;
		this.marca= marca;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public void setNombre(double precio) {
		this.precio= precio;
	}
	
	public String getAlergenos() {
		return this.alergenos;
	}
	
	public void setAlergenos(String alergenos) {
		this.alergenos = alergenos;
	}
	
	public int getStock() {
		return this.stock ;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public void setMarca(String marca) {
		this.marca= marca;
	}
}
