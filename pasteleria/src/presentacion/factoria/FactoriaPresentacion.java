package presentacion.factoria;

import presentacion.Evento;
import presentacion.IGUI;
import presentacion.GUIProducto.VistaPrincipalProducto;
import presentacion.GUIProducto.VistaAltaProducto;
import presentacion.MainWindow;



public class FactoriaPresentacion extends FactoriaAbstractaPresentacion {

	public IGUI createVista(Evento id) {
		switch (id) {
		case MAIN_WINDOW:
			return new MainWindow();
		case VISTA_PRINCIPAL_PRODUCTO:
			return new VistaPrincipalProducto();
			
		case ALTA_PRODUCTO:
			return new VistaAltaProducto();
		default:
			return null;
		}
	}

}
