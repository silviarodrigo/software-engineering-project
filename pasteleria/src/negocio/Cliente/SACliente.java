package negocio.Cliente;

import java.util.Collection;

public interface SACliente {
	public int altaCliente(TCliente cl);

	public boolean bajaCliente(int id);

	public int actualizarCliente(TCliente cl);

	public TCliente buscarCliente(int id);

	public Collection<TCliente> listarClientes();
}
