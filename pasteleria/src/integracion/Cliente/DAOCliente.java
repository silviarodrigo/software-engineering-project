package integracion.Cliente;

import java.util.Collection;


import negocio.Cliente.TCliente;

public interface DAOCliente {

	public int altaCliente(TCliente cliente);

	public boolean bajaCliente(int id);

	public TCliente buscarCliente(int id);
	
	//public TCliente buscarCliente(String dni);

	public int actualizarCliente(TCliente cliente);

	Collection<TCliente> listarClientes();
}