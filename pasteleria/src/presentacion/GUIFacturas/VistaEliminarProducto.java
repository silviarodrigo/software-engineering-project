package presentacion.GUIFacturas;

import java.awt.Dimension;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import negocio.Facturas.TFactura;
import negocio.Facturas.TLineaFactura;
import presentacion.Evento;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;

public class VistaEliminarProducto extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	private JTextField _tFIdProducto;
	private JSpinner _jSCantidad;

	public VistaEliminarProducto() {
		initGUI();
	}

	void initGUI() {
		setTitle("Eliminar Producto");

		JPanel _mainPanel = new JPanel();
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));

		JPanel _anadirPanel = new JPanel();
		_anadirPanel.setLayout(new BoxLayout(_anadirPanel, BoxLayout.Y_AXIS));
		setContentPane(_mainPanel);
		_mainPanel.add(_anadirPanel);

		JLabel idLabel = new JLabel("Id producto: ");
		_tFIdProducto = new JTextField();
		_tFIdProducto.setPreferredSize(new Dimension(100, 20));
		JPanel nombrePanel = new JPanel();
		nombrePanel.add(idLabel);
		nombrePanel.add(_tFIdProducto);
		_anadirPanel.add(nombrePanel);

		JLabel cantidadLabel = new JLabel("Cantidad: ");
		_jSCantidad = new JSpinner();
		_jSCantidad.setPreferredSize(new Dimension(100, 20));
		JPanel cantidadPanel = new JPanel();
		cantidadPanel.add(cantidadLabel);
		cantidadPanel.add(_jSCantidad);
		_anadirPanel.add(cantidadPanel);

		JPanel btnPanel = new JPanel();
		JButton acceptBtn = new JButton("Aceptar");
		acceptBtn.addActionListener(
				(e) -> eliminarProducto(this._tFIdProducto.getText(), this._jSCantidad.getValue().toString()));
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener((e) -> dispose());
		btnPanel.add(acceptBtn);
		btnPanel.add(cancelBtn);
		_anadirPanel.add(btnPanel);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void eliminarProducto(String id_producto, String cant) {
		int id_prod;
		int cantidad;
		try {
			id_prod = Integer.parseInt(id_producto);
			cantidad = Integer.parseInt(cant);
			if (cantidad <= 0) {
				JOptionPane.showMessageDialog(this, "Debes indicar una cantidad valida", "Eliminar Producto",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			TLineaFactura linea = new TLineaFactura(id_prod, 0, 0, cantidad);
			Controlador.getInstance().accion(Evento.BUSCAR_PRODUCTO, linea);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Debes indicar un id de producto valido", "Eliminar Producto",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizar(Evento e, Object datos) {
		switch (e) {
		case ELIMINAR_PRODUCTO_SUCCESS:
			JOptionPane.showMessageDialog(this, datos, "Eliminar Producto", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			break;
		case ELIMINAR_PRODUCTO_ERROR:
			JOptionPane.showMessageDialog(this, datos, "Eliminar Producto", JOptionPane.ERROR_MESSAGE);
			dispose();
			break;
		default:
			break;
		}
	}
}
