package negocio.Empleados;

import java.util.Collection;

public interface SAEmpleados {
   public String altaEmpleado(Templeado empleado);
   public TEmpleado buscar(String id);
   public Collection<TEmpleado> listarTodos();
   
}
