package negocio.Marca;

import java.util.Collection;

public interface SAMarca {
	public int altaMarca(TMarca marca);
	public boolean bajaMarca(int id);
	public boolean actualizarMarca(TMarca marca);
	public TMarca buscarMarca(int id);
	public Collection<TMarca> listarMarca();
}
