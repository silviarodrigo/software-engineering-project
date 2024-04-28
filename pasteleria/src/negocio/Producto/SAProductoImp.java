package negocio.Producto;

import java.util.Collection;

import integracion.Factoria.FactoriaAbstractaIntegracion;
import integracion.Producto.DAOProducto;


public class SAProductoImp implements SAProducto {

	@Override
	public String altaProducto(TProducto producto) {
		String nombre = "";
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		if(daoProducto.buscarProducto(producto.getNombre())==null) {
			nombre = daoProducto.altaProducto(producto);
		}
		return nombre;
	}

	@Override
	public boolean bajaProducto(String nombre) {
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		return daoProducto.bajaProducto(nombre);
	}

	@Override
	public TProducto buscarProducto(String nombre) {
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		return daoProducto.buscarProducto(nombre);
	}

	@Override
	public boolean actualizarProducto(TProducto producto) {
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		if(daoProducto.actualizarProducto(producto)) {
			return true;
		}else return false;
	}

	@Override
	public Collection<TProducto> listarProductos() {
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		return daoProducto.listarProductos();
	}

}
