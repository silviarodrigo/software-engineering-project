package presentacion.GUIProducto;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.Evento;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;

public class VistaBajaProducto extends JDialog implements IGUI {
	
	JTextField _tFNombre;

	public VistaBajaProducto() {
		initGUI();
	}
	
	void initGUI() {
		setTitle("Baja Producto");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		_tFNombre = new JTextField();
		_tFNombre.setPreferredSize(new Dimension(100, 20));
		JPanel nombrePanel = new JPanel();
		nombrePanel.add(nombreLabel);
		nombrePanel.add(_tFNombre);
		mainPanel.add(nombrePanel);
		
		JPanel endPanel = new JPanel();
		JButton acceptBtn = new JButton("Eliminar");
		acceptBtn.addActionListener((e)-> bajaProducto());
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener((e)-> dispose());
		endPanel.add(acceptBtn);
		endPanel.add(cancelBtn);
		mainPanel.add(endPanel);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void bajaProducto() {
		String nombre = _tFNombre.getText();

		if (nombre == null || nombre.equals("")) {
			JOptionPane.showMessageDialog(this, "Debes indicar un nombre", "Baja Producto", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Controlador.getInstance().accion(Evento.BAJA_PRODUCTO, nombre);
	}
	
	@Override
	public void actualizar(Evento e, Object datos) {		
	}

}
