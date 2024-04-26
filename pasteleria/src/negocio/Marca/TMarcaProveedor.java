package negocio.Marca;

public class TMarcaProveedor {

	private int id;
	private int idMarca;
	private int idProveedor;
	private boolean activo;
	
	
	public TMarcaProveedor(int idMarca,  int idProveedor){
		this.id = 0;
		this.idMarca = idMarca;
		this.idProveedor = idProveedor;
		this.activo = true;
	}
	
	public TMarcaProveedor(int id, int idMarca,  int idProveedor, boolean activo){
		this.id = id;
		this.idMarca = idMarca;
		this.idProveedor = idProveedor;
		this.activo = activo;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
		
	public int getIDMarca() {
		return this.idMarca;
	}
	
	public void setIDMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	
	public int getIDProveedor() {
		return this.idProveedor;
	}
	
	public void setIDProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
