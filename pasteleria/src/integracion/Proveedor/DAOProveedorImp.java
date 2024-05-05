package integracion.Proveedor;

import java.util.Collection;

import org.json.JSONObject;

import negocio.Proveedor.TProveedor;

public class DAOProveedorImp implements DAOProveedor {

	@Override
	public int altaProveedor(TProveedor proveedor) {
		JSONObject jProv = createJSON(proveedor);
	}

	@Override
	public boolean bajaProveedor(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int actualizarProveedor(TProveedor proveedor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TProveedor buscarProveedor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TProveedor buscarProveedor(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TProveedor> listarProveedor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private JSONObject createJSON(TProveedor proveedor) {
		JSONObject jObj = new JSONObject();
		jObj.put("Nombre", proveedor.getNombre());
		jObj.put("Telefono", proveedor.getCorreo());
		jObj.put("Correo", proveedor.getCorreo());
		jObj.put("Codigp postal", proveedor.getCorreo());
		jObj.put("Id", proveedor.getID());
		jObj.put("Activo", proveedor.getActivo());
		return jObj;
	}

}
