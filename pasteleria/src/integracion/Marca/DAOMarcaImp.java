package integracion.Marca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;

import org.json.*;
import negocio.Marca.TMarca;
import negocio.Producto.TBebida;
import negocio.Producto.TDulce;
import negocio.Producto.TPan;
import negocio.Producto.TProducto;


//Integracion inserta el cliente cogiendo sus datos del JSON/base de datos y lo devuelve

public class DAOMarcaImp implements DAOMarca {
	
	@Override
	public int altaMarca(TMarca marca) {
		//comprobamos que la marca no está ya insertada
		if (buscarMarca(marca.getNombre()).equals(marca)) {
			return -1;
		}
				
		//cargamos los datos de la nueva marca en un JSON
		JSONObject jo = createJSON(marca);
		
		//obtenemos el JSON con toda la info 
		JSONObject JO = getJSONFromFile();
		
		JSONArray JA; int next_id = 0;
		if (JO == null) {
			JO = new JSONObject();
			JA = new JSONArray();
			JA.put(jo);
		}
		else {
			//Obtenemos los datos del JSON
			JA = JO.getJSONArray("Marcas");
		    next_id = JO.getInt("next_id");
		    
		    
		    jo.put("Id", next_id);
			JA.put(jo);
		}
		
		//insertamos la nueva marca en el JSON
		JO.put("Marcas", JA);
		JO.put("next_id", next_id+1);
		
		
		marca.setID(next_id);
		
		
		//Escribimos el nuevo JSON con toda la informacion
		if (writeJSONObject(JO)) {
			return next_id;
		}
		else {
			return -1;
		}
	}

	
	@Override
	public boolean bajaMarca(int id) {
		//Accedemos a los datos guardados
		JSONObject JO = getJSONFromFile();
		JSONArray JA;
		
		if (JO == null) {
			return false; 
		}
		else {
			JA = JO.getJSONArray("Marcas");
			JSONObject jo;
			
			try {
				jo = JA.getJSONObject(id);
			}
			catch (JSONException e) {
				return false;
			}
			
			jo.put("Activo", false);
			JA.put(id, jo);
			JO.put("Marcas", JA);
		}
		
		return writeJSONObject(JO);
	}
		

	@Override
	public boolean actualizarMarca(TMarca marca) {
		//cargamos los datos de la nueva marca en un JSON
		JSONObject jo = createJSON(marca);
		
		//Accedemos a los datos guardados
		JSONObject JO = getJSONFromFile();
		
		if (JO == null) {
			return false; 
		}
		else {
			JSONArray JA = JO.getJSONArray("Marcas");
			JA.put(marca.getID(), jo); //ESTO PUEDE DAR ERROR??
			JO.put("Marcas", JA);
		}
				
		return writeJSONObject(JO);
	}
		

	
	@Override
	public TMarca buscarMarca(int id) {
		//Accedemos a los datos guardados
		JSONObject JO = getJSONFromFile();
		
		if (JO == null) {
			return null; 
		}
		else {
			// Obtenemos los datos del JSON
			JSONArray JA = JO.getJSONArray("Marcas");

			JSONObject jo;
			try {
				jo = JA.getJSONObject(id);
			}
			catch (JSONException e) {
				return null;
			}
		
			String nombre = jo.getString("Nombre");
			String correo = jo.getString("Correo");
			boolean activo = jo.getBoolean("Activo");
			
			return new TMarca(id, nombre, correo, activo);
		}
	}
	
	
	@Override
	public TMarca buscarMarca(String nombre) {
		//Accedemos a los datos guardados
		JSONObject JO = getJSONFromFile();
		
		if (JO == null) {
			return null; 
		}
		else {
			// Obtenemos los datos del JSON
			JSONArray JA = JO.getJSONArray("Marcas");
			
			int i = 0; 
			while (i < JA.length() && !JA.getJSONObject(i).get("Nombre").equals(nombre)) {
				i++;
			}
			
			if (i == JA.length()) return null; //no lo ha encontrado
			else {
				JSONObject jo = JA.getJSONObject(i);
				
				int id = jo.getInt("Id");
				String correo = jo.getString("Correo");
				boolean activo = jo.getBoolean("Activo");
				
				return new TMarca(id, nombre, correo, activo);				
			}		
		}
	}


	@Override
	public Collection<TMarca> listarMarca() { 
		Collection<TMarca> lista = new ArrayList<TMarca>();
		
		//Accedemos a los datos guardados
		JSONObject JO = getJSONFromFile();
		
		if (JO != null) {
			// Obtenemos los datos del JSON
			JSONArray JA = JO.getJSONArray("Marcas");
			
			for (int i = 0; i < JA.length(); i++) {
				JSONObject jo = JA.getJSONObject(i);
				lista.add(new TMarca(i , jo.getString("Nombre"), jo.getString("Correo"), jo.getBoolean("Activo")));
			}
		}
		return lista;
	}
	
	
	private JSONObject getJSONFromFile() {
		JSONObject JO;
		try {
			InputStream in  = new FileInputStream(new File("pasteleria/resources/Marca.json"));
			JO = new JSONObject(new JSONTokener(in));
			
		} catch (FileNotFoundException e) {
			JO = null;	
		}
		return JO;
	}
	
	private JSONObject createJSON(TMarca marca) {
		JSONObject jo = new JSONObject();
		jo.put("Id", marca.getID());
		jo.put("Nombre", marca.getNombre());
		jo.put("Correo", marca.getCorreo());
		jo.put("Activo", marca.getActivo());
		return jo;
	}
	
	private boolean writeJSONObject(JSONObject JO) {		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("pasteleria/resources/Marca.json"));
			bw.write(JO.toString(3));
			bw.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
