package integracion.Facturas;

import java.util.Collection;
import negocio.Facturas.TDatosVenta;
import java.io.BufferedReader;
import negocio.Facturas.TFactura;
import negocio.Facturas.TLineaFactura;
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

	public boolean modificarFactura(TLineaFactura linea) {
		DAOLineaFactura daol = FactoriaAbstractaIntegracion.getInstance().crearDAOLineaFactura();
		return daol.modificarLineaFactura(linea);
	}

	public TFactura buscarFactura(String id_factura) {
		TFactura factura = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Facturas.json"));
			JSONObject ji = new JSONObject(new JSONTokener(br));
			JSONArray ja = new JSONArray();
			ja = ji.getJSONArray("ListaFacturas");

			int i = 0;
			while (i < ja.length() && ja.getJSONObject(i).getString("id_factura") != id_factura) {
				i++;
			}
			if (i < ja.length()) {
				// Obtenemos todas las lineas de factura
				DAOLineaFactura daol = FactoriaAbstractaIntegracion.getInstance().crearDAOLineaFactura();
				ArrayList<TLineaFactura> lineas_factura = (ArrayList<TLineaFactura>) daol.mostrarLineasFactura();
				// seleccionamos las que pertenecen a la factura actual
				for (int j = 0; j < lineas_factura.size(); ++j) {
					if (!lineas_factura.get(j).getIdFactura().equals(ja.getJSONObject(i).getString("id_factura"))) {
						lineas_factura.remove(j);
					}
				}
				// creamos el resto de elementos necesarios para crear la factura
				TDatosVenta dt = new TDatosVenta(ja.getJSONObject(i).getString("fecha"),
						ja.getJSONObject(i).getString("id_cliente"), ja.getJSONObject(i).getString("id_vendedor"),
						lineas_factura);
				// creamos la factura
				factura = new TFactura(ja.getJSONObject(i).getString("id_factura"),
						ja.getJSONObject(i).getDouble("precio"), dt, ja.getJSONObject(i).getBoolean("activa"));
			}
			if (br != null) {// cerramos el fichero siempre
				br.close();
			}

		} catch (IOException e) {
			return null;
		}
		return factura;

	}

	public boolean crearFactura(TFactura f) {
		boolean exito = true;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Facturas.json"));
			JSONObject ji = new JSONObject(new JSONTokener(br));

			JSONArray ja = new JSONArray();
			ja = ji.getJSONArray("ListaFacturas");
			int next_id = ji.getInt("next_id");
			next_id++;

			// Creamos el json de la nueva factura
			JSONObject jo = new JSONObject();
			jo.put("id", f.getIdFactura());
			jo.put("fecha", f.getFecha());
			jo.put("id_cliente", f.getIdCliente());
			jo.put("id_vendedor", f.getIdVendedor());
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
		return exito;
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
					if (!lineas_factura.get(j).getIdFactura().equals(ja.getJSONObject(i).getString("id_factura"))) {
						lineas_factura.remove(j);
					}
				}
				// creamos el resto de elementos necesarios para crear la factura
				TDatosVenta dt = new TDatosVenta(ja.getJSONObject(i).getString("fecha"),
						ja.getJSONObject(i).getString("id_cliente"), ja.getJSONObject(i).getString("id_vendedor"),
						lineas_factura);
				// creamos la factura
				facturas.add(new TFactura(ja.getJSONObject(i).getString("id_factura"),
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

}
