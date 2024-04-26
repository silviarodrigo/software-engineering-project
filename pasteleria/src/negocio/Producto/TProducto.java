package negocio.Producto;

public class TProducto {
	private String nombre;
	private double precio;
	private String alergenos;
	private int stock;
	private String tipo;
	private String marca;
	private int id;
	private boolean activo;
	
	TProducto(String nombre, double precio, String alergenos, int stock,String tipo, String marca ){
		this.nombre= nombre;
		this.precio= precio;
		this.alergenos = alergenos;
		this.stock = stock;
		this.tipo = tipo;
		this.marca= marca;
		this.id = -1;
		this.activo = true;
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
	
	public void setPrecio(double precio) {
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
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
