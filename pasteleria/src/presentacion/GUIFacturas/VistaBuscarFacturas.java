package presentacion.GUIFacturas;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Producto.TProducto;
import negocio.Producto.TDulce;
import negocio.Producto.TPan;
import negocio.Facturas.TDatosVenta;
import negocio.Facturas.TFactura;
import negocio.Facturas.TLineaFactura;
import negocio.Producto.TBebida;
import presentacion.Evento;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;

public class VistaBuscarFacturas extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;
	JTextField _tFIdFactura;
	JPanel _pedirIdFacturaPanel;
	JPanel _infoPanel;
	JPanel _mainPanel;

	public VistaBuscarFacturas() {
		initGUI();
	}

	void initGUI() {
		setTitle("Buscar Factura");

		_mainPanel = new JPanel();
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));
		_pedirIdFacturaPanel = new JPanel();
		_pedirIdFacturaPanel.setLayout(new BoxLayout(_pedirIdFacturaPanel, BoxLayout.Y_AXIS));
		setContentPane(_mainPanel);
		_mainPanel.add(_pedirIdFacturaPanel);

		_tFIdFactura = new JTextField();
		_tFIdFactura.setPreferredSize(new Dimension(100, 20));
		JPanel idFacturaPanel = new JPanel();
		idFacturaPanel.add(new JLabel("Id factura: "));
		idFacturaPanel.add(_tFIdFactura);
		_pedirIdFacturaPanel.add(idFacturaPanel);

		JPanel btnPanel = new JPanel();
		JButton acceptBtn = new JButton("Buscar");
		acceptBtn.addActionListener((e) -> buscarFactura());

		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener((e) -> dispose());

		btnPanel.add(acceptBtn);
		btnPanel.add(cancelBtn);
		_pedirIdFacturaPanel.add(btnPanel);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	void initInfoGUI(TFactura factura) {

		_infoPanel = new JPanel();
		_infoPanel.setLayout(new BoxLayout(_infoPanel, BoxLayout.Y_AXIS));
		_mainPanel.add(_infoPanel);

		if (!factura.getActivo()) {
			JLabel mensajeErrorLabel = new JLabel("Factura no existente");
			_infoPanel.add(mensajeErrorLabel);
		} else {
			TDatosVenta datos_venta = factura.getDatosVentas();
			JLabel idLabel = new JLabel("Id: " + factura.getIdFactura());
			JLabel precioLabel = new JLabel("Precio: " + factura.getPrecio_total());
			JLabel fechaLabel = new JLabel("Fecha: " + datos_venta.getFecha());
			JLabel id_clienteLabel = new JLabel("Id cliente: " + datos_venta.getIdCliente());
			JLabel id_vendedor = new JLabel("Id vendedor: " + datos_venta.getIdVendedor());
			_infoPanel.add(idLabel);
			_infoPanel.add(precioLabel);
			_infoPanel.add(fechaLabel);
			_infoPanel.add(id_clienteLabel);
			_infoPanel.add(id_vendedor);
			for (TLineaFactura lf : datos_venta.getProductos()) {
				if (lf.getActivo()) {
					JLabel idlineaLabel = new JLabel("Id linea: " + lf.getIdLinea());
					JLabel productoLabel = new JLabel("Id producto: " + lf.getIdProducto());
					JLabel cantidadLabel = new JLabel("Cantidad: " + lf.getCantidad());
					_infoPanel.add(idlineaLabel);
					_infoPanel.add(productoLabel);
					_infoPanel.add(cantidadLabel);
				}
			}
		}

		JButton continuarBtn = new JButton("Continuar");
		continuarBtn.addActionListener((e) -> dispose());
		_infoPanel.add(continuarBtn);

		pack();
	}

	private void buscarFactura() {
		int id_factura;
		try {
			id_factura = Integer.parseInt(this._tFIdFactura.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Debes indicar un id de factura valido", "Buscar Factura", JOptionPane.ERROR_MESSAGE);
			return;
		}

		Controlador.getInstance().accion(Evento.BUSCAR_FACTURA, id_factura);
	}

	@Override
	public void actualizar(Evento e, Object datos) {
		switch (e) {
		case BUSCAR_FACTURA_SUCCESS:
			_pedirIdFacturaPanel.setVisible(false);
			initInfoGUI((TFactura) datos);
			break;
		case BUSCAR_FACTURA_ERROR:
			JOptionPane.showMessageDialog(this, "ERROR: " + datos, "Buscar Factura", JOptionPane.ERROR_MESSAGE);
			dispose();
			break;
		default:
			break;
		}
	}
}
