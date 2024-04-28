package negocio.Producto;

import java.util.Collection;

import integracion.Factoria.FactoriaAbstractaIntegracion;
import integracion.Producto.DAOProducto;


public class SAProductoImp implements SAProducto {

	@Override
	public int altaProducto(TProducto producto) {
		int id = -1;
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		TProducto prod = daoProducto.buscarProducto(producto.getNombre());
		if(prod == null) {
			id = daoProducto.altaProducto(producto);
		}
		else if (!prod.getActivo()) {
			producto.setId(prod.getId());
			producto.setActivo(true);
			id = daoProducto.actualizarProducto(producto);
		}
		return id;
	}

	@Override
	public int bajaProducto(String nombre) {
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		TProducto prod = daoProducto.buscarProducto(nombre);
		if (prod == null) {
			return -1;
		}
		return daoProducto.bajaProducto(prod.getId(), prod.getTipo());
	}

	@Override
	public TProducto buscarProducto(String nombre) {
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		return daoProducto.buscarProducto(nombre);
	}

	@Override
	public int actualizarProducto(TProducto producto) {
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		return daoProducto.actualizarProducto(producto);
	}

	@Override
	public Collection<TProducto> listarProductos() {
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		return daoProducto.listarProductos();
	}

}
