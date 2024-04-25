package presentacion.GUICliente;

import java.awt.*;

import javax.swing.*;

public class VistaPrincipalPresentacion extends JFrame {
	
	// Botones
	private JButton _baltacliente;
	private JButton _bbajacliente;
	private JButton _bbuscarcliente;
	private JButton _blistarcliente;
	private JButton _bactualizarcliente;
	
	// VIstas
	private VistaAltaCliente _valta;
	private VistaBajaCliente _vbaja;
	private VistaBuscarClientes _vbuscar;
	private VistaListarClientes _vlistar;
	private VistaActualizarCliente _vactualizar;

	public VistaPrincipalPresentacion() {
		initGUI();
	}

	private void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);

		// Incializamos botones.
		this._baltacliente = new JButton("Alta Cliente");
		this._bbajacliente = new JButton("Baja Cliente");
		this._bbuscarcliente = new JButton("Buscar Cliente");
		this._blistarcliente = new JButton("Listar Clientes");
		this._bactualizarcliente = new JButton("Actualizar Cliente");
		
		this._baltacliente.setPreferredSize(new Dimension(150, 50));
		this._bbajacliente.setPreferredSize(new Dimension(150, 50));
		this._bbuscarcliente.setPreferredSize(new Dimension(150, 50));
		this._blistarcliente.setPreferredSize(new Dimension(150, 50));
		this._bactualizarcliente.setPreferredSize(new Dimension(150, 50));

		// Añadimos listeners a los botones.
		this._baltacliente.addActionListener((e) -> altaListener());

		// Paneles donde colocaremos los botones.
		JPanel panelSuperior = new JPanel();
		JPanel panelInferior = new JPanel();

		// Añadimos botones al panel.
		panelSuperior.add(this._baltacliente);
		panelSuperior.add(this._bbajacliente);
		panelSuperior.add(this._bbuscarcliente);
		panelInferior.add(this._blistarcliente);
		panelInferior.add(this._bactualizarcliente);

		// Añadimos los paneles al panel principal.
		mainPanel.add(panelSuperior, BorderLayout.NORTH);
		mainPanel.add(panelInferior, BorderLayout.CENTER);
		
		// Inicializamos las vistas
		this._valta = new VistaAltaCliente();

		//mainPanel.setBackground(loadImage("resources/maxresdefault.jpg"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 250));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void altaListener() {
		SwingUtilities.invokeLater(() -> this._valta.open());
	}

	private void bajaListener() {

	}

	private void buscarListener() {

	}

	private void listarListener() {

	}

	private void actualizarListener() {

	}
	
	// EXTRA
	private ImageIcon loadImage(String path) {
		return new ImageIcon(Toolkit.getDefaultToolkit().createImage(path));
	}

}
