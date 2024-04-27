package negocio.Producto;

public class TPan extends TProducto{

	TPan(String nombre, double precio, String alergenos, int stock, int marcaId) {
		super(nombre, precio, alergenos, stock, "Pan", marcaId);
	}

}
