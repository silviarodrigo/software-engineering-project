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
import presentacion.GUIFacturas.VistaBuscarFacturas;
import presentacion.GUIFacturas.VistaListarFacturas;
import presentacion.GUIFacturas.VistaModificarFacturas;
import presentacion.GUIFacturas.VistaPrincipalFacturas;
import presentacion.GUIFacturas.VistaAbrirVenta;



public class FactoriaPresentacion extends FactoriaAbstractaPresentacion {

	public IGUI createVista(Evento id) {
		switch (id) {
		case MAIN_WINDOW:
			return new MainWindow();
		//PRODUCTO
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
		//FACTURAS
		case VISTA_PRINCIPAL_FACTURAS:
			return new VistaPrincipalFacturas();
		case VISTA_BUSCAR_FACTURA:
			return new VistaBuscarFacturas();
		case VISTA_MODIFICAR_FACTURAS:
			return new VistaModificarFacturas();
		case VISTA_LISTAR_FACTURAS:
			return new VistaListarFacturas();
		case VISTA_ABRIR_VENTA:
			return new VistaAbrirVenta();
		default:
			return null;
		}
	}

}
