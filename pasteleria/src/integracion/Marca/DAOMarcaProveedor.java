package integracion.Marca;

import java.util.Collection;

import negocio.Marca.TMarcaProveedor;

public interface DAOMarcaProveedor {

	public int altaMarcaProveedor(TMarcaProveedor marcaProveedor);
	public boolean bajaMarcaProveedor(int id);
	public boolean actualizarMarcaProveedor(TMarcaProveedor marcaProveedor);
	public TMarcaProveedor buscarMarcaProveedor(int id);
	public Collection<TMarcaProveedor> listarMarcaProveedor();
	
}
