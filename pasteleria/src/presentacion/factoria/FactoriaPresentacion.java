package presentacion.factoria;

import presentacion.Evento;
import presentacion.IGUI;
import presentacion.GUIProducto.VistaPrincipalProducto;
import presentacion.GUIProducto.VistaActualizarProducto;
import presentacion.GUIProducto.VistaAltaProducto;
import presentacion.GUIProducto.VistaBajaProducto;
import presentacion.GUIProducto.VistaBuscarProducto;
import presentacion.GUIProducto.VistaListarProducto;
import presentacion.MainWindow;



public class FactoriaPresentacion extends FactoriaAbstractaPresentacion {

	public IGUI createVista(Evento id) {
		switch (id) {
		case MAIN_WINDOW:
			return new MainWindow();
		case VISTA_PRINCIPAL_PRODUCTO:
			return new VistaPrincipalProducto();
		case VISTA_ALTA_PRODUCTO:
			return new VistaAltaProducto();
		case VISTA_BAJA_PRODUCTO:
			return new VistaBajaProducto();
		case VISTA_ACTUALIZAR_PRODUCTO:
			return new VistaActualizarProducto();
		case VISTA_BUSCAR_PRODUCTO:
			return new VistaBuscarProducto();
		case VISTA_LISTAR_PRODUCTO:
			return new VistaListarProducto();
		default:
			return null;
		}
	}

}
