package integracion.Producto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.InputStream;

import java.util.Collection;
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
		JSONObject jProd = new JSONObject();
		String tipo = producto.getTipo();
		String filename;
		jProd.put("nombre", producto.getNombre());
		jProd.put("precio", producto.getPrecio());
		jProd.put("alergenos", producto.getAlergenos());
		jProd.put("stock", producto.getStock());
		jProd.put("tipo", tipo);
		jProd.put("marcaId", producto.getMarca());
		jProd.put("activo", producto.getActivo());
		if (tipo == "Dulce") {
			jProd.put("relleno", ((TDulce)producto).getRelleno());
			filename = "resources/Dulces.json";
		}
		else if (tipo == "Pan") {
			jProd.put("integral", ((TPan)producto).getIntegral());
			jProd.put("sal", ((TPan)producto).getSal());
			filename = "resources/Pan.json";
		}
		else {
			jProd.put("tamaño", ((TBebida)producto).getTamanyo());
			filename = "resources/Bebida.json";
		}
		int next_id;
		JSONArray ja;
		try {
			InputStream in  = new FileInputStream(new File(filename));
			JSONObject jO = new JSONObject(new JSONTokener(in));
			ja = jO.getJSONArray("productos");
			next_id = jO.getInt("next_id");
			jProd.put("id", next_id);
			ja.put(jProd);
			next_id++;
			
		} catch (FileNotFoundException e) {
			JSONObject jO = new JSONObject();
			jProd.put("id", 0);
			ja = new JSONArray();
			ja.put(jProd);
			next_id = 1;	
		}
		
		try {
			BufferedWriter bW = new BufferedWriter(new FileWriter(filename, false));
			JSONObject newJO = new JSONObject();
			newJO.put("productos", ja);
			newJO.put("next_id", next_id);	
			bW.write(newJO.toString());
		} catch (Exception e) {
			return -1;
		}
		
		return next_id-1;
	}

	@Override
	public int bajaProducto(String nombre) {
		// TODO Auto-generated method stub
		return -1;
	}
	
	private int bajaProducto(int id) {
		return -1;
	}

	@Override
	public TProducto buscarProducto(String nombre) {
		JSONArray ja1;
		JSONArray ja2;
		JSONArray ja3;
		try {
			InputStream in  = new FileInputStream(new File("resources/Dulces.json"));
			JSONObject jO = new JSONObject(new JSONTokener(in));
			ja1 = jO.getJSONArray("productos");
			
		} catch (FileNotFoundException e) {
			ja1 = null;	
		}
		try {
			InputStream in  = new FileInputStream(new File("resources/Pan.json"));
			JSONObject jO = new JSONObject(new JSONTokener(in));
			ja2 = jO.getJSONArray("productos");
			
		} catch (FileNotFoundException e) {
			ja2 = null;	
		}
		try {
			InputStream in  = new FileInputStream(new File("resources/Bebida.json"));
			JSONObject jO = new JSONObject(new JSONTokener(in));
			ja3 = jO.getJSONArray("productos");
			
		} catch (FileNotFoundException e) {
			ja3 = null;	
		}
		TProducto prod = searchInJArray(nombre, ja1);
		if (prod == null) {
			prod = searchInJArray(nombre, ja2);
			if (prod == null) {
				prod = searchInJArray(nombre, ja3);
			}
		}
		return prod;
	}
	
	private TProducto searchInJArray(String nombre, JSONArray ja) {
		int i = 0;
		while (i < ja.length() && !(ja.getJSONObject(i).get("nombre") == nombre)) {
			i++;
		}
		if (i == ja.length()) {
			return null;
		}
		return createTProducto(ja.getJSONObject(i));
	}
	
	private TProducto createTProducto(JSONObject jO) {
		String nombre = jO.getString("nombre");
		double precio = jO.getDouble("precio");
		String alergenos = jO.getString("alergenos");
		int stock = jO.getInt("stock");
		String tipo = jO.getString("tipo");
		int marcaId = jO.getInt("marcaId");
		int id = jO.getInt("id");
		boolean activo = jO.getBoolean("activo");
		if (tipo == "Dulce") {
			String relleno = jO.getString("relleno");
			TDulce dulce = new TDulce(nombre, precio, alergenos, stock, marcaId, relleno);
			dulce.setActivo(activo);
			dulce.setId(id);
			return dulce;
		}
		else if (tipo == "Pan" ) {
			boolean sal = jO.getBoolean("sal");
			boolean integral = jO.getBoolean("integral");
			TPan pan = new TPan(nombre, precio, alergenos, stock, marcaId, sal, integral);
			pan.setActivo(activo);
			pan.setId(id);
			return pan;
		}
		else if (tipo == "Bebida"){
			String tamanyo = jO.getString("tamaño");
			TBebida bebida = new TBebida(nombre, precio, alergenos, stock, marcaId, tamanyo);
			bebida.setActivo(activo);
			bebida.setId(id);
			return bebida;
		}
		return null;
	}

	@Override
	public int actualizarProducto(TProducto producto) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public Collection<TProducto> listarProductos() {
		// TODO Auto-generated method stub
		return null;
	}

}
