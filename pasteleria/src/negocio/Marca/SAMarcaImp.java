package negocio.Marca;

import java.util.Collection;

import negocio.Factoria.FactoriaAbstractaNegocio;
import integracion.Factoria.FactoriaAbstractaIntegracion;
import integracion.Marca.DAOMarca;

//"Negocio pide a integración que lo añada"

//Accede al DAOMarca, DAOProducto (comprobar que no hay ningun producto con esa marca la eliminarla) y a DAOMarcaProveedor

public class SAMarcaImp implements SAMarca{
	
	//MODIFCA EN ALGO EL NEXT_ID?? SI LA HA INSERTADO, DEVUELVE EL NOMBRE DE LA MARCA O NEXT_ID??
	public String altaMarca(TMarca marca) {
		DAOMarca daoMarca = FactoriaAbstractaIntegracion.getInstance().crearDAOMarca();
		
		String nombre = marca.getNombre();
		if (daoMarca.buscarMarca(nombre) == null) {//no está insertada ya
			next_id = daoMarca.altaMarca(marca);			
		}
		return next_id;
	}
	
	//IGUAL ES MAS FACIL QUE MARCA TENGA UN INT PRODUCTOS (con el nº de productos asociados) e ir cambiandolo cuando den de baja un producto 
	public boolean bajaMarca(String nombre) {
		DAOMarca daoMarca = FactoriaAbstractaIntegracion.getInstance().crearDAOMarca();
		DAOProducto daoProducto = FactoriaAbstractaIntegracion.getInstance().crearDAOproducto();
		
		//Comprobamos que no haya ningun producto con esa marca 
		int cont = 0;
		for (TProdcuto prod : daoProducto.listarProducto()) {
			if (prod.getMarca() != id) {
				cont++;
			}
		}
		
		boolean bool = false;
		if (cont == daoProducto.listarProducto().size()) { //ningun producto tiene esa marca
			bool = daoMarca.bajaMarca(id);
		}
		return bool;
	}
	
	
	public boolean actualizarMarca(TMarca marca) {
		DAOMarca daoMarca = FactoriaAbstractaIntegracion.getInstance().crearDAOMarca();
		
		if(daoMarca.actualizarMarca(marca)) return true;
		else return false;
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
