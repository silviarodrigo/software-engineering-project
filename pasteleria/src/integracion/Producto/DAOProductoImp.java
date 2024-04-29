package integracion.Producto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.InputStream;

import java.util.Collection;
import java.util.ArrayList;

import negocio.Producto.TProducto;
import negocio.Producto.TDulce;
import negocio.Producto.TPan;
import negocio.Producto.TBebida;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class DAOProductoImp implements DAOProducto {
	
	@Override
	public int altaProducto(TProducto producto) {
		JSONObject jProd = createJSON(producto);
		String filename = getFilename(producto.getTipo());
		int next_id;
		JSONArray ja;
		
		JSONObject jO = getJSONFromFile(filename);
		if (jO != null) {
			ja = jO.getJSONArray("productos");
			next_id = jO.getInt("next_id");
			jProd.put("id", next_id);
			ja.put(jProd);
		}
		else {
			jO = new JSONObject();
			next_id = 0;
			jProd.put("id", next_id);
			ja = new JSONArray();
			ja.put(jProd);
		}
		
		jO.put("productos", ja);
		jO.put("next_id", next_id+1);
		
		if (writeJSONObject(filename, jO)) {
			return next_id;
		}
		else {
			return -1;
		}
		
	}
	
	@Override
	public int actualizarProducto(TProducto producto) {
		JSONObject jProd = createJSON(producto);
		String filename = getFilename(producto.getTipo());
		JSONObject jO = getJSONFromFile(filename);
		
		if (jO != null) {
			JSONArray ja = jO.getJSONArray("productos");
			ja.put(producto.getId(), jProd);
			jO.put("productos", ja);
		}
		
		else {
			return -1;
		}
		
		if (writeJSONObject(filename, jO)) {
			return producto.getId();
		}
		else {
			return -1;
		}
		
	}
	
	@Override
	public void bajaProducto(int id, String tipo) {
		String filename = getFilename(tipo);
		JSONArray ja;
		JSONObject jO = getJSONFromFile(filename);
		
		if (jO != null) {
			ja = jO.getJSONArray("productos");
			JSONObject jProd = ja.getJSONObject(id);
			jProd.put("activo", false);
			ja.put(id, jProd);
			jO.put("productos", ja);
		}
		
		writeJSONObject(filename, jO);
	}

	@Override
	public TProducto buscarProducto(String nombre) {
		JSONArray ja1 = getProductosJArray(getFilename("Dulce"));
		JSONArray ja2 = getProductosJArray(getFilename("Pan"));
		JSONArray ja3 = getProductosJArray(getFilename("Bebida"));
		TProducto prod = searchInJArray(nombre, ja1);
		if (prod == null) {
			prod = searchInJArray(nombre, ja2);
			if (prod == null) {
				prod = searchInJArray(nombre, ja3);
			}
		}
		return prod;
	}
	
	
	@Override
	public Collection<TProducto> listarProductos() {
		Collection<TProducto> listaProductos = new ArrayList<TProducto>();
		String[] tipos = {"Dulce", "Pan", "Bebida"};
		for (String tipo : tipos) {
			String filename = getFilename(tipo);
			JSONArray ja = getProductosJArray(filename);
			if (ja != null) {
				for (int i = 0; i < ja.length(); i++) {
					listaProductos.add(createTProducto(ja.getJSONObject(i)));
				}
			}
		}
		return listaProductos;
	}
	
	private TProducto createTProducto(JSONObject jO) {
		// Crea un transfer de producto a partir del JSONObject correspondiente
		String nombre = jO.getString("nombre");
		double precio = jO.getDouble("precio");
		String alergenos = jO.getString("alergenos");
		int stock = jO.getInt("stock");
		String tipo = jO.getString("tipo");
		int marcaId = jO.getInt("marcaId");
		int id = jO.getInt("id");
		boolean activo = jO.getBoolean("activo");
		// Como tenemos herencia, tenemos que diferenciar las diferentes subclases/tipos
		if (tipo.equals("Dulce")) {
			String relleno = jO.getString("relleno");
			TDulce dulce = new TDulce(nombre, precio, alergenos, stock, marcaId, relleno);
			dulce.setActivo(activo);
			dulce.setId(id);
			return dulce;
		}
		else if (tipo.equals("Pan")) {
			boolean sal = jO.getBoolean("sal");
			boolean integral = jO.getBoolean("integral");
			TPan pan = new TPan(nombre, precio, alergenos, stock, marcaId, sal, integral);
			pan.setActivo(activo);
			pan.setId(id);
			return pan;
		}
		else if (tipo.equals("Bebida")){
			String tamanyo = jO.getString("tamaño");
			TBebida bebida = new TBebida(nombre, precio, alergenos, stock, marcaId, tamanyo);
			bebida.setActivo(activo);
			bebida.setId(id);
			return bebida;
		}
		return null;
	}
	
	
	private TProducto searchInJArray(String nombre, JSONArray ja) {
		// Nos devuelve el TProducto con nombre 'nombre'  en la JSONArray ja
		// Devuelve null si no existe
		if (ja == null) {
			return null;
		}
		int i = 0;
		while (i < ja.length() && !(ja.getJSONObject(i).get("nombre").equals(nombre))) {
			i++;
		}
		if (i == ja.length()) {
			return null;
		}
		return createTProducto(ja.getJSONObject(i));
	}
	
	private JSONObject getJSONFromFile(String filename) {
		// Devuelve el JSONObject del archivo filename
		JSONObject jO;
		try {
			InputStream in  = new FileInputStream(new File(filename));
			jO = new JSONObject(new JSONTokener(in));
			
		} catch (FileNotFoundException e) {
			jO = null;	
		}
		return jO;
	}
	
	
	private JSONArray getProductosJArray(String filename) {
		// Devuelve el JSONArray guardado en el archivo filename
		JSONObject jO = getJSONFromFile(filename); 
		if (jO == null) {
			return null;
		}
		else {
			return jO.getJSONArray("productos");
		}
	}
	
	private JSONObject createJSON(TProducto producto) {
		// Crea un JSONObject a partir de un transfer de producto
		JSONObject jProd = new JSONObject();
		String tipo = producto.getTipo();
		jProd.put("nombre", producto.getNombre());
		jProd.put("precio", producto.getPrecio());
		jProd.put("alergenos", producto.getAlergenos());
		jProd.put("stock", producto.getStock());
		jProd.put("tipo", tipo);
		jProd.put("marcaId", producto.getMarca());
		jProd.put("activo", producto.getActivo());
		// Tenemos en cuenta las subclases dadas por la herencia
		if (tipo.equals("Dulce")) {
			jProd.put("relleno", ((TDulce)producto).getRelleno());
		}
		else if (tipo.equals("Pan")) {
			jProd.put("integral", ((TPan)producto).getIntegral());
			jProd.put("sal", ((TPan)producto).getSal());
		}
		else {
			jProd.put("tamaño", ((TBebida)producto).getTamanyo());
		}
		jProd.put("id", producto.getId());
		return jProd;
	}
	
	private boolean writeJSONObject(String filename, JSONObject jO) {
		// Escribe el JSONObject jO al archivo filename
		try {
			BufferedWriter bW = new BufferedWriter(new FileWriter(filename, false));
			bW.write(jO.toString(3));
			bW.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private String getFilename(String tipo) {
		// Nos da el nombre del archivo correspondiente a cada tipo
		String filename;
		if (tipo.equals("Dulce")) {
			filename = "resources/Dulces.json";
		}
		else if (tipo.equals("Pan")) {
			filename = "resources/Pan.json";
		}
		else {
			filename = "resources/Bebida.json";
		}
		return filename;
	}

}
