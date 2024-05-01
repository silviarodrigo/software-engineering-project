package presentacion;

public enum Evento {
	MAIN_WINDOW,
	// PRODUCTO
	VISTA_PRINCIPAL_PRODUCTO, VISTA_ALTA_PRODUCTO, VISTA_BAJA_PRODUCTO, VISTA_ACTUALIZAR_PRODUCTO,
	VISTA_BUSCAR_PRODUCTO, VISTA_LISTAR_PRODUCTO, ALTA_PRODUCTO, BAJA_PRODUCTO, ACTUALIZAR_PRODUCTO, BUSCAR_PRODUCTO,
	LISTAR_PRODUCTO, ALTA_PRODUCTO_SUCCESS, ALTA_PRODUCTO_ERROR, BUSCAR_PRODUCTO_SUCCESS, BUSCAR_PRODUCTO_ERROR,
	BAJA_PRODUCTO_SUCCESS, BAJA_PRODUCTO_ERROR, ACTUALIZAR_PRODUCTO_SUCCESS, ACTUALIZAR_PRODUCTO_ERROR,
	// FACTURAS
	VISTA_PRINCIPAL_FACTURAS, VISTA_BUSCAR_FACTURA, VISTA_LISTAR_FACTURAS, LISTAR_FACTURAS, VISTA_MODIFICAR_FACTURA,
	BUSCAR_FACTURA, BUSCAR_FACTURA_SUCCESS, BUSCAR_FACTURA_ERROR, MODIFICAR_FACTURA_SUCCESS, MODIFICAR_FACTURA_ERROR,
	MODIFICAR_FACTURA, ABRIR_VENTA, ANADIR_PRODUCTO_SUCCESS, ANADIR_PRODUCTO_ERROR, VISTA_ANADIR_PRODUCTO,
	VISTA_ELIMINAR_PRODUCTO, ELIMINAR_PRODUCTO_SUCCESS, ELIMINAR_PRODUCTO_ERROR, ANADIR_PRODUCTO, ELIMINAR_PRODUCTO,
	VISTA_CERRAR_VENTA, CERRAR_VENTA,CERRAR_VENTA_SUCCESS, CERRAR_VENTA_ERROR,
	// MARCAS
	VISTA_PRINCIPAL_MARCA, VISTA_ALTA_MARCA, VISTA_BAJA_MARCA, VISTA_ACTUALIZAR_MARCA, VISTA_BUSCAR_MARCA,
	VISTA_LISTAR_MARCAS, ALTA_MARCA, BAJA_MARCA, ACTUALIZAR_MARCA, BUSCAR_MARCA, LISTAR_MARCAS, ALTA_MARCA_SUCCESS,
	ALTA_MARCA_ERROR, BAJA_MARCA_SUCCESS, BAJA_MARCA_ERROR, ACTUALIZAR_MARCA_SUCCESS, ACTUALIZAR_MARCA_ERROR,
	BUSCAR_MARCA_SUCCESS, BUSCAR_MARCA_ERROR,
	//EMPLEADOS
	ALTA_EMPLEADO, ALTA_EMPLEADO_ERROR, ALTA_EMPLEADO_EXITO, BAJA_EMPLEADO, BAJA_EMPLEADO_ERROR, BAJA_EMPLEADO_EXITO,
	BUSCAR_EMPLEADO, BUSCAR_EMPLEADO_EXITO, BUSCAR_EMPLEADO_ERROR, ACTUALIZAR_EMPLEADO_EXITO,ACTUALIZAR_EMPLEADO_ERROR,ACTUALIZAR_EMPLEADO, LISTAR_EMPLEADOS,
	VISTA_ALTA_EMPLEADO, VISTA_BAJA_EMPLEADO, VISTA_ACTUALIZAR_EMPLEADO, VISTA_BUSCAR_EMPLEADO, VISTA_LISTAR_EMPLEADOS,VISTA_PRINCIPAL_EMPLEADOS
}
