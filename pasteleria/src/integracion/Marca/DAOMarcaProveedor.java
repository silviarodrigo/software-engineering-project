package integracion.Marca;

import java.util.Collection;

import negocio.Marca.TMarcaProveedor;

public interface DAOMarcaProveedor {

	public int altaMarcaProveedor(TMarcaProveedor marcaProveedor);
	public boolean bajaMarcaProveedor(String nombreMarca, String nmobreProv);
	public int actualizarMarcaProveedor(TMarcaProveedor marcaProveedor);
	public TMarcaProveedor buscarMarcaProveedor(int id);
	//ESTO HAY QUE PONERLO?? Y POR QUÉ LO BUSCO? ID MARCA O ID PROVEEDOR??
	//public TMarcaProveedor buscarMarca(String nombre); //solo cuando se da de alta
	public Collection<TMarcaProveedor> listarMarcaProveedor();
	
}
