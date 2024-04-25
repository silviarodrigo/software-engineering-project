package negocio.Producto;

public interface SAProducto {
	public String altaProducto(TProducto producto);
	public boolean bajaProducto(String nombre);
	public TProducto buscarProducto(String nombre);
	public String actualizarProducto(TProducto producto);
	public Collection<TProducto> listarProductos();
}
