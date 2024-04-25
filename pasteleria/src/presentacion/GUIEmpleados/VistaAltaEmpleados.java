package presentacion.GUIEmpleados;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import presentacionEmpleados.IGUI; interfaz grafica?

public class VistaAltaEmpleados extends JDialog implements IGUI{
	
	//ATRIBUTOS
	private JLabel etiquetaIdentificador;
	private JTextField tIdentificador;
	private JLabel etiquetaNombreApellido;
	private JTextField tNombreApellido;
	private JLabel etiquetaEmail;
	private JTextField tEmail;
	private JLabel etiquetaDireccion;
	private JTextField tDir;
	private JLabel etiquetaGenero;
	private JComboBox _generoComboBox;
	
	
	//botones
	private JButton buttonOkey;
	
	
	//Tenemos que guardar de cada empleado:
	//ID, NOMBRE&APELLIDO, EMAIL, DIRECCION, GENERO
	
	//constructora
	public VistaAltaEmpleados (Frame ventana) {
		super(ventana,true);
		setTitle("Alta Empleado");
		JPanel mainPanel= new JPanel();
		setContentPane(mainPanel);
		
		//creamos el borde del mainPanel
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		Box container= Box.createVerticalBox();
		
		JPanel empleado= new JPanel();
		empleado.setAlignmentX(CENTER_ALIGNMENT);
		JLabel etiqueta1= new JLabel("Datos empleado");
		//le ponemos la funete que queramos a la etiqueta
		etiqueta1.setFont(new Font("Serif", Font.BOLD,12));
		//añadimos al planel la etiqueta 
		empleado.add(etiqueta1);
		//añadimos al container la etiqueta
		
		container.add(empleado);
		
		//creamos otro panel, el del identificador
		JPanel panelIdentificador= new JPanel();
		//creamos otra etiqueta, la del id ´
		this.etiquetaIdentificador=new JLabel("id: ");
		//lo añadimos;
		panelIdentificador.add(etiquetaIdentificador);
		//como vamos a escribir el identifiador
		//creamos un JTextField
		this.tIdentificador= new JTextField(15);
		panelIdentificador.add(tIdentificador);
	
		//lo añadimos al container
		container.add(panelIdentificador);
		
		
		//creamos otro panel, el del nombre y apellido
		JPanel panelNombreApellido= new JPanel();
		//creamos otra etiqueta´
		this.etiquetaNombreApellido=new JLabel("Nombre: ");
		//lo añadimos;
		panelNombreApellido.add(etiquetaNombreApellido);
		//creamos un JTextField para rellenar la info

		this.tNombreApellido= new JTextField(15);
		panelNombreApellido.add(tNombreApellido);
		
		//lo añadimos al container
		container.add(panelNombreApellido);
		
		//PREGUNTAR SI PONER NOMBRE Y APELLIDOS JUNTOS?
		
		//creamos otro panel, el del email
		JPanel panelEmail= new JPanel();
		//creamos otra etiqueta ´
		this.etiquetaEmail=new JLabel("Email: ");
		//lo añadimos;
		panelEmail.add(etiquetaEmail);
		//creamos un JTextField para rellenar la info

		this.tEmail= new JTextField(15);
		panelEmail.add(tEmail);
		
		//lo añadimos al container
		container.add(panelEmail);
		
		
		//creamos otro panel, el de la direccion
		
		JPanel panelDireccion= new JPanel();
		//creamos otra etiqueta ´
		this.etiquetaDireccion=new JLabel("Direccion: ");
		//lo añadimos;
		panelDireccion.add(etiquetaDireccion);
		//creamos un JTextField para rellenar la info

		this.tDir= new JTextField(15);
		panelDireccion.add(tDir);
		
		//lo añadimos al container
		container.add(panelDireccion);
		
		
		//creamos un ComboBox para ver el genero
		JPanel panelComboBox= new JPanel();
		this.etiquetaGenero= new JLabel("Genero: ");
		panelComboBox.add(etiquetaGenero);
		//hacemos un comboBox;
		JComboBox _generoComboModel= new JComboBox();
		//la idea es meter en el _generoComboBox MASCULINO, FEMENINO, NO CONTESTA
		//HACERLO CON UN ARRAY?
		//PREGUNTAR ESTO
	    _generoComboBox= new JComboBox();
	    panelComboBox.add(_generoComboBox);
	    
	    
	    //tenemos que tener un boton de OK y otro de CANCELAR
	    //si falta algo de info por rellenar
	    //debe informar y lanzar error
	    
	    //CREAMOS LOS BOTONES DE OK Y CANCEL
	    
	    JPanel buttonOK= new JPanel();
	    buttonOK.setAlignmentX(CENTER_ALIGNMENT);
	    buttonOkey= new JButton("OK"); //¿SE PUEDE HACER ASI?
	    //O HAY QUE HACER ESTO:
	    buttonOkey.setText("OK");//PREGUNTAR
	    
	    
	    //Lo que puede suceder cuando pulsemos el boton de ok
	    buttonOkey.addActionListener((e)->{
	    	//tenemos que comprobar que ninguno de los JTextField esté sin rellenar
	    	//la comprobacion que se hace es preguntar si esta vacio
	    	if(tIdentificador.getText().isEmpty()||tNombreApellido.getText().isEmpty()||tEmail.getText().isEmpty()||tDir.getText().isEmpty()) {
	    		//MIRAR POR QUÉ ESTO NO FUNCIONA
	    		//JOptionPane.showMessageDialog(vistaAltaEmpleado.this,  "ERROR: Falta algun dato por rellenar", JOptionPane.ERROR_MESSAGE);
	    		
	    		
	    	}
	    	else {
	    		//has rellenado todo
	    		//deberia decir que ha guardado al empleado
	    		
	    	}
	    		
	    };
	    
	}
	
	
	
	
}