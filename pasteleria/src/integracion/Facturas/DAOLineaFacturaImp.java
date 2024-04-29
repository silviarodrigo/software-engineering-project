package integracion.Facturas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import negocio.Facturas.TLineaFactura;

public class DAOLineaFacturaImp implements DAOLineaFactura {

	public boolean modificarLineaFactura(TLineaFactura lf) {
		boolean exito = true;
		try {
			// Accedemos al json
			BufferedReader brlf = new BufferedReader(new FileReader("LineasFacturas.json"));
			JSONObject ji = new JSONObject(new JSONTokener(brlf));
			JSONArray ja = new JSONArray();
			ja = ji.getJSONArray("ListaLineasFactura");
			int next_id = ji.getInt("next_id");
			// buscamos la linea
			int i = 0;
			while (i < ja.length() && ja.getJSONObject(i).getInt("id_linea") != lf.getIdLinea()) {
				i++;
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter("LineasFacturas.json"));
			if (i < ja.length()) {
				ja.remove(i);
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
				JSONObject jo2 = new JSONObject();
				jo2.put("ListaLineasFactura", ja);
				jo2.put("next_id", next_id);
				bw.write(jo2.toString());
			}
			if (bw != null) {// cerramos el fichero siempre
				bw.close();
			}
		} catch (IOException | JSONException e) {
			exito = false;
		}
		return exito;
	}

	public TLineaFactura buscarLineaFactura(int id) {
		try {
			// Accedemos al json
			BufferedReader brlf = new BufferedReader(new FileReader("LineasFacturas.json"));
			JSONObject ji = new JSONObject(new JSONTokener(brlf));
			JSONArray ja = new JSONArray();
			ja = ji.getJSONArray("ListaLineasFactura");

			// buscamos la linea
			int i = 0;
			while (i < ja.length() && ja.getJSONObject(i).getInt("id_linea") != id) {
				i++;
			}
			if (i < ja.length())
				return new TLineaFactura(ja.getJSONObject(i).getInt("id_producto"),
						ja.getJSONObject(i).getInt("id_factura"), ja.getJSONObject(i).getInt("id_linea"),
						ja.getJSONObject(i).getInt("cantidad"));
			else
				return null;

		} catch (IOException e) {
			return null;
		}
	}

	public int crearLineaFactura(TLineaFactura lf) {
		boolean exito = true;
		try {
			BufferedReader br = new BufferedReader(new FileReader("LineasFacturas.json"));
			JSONObject ji = new JSONObject(new JSONTokener(br));
			JSONArray ja = new JSONArray();
			ja = ji.getJSONArray("ListaLineasFactura");
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
			BufferedWriter bw = new BufferedWriter(new FileWriter("LineasFacturas.json"));
			JSONObject jo2 = new JSONObject();
			jo2.put("ListaLineasFactura", ja);
			jo2.put("next_id", next_id);
			bw.write(jo2.toString());

			if (bw != null) {// cerramos el fichero siempre
				bw.close();
			}
		} catch (IOException | JSONException e) {
			exito = false;
		}
		if (exito) {
			return lf.getIdLinea();
		} else
			return -1;
	}

	public void eliminarLineaFactura(TLineaFactura lf) {
		try {
			// Accedemos al json
			BufferedReader brlf = new BufferedReader(new FileReader("LineasFacturas.json"));
			JSONObject ji = new JSONObject(new JSONTokener(brlf));
			JSONArray ja = new JSONArray();
			ja = ji.getJSONArray("ListaLineasFactura");

			// buscamos la linea
			int i = 0;
			while (i < ja.length() && ja.getJSONObject(i).getInt("id_linea") != lf.getIdLinea()) {
				i++;
			}
			if (i < ja.length()) {
				lf.setActivo(false);
				// Escribimos el fichero otra vez con los datos actualizados
				ja.getJSONObject(i).remove("activo");
				ja.getJSONObject(i).put("activo", "false");
				BufferedWriter bw = new BufferedWriter(new FileWriter("LineasFacturas.json"));
				JSONObject jo2 = new JSONObject();
				jo2.put("ListaLineasFactura", ja);
				bw.write(jo2.toString());

				if (bw != null) {// cerramos el fichero siempre
					bw.close();
				}
			}

		} catch (IOException e) {

		}

	}

	public Collection<TLineaFactura> mostrarLineasFactura() {
		ArrayList<TLineaFactura> lineas_factura = new ArrayList<TLineaFactura>();
		try {
			// Accedemos al json
			BufferedReader br = new BufferedReader(new FileReader("LineasFacturas.json"));
			JSONObject ji = new JSONObject(new JSONTokener(br));
			JSONArray ja = new JSONArray();
			ja = ji.getJSONArray("ListaLineasFactura");

			for (int i = 0; i < ja.length(); i++) {
				lineas_factura.add(new TLineaFactura(ja.getJSONObject(i).getInt("id_producto"),
						ja.getJSONObject(i).getInt("id_factura"), ja.getJSONObject(i).getInt("id_linea"),
						ja.getJSONObject(i).getInt("cantidad")));
			}

			if (br != null) {// cerramos el fichero siempre
				br.close();
			}

		} catch (IOException e) {
			return null;
		}
		return lineas_factura;

	}

}
