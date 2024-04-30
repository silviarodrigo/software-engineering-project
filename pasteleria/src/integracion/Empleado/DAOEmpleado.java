package integracion.Empleado;

import java.util.Collection;


import negocio.Empleados.TEmpleado;

public interface DAOEmpleado {

	   public int altaEmpleado(TEmpleado empleado);
	   public int bajaEmpleado(String dni);
	   public TEmpleado buscarEmpleado (String nombre);
	   public TEmpleado buscarEmpleado (int dni);
	   public int actualizarEmpleado(TEmpleado empleado); //vamos a buscar por dni
	   public Collection<TEmpleado> listarEmpleados();
	   
}