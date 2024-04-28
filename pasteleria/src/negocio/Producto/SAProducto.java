package negocio.Producto;

import java.util.Collection;

public interface SAProducto {
	public String altaProducto(TProducto producto);
	public boolean bajaProducto(String nombre);
	public TProducto buscarProducto(String nombre);
	public boolean actualizarProducto(TProducto producto);
	public Collection<TProducto> listarProductos();
}
