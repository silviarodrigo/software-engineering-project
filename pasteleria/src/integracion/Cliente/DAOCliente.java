package integracion.Cliente;

import java.util.Collection;

import negocio.Cliente.TCliente;

public interface DAOCliente {

	public String insertarCliente(TCliente cliente);

	public boolean bajaCliente(int id);

	public TCliente buscarCliente(int id);

	public boolean actualizarCliente(TCliente cliente);

	Collection<TCliente> listarClientes();
}