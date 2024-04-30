package negocio.Empleados;

public class TEmpleado {
	private int id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String email;
	private String numTelefono;
	private String direccion;
	private boolean activo;
	private int numVentas;

	//constructora para inicializar
	public TEmpleado(String nombre, String apellidos, String dni, String email, String direccion, String numeroTelefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email =email;
		this.activo = true;
		this.id = 0;
		this.direccion=direccion;
		this.numTelefono=numeroTelefono;
		this.numVentas=0;
	}
	
	
	
	public TEmpleado(String nombre, String apellidos, String dni, String email, boolean activo, int id, String direccion,String numeroTelefono, int ventas) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.activo = activo;
		this.id = id;
		this.direccion=direccion;
		this.numTelefono=numeroTelefono;
		this.numVentas=ventas;
	}
	
	//El transfer TEmpleado solo contará con operaciones getters y setters.

	// Getters.
	public String getNombre() {
		return this.nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public String getDNI() {
		return this.dni;
	}

	public String getCorreo() {
		return this.email;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNumTelefono() {
		return this.numTelefono;
	}
	
	public int getNumVentas() {
		return this.numVentas;
	}

	
	// Setters.
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setId(String dni) {
		this.dni = dni;
	}

	public void setCorreo(String email) {
		this.email = email;
	}
	
	public void setDireccion (String direccion) {
		this.direccion=direccion;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNumTelefono(String numTelefono) {
		this.numTelefono=numTelefono;
	}
	
	public void setNumVentas(int numVentas){
		this.numVentas=numVentas;
	}
}
