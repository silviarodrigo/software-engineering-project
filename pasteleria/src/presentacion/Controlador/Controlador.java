package presentacion.Controlador;
import presentacion.Evento;

public abstract class Controlador {
	// Hace uso del patron singleton
	private static Controlador instancia = null;
	
	public static Controlador getInstance() {
		if(instancia == null) {
			instancia = new ControladorImp();
		}
		return instancia;
	}
	
	public abstract void accion(Evento e, Object datos);
	
	
	
}