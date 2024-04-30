package integracion.Facturas;

import java.util.Collection;
import negocio.Facturas.TDatosVenta;
import java.io.BufferedReader;
import negocio.Facturas.TFactura;
import negocio.Facturas.TLineaFactura;
import negocio.Producto.TProducto;

import org.json.*;

import integracion.Factoria.FactoriaAbstractaIntegracion;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

public class DAOFacturaImp implements DAOFactura {

	public boolean modificarFactura(int id_f, int id_c, int id_v, String fecha) {
		boolean exito = false;
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("Facturas.json"));
			JSONObject ji = new JSONObject(new JSONTokener(br));
			JSONArray ja = new JSONArray();
			ja = ji.getJSONArray("ListaFacturas");
			int next_id = ji.getInt("next_id");
			int i = 0;
			while (i < ja.length() && ja.getJSONObject(i).getInt("id_factura") != id_f) {
				i++;
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter("Facturas.json"));
			if (i < ja.length()) {
				exito = true;
				JSONObject jo = new JSONObject();
				jo.put("id_factura", id_f);
				jo.put("fecha", fecha);
				jo.put("id_cliente", id_c);
				jo.put("id_vendedor", id_v);
				jo.put("precio", ja.getJSONObject(i).getInt("precio"));
				jo.put("activa", ja.getJSONObject(i).getInt("activa"));
				ja.put(i, jo);// lo añadimos a nuestra lista de facturas

				// Escribimos el fichero otra vez con los datos actualizados
				JSONObject jo2 = new JSONObject();
				jo2.put("ListaFacturas", ja);
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

//	public boolean modificarFactura(TLineaFactura linea) {
//		DAOLineaFactura daol = FactoriaAbstractaIntegracion.getInstance().crearDAOLineaFactura();
//		return daol.modificarLineaFactura(linea);
//	}

	public TFactura buscarFactura(int id_factura) {
		TFactura factura = null;
		try {
			JSONObject ji = getJSONFromFile("Facturas.json");
			JSONArray ja = new JSONArray();
			ja = ji.getJSONArray("ListaFacturas");

			int i = 0;
			while (i < ja.length() && ja.getJSONObject(i).getInt("id_factura") != id_factura) {
				i++;
			}
			if (i < ja.length()) {
				// Obtenemos todas las lineas de factura
				DAOLineaFactura daol = FactoriaAbstractaIntegracion.getInstance().crearDAOLineaFactura();
				ArrayList<TLineaFactura> lineas_factura = (ArrayList<TLineaFactura>) daol.mostrarLineasFactura();
				// seleccionamos las que pertenecen a la factura actual
				for (int j = 0; j < lineas_factura.size(); ++j) {
					if (lineas_factura.get(j).getIdFactura() != ja.getJSONObject(i).getInt("id_factura")) {
						lineas_factura.remove(j);
					}
				}
				// creamos el resto de elementos necesarios para crear la factura
				TDatosVenta dt = new TDatosVenta(ja.getJSONObject(i).getString("fecha"),
						ja.getJSONObject(i).getInt("id_cliente"), ja.getJSONObject(i).getInt("id_vendedor"),
						lineas_factura);
				// creamos la factura
				factura = new TFactura(ja.getJSONObject(i).getInt("id_factura"),
						ja.getJSONObject(i).getDouble("precio"), dt, ja.getJSONObject(i).getBoolean("activa"));
			}
//			if (br != null) {// cerramos el fichero siempre
//				br.close();
//			}

		} catch (Exception e) {
			return null;
		}
		return factura;

	}

	public int crearFactura(TFactura f) {
		boolean exito = true;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Facturas.json"));
			JSONObject ji = new JSONObject(new JSONTokener(br));

			JSONArray ja = new JSONArray();
			ja = ji.getJSONArray("ListaFacturas");
			int next_id = ji.getInt("next_id");
			f.setIdFactura(next_id);
			next_id++;// lo dejamos preparado para la siguiente factura

			TDatosVenta datos_factura = f.getDatosVentas();
			// Creamos el json de la nueva factura
			JSONObject jo = new JSONObject();
			jo.put("id_factura", f.getIdFactura());
			jo.put("fecha", datos_factura.getFecha());
			jo.put("id_cliente", datos_factura.getIdCliente());
			jo.put("id_vendedor", datos_factura.getIdVendedor());
			jo.put("precio", f.getPrecio_total());
			if (f.getActivo()) {
				jo.put("activa", "true");
			} else {
				jo.put("activa", "false");
			}
			ja.put(jo);// lo añadimos a nuestra lista de facturas

			// Escribimos el fichero otra vez con los datos actualizados
			BufferedWriter bw = new BufferedWriter(new FileWriter("Facturas.json"));
			JSONObject jo2 = new JSONObject();
			jo2.put("ListaFacturas", ja);
			jo2.put("next_id", next_id);
			bw.write(jo2.toString());

			if (bw != null) {// cerramos el fichero siempre
				bw.close();
			}
		} catch (IOException | JSONException e) {
			exito = false;
		}
		if (exito) {
			return f.getIdFactura();
		} else
			return -1;
	}

	public Collection<TFactura> listarFacturas() {
		ArrayList<TFactura> facturas = new ArrayList<TFactura>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Facturas.json"));
			JSONObject ji = new JSONObject(new JSONTokener(br));
			JSONArray ja = new JSONArray();
			ja = ji.getJSONArray("ListaFacturas");

			int i = 0;
			while (i < ja.length()) {
				// Obtenemos todas las lineas de factura
				DAOLineaFactura daol = FactoriaAbstractaIntegracion.getInstance().crearDAOLineaFactura();
				ArrayList<TLineaFactura> lineas_factura = (ArrayList<TLineaFactura>) daol.mostrarLineasFactura();
				// seleccionamos las que pertenecen a la factura actual
				for (int j = 0; j < lineas_factura.size(); ++j) {
					if (lineas_factura.get(j).getIdFactura() != ja.getJSONObject(i).getInt("id_factura")) {
						lineas_factura.remove(j);
					}
				}
				// creamos el resto de elementos necesarios para crear la factura
				TDatosVenta dt = new TDatosVenta(ja.getJSONObject(i).getString("fecha"),
						ja.getJSONObject(i).getInt("id_cliente"), ja.getJSONObject(i).getInt("id_vendedor"),
						lineas_factura);
				// creamos la factura
				facturas.add(new TFactura(ja.getJSONObject(i).getInt("id_factura"),
						ja.getJSONObject(i).getDouble("precio"), dt, ja.getJSONObject(i).getBoolean("activa")));
				i++;
			}
			if (br != null) {// cerramos el fichero siempre
				br.close();
			}

		} catch (IOException e) {
			return null;
		}
		return facturas;

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

}
