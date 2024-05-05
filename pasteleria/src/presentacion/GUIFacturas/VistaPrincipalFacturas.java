package presentacion.GUIFacturas;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentacion.Evento;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;

public class VistaPrincipalFacturas extends JFrame implements IGUI {
	private static final long serialVersionUID = 1L;

	public VistaPrincipalFacturas() {
		initGUI();
	}
	
	private void initGUI() {
		setTitle("Subsistema Facturas");
		
		JPanel mainPanel = new JPanel();
		setContentPane(mainPanel);
		
		JPanel buttonPanel = new JPanel();
		mainPanel.add(buttonPanel);
		
		JButton abrirBtn = new JButton("Abrir venta");
		abrirBtn.addActionListener((e) -> listenerAbrirVentana(Evento.ABRIR_VENTA));
		buttonPanel.add(abrirBtn);
		
		JButton annadirBtn = new JButton("Anadir producto");
		annadirBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_ANADIR_PRODUCTO));
		buttonPanel.add(annadirBtn);
		
		JButton eliminarBtn = new JButton("Eliminar producto");
		eliminarBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_ELIMINAR_PRODUCTO));
		buttonPanel.add(eliminarBtn);
		
		JButton cerrarBtn = new JButton("Cerrar venta");
		cerrarBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_CERRAR_VENTA));
		buttonPanel.add(cerrarBtn);
		
		JButton bajaBtn = new JButton("Modificar factura");
		bajaBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_MODIFICAR_FACTURA));
		buttonPanel.add(bajaBtn);
		
		JButton actualizarBtn = new JButton("Buscar factura");
		actualizarBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_BUSCAR_FACTURA));
		buttonPanel.add(actualizarBtn);
		
		JButton listarBtn = new JButton("Listar Facturas");
		listarBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_LISTAR_FACTURAS));
		buttonPanel.add(listarBtn);
		
		JButton listarPorClienteBtn = new JButton("Listar Facturas Por Cliente");
		listarPorClienteBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_LISTAR_FACTURAS_POR_CLIENTE));
		buttonPanel.add(listarPorClienteBtn);
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	private void listenerAbrirVentana(Evento e) {
		Controlador.getInstance().accion(e, null);
	}
	
	@Override
	public void actualizar(Evento e, Object datos) {
	}

}
