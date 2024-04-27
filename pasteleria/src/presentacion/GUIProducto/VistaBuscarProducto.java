package presentacion.GUIProducto;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Producto.TProducto;
import presentacion.Evento;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;

public class VistaBuscarProducto extends JDialog implements IGUI {

	JTextField _tFNombre;
	JPanel _pedirNombrePanel;
	JPanel _infoPanel;

	public VistaBuscarProducto() {
		initGUI();
	}
	
	void initGUI() {
		setTitle("Buscar Producto");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		_pedirNombrePanel = new JPanel();
		_pedirNombrePanel.setLayout(new BoxLayout(_pedirNombrePanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		mainPanel.add(_pedirNombrePanel);
		
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
	
	void initInfoGUI(TProducto producto) {
		_infoPanel = new JPanel();
		_infoPanel.setLayout(new BoxLayout(_infoPanel, BoxLayout.Y_AXIS));

		
		JLabel nombreLabel = new JLabel("Nombre: " + producto.getNombre());
		JLabel idLabel = new JLabel("ID: " + producto.getId());
		JLabel stockLabel = new JLabel("Stock: " + producto.getStock());
		JLabel precioLabel = new JLabel("Precio: " + producto.getPrecio());
		JLabel alergenosLabel = new JLabel("Alérgenos: " + producto.getAlergenos());
		JLabel tipoLabel = new JLabel("Tipo: " + producto.getTipo());
		_infoPanel.add(nombreLabel);
		_infoPanel.add(idLabel);
		_infoPanel.add(stockLabel);
		_infoPanel.add(precioLabel);
		_infoPanel.add(alergenosLabel);
		_infoPanel.add(tipoLabel);

	}
	
	private void buscarProducto() {
		String nombre = _tFNombre.getText();
		if (nombre == null || nombre.equals("")) {
			JOptionPane.showMessageDialog(this, "Debes indicar un nombre", "Buscar Producto", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Controlador.getInstance().accion(Evento.BUSCAR_PRODUCTO, nombre);
	}
	
	@Override
	public void actualizar(Evento e, Object datos) {		
	}
}
