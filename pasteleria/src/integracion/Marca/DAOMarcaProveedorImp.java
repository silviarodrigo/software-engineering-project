package integracion.Marca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import negocio.Marca.TMarcaProveedor;



//HAY QUE CAMBIARLO TODOOOOOOOOOOOOOOOOOOOOOOOO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
public class DAOMarcaProveedorImp implements DAOMarcaProveedor {

	@Override
	public int altaMarcaProveedor(TMarcaProveedor marcaProveedor) {
		JSONObject JO;
		try {
			//Accedemos a los datos guardados hasta ahora
			InputStream in = new FileInputStream(new File("pasteleria/resources/MarcasProveedor.json"));
			JO = new JSONObject (new JSONTokener(in));
		}
		catch (Exception e){
			return -1;
		}
		
		//Obtenemos los datos del JSON
		JSONArray JA = JO.getJSONArray("ListaMarcasProveedor");
		int next_id = JO.getInt("next_id");
		
		marcaProveedor.setID(next_id);
		
		//cargamos los datos de la nueva marca en un JSON
		JSONObject jo = new JSONObject();
		jo.put("Id", next_id);
		jo.put("IdMarca", marcaProveedor.getIDMarca());
		jo.put("IdProveedor", marcaProveedor.getIDProveedor());
		jo.put("Activo", marcaProveedor.getActivo());
		
		
		//insertamos la nueva marca en el JSON
		JA.put(jo);
		++next_id;
		
		//Creamos el nuevo JSON con toda la informacion y lo escribimos
		JSONObject JW = new JSONObject();
		JW.put("ListaMarcasProveedor", JA);
		JW.put("next_id", next_id);
		
		try {	
			BufferedWriter bw = new BufferedWriter(new FileWriter("pasteleria/resources/MarcasProveedor.json"));
			bw.write(JW.toString());
			bw.close();
		} 
		catch(Exception e) {
			return -1;
		}		
		
		return marcaProveedor.getID();
	}

	@Override
	public boolean bajaMarcaProveedor(int id) {
		try {
			//Accedemos a los datos guardados
			InputStream in = new FileInputStream(new File("pasteleria/resources/MarcasProveedor.json"));
			JSONObject JO = new JSONObject (new JSONTokener(in));
			JSONArray JA = JO.getJSONArray("ListaMarcasProveedor");
			
			int i = 0; 
			while (i < JA.length() && !(JA.getJSONObject(i).getInt("Id") == id)) {
				i++;
			}
			if (i == JA.length()) return false; //no lo ha encontrado
			else {
				JA.getJSONObject(i).put("Activo", false);
								
				JSONObject newJO = new JSONObject();
				newJO.put("ListaMarcasProveedor", JA);
				newJO.put("next_id", JO.get("next_id")); //no se modifica el next_id
				
				BufferedWriter bw = new BufferedWriter(new FileWriter("pasteleria/resources/MarcasProveedor.json"));
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
	public boolean actualizarMarcaProveedor(TMarcaProveedor marcaProveedor) {
		try {
			//Accedemos a los datos guardados
			InputStream in = new FileInputStream(new File("pasteleria/resources/MarcasProveedor.json"));
			JSONObject JO = new JSONObject (new JSONTokener(in));
			JSONArray JA = JO.getJSONArray("ListaMarcasProveedor");

			
			int i = 0; int id = marcaProveedor.getID();
			while (i < JA.length() && !(JA.getJSONObject(i).getInt("Id") == id)) {
				i++;
			}
			if (i == JA.length()) return false; //no lo ha encontrado
			else {
				JSONObject jo = JA.getJSONObject(i);
				JA.remove(i);
				
				//El ID es inmodificable
				jo.remove("IdMarca");
				jo.put("IdMarca", marcaProveedor.getIDMarca());
				jo.remove("IdProveedor");
				jo.put("IdProveedor", marcaProveedor.getIDProveedor());
				jo.remove("Activo");
				jo.put("Activo", marcaProveedor.getActivo());
				
				JA.put(jo);
				
				JSONObject newJO = new JSONObject();
				newJO.put("ListaMarcasProveedor", JA);
				newJO.put("next_id", JO.get("next_id"));
				
				BufferedWriter bw = new BufferedWriter(new FileWriter("pasteleria/resources/MarcasProveedor.json"));
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
	public TMarcaProveedor buscarMarcaProveedor(int id) {
		try {
			// Accedemos a los datos guardados hasta ahora
			InputStream in = new FileInputStream(new File("pasteleria/resources/MarcasProveedor.json"));
			JSONObject JO = new JSONObject(new JSONTokener(in));

			// Obtenemos los datos del JSON
			JSONArray JA = JO.getJSONArray("ListaMarcasProveedor");
			
			int i = 0; 
			while (i < JA.length() && !(JA.getJSONObject(i).getInt("Id") == id)) {
				i++;
			}
			if (i == JA.length()) return null; //no lo ha encontrado
			else {
				JSONObject jo = JA.getJSONObject(i);
				
				int IdMarca = jo.getInt("IdMarca");
				int IdProveedor = jo.getInt("IdProveedor");
				boolean activo = jo.getBoolean("Activo");
				
				return new TMarcaProveedor(id, IdMarca, IdProveedor, activo);
			}
		} 
		catch (Exception e) {
			return null; 
		}
	}

	@Override
	public Collection<TMarcaProveedor> listarMarcaProveedor() {
		Collection<TMarcaProveedor> lista = new ArrayList<TMarcaProveedor>();
		
		JSONArray JA = null;
		try {
			InputStream in = new FileInputStream(new File("pasteleria/resources/TMarcaProveedor.json"));
			JSONObject JO = new JSONObject(new JSONTokener(in));
			JA = JO.getJSONArray("ListaMarcasProveedor");
			
		}
		catch (Exception e) {
			return null;
		}

		int i = 0;
		while (i < JA.length()) {
			JSONObject jo = JA.getJSONObject(i);
			lista.add(new TMarcaProveedor( jo.getInt("Id"), jo.getInt("IdMarca"), jo.getInt("IdProveedor"), jo.getBoolean("Activo")));
			i++;
		}
		return lista;
	}

}
