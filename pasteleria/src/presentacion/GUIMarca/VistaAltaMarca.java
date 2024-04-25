package presentacion.GUIMarca;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaAltaMarca extends JDialog{

	private static final long serialVersionUID = 1L;
	
	//JPanel para cada atributo que se pide, con su JLabel y su JTextField
	JPanel nombrePanel;
	JLabel nombreLabel;
	JTextField nombreText;
	
	JPanel correoPanel;
	JLabel correoLabel;
	JTextField correoText;
	
	//Ok y Cancel Button en su JPanel
	JButton okButton;
	JButton cancelButton;
	JPanel okCancelPanel;
}
