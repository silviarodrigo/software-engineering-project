package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
		productoBtn.addActionListener((e) -> listenerAbrirVentana(Evento.VISTA_ALTA_PRODUCTO));
		
		pack();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void listenerAbrirVentana(Evento e) {
		Controlador.getInstance().accion(e, null);
		this.dispose();
	}

	@Override
	public void actualizar(Evento e, Object datos) {
	}

}
