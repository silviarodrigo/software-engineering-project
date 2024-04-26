package negocio.Marca;

import java.util.Collection;

import negocio.Factoria.FactoriaAbstractaNegocio;
import integracion.Factoria.FactoriaAbstractaIntegracion;
import integracion.Marca.DAOMarca;
import integracion.Producto.DAOProducto;

//"Negocio pide a integración que lo añada"

//Accede al DAOMarca, DAOProducto (comprobar que no hay ningun producto con esa marca la eliminarla) y a DAOMarcaProveedor

public class SAMarcaImp implements SAMarca{
	
	//MODIFCA EN ALGO EL NEXT_ID?? SI LA HA INSERTADO DEVUELVE NEXT_ID??
	public int altaMarca(TMarca marca) {
		DAOMarca daoMarca = FactoriaAbstractaIntegracion.getInstance().crearDAOMarca();
		
		int id = 0;
		if (marca.getID() == 0) {//no está insertada todavía
			id = daoMarca.altaMarca(marca);			
		}
		return id;
	}
	
	
	public boolean bajaMarca(int id) {
		DAOMarca daoMarca = FactoriaAbstractaIntegracion.getInstance().crearDAOMarca();
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOProducto();
		
		//Comprobamos que no haya ningun producto con esa marca 
		int cont = 0;
		for (TProdcuto prod : daoProducto.listarProducto()) {
			if (prod.getMarca() == id) {
				cont++;
			}
		}
		
		boolean bool = false;
		if (cont == 0) { //ningun producto tiene esa marca
			bool = daoMarca.bajaMarca(id);
		}
		return bool;
	}
	
	
	public boolean actualizarMarca(TMarca marca) {
		DAOMarca daoMarca = FactoriaAbstractaIntegracion.getInstance().crearDAOMarca();
		
		if(daoMarca.actualizarMarca(marca)) return true;
		else return false;
	}
	
	public TMarca buscarMarca(int id) {
		DAOMarca daoMarca = FactoriaAbstractaIntegracion.getInstance().crearDAOMarca();
		return daoMarca.buscarMarca(id);
	}
	
	public TMarca buscarMarca(String nombre) {
		DAOMarca daoMarca = FactoriaAbstractaIntegracion.getInstance().crearDAOMarca();
		return daoMarca.buscarMarca(nombre);
	}
	
	public Collection<TMarca> listarMarca(){
		DAOMarca daoMarca = FactoriaAbstractaIntegracion.getInstance().crearDAOMarca();
		return daoMarca.listarMarca();
	}
}
