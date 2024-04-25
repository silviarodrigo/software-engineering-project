package presentacion.GUICliente;

import java.awt.*;
import javax.swing.*;

public class VistaAltaCliente extends JDialog{
	
	// Etiquetas
	private JLabel _lnombre;
	private JLabel _lapellidos;
	private JLabel _ldni;
	private JLabel _lcorreo;
	private JLabel _ltelefono;
	private JLabel _ldireccion;
	
	// Text Fields
	private JTextField _tfnombre;
	private JTextField _tfapellidos;
	private JTextField _tfdni;
	private JTextField _tfcorreo;
	private JTextField _tftelefono;
	private JTextField _tfdireccion;
	
	// Botones
	private JButton _baceptar;
	private JButton _bcancelar;

	public VistaAltaCliente() {
		initGUI();
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.setContentPane(mainPanel);
		
		// Inicializamos JLabels.
		this._lnombre = new JLabel("Nombre:");
		this._lapellidos = new JLabel("Apellidos:");
		this._ldni = new JLabel("DNI:");
		this._lcorreo = new JLabel("Correo:");
		this._ltelefono= new JLabel("Telefono:");
		this._ldireccion= new JLabel("Dirección:");
		
		// Inicializamos JTextFields.
		this._tfnombre = new JTextField();
		this._tfapellidos = new JTextField();
		this._tfdni = new JTextField();
		this._tfcorreo = new JTextField();
		this._tftelefono = new JTextField();
		this._tfdireccion = new JTextField();
		
		this._tfnombre.setPreferredSize(new Dimension(100, 50));
		this._tfapellidos.setPreferredSize(new Dimension(100, 50));
		this._tfdni.setPreferredSize(new Dimension(100, 50));
		this._tfcorreo.setPreferredSize(new Dimension(100, 50));
		this._tftelefono.setPreferredSize(new Dimension(100, 50));
		this._tfdireccion.setPreferredSize(new Dimension(100, 50));
		
		// Inicializamos botones
		this._baceptar = new JButton("ACEPTAR");
		this._bcancelar = new JButton("CANCELAR");
		this._baceptar.addActionListener((e) -> acceptListener());
		this._bcancelar.addActionListener((e) -> cancelListener());
		
		// Creamos paneles para colocar cada Label con su TextField.
		JPanel pnombre = new JPanel(new FlowLayout());
		JPanel papellidos = new JPanel(new FlowLayout());
		JPanel pdni = new JPanel(new FlowLayout());
		JPanel pcorreo = new JPanel(new FlowLayout());
		JPanel ptelefono = new JPanel(new FlowLayout());
		JPanel pdireccion = new JPanel(new FlowLayout());
		
		// Creamos panel para los botones
		JPanel buttonPanel = new JPanel();
		
		// Añdimos los campos a los paneles.
		pnombre.add(this._lnombre);
		pnombre.add(this._tfnombre);
		papellidos.add(this._lapellidos);
		papellidos.add(this._tfapellidos);
		pdni.add(this._ldni);
		pdni.add(this._tfdni);
		pcorreo.add(this._lcorreo);
		pcorreo.add(this._tfcorreo);
		ptelefono.add(this._ltelefono);
		ptelefono.add(this._tftelefono);
		pdireccion.add(this._ldireccion);
		pdireccion.add(this._tfdireccion);
		
		buttonPanel.add(this._baceptar);
		buttonPanel.add(Box.createRigidArea(new Dimension(30, 20)));
		buttonPanel.add(this._bcancelar);
		
		// Añadimos paneles al panel principal
		mainPanel.add(pnombre);
		mainPanel.add(papellidos);
		mainPanel.add(pdni);
		mainPanel.add(pcorreo);
		mainPanel.add(ptelefono);
		mainPanel.add(pdireccion);
		mainPanel.add(buttonPanel);
		
		setPreferredSize(new Dimension (600, 500));
		//pack();
		//setLocationRelativeTo(null);
		//setVisible(true);
	}
	
	private void cancelListener() {
		SwingUtilities.invokeLater(() -> setVisible(false));
	}
	
	// HACER
	private void acceptListener() {
		
		SwingUtilities.invokeLater(() -> setVisible(false));
	}
	
	public void open() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
