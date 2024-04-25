package presentacion;

import javax.swing.JFrame;

public class MainWindow extends JFrame implements IGUI {
	private static final long serialVersionUID = 7062033845360986187L;
	
	public MainWindow() {
		super("Pasteleria Cerecillas con Nata");
		initGUI();
	}
	
	private void initGUI() {
		
	}

	@Override
	public void actualizar(Evento e, Object datos) {
	}

}
