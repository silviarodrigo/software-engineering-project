package presentacion.factoria;

import presentacion.Evento;
import presentacion.IGUI;
import presentacion.GUIProducto.VistaPrincipalProducto;
import presentacion.GUIProducto.VistaAltaProducto;


public class FactoriaPresentacion extends FactoriaAbstractaPresentacion {

	public IGUI createVista(Evento id) {
		switch (id) {
		case VISTA_PRINCIPAL_PRODUCTO:
			return new VistaPrincipalProducto();
			
		case ALTA_PRODUCTO:
			return new VistaAltaProducto();
		default:
			return null;
		}
	}

}
