package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentacion.Controlador.Controlador;

import javax.swing.JButton;



public class MainWindow extends JFrame implements IGUI {
	private static final long serialVersionUID = 7062033845360986187L;
	
	public MainWindow() {
		super("Pasteleria Cerecillas con Nata");
		initGUI();
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel();
		setContentPane(mainPanel);
		
		JPanel buttonPanel = new JPanel();
		mainPanel.add(buttonPanel);
		
		JButton productoBtn = new JButton("Producto");
		productoBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_PRINCIPAL_PRODUCTO));
		buttonPanel.add(productoBtn);
		
		JButton facturasBtn = new JButton("Facturas");
		facturasBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_PRINCIPAL_FACTURAS));
		buttonPanel.add(facturasBtn);
		
		JButton marcasBtn = new JButton("Marca");
		marcasBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_PRINCIPAL_MARCA));
		buttonPanel.add(marcasBtn);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para que acabe el programa al cerrar la ventana.
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	//Funcion a usar en los listeners de los botones
	private void listenerAbrirVentana(Evento e) {
		Controlador.getInstance().accion(e, null);
	}

	@Override
	public void actualizar(Evento e, Object datos) {
	}

}
