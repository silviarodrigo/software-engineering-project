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
	public String altaMarca(TMarca marca) { ///PARA QUÉ SIRVE NEXT_ID?????????? QUÉ RETURNEO??
		//cargamos los datos de la nueva marca en un JSON
		JSONObject jo = new JSONObject();
		jo.put("Nombre", marca.getNombre());;
		jo.put("Correo", marca.getCorreo());
		
		int next_id = 0;
		try {
			
			//Accedemos a los datos guardados hasta ahora
			InputStream in = new FileInputStream(new File("Marca/resources/Marca.json"));
			JSONObject JO = new JSONObject (new JSONTokener(in));
			
			//Obtenemos los datos del JSON
			JSONArray JA = JO.getJSONArray("Marcas");
			next_id = JO.getInt("next_id"); 
			
			//Insertamos la nueva marca en el array y aumentamos el next_id
			JA.put(jo);
			++next_id;
		
			//Creamos el nuevo JSON con toda la informacion y lo escribimos
			JSONObject JW = new JSONObject();
			JW.put("Marcas", JA);
			JW.put("next_id", next_id);
			BufferedWriter bw = new BufferedWriter(new FileWriter("Marca/resources/Marca.json"));
			bw.write(JW.toString());
			bw.close();
		} 
		catch(Exception e) {
			return null;
		}		
		return marca.getNombre();
	}

	@Override
	public boolean bajaMarca(String nombre) {
		try {
			//Accedemos a los datos guardados
			InputStream in = new FileInputStream(new File("Marca/resources/Marca.json"));
			JSONObject JO = new JSONObject (new JSONTokener(in));
			JSONArray JA = JO.getJSONArray("Marcas");

			//int next_id = JO.getInt("next_id"); ¿¿NECESITO EL NEXT_ID PARA ALGO?? O HACER ALGO CON ÉL??
			
			int i = 0; 
			while (i < JA.length() && !JA.getJSONObject(i).get("Nombre").equals(nombre)) {
				i++;
			}
			if (i == JA.length()) return false; //no lo ha encontrado
			else {
				JA.remove(i);
				
				JSONObject newJO = new JSONObject();
				newJO.put("Marcas", JA);
				newJO.put("next_id", JO.get("next_id")); //TENGO QUE MODIFICAR EL NEXT_ID???
				
				BufferedWriter bw = new BufferedWriter(new FileWriter("Marca/resources/Marca.json"));
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
			InputStream in = new FileInputStream(new File("Marca/resources/Marca.json"));
			JSONObject JO = new JSONObject (new JSONTokener(in));
			JSONArray JA = JO.getJSONArray("Marcas");

			
			int i = 0; String nombre = marca.getNombre();
			while (i < JA.length() && !JA.getJSONObject(i).get("Nombre").equals(nombre)) {
				i++;
			}
			if (i == JA.length()) return false; //no lo ha encontrado
			else {
				JSONObject jo = JA.getJSONObject(i);
				JA.remove(i);
				
				/* ENTIENDO QUE EL NOMBRE ES INMODIFICABLE PQ ES CON LO QUE LO BUSCO??
				jo.remove("Nombre");
				jo.put("Nombre", marca.getNombre());
				*/
				jo.remove("Correo");
				jo.put("Correo", marca.getCorreo());
				
				JA.put(jo);
				
				JSONObject newJO = new JSONObject();
				newJO.put("Marcas", JA);
				newJO.put("next_id", JO.get("next_id"));
				
				BufferedWriter bw = new BufferedWriter(new FileWriter("Marca/resources/Marca.json"));
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
	public TMarca buscarMarca(String nombreMarca) {
		try {

			// Accedemos a los datos guardados hasta ahora
			InputStream in = new FileInputStream(new File("Marca/resources/Marca.json"));
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
				
				String nombre = jo.getString("Nombre"); //.toLowerCase()
				String correo = jo.getString("Correo");
				
				return new TMarca(nombre, correo);
			}
		} 
		catch (Exception e) {
			return null; 
		}
	}

	@Override
	public Collection<TMarca> listarMarca() { //ENTIENDO QUE NO HAY QUE DECIR NADA DEL NEXT_ID??
		Collection<TMarca> lista = new ArrayList<TMarca>();
		
		JSONArray JA = null;
		try {
			InputStream in = new FileInputStream(new File("Marca/resources/Marca.json"));
			JSONObject JO = new JSONObject(new JSONTokener(in));
			JA = JO.getJSONArray("Marcas");
			
		}
		catch (Exception e) {
			return null;
		}

		int i = 0;
		while (i < JA.length()) {
			JSONObject jo = JA.getJSONObject(i);
			lista.add(new TMarca((String)jo.get("Nombre"), (String)jo.get("Correo")));
			i++;
		}
		return lista;
	}
	
}
