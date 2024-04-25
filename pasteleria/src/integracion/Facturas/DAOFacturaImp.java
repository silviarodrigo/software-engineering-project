package integracion.Facturas;

import java.util.Collection;
import java.io.BufferedReader;
import negFactura.TFactura;
import negFactura.TLineaFactura;
import org.json.*;

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

	@Override
	public boolean modificarFactura(TLineaFactura linea) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TFactura buscarFactura(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean crearFactura(TFactura f) {
		boolean exito = true;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Facturas.json"));
			JSONObject ji = new JSONObject(new JSONTokener(br));

			JSONArray ja = new JSONArray();
			ja = ji.getJSONArray("ListaFacturas");

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
			bw.write(jo2.toString());

		} catch (IOException | JSONException e) {
			exito = false;
		} finally {
///////////////////////////////////////////////////////////////////////////CERRAR FICHERO
		}
		return exito;
	}

	@Override
	public Collection<TFactura> listarFacturas() {
		ArrayList<TFactura> facturas = new ArrayList<TFactura>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Facturas.json"));

			JSONObject ji = new JSONObject(new JSONTokener(br));
			JSONArray ja = new JSONArray();
			ja = ji.getJSONArray("ListaFacturas");

			int cont = 0;
			while (cont < ja.length()) {

				cont++;
			}
		} catch (IOException e) {
			// e.printStackTrace();
			return null;
		} finally {
///////////////////////////////////////////////////////////////////////////CERRAR FICHERO
		}

		return facturas;
	}

}
