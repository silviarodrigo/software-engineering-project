package negocio.Producto;

import java.util.Collection;

import negocio.Marca.TMarca;

public class TOAProductosMarca {
	
	private Collection<TProducto> productos;
	private TMarca marca;
	
	public TOAProductosMarca(Collection<TProducto> productos, TMarca marca) {
		this.productos = productos;
		this.marca = marca;
	}
	
	TMarca getMarca() {
		return marca;
	}
	
	void setMarca(TMarca marca) {
		this.marca = marca;
	}
	
	Collection<TProducto> getProductos() {
		return productos;
	}
	
	void setProductos(Collection<TProducto> productos) {
		this.productos = productos;
	}
}
