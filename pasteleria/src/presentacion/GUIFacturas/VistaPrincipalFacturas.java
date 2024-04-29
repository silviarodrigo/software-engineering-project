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
		
		JButton altaBtn = new JButton("Abrir venta");
		altaBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_ABRIR_VENTA));
		buttonPanel.add(altaBtn);
		
		JButton bajaBtn = new JButton("Modificar factura");
		bajaBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_MODIFICAR_FACTURA));
		buttonPanel.add(bajaBtn);
		
		JButton actualizarBtn = new JButton("Buscar factura");
		actualizarBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_BUSCAR_FACTURAS));
		buttonPanel.add(actualizarBtn);
		
		JButton listarBtn = new JButton("Listar Facturas");
		listarBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_LISTAR_FACTURAS));
		buttonPanel.add(listarBtn);
		
//		JButton buscarBtn = new JButton("Volver");
//		buscarBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_BUSCAR_PRODUCTO));
//		buttonPanel.add(buscarBtn);
		
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
