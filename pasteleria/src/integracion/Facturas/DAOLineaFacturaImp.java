package integracion.Facturas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import integracion.Factoria.FactoriaAbstractaIntegracion;
import negocio.Facturas.TDatosVenta;
import negocio.Facturas.TFactura;
import negocio.Facturas.TLineaFactura;

public class DAOLineaFacturaImp implements DAOLineaFactura {
	private String filename = "resources/LineasFactura.json";
//	public boolean modificarLineaFactura(TLineaFactura lf) {
//		boolean exito = true;
//		try {
//			// Accedemos al json
//			BufferedReader brlf = new BufferedReader(new FileReader("LineasFacturas.json"));
//			JSONObject ji = new JSONObject(new JSONTokener(brlf));
//			JSONArray ja = new JSONArray();
//			ja = ji.getJSONArray("ListaLineasFactura");
//			int next_id = ji.getInt("next_id");
//			// buscamos la linea
//			int i = 0;
//			while (i < ja.length() && ja.getJSONObject(i).getInt("id_linea") != lf.getIdLinea()) {
//				i++;
//			}
//
//			BufferedWriter bw = new BufferedWriter(new FileWriter("LineasFacturas.json"));
//			if (i < ja.length()) {
//				ja.remove(i);
//				// Creamos el json de la nueva linea factura
//				JSONObject jo = new JSONObject();
//				jo.put("id_linea", lf.getIdLinea());
//				jo.put("id_factura", lf.getIdFactura());
//				jo.put("id_producto", lf.getIdProducto());
//				jo.put("cantidad", lf.getCantidad());
//				if (lf.getActivo()) {
//					jo.put("activa", "true");
//				} else {
//					jo.put("activa", "false");
//				}
//				ja.put(jo);// lo añadimos a nuestra lista de lineas de facturas
//
//				// Escribimos el fichero otra vez con los datos actualizados
//				JSONObject jo2 = new JSONObject();
//				jo2.put("ListaLineasFactura", ja);
//				jo2.put("next_id", next_id);
//				bw.write(jo2.toString());
//			}
//			if (bw != null) {// cerramos el fichero siempre
//				bw.close();
//			}
//		} catch (IOException | JSONException e) {
//			exito = false;
//		}
//		return exito;
//	}

	public TLineaFactura buscarLineaFactura(int id) {
		JSONArray ja = getLineasFacturasJArray("ListaLineasFacturas");
		int i = searchInJArray(id, ja);

		if (i != -1)
			return new TLineaFactura(ja.getJSONObject(i).getInt("id_producto"),
					ja.getJSONObject(i).getInt("id_factura"), ja.getJSONObject(i).getInt("id_linea"),
					ja.getJSONObject(i).getInt("cantidad"));
		else
			return null;
	}

	public int crearLineaFactura(TLineaFactura lf) {
		boolean exito = true;
		try {
			JSONObject ji = getJSONFromFile(filename);
			JSONArray ja = ji.getJSONArray("ListaLineasFacturas");
			int next_id = ji.getInt("next_id");

			lf.setIdLinea(next_id);
			next_id++;// lo dejamos preparado para la siguiente factura

			// Creamos el json de la nueva linea factura
			JSONObject jo = new JSONObject();
			jo.put("id_linea", lf.getIdLinea());
			jo.put("id_factura", lf.getIdFactura());
			jo.put("id_producto", lf.getIdProducto());
			jo.put("cantidad", lf.getCantidad());
			if (lf.getActivo()) {
				jo.put("activa", "true");
			} else {
				jo.put("activa", "false");
			}
			ja.put(jo);// lo añadimos a nuestra lista de lineas de facturas

			// Escribimos el fichero otra vez con los datos actualizados
			writeJSONObject(filename, ja, next_id);

		} catch (JSONException e) {
			exito = false;
		}
		if (exito) {
			return lf.getIdLinea();
		} else
			return -1;
	}

	public void eliminarLineaFactura(TLineaFactura lf) {
		JSONObject ji = getJSONFromFile(filename);
		JSONArray ja = ji.getJSONArray("ListaLineasFacturas");
		int next_id = ji.getInt("next_id");
		int i = searchInJArray(lf.getIdLinea(), ja);

		if (i != -1) {
			lf.setActivo(false);

			ja.getJSONObject(i).remove("activo");
			ja.getJSONObject(i).put("activo", "false");

			// Escribimos el fichero otra vez con los datos actualizados
			writeJSONObject(filename, ja, next_id);
		}
	}

	public Collection<TLineaFactura> mostrarLineasFactura() {
		ArrayList<TLineaFactura> lineas_factura = new ArrayList<TLineaFactura>();

		// Accedemos al json
		JSONArray ja =  getLineasFacturasJArray(filename);

		for (int i = 0; i < ja.length(); i++) {
			lineas_factura.add(new TLineaFactura(ja.getJSONObject(i).getInt("id_producto"),
					ja.getJSONObject(i).getInt("id_factura"), ja.getJSONObject(i).getInt("id_linea"),
					ja.getJSONObject(i).getInt("cantidad")));
		}
		return lineas_factura;

	}

// FUNCIONES AUXILIARES
	private int searchInJArray(int id_l, JSONArray ja) {
		// devuele la posicion de la factura en el array, o -1 si no existe
		if (ja == null) {
			return -1;
		}
		int i = 0;
		while (i < ja.length() && ja.getJSONObject(i).getInt("id_linea") != id_l) {
			i++;
		}
		if (i == ja.length()) {
			return -1;
		}
		return i;
	}

	private JSONObject getJSONFromFile(String filename) {
		// Devuelve el JSONObject del archivo filename
		JSONObject jO;
		try {
			InputStream in = new FileInputStream(new File(filename));
			jO = new JSONObject(new JSONTokener(in));

		} catch (FileNotFoundException e) {
			jO = null;
		}
		return jO;
	}

	private JSONArray getLineasFacturasJArray(String filename) {
		// Devuelve el JSONArray guardado en el archivo filename
		JSONObject jO = getJSONFromFile(filename);
		if (jO == null) {
			return null;
		} else {
			return jO.getJSONArray("ListaLineasFacturas");
		}
	}

	private boolean writeJSONObject(String filename, JSONArray ja, int next_id) {
		// Escribimos el fichero otra vez con los datos actualizados
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			JSONObject jo2 = new JSONObject();
			jo2.put("ListaLineasFacturas", ja);
			jo2.put("next_id", next_id);
			bw.write(jo2.toString());

			if (bw != null) {// cerramos el fichero siempre
				bw.close();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
