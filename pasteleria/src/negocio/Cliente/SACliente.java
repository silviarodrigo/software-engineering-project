package negocio.Cliente;

import java.util.Collection;

public interface SACliente {
	public String alta(TCliente cl);
	public String baja(String id);
	public boolean actualizar(TCliente cl);
	public TCliente buscar(int id);
	public Collection<TCliente> listar();
}
