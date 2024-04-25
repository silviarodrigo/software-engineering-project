package Negocio;

import java.util.Collection;

public interface SAMarca {
	String altaMarca(TMarca marca);
	boolean bajaMarca(String nombre);
	boolean actualizarMarca(TMarca marca);
	TMarca buscarMarca(String nombre);
	Collection<TMarca> listarMarca();
}
