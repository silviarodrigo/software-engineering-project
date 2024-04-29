package presentacion.GUIMarca;

import javax.swing.JButton;
import javax.swing.JDialog;

import presentacion.Evento;
import presentacion.IGUI;

public class VistaPrincipalMarca extends JDialog implements IGUI{ //JDIALOG O JFRAME???

	private static final long serialVersionUID = 1L;
	//un botón por cada vista
	JButton altaBoton;
	JButton bajaBoton;
	JButton modificarBoton;
	JButton buscarBoton;
	JButton listarBoton;
	@Override
	public void actualizar(Evento e, Object datos) {
		// TODO Auto-generated method stub
		
	}
	
}
