package integracion.Marca;

import java.util.Collection;

import negocio.Marca.TMarca;

public interface DAOMarca {
	public String altaMarca(TMarca marca);
	public boolean bajaMarca(String nombre);
	public boolean actualizarMarca(TMarca marca);
	public TMarca buscarMarca(String nombre);
	public Collection<TMarca> listarMarca();
}
