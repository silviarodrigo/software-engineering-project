package presentacion.GUIProducto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;


import presentacion.Evento;
import presentacion.IGUI;

public class VistaActualizarProducto extends JDialog implements IGUI {

	public VistaActualizarProducto() {
		initGUI();
	}
	
	private void initGUI() {
		setTitle("Actualizar Producto");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		JTextField tFNombre = new JTextField();
		tFNombre.setPreferredSize(new Dimension(100, 20));
		JPanel nombrePanel = new JPanel();
		nombrePanel.add(nombreLabel);
		nombrePanel.add(tFNombre);
		mainPanel.add(nombrePanel);
		
		JLabel stockLabel = new JLabel("Stock: ");
		JTextField tFStock = new JTextField();
		tFStock.setPreferredSize(new Dimension(100, 20));
		JPanel stockPanel = new JPanel();
		stockPanel.add(stockLabel);
		stockPanel.add(tFStock);
		mainPanel.add(stockPanel);
		
		JLabel precioLabel = new JLabel("Precio: ");
		JTextField tFPrecio = new JTextField();
		tFPrecio.setPreferredSize(new Dimension(100, 20));
		JPanel precioPanel = new JPanel();
		precioPanel.add(precioLabel);
		precioPanel.add(tFPrecio);
		mainPanel.add(precioPanel);
		
		pack();
		setVisible(true);
		
	}
	
	@Override
	public void actualizar(Evento e, Object datos) {
	}

}
