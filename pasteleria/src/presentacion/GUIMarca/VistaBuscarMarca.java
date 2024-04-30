package presentacion.GUIMarca;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import negocio.Marca.TMarca;
import negocio.Producto.TBebida;
import negocio.Producto.TDulce;
import negocio.Producto.TPan;
import negocio.Producto.TProducto;
import presentacion.Evento;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;

public class VistaBuscarMarca extends JDialog implements IGUI {

	private static final long serialVersionUID = 1L;
	
	
	JSpinner idText;
	JButton okButton;
	JButton cancelButton;
	JPanel _pedirIdPanel;
	JPanel _infoPanel;
	JPanel _mainPanel;

	public VistaBuscarMarca() {
		initGUI();
	}
	
	void initGUI() {
		setTitle("Buscar Marca");

		_mainPanel = new JPanel();
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));
		_pedirIdPanel = new JPanel();
		_pedirIdPanel.setLayout(new BoxLayout(_pedirIdPanel, BoxLayout.Y_AXIS));
		setContentPane(_mainPanel);
		_mainPanel.add(_pedirIdPanel);
		
		JLabel idLabel = new JLabel("Id: ");
		idText = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
		idText.setPreferredSize(new Dimension(100, 20));
		JPanel idPanel = new JPanel();
		idPanel.add(idLabel);
		idPanel.add(idText);
		_pedirIdPanel.add(idPanel);
		
		
		//Buscar/Cancel
		JPanel okCancelPanel = new JPanel();
		okButton = new JButton("Buscar");
		okButton.addActionListener((e)-> buscarMarca());
		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener((e)-> dispose());
		okCancelPanel.add(okButton);
		okCancelPanel.add(cancelButton);
		_pedirIdPanel.add(okCancelPanel);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	void initInfoGUI(TMarca marca) {
		_infoPanel = new JPanel();
		_infoPanel.setLayout(new BoxLayout(_infoPanel, BoxLayout.Y_AXIS));
		_mainPanel.add(_infoPanel);

		JLabel idLabel = new JLabel("Id: " + marca.getID());
		JLabel nombreLabel = new JLabel("Nombre: " + marca.getNombre());
		JLabel correoLabel = new JLabel("Correo: " + marca.getCorreo());
		_infoPanel.add(idLabel);
		_infoPanel.add(nombreLabel);
		_infoPanel.add(correoLabel);
		
		JButton continuarBtn = new JButton("Continuar");
		continuarBtn.addActionListener((e) -> dispose());
		_infoPanel.add(continuarBtn);
		
		pack();
	}
	
	private void buscarMarca() {
		int id = (int) idText.getValue();
		
		/*TAL Y COMO ESTÁ IMPLEMENTADO NO DEBERÍA PODER ELEGIR UN Nº NEGATIVO
		 * if (id < 0) {
			JOptionPane.showMessageDialog(this, "Debe indicar un Id valido", "Baja Marca", JOptionPane.ERROR_MESSAGE);
			return;
		}*/
		
		Controlador.getInstance().accion(Evento.BUSCAR_MARCA, id);
	}
	
	@Override
	public void actualizar(Evento e, Object datos) {	
		switch(e) {
		case BUSCAR_MARCA_SUCCESS:
			_pedirIdPanel.setVisible(false);
			initInfoGUI((TMarca) datos);
			break;
		case BUSCAR_MARCA_ERROR:
			JOptionPane.showMessageDialog(this, "ERROR: " + datos, "Buscar Marca", JOptionPane.ERROR_MESSAGE);
			dispose();
			break;
		default:
			break;
		}
	}

}
