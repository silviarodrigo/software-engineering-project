package integracion.Proveedor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import negocio.Proveedor.TProveedor;

public class DAOProveedorImp implements DAOProveedor {

	@Override
	public int altaProveedor(TProveedor proveedor) {
		JSONObject jProv = createJSON(proveedor);
		JSONObject jO = getJSONFromFile();
		JSONArray jA;
		int next_id;
		
		//si no tenemos datos preexistentes
		if (jO == null) {
			jO = new JSONObject();
			jA = new JSONArray();
			next_id = 0;
			jProv.put("Id", next_id);
			jA.put(jProv);
		}
		//si sí los tenemos
		else {
			jA = jO.getJSONArray("Proveedores");
		    next_id = jO.getInt("next_id");
		    jProv.put("Id", next_id);
			jA.put(jProv);
		}
		
		jO.put("Proveedores", jA);
		jO.put("next_id", next_id+1);
		
		if (writeJSONObject(jO)) {
			return next_id;
		}
		else {
			return -1;
		}
	}

	@Override
	public void bajaProveedor(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int actualizarProveedor(TProveedor proveedor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TProveedor buscarProveedor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TProveedor buscarProveedor(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TProveedor> listarProveedor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private JSONObject createJSON(TProveedor proveedor) {
		JSONObject jObj = new JSONObject();
		jObj.put("Nombre", proveedor.getNombre());
		jObj.put("Telefono", proveedor.getTelefono());
		jObj.put("Correo", proveedor.getCorreo());
		jObj.put("Codigo postal", proveedor.getCodigoPostal());
		jObj.put("Id", proveedor.getID());
		jObj.put("Activo", proveedor.getActivo());
		return jObj;
	}
	
	private JSONObject getJSONFromFile() {
		JSONObject jO;
		try {
			InputStream in  = new FileInputStream(new File("resources/Proveedor.json"));
			jO = new JSONObject(new JSONTokener(in));
			
		} catch (FileNotFoundException e) {
			jO = null;	
		}
		return jO;
	}
	
	private boolean writeJSONObject(JSONObject JO) {		
		try {
			BufferedWriter bW = new BufferedWriter(new FileWriter("resources/Marca.json"));
			bW.write(JO.toString(3));
			bW.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
