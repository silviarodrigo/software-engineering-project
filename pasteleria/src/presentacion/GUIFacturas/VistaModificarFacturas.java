package presentacion.GUIFacturas;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Facturas.TFactura;
import negocio.Facturas.TDatosVenta;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import presentacion.Evento;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;

public class VistaModificarFacturas extends JFrame implements IGUI {

	private JTextField _tFIdFactura;
	private JTextField _tFIdVendedor;
	private JTextField _tFIdCliente;
	private JTextField _tFFecha;

	public VistaModificarFacturas() {
		initGUI();
	}

	private void initGUI() {
		setTitle("Modificar Factura");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);

		// Campos comunes
		JLabel idFacturaLabel = new JLabel("Id factura: ");
		_tFIdFactura = new JTextField();
		_tFIdFactura.setPreferredSize(new Dimension(100, 20));
		JPanel idFacturaPanel = new JPanel();
		idFacturaPanel.add(idFacturaLabel);
		idFacturaPanel.add(_tFIdFactura);
		mainPanel.add(idFacturaPanel);

		JLabel idClienteLabel = new JLabel("Id cliente: ");
		_tFIdCliente = new JTextField();
		_tFIdCliente.setPreferredSize(new Dimension(100, 20));
		JPanel idClientePanel = new JPanel();
		idClientePanel.add(idClienteLabel);
		idClientePanel.add(_tFIdCliente);
		mainPanel.add(idClientePanel);

		JLabel idVendedorLabel = new JLabel("Id vendedor: ");
		_tFIdVendedor = new JTextField();
		_tFIdVendedor.setPreferredSize(new Dimension(100, 20));
		JPanel idVendedorPanel = new JPanel();
		idVendedorPanel.add(idVendedorLabel);
		idVendedorPanel.add(_tFIdVendedor);
		mainPanel.add(idVendedorPanel);

		JLabel fechaLabel = new JLabel("Fecha: ");
		_tFFecha = new JTextField();
		_tFFecha.setPreferredSize(new Dimension(100, 20));
		JPanel fechaPanel = new JPanel();
		fechaPanel.add(fechaLabel);
		fechaPanel.add(_tFFecha);
		mainPanel.add(fechaPanel);

		JPanel endPanel = new JPanel();
		JButton acceptBtn = new JButton("Aceptar");
		acceptBtn.addActionListener((e) -> modificarFactura());
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener((e) -> dispose());
		endPanel.add(acceptBtn);
		endPanel.add(cancelBtn);
		mainPanel.add(endPanel);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void modificarFactura() {

		int id_factura;
		try {
			id_factura = Integer.parseInt(this._tFIdFactura.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Debes indicar un id de factura valido", "Modificar Factura",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int id_vendedor;
		try {
			id_vendedor = Integer.parseInt(this._tFIdVendedor.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Debes indicar un id de vendedor valido", "Modificar Factura",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int id_cliente;
		try {
			id_cliente = Integer.parseInt(this._tFIdCliente.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Debes indicar un id de cliente valido", "Modificar Factura",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		String fecha = _tFFecha.getText();
		if (fecha == null || fecha.equals("")) {
			JOptionPane.showMessageDialog(this, "Debes indicar una fecha valida", "Modificar Factura",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		TFactura factura = new TFactura(id_factura, 0, new TDatosVenta(fecha, id_cliente, id_vendedor, null), true);
		Controlador.getInstance().accion(Evento.MODIFICAR_FACTURA, factura);

	}

	@Override
	public void actualizar(Evento e, Object datos) {
		switch (e) {
		case MODIFICAR_FACTURA_SUCCESS:
			JOptionPane.showMessageDialog(this, "factura con id " + datos + " modificada con éxito.",
					"Modificar Factura", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			break;
		case MODIFICAR_FACTURA_ERROR:
			JOptionPane.showMessageDialog(this, "Error al modificar la factura: " + datos, "Modificar Factura",
					JOptionPane.ERROR_MESSAGE);
			dispose();
			break;
		default:
			break;
		}
	}

}
