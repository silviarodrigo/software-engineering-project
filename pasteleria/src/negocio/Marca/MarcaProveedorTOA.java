package negocio.Marca;

import integracion.Factoria.FactoriaAbstractaIntegracion;
import integracion.Marca.DAOMarca;
import integracion.Marca.DAOMarcaProveedor;
import integracion.Proveedor.DAOProveedor;
import negocio.Proveedor.TProveedor;
import negocio.Marca.TMarcaProveedor;

public class MarcaProveedorTOA {
	
	
	public void altaMarcaProveedor(TMarca marca, TProveedor proveedor) throws IllegalArgumentException { //la marca solo tiene bien el nombre
		
		DAOMarca daoMarca = FactoriaAbstractaIntegracion.getInstance().crearDAOMarca();
		TMarca prueba = daoMarca.buscarMarca(marca.getNombre());
		if (prueba == null) { //no existe la marca 
			throw new IllegalArgumentException("Marca no existente.");
		}
		else if (!prueba.getActivo()) { //sí está pero "inactiva"
			throw new IllegalArgumentException("La marca no  está activa.");
		}

		TMarcaProveedor marcaProv = new TMarcaProveedor(prueba, proveedor);
		
		
		DAOMarcaProveedor daoMarcaProv = FactoriaAbstractaIntegracion.getInstance().crearDAOMarcaProveedor();
		daoMarcaProv.altaMarcaProveedor(marcaProv);
		
	}
	
public void bajaMarcaProveedor(String nombreMarca, String nombreProv) throws IllegalArgumentException { //la marca solo tiene bien el nombre
		if (nombreMarca != null) { //hay que dar de baja todas las entradas que tengan esa marca
			DAOMarca daoMarca = FactoriaAbstractaIntegracion.getInstance().crearDAOMarca();
			TMarca prueba = daoMarca.buscarMarca(nombreMarca);
			if (prueba == null) { //no existe la marca 
				throw new IllegalArgumentException("Marca no existente.");
			}
			else if (!prueba.getActivo()) { //sí está pero "inactiva"
				throw new IllegalArgumentException("La marca no está activa.");
			} 
			
			DAOMarcaProveedor daoMarcaProv = FactoriaAbstractaIntegracion.getInstance().crearDAOMarcaProveedor();
			daoMarcaProv.bajaMarcaProveedor(marcaProv);
			
		}
		else { //hay que dar de baja todas las entradas que tengan ese proveedor 
			DAOProveedor daoProv = FactoriaAbstractaIntegracion.getInstance().crearDAOProveedor();
			TProveedor prueba = daoProv.buscarProveedor(nombreProv);
			if (prueba == null) { //no existe el proveedor 
				throw new IllegalArgumentException("Proveedor no existente.");
			}
			else if (!prueba.getActivo()) { //sí está pero "inactivo"
				throw new IllegalArgumentException("El proveedor no está activo.");
			} 
			
			DAOMarcaProveedor daoMarcaProv = FactoriaAbstractaIntegracion.getInstance().crearDAOMarcaProveedor();
			daoMarcaProv.bajaMarcaProveedor(marcaProv);
		}
		
	}
	
	
}
