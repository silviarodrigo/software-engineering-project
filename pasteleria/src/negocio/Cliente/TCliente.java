package negocio.Cliente;

public class TCliente {
	private String nombre_y_apellidos;
	private int id;
	private String correo;
	
	public TCliente (String nom_y_ap, int id, String correo) {
		this.nombre_y_apellidos = nom_y_ap;
		this.id = id;
		this.correo = correo;
	}
	
	// Getters.
	public String getNombreYApellidos() {
		return this.nombre_y_apellidos;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getCorreo() {
		return this.correo;
	}
	
	// Setters.
	public void setNombreYApellidos(String nom_y_ap) {
		this.nombre_y_apellidos = nom_y_ap;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
