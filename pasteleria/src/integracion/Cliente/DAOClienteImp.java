package integracion.Cliente;

import java.util.Collection;
import org.json.*;
import java.io.*;

import negocio.Cliente.TCliente;

public class DAOClienteImp implements DAOCliente {

	@Override
	public String insertarCliente(TCliente cliente) {
		String nom_y_ap = cliente.getNombreYApellidos();
		String correo = cliente.getCorreo();
		int dni = cliente.getId();
		
		JSONObject jo = new JSONObject();
		
		
	}

	@Override
	public boolean bajaCliente(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TCliente buscarCliente(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizarCliente(TCliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<TCliente> listarClientes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	JSONObject loadData() throws Exception {
		try {
			// Obtenemos los clientes del fichero JSON.
			InputStream is = new FileInputStream(new File("Cliente/resources/Cliente.json"));
			JSONObject jo = new JSONObject(new JSONTokener(is));
			JSONArray ja = jo.getJSONArray("Clientes");
			
		}
		catch(Exception e) {
			throw new IOException(e.getMessage());
		}
		
		
	}

}
