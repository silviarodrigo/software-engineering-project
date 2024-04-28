package integracion.Producto;

import java.util.Collection;
import negocio.Producto.TProducto;

public interface DAOProducto {
	public int altaProducto(TProducto producto);
	public int bajaProducto(String nombre);
	public TProducto buscarProducto(String nombre);
	public int actualizarProducto(TProducto producto);
	public Collection<TProducto> listarProductos();
}