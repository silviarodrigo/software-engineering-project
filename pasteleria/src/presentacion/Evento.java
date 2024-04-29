package presentacion;

public enum Evento {
	MAIN_WINDOW, 
	//PRODUCTO
	VISTA_PRINCIPAL_PRODUCTO, VISTA_ALTA_PRODUCTO, VISTA_BAJA_PRODUCTO, VISTA_ACTUALIZAR_PRODUCTO,
	VISTA_BUSCAR_PRODUCTO, VISTA_LISTAR_PRODUCTO, ALTA_PRODUCTO, BAJA_PRODUCTO, ACTUALIZAR_PRODUCTO, BUSCAR_PRODUCTO,
	LISTAR_PRODUCTO, ALTA_PRODUCTO_SUCCESS, ALTA_PRODUCTO_ERROR, BUSCAR_PRODUCTO_SUCCESS, BUSCAR_PRODUCTO_ERROR,
	BAJA_PRODUCTO_SUCCESS, BAJA_PRODUCTO_ERROR, ACTUALIZAR_PRODUCTO_SUCCESS, ACTUALIZAR_PRODUCTO_ERROR,
	//FACTURAS
	VISTA_PRINCIPAL_FACTURAS, VISTA_BUSCAR_FACTURA, VISTA_MODIFICAR_FACTURAS, VISTA_LISTAR_FACTURAS, VISTA_ABRIR_VENTA,
	LISTAR_FACTURAS, VISTA_MODIFICAR_FACTURA, BUSCAR_FACTURA, BUSCAR_FACTURA_SUCCESS, BUSCAR_FACTURA_ERROR,
	MODIFICAR_FACTURA_SUCCESS, MODIFICAR_FACTURA_ERROR, MODIFICAR_FACTURA,
}
