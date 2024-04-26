package integracion.Marca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;

import org.json.*;
import negocio.Marca.TMarca;


//Integracion inserta el cliente cogiendo sus datos del JSON/base de datos y lo devuelve

public class DAOMarcaImp implements DAOMarca {

	@Override
	public int altaMarca(TMarca marca) {
		JSONObject JO;
		try {
			//Accedemos a los datos guardados hasta ahora
			InputStream in = new FileInputStream(new File("pasteleria/resources/Marca.json"));
			JO = new JSONObject (new JSONTokener(in));
		}
		catch (Exception e){
			return -1;
		}
		
		//Obtenemos los datos del JSON
		JSONArray JA = JO.getJSONArray("Marcas");
		int next_id = JO.getInt("next_id");
		
		marca.setID(next_id);
		
		//cargamos los datos de la nueva marca en un JSON
		JSONObject jo = new JSONObject();
		jo.put("Id", next_id);
		jo.put("Nombre", marca.getNombre());
		jo.put("Correo", marca.getCorreo());
		jo.put("Activo", marca.getActivo());
		
		//insertamos la nueva marca en el JSON
		JA.put(jo);
		++next_id;
		
		//Creamos el nuevo JSON con toda la informacion y lo escribimos
		JSONObject JW = new JSONObject();
		JW.put("Marcas", JA);
		JW.put("next_id", next_id);
		
		try {	
			BufferedWriter bw = new BufferedWriter(new FileWriter("pasteleria/resources/Marca.json"));
			bw.write(JW.toString());
			bw.close();
		} 
		catch(Exception e) {
			return -1;
		}		
		
		return marca.getID();
	}

	@Override
	public boolean bajaMarca(int id) {
		try {
			//Accedemos a los datos guardados
			InputStream in = new FileInputStream(new File("pasteleria/resources/Marca.json"));
			JSONObject JO = new JSONObject (new JSONTokener(in));
			JSONArray JA = JO.getJSONArray("Marcas");
			
			int i = 0; 
			while (i < JA.length() && !(JA.getJSONObject(i).getInt("Id") == id)) {
				i++;
			}
			if (i == JA.length()) return false; //no lo ha encontrado
			else {
				JA.getJSONObject(i).put("Activo", false);
								
				JSONObject newJO = new JSONObject();
				newJO.put("Marcas", JA);
				newJO.put("next_id", JO.get("next_id")); //no se modifica el next_id
				
				BufferedWriter bw = new BufferedWriter(new FileWriter("pasteleria/resources/Marca.json"));
				bw.write(newJO.toString());
				bw.close();
			}
		} 
		catch(Exception e) {
			return false;
		}		
		return true;
	}
		

	@Override
	public boolean actualizarMarca(TMarca marca) {
		try {
			//Accedemos a los datos guardados
			InputStream in = new FileInputStream(new File("pasteleria/resources/Marca.json"));
			JSONObject JO = new JSONObject (new JSONTokener(in));
			JSONArray JA = JO.getJSONArray("Marcas");

			
			int i = 0; int id = marca.getID();
			while (i < JA.length() && !(JA.getJSONObject(i).getInt("Id") == id)) {
				i++;
			}
			if (i == JA.length()) return false; //no lo ha encontrado
			else {
				JSONObject jo = JA.getJSONObject(i);
				JA.remove(i);
				
				//El ID es inmodificable
				jo.remove("Nombre");
				jo.put("Nombre", marca.getNombre());
				jo.remove("Correo");
				jo.put("Correo", marca.getCorreo());
				jo.remove("Activo");
				jo.put("Activo", marca.getActivo());
				
				JA.put(jo);
				
				JSONObject newJO = new JSONObject();
				newJO.put("Marcas", JA);
				newJO.put("next_id", JO.get("next_id"));
				
				BufferedWriter bw = new BufferedWriter(new FileWriter("pasteleria/resources/Marca.json"));
				bw.write(newJO.toString());
				bw.close();
			}
		} 
		catch(Exception e) {
			return false;
		}		
		return true;
	}

	@Override
	public TMarca buscarMarca(int id) {
		try {
			// Accedemos a los datos guardados hasta ahora
			InputStream in = new FileInputStream(new File("pasteleria/resources/Marca.json"));
			JSONObject JO = new JSONObject(new JSONTokener(in));

			// Obtenemos los datos del JSON
			JSONArray JA = JO.getJSONArray("Marcas");
			
			int i = 0; 
			while (i < JA.length() && !(JA.getJSONObject(i).getInt("Id") == id)) {
				i++;
			}
			if (i == JA.length()) return null; //no lo ha encontrado
			else {
				JSONObject jo = JA.getJSONObject(i);
				
				String nombre = jo.getString("Nombre");
				String correo = jo.getString("Correo");
				boolean activo = jo.getBoolean("Activo");
				
				return new TMarca(id, nombre, correo, activo);
			}
		} 
		catch (Exception e) {
			return null; 
		}
	}
	
	/*
	@Override
	public TMarca buscarMarca(String nombreMarca) {
		try {
			// Accedemos a los datos guardados hasta ahora
			InputStream in = new FileInputStream(new File("pasteleria/resources/Marca.json"));
			JSONObject JO = new JSONObject(new JSONTokener(in));

			// Obtenemos los datos del JSON
			JSONArray JA = JO.getJSONArray("Marcas");
			
			int i = 0; 
			while (i < JA.length() && !JA.getJSONObject(i).get("Nombre").equals(nombreMarca)) {
				i++;
			}
			if (i == JA.length()) return null; //no lo ha encontrado
			else {
				JSONObject jo = JA.getJSONObject(i);
				
				int id = jo.getInt("Id");
				String correo = jo.getString("Correo");
				boolean activo = jo.getBoolean("Activo");
				
				return new TMarca(id, nombreMarca, correo, activo);
			}
		} 
		catch (Exception e) {
			return null; 
		}
	}
	*/

	@Override
	public Collection<TMarca> listarMarca() { 
		Collection<TMarca> lista = new ArrayList<TMarca>();
		
		JSONArray JA = null;
		try {
			InputStream in = new FileInputStream(new File("pasteleria/resources/Marca.json"));
			JSONObject JO = new JSONObject(new JSONTokener(in));
			JA = JO.getJSONArray("Marcas");
			
		}
		catch (Exception e) {
			return null;
		}

		int i = 0;
		while (i < JA.length()) {
			JSONObject jo = JA.getJSONObject(i);
			lista.add(new TMarca( jo.getInt("Id"), jo.getString("Nombre"), jo.getString("Correo"), jo.getBoolean("Activo")));
			i++;
		}
		return lista;
	}
	
}
