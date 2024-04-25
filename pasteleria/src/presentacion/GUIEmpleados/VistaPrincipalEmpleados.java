package presentacion.GUIEmpleados;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VistaPrincipalEmpleados extends JDialog{

	
	//tendremos botones por cada caso de uso
	JButton _altaEmpleadoButton;
	JButton _bajaEmpleadoButton;
	JButton _buscarEmpleadoButton;
	JButton _listarEmpleadoButton;
	JButton _modificarEmpleadoButton;
	
	VistaAltaEmpleados _vistaAlta;
	VistaBajaEmpleado _vistaBaja;
	
	
	
	VistaPrincipalEmpleados(){
		initGUI();
	}
	
	
	private void initGUI() {
		
		JPanel mainPanel= new JPanel(new BorderLayout());
		setContentPane(mainPanel);
		
		
		//la vista principal tiene que tener los 5 botones
		
		JPanel panelArriba= new JPanel();
		//lo añado al "norte"
		mainPanel.add(panelArriba, BorderLayout.PAGE_START);
		
		
		JPanel panelAbajo= new JPanel();
		mainPanel.add(panelAbajo);
		
		
		//creamos botones de alta,baja,modificar,listar,actualizar (empleados)
		_altaEmpleadoButton= new JButton("Alta empleado");
		_bajaEmpleadoButton= new JButton("Baja empleado");
		_buscarEmpleadoButton= new JButton("Buscar empleado");
		_listarEmpleadoButton= new JButton("Listar empleado");
		_modificarEmpleadoButton= new JButton("Modificar empleado");
		
		
		panelArriba.add(_altaEmpleadoButton);
		
		_altaEmpleadoButton.addActionListener((e)->{
			//llamamos a su vista;
			this.altaImplementacion();
			
			
		});
	
		
		panelArriba.add(_bajaEmpleadoButton);
		
		_bajaEmpleadoButton.addActionListener((e)->{
			//llamamos a su vista;
			this.bajaImplementacion();
			
			
		});
		
		
		panelArriba.add(_buscarEmpleadoButton);
		panelAbajo.add(_listarEmpleadoButton);
		panelAbajo.add(_modificarEmpleadoButton);
		
		
	
		
		
	}


	private void setContentPane(JPanel mainPanel) {
		// TODO Auto-generated method stub
		
	}
	
	private void altaImplementacion() {
		SwingUtilities.invokeLater(()->{
			_vistaAlta.open();
		});
	}
	
	private void bajaImplementacion() {
		SwingUtilities.invokeLater(()->{
			//_vistaBaja.open();
		});
	}
	
	
	
	
	
}
