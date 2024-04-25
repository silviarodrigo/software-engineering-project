package integracion.Producto;

import java.util.Collection;
import negocio.Producto.TProducto;

public interface DAOProducto {
	public String altaProducto(TProducto producto);
	public boolean bajaProducto(String nombre);
	public TProducto buscarProducto(String nombre);
	public String actualizarProducto(TProducto producto);
	public Collection<TProducto> listarProductos();
}