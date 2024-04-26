package presentacion.Controlador;

import presentacion.Evento;
import presentacion.factoria.FactoriaAbstractaPresentacion;
import negocio.Producto.TProducto;
import negocio.Producto.SAProducto;



public class ControladorImp extends Controlador {
	public void accion(Evento evento, Object datos) {
		switch (evento) {
		case MAIN_WINDOW:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.MAIN_WINDOW);
			break;
		case ALTA_PRODUCTO:
			//CODIGO COPIADO DE SUS DIAPOSITIVAS
			/*
			TProducto tProducto = (TProducto) datos;
			SAProducto saProd = FactoriaAbstractaNegocio.getInstancia().crearSAProducto();
			int res = saProd.create(tProducto);
			//Según el valor de res, se actualiza la vista de una manera u otra.
			//Si todo OK el aspecto es este (faltaría el else):
			FactoriaAbstractaPresentacion.getInstance().createVista(evento).actualizar(Evento.RES_ALTA_CLIENTE_OK,res);
			
			//mostraría una ventana semipreparada informando*/
			break;
		case VISTA_PRINCIPAL_PRODUCTO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_PRINCIPAL_PRODUCTO);
			break;
		case VISTA_ALTA_PRODUCTO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ALTA_PRODUCTO);
			break;
		case VISTA_BAJA_PRODUCTO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BAJA_PRODUCTO);
			break;
		case VISTA_ACTUALIZAR_PRODUCTO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_ACTUALIZAR_PRODUCTO);
			break;
		case VISTA_BUSCAR_PRODUCTO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_BUSCAR_PRODUCTO);
			break;
		case VISTA_LISTAR_PRODUCTO:
			FactoriaAbstractaPresentacion.getInstance().createVista(Evento.VISTA_LISTAR_PRODUCTO);
			break;
		}
	}
}
