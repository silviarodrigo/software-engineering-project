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
	private String filename = "resources/Facturas.json";

	public int crearFactura(TFactura f) {
		boolean exito = true;
		try {
			JSONObject ji = getJSONFromFile(filename);
			JSONArray ja = ji.getJSONArray("ListaFacturas");
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

			writeJSONObject(filename, ja, next_id);

		} catch (JSONException e) {
			exito = false;
		}
		if (exito) {
			return f.getIdFactura();
		} else
			return -1;
	}

	public TFactura buscarFactura(int id_factura) {
		TFactura factura = null;
		JSONArray ja = getFacturasJArray(filename);

		int i = searchInJArray(id_factura, ja);
		if (i != -1) {
			factura = facturaConLineas(ja, i);
		}
		return factura;
	}

	public boolean modificarFactura(int id_f, int id_c, int id_v, String fecha) {
		boolean exito = false;
		try {
			JSONObject ji = getJSONFromFile(filename);
			JSONArray ja = ji.getJSONArray("ListaFacturas");
			int next_id = ji.getInt("next_id");
			int i = searchInJArray(id_f, ja);

			if (i != -1) {
				exito = true;
				ja.getJSONObject(i).put("fecha", fecha);
				ja.getJSONObject(i).put("id_cliente", id_c);
				ja.getJSONObject(i).put("id_vendedor", id_v);

				writeJSONObject(filename, ja, next_id);
			}
		} catch (JSONException e) {
			exito = false;
		}
		return exito;
	}

	public Collection<TFactura> listarFacturas() {
		ArrayList<TFactura> facturas = new ArrayList<TFactura>();
		JSONArray ja = getFacturasJArray(filename);

		if (ja != null) {
			for (int i = 0; i < ja.length(); i++) {
				if (ja.getJSONObject(i).getBoolean("activa")) {
					facturas.add(facturaConLineas(ja, i));
				}
			}
		}
		return facturas;
	}

//EXTRAS
	public Collection<TFactura> listarFacturasPorCliente(int id_cliente) {
		ArrayList<TFactura> facturas = new ArrayList<TFactura>();
		JSONArray ja = getFacturasJArray(filename);

		if (ja != null) {
			for (int i = 0; i < ja.length(); i++) {
				if (ja.getJSONObject(i).getInt("id_cliente") == id_cliente
						&& ja.getJSONObject(i).getBoolean("activa")) {
					facturas.add(facturaConLineas(ja, i));
				}
			}
		}
		return facturas;
	}

	public boolean devolucionFactura(TFactura factura) {
		if (factura.getPrecio_total() == 0) {
			factura.setActivo(false);
		}
		boolean exito = true;
		try {
			JSONObject ji = getJSONFromFile(filename);
			JSONArray ja = ji.getJSONArray("ListaFacturas");
			int next_id = ji.getInt("next_id");
			ja.getJSONObject(factura.getIdFactura()).put("precio", factura.getPrecio_total());
			ja.getJSONObject(factura.getIdFactura()).put("activa", factura.getActivo());
			writeJSONObject(filename, ja, next_id);
		} catch (JSONException e) {
			exito = false;
		}
		return exito;
	}

//FUNCIONES AUXILIARES
	private TFactura facturaConLineas(JSONArray ja, int i) {
		// Obtenemos todas las lineas de factura
		DAOLineaFactura daol = FactoriaAbstractaIntegracion.getInstance().crearDAOLineaFactura();
		ArrayList<TLineaFactura> lineas_factura_totales = (ArrayList<TLineaFactura>) daol.mostrarLineasFactura();
		ArrayList<TLineaFactura> lineas_factura_individuales = new ArrayList<>();
		// seleccionamos las que pertenecen a la factura actual
		if (lineas_factura_totales != null) {
			for (int j = 0; j < lineas_factura_totales.size(); ++j) {
				if (lineas_factura_totales.get(j).getIdFactura() == ja.getJSONObject(i).getInt("id_factura")) {
					lineas_factura_individuales.add(lineas_factura_totales.get(j));
				}
			}
		}
		// creamos el resto de elementos necesarios para crear la factura
		TDatosVenta dt = new TDatosVenta(ja.getJSONObject(i).getString("fecha"),
				ja.getJSONObject(i).getInt("id_cliente"), ja.getJSONObject(i).getInt("id_vendedor"),
				lineas_factura_individuales);
		// creamos la factura
		return new TFactura(ja.getJSONObject(i).getInt("id_factura"), ja.getJSONObject(i).getDouble("precio"), dt,
				ja.getJSONObject(i).getBoolean("activa"));
	}

	private int searchInJArray(int id_f, JSONArray ja) {
		// devuele la posicion de la factura en el array, o -1 si no existe
		if (ja == null) {
			return -1;
		}
		int i = 0;
		while (i < ja.length() && ja.getJSONObject(i).getInt("id_factura") != id_f) {
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

	private JSONArray getFacturasJArray(String filename) {
		// Devuelve el JSONArray guardado en el archivo filename
		JSONObject jO = getJSONFromFile(filename);
		if (jO == null) {
			return null;
		} else {
			return jO.getJSONArray("ListaFacturas");
		}
	}

	private boolean writeJSONObject(String filename, JSONArray ja, int next_id) {
		// Escribimos el fichero otra vez con los datos actualizados
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			JSONObject jo2 = new JSONObject();
			jo2.put("ListaFacturas", ja);
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
