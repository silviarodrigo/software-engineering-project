package presentacion.GUIEmpleados;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import negocio.Empleados.TEmpleado;
import presentacion.Evento;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;

public class VistaBuscarEmpleado extends JDialog implements IGUI {


	private static final long serialVersionUID = 1L;
	JSpinner idEmployee;
	JButton buttonOkey;
	JButton buttonCancel;
	JPanel _idPanel;
	JPanel _DNIpanel;
	JPanel _infoEmpleadoPanel;
	JPanel _mainPanel;

	public VistaBuscarEmpleado() {
		initGUI();
	}

	void initGUI() {
		setTitle("Buscar Empleado");

		_mainPanel = new JPanel();
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));

		// buscamos siempre por ID a los empleados
		// el ID va a ser único
		_idPanel = new JPanel();
		_idPanel.setLayout(new BoxLayout(_idPanel, BoxLayout.Y_AXIS));
		setContentPane(_mainPanel);

		// vamos a poner un JSpinner, y vamos despues a añadirlo todo
		JLabel idLabel = new JLabel("Id: ");
		idEmployee = new JSpinner(new SpinnerNumberModel(0, 0, 3000, 1));
		idEmployee.setPreferredSize(new Dimension(100, 20));
		JPanel insertID = new JPanel();
		insertID.add(idLabel);
		insertID.add(idEmployee);
		_idPanel.add(insertID);

		_mainPanel.add(_idPanel); // no se si ponerlo antes o despues

		// BUTTON OKEY
		JPanel okCancelPanel = new JPanel();
		this.buttonOkey = new JButton("Aceptar");
		this.buttonOkey.addActionListener((e) -> {
			buscarEmpleado();
		});

		okCancelPanel.add(buttonOkey);

		// BUTTON CANCEL
		this.buttonCancel = new JButton("Cancelar");
		this.buttonCancel.addActionListener((e) -> {
			cancelImp(); // a lo mejor retocar esto?
		});

		okCancelPanel.add(buttonCancel);

		// añadimos ambos botones (ok y cancel) al main_panel
		_mainPanel.add(okCancelPanel);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	void infoEmpleado(TEmpleado empleado) {
		
		//creamos un panel de info del empleado
		//en este panel mostraremos toda la info del empleado
		//en el caso de que la funcion buscar_Empleado tenga exito
		
		_infoEmpleadoPanel = new JPanel();
		_infoEmpleadoPanel.setLayout(new BoxLayout(_infoEmpleadoPanel, BoxLayout.Y_AXIS));
		_mainPanel.add(_infoEmpleadoPanel);

		JLabel idEmpleadoEtiqueta = new JLabel("Id: " + empleado.getId());
		JLabel nombreEmpleadoEtiqueta = new JLabel("Nombre: " + empleado.getNombre());
		JLabel apellidoEmpleadoEtiqueta = new JLabel("Apellido: " + empleado.getApellido());
		JLabel DNIEmpleadoEtiqueta= new JLabel("DNI: "+ empleado.getDNI());
		JLabel DireccionEmpleadoEtiqueta = new JLabel("Direccion: " + empleado.getDireccion());
		JLabel EmailEmpleadoEtiqueta = new JLabel("Email: " + empleado.getCorreo());
		JLabel numeroTelefonoEmpleadoEtiqueta = new JLabel("Email: " + empleado.getNumTelefono());
		
		_infoEmpleadoPanel.add(idEmpleadoEtiqueta);
		_infoEmpleadoPanel.add(nombreEmpleadoEtiqueta);
		_infoEmpleadoPanel.add(apellidoEmpleadoEtiqueta);
		_infoEmpleadoPanel.add(DNIEmpleadoEtiqueta);
		_infoEmpleadoPanel.add(DireccionEmpleadoEtiqueta);
		_infoEmpleadoPanel.add(EmailEmpleadoEtiqueta);
		_infoEmpleadoPanel.add(numeroTelefonoEmpleadoEtiqueta);
		//poner tb numVentasEmpleado???

		
		//añadir boton de continuar????
		//o no hace falta 
		pack();
	}

	private void buscarEmpleado() {
		//buscaremos al empleado por su ID
		//cada empleado tiene un ID unico
		int id = (int) idEmployee.getValue();
		Controlador.getInstance().accion(Evento.BUSCAR_MARCA, id);
	}
	

	private void cancelImp() {
		SwingUtilities.invokeLater(() -> {
			setVisible(false); //libera todos los componentes
		});
	}


	@Override
	public void actualizar(Evento e, Object datos) {
		switch (e) {
		case BUSCAR_EMPLEADO_EXITO:
			_idPanel.setVisible(false);
			infoEmpleado((TEmpleado) datos);
			break;
		case BUSCAR_EMPLEADO_ERROR:
			JOptionPane.showMessageDialog(this, "ERROR:No se ha encontrado al empleado " + datos, "Buscar Empleado", JOptionPane.ERROR_MESSAGE);
			dispose();
			break;
		default:
			break;
		}
	}

}
