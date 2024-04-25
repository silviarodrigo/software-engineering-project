package Negocio;


public class TMarca {
	private String nombre;
	private String correo;
	
	public TMarca(String nombre){
		this.nombre = nombre;
		this.correo = "";
	}
	
	public TMarca(String nombre, String correo){
		this.nombre = nombre;
		this.correo = correo;
	}
		
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}