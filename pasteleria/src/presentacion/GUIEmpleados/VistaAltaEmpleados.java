package presentacion.GUIEmpleados;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
//import presentacionEmpleados.IGUI; interfaz grafica?

public class VistaAltaEmpleados extends JDialog {

	// ATRIBUTOS
	private JLabel etiquetaIdentificador;
	private JTextField textoIdentificador;

	private JLabel etiquetaNombreApellido;
	private JTextField textoNombreApellido;
	
	private JLabel etiquetaTelefono;
	private JTextField textoTelefono;

	private JLabel etiquetaEmail;
	private JTextField textoEmail;

	private JLabel etiquetaDireccion;
	private JTextField textoDireccion;

	private JLabel etiquetaNumero;
	private JTextField etiquetaNum;

	// botones
	private JButton buttonOkey;
	private JButton buttonCancel;
	

	VistaAltaEmpleados() {
		initGUI();
	}

	private void initGUI() {

    	
    		JPanel mainPanel= new JPanel();
    		setContentPane(mainPanel);
    		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));;
  
    		
    		//IDENTIFICADOR
    		JPanel panelIdentificador= new JPanel();
    		this.etiquetaIdentificador=new JLabel("id: ");
    		this.textoIdentificador= new JTextField(15);
    		panelIdentificador.add(etiquetaIdentificador);
    		panelIdentificador.add(textoIdentificador);
    		
    		
    		//NOMBRE&APELLIDOS
    		JPanel panelNombreApellido= new JPanel();
    		this.etiquetaNombreApellido= new JLabel("Nombre y Apellido: ");
            this.textoNombreApellido=new JTextField(15);
            panelNombreApellido.add(etiquetaNombreApellido);
            panelNombreApellido.add(textoIdentificador);
    	
            
            
    		//TELÉFONO
            JPanel panelTelefono= new JPanel();
            this.etiquetaTelefono= new JLabel();
            this.textoTelefono= new JTextField(15);
            panelTelefono.add(etiquetaTelefono);
            panelTelefono.add(textoTelefono);
            
            
            
            //EMAIL
            JPanel panelEmail= new JPanel();
            this.etiquetaEmail= new JLabel();
            this.textoEmail= new JTextField(15);
            panelTelefono.add(etiquetaEmail);
            panelTelefono.add(textoEmail);
            
            
            
            //DIRECCION
            JPanel panelDireccion= new JPanel();
            this.etiquetaDireccion= new JLabel();
            this.textoDireccion= new JTextField(15);
            panelTelefono.add(etiquetaDireccion);
            panelTelefono.add(textoDireccion);
            
            
            //AÑADIMOS TODOS LOS PANELES AL main_Panel
            mainPanel.add(panelIdentificador);
            mainPanel.add(panelNombreApellido);
            mainPanel.add(panelTelefono);
            mainPanel.add(panelEmail);
            mainPanel.add(panelDireccion);
            
            
            
            //CREAMOS LOS BOTONES DE OK Y CANCEL
            
            //BUTTON OKEY
            JPanel okCancelPanel= new JPanel();
            this.buttonOkey= new JButton("Aceptar");
            this.buttonOkey.addActionListener((e)->{
            	okImp();
            });
           
            okCancelPanel.add(buttonOkey);
            
            //BUTTON CANCEL
            
         
            this.buttonCancel= new JButton("Cancelar");
            this.buttonCancel.addActionListener((e)->{
            	cancelImp();
            });
    		
            okCancelPanel.add(buttonCancel);
            
            //añadimos ambos botones (ok y cancel) al main_panel
            mainPanel.add(okCancelPanel);
         
    		
    	}
	 public void open() {
			pack();
			this.setLocationRelativeTo(null);
			setVisible(true);
		}
		
		private void okImp() {
			SwingUtilities.invokeLater(()->{
				setVisible(false);
			});
			
		}
		
		private void cancelImp() {
			SwingUtilities.invokeLater(()->{
				setVisible(false);
			});
		}

}

