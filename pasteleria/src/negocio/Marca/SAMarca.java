package negocio.Marca;

import java.util.Collection;

public interface SAMarca {
	int altaMarca(TMarca marca);
	boolean bajaMarca(int id);
	boolean actualizarMarca(TMarca marca);
	TMarca buscarMarca(int id);
	Collection<TMarca> listarMarca();
}
