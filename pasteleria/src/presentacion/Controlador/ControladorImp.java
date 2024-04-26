package presentacion.Controlador;

import presentacion.Evento;
import negocio.Producto.TProducto;
import negocio.Producto.SAProducto;



public class ControladorImp extends Controlador {
	public void accion(Evento evento, Object datos) {
		switch (evento) {
		case ALTA_PRODUCTO:
			//CODIGO COPIADO DE SUS DIAPOSITIVAS
			/*
			TProducto tProducto = (TProducto) datos;
			SAProducto saProd = FactoriaAbstractaNegocio.getInstancia().crearSAProducto();
			int res = saProd.create(tProducto);
			//Según el valor de res, se actualiza la vista de una manera u otra.
			//Si todo OK el aspecto es este (faltaría el else):
			FactoriaAbstractaPresentacion.getInstance().createVista(evento).actualizar(Evento.RES_ALTA_CLIENTE_OK,res);
			
			//mostraría una ventana semipreparada informando
			break;
			*/
		}
	}
}
