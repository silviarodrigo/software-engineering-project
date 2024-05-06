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

import negocio.Facturas.TDatosVenta;
import negocio.Facturas.TFactura;
import negocio.Facturas.TLineaFactura;
import presentacion.Evento;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;

public class VistaCerrarVenta extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	private JTextField _tFIdCliente;
	private JTextField _tFIdVendedor;
	private JTextField _tFFecha;

	public VistaCerrarVenta() {
		initGUI();
	}

	void initGUI() {
		setTitle("Cerrar Venta");

		JPanel _mainPanel = new JPanel();
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));

		JPanel _anadirPanel = new JPanel();
		_anadirPanel.setLayout(new BoxLayout(_anadirPanel, BoxLayout.Y_AXIS));
		setContentPane(_mainPanel);
		_mainPanel.add(_anadirPanel);

		JLabel idClienteLabel = new JLabel("Id cliente: ");
		_tFIdCliente = new JTextField();
		_tFIdCliente.setPreferredSize(new Dimension(100, 20));
		JPanel clientePanel = new JPanel();
		clientePanel.add(idClienteLabel);
		clientePanel.add(_tFIdCliente);
		_anadirPanel.add(clientePanel);

		JLabel idVendedorLabel = new JLabel("Id vendedor: ");
		_tFIdVendedor = new JTextField();
		_tFIdVendedor.setPreferredSize(new Dimension(100, 20));
		JPanel vendedorPanel = new JPanel();
		vendedorPanel.add(idVendedorLabel);
		vendedorPanel.add(_tFIdVendedor);
		_anadirPanel.add(vendedorPanel);

		JLabel fechaLabel = new JLabel("Fecha: ");
		_tFFecha = new JTextField();
		_tFFecha.setPreferredSize(new Dimension(100, 20));
		JPanel fechaPanel = new JPanel();
		fechaPanel.add(fechaLabel);
		fechaPanel.add(_tFFecha);
		_anadirPanel.add(fechaPanel);

		JPanel btnPanel = new JPanel();
		JButton acceptBtn = new JButton("Aceptar");
		acceptBtn.addActionListener((e) -> {
			cerrarVenta();
			dispose();
		});
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener((e) -> dispose());
		btnPanel.add(acceptBtn);
		btnPanel.add(cancelBtn);
		_anadirPanel.add(btnPanel);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void cerrarVenta() {
		int id_cliente;
		int id_vendedor;
		String fecha;
		try {
			id_cliente = Integer.parseInt(this._tFIdCliente.getText());
			id_vendedor = Integer.parseInt(this._tFIdVendedor.getText());
			fecha = this._tFFecha.getText();
			TFactura factura = new TFactura(0, 0, new TDatosVenta(fecha, id_cliente, id_vendedor, null), true);
			Controlador.getInstance().accion(Evento.CERRAR_VENTA, factura);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Debes indicar un id valido", "Cerrar Venta",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizar(Evento e, Object datos) {
		switch (e) {
		case CERRAR_VENTA_SUCCESS:
			JOptionPane.showMessageDialog(this, "factura con id " + datos + " creada con exito.", "Cerrar venta",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
			break;
		case CERRAR_VENTA_ERROR:
			JOptionPane.showMessageDialog(this, "Error al cerrar la venta", "Cerrar venta", JOptionPane.ERROR_MESSAGE);
			dispose();
			break;
		default:
			break;
		}
	}
}
