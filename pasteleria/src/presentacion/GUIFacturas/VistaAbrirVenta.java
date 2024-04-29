package presentacion.GUIFacturas;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.Evento;
import presentacion.IGUI;

public class VistaAbrirVenta extends JFrame implements IGUI{

	public VistaAbrirVenta() {
		initGUI();
	}
	
	void initGUI() {
		setTitle("Buscar Producto");

		_mainPanel = new JPanel();
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));
		_pedirNombrePanel = new JPanel();
		_pedirNombrePanel.setLayout(new BoxLayout(_pedirNombrePanel, BoxLayout.Y_AXIS));
		setContentPane(_mainPanel);
		_mainPanel.add(_pedirNombrePanel);
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		_tFNombre = new JTextField();
		_tFNombre.setPreferredSize(new Dimension(100, 20));
		JPanel nombrePanel = new JPanel();
		nombrePanel.add(nombreLabel);
		nombrePanel.add(_tFNombre);
		_pedirNombrePanel.add(nombrePanel);
		
		JPanel btnPanel = new JPanel();
		JButton acceptBtn = new JButton("Buscar");
		acceptBtn.addActionListener((e)-> buscarProducto());
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener((e)-> dispose());
		btnPanel.add(acceptBtn);
		btnPanel.add(cancelBtn);
		_pedirNombrePanel.add(btnPanel);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actualizar(Evento e, Object datos) {
		// TODO Auto-generated method stub
		
	}
}
