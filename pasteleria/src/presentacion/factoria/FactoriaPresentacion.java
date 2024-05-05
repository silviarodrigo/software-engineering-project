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
import presentacion.GUICliente.VistaActualizarCliente;
import presentacion.GUICliente.VistaAltaCliente;
import presentacion.GUICliente.VistaBajaCliente;
import presentacion.GUICliente.VistaBuscarCliente;
import presentacion.GUICliente.VistaListarClientes;
import presentacion.GUICliente.VistaPrincipalCliente;
import presentacion.GUIFacturas.VistaBuscarFacturas;
import presentacion.GUIFacturas.VistaCerrarVenta;
import presentacion.GUIFacturas.VistaEliminarProducto;
import presentacion.GUIFacturas.VistaListarFacturas;
//import presentacion.GUIFacturas.VistaListarFacturasConCliente;
import presentacion.GUIFacturas.VistaListarFacturasPorCliente;
import presentacion.GUIFacturas.VistaModificarFacturas;
import presentacion.GUIFacturas.VistaPrincipalFacturas;
import presentacion.GUIFacturas.VistaAnadirProducto;
import presentacion.GUIMarca.VistaPrincipalMarca;
import presentacion.GUIMarca.VistaAltaMarca;
import presentacion.GUIMarca.VistaBajaMarca;
import presentacion.GUIMarca.VistaActualizarMarca;
import presentacion.GUIMarca.VistaBuscarMarca;
import presentacion.GUIMarca.VistaListarMarca;
import presentacion.GUIEmpleados.*;

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
		case VISTA_MODIFICAR_FACTURA:
			return new VistaModificarFacturas();
		case VISTA_LISTAR_FACTURAS:
			return new VistaListarFacturas();
		case VISTA_ANADIR_PRODUCTO:
			return new VistaAnadirProducto();
		case VISTA_ELIMINAR_PRODUCTO:
			return new VistaEliminarProducto();
		case VISTA_CERRAR_VENTA:
			return new VistaCerrarVenta();
			//EXTRA
		case VISTA_LISTAR_FACTURAS_POR_CLIENTE:
			return new VistaListarFacturasPorCliente();
		//case VISTA_LISTAR_FACTURAS_CON_CLIENTE:
		//	return new VistaListarFacturasConCliente();
			
		//MARCA
		case VISTA_PRINCIPAL_MARCA:
			return new VistaPrincipalMarca();
		case VISTA_ALTA_MARCA:
			return new VistaAltaMarca();
		case VISTA_BAJA_MARCA:
			return new VistaBajaMarca();
		case VISTA_ACTUALIZAR_MARCA:
			return new VistaActualizarMarca();
		case VISTA_BUSCAR_MARCA:
			return new VistaBuscarMarca();
		case VISTA_LISTAR_MARCAS:
			return new VistaListarMarca();
			
		// CLIENTE
		case VISTA_PRINCIPAL_CLIENTE:
			return new VistaPrincipalCliente();
		case VISTA_ALTA_CLIENTE:
			return new VistaAltaCliente();
		case VISTA_BAJA_CLIENTE:
			return new VistaBajaCliente();
		case VISTA_ACTUALIZAR_CLIENTE:
			return new VistaActualizarCliente();
		case VISTA_BUSCAR_CLIENTE:
			return new VistaBuscarCliente();
		case VISTA_LISTAR_CLIENTES:
			return new VistaListarClientes();
			
		//EMPLEADOS
		case VISTA_PRINCIPAL_EMPLEADOS:
			return new VistaPrincipalEmpleados();
		case VISTA_ALTA_EMPLEADO:
			return new VistaAltaEmpleados();
		case VISTA_BAJA_EMPLEADO:
			return new VistaBajaEmpleados();
		case VISTA_ACTUALIZAR_EMPLEADO:
			return new VistaActualizarEmpleados();
		case VISTA_BUSCAR_EMPLEADO:
			return new VistaBuscarEmpleado();
		case VISTA_LISTAR_EMPLEADOS:
			return new VistaListarEmpleados();
		
		default:
			return null;
		}
	}

}
