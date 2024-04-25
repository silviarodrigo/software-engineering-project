package presentacion.GUIProveedores;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class VistaAltaProveedor extends JDialog {

	
	//vamos a tener atributos para cada información que le queramos pedir del proveedor
	//por lo que vamos a tener JLabel y JTextFeild
	//y a suvez vamos a tener un panel por cada par label text
	
	
	JLabel _nombreLabel;
	JTextField _nombreText;
	JPanel _nombrePanel;
	
	JLabel _codigoPostalLabel;
	JTextField _codigoPostalText;
	JPanel _codigoPostalPanel;
	
	JLabel _telefonoLabel;
	JTextField _telefonoText;
	JPanel _telefonoPanel;
	
	
	
	//botones ok y cancel
	JButton _okButton;
	JButton _cancelButton;
	JPanel _okCancelPanel;
	
	vistaAltaProveedor(){
		initGUI();
	}
	
	//componentes gráficos
		private void initGUI() {
			
			JPanel mainVistaAltaPanel = new JPanel();
			this.setContentPane(mainVistaAltaPanel);
			mainVistaAltaPanel.setLayout(new BoxLayout(mainVistaAltaPanel,BoxLayout.Y_AXIS));
			//mainVistaAltaPanel.setSize(500,500);
			
			//CREAMOS tuplaS LABEL-TEXT-panel
			
			//NOMBRE
			_nombreLabel = new JLabel("Nombre: ");
			_nombreText = new JTextField();
			_nombreText.setPreferredSize(new Dimension(50, 25));
			_nombrePanel = new JPanel(new FlowLayout());
			_nombrePanel.add(_nombreLabel);
			_nombrePanel.add(_nombreText);
			
			mainVistaAltaPanel.add(_nombrePanel);
			
			//TELEFONO
			_telefonoLabel = new JLabel("Teléfono: ");
			_telefonoText = new JTextField();
			_telefonoText.setPreferredSize(new Dimension(50, 25));
			_telefonoPanel = new JPanel(new FlowLayout());
			_telefonoPanel.add(_telefonoLabel);
			_telefonoPanel.add(_telefonoText);
			
			mainVistaAltaPanel.add(_telefonoPanel);
			
			//CODIGO POSTAL
			
			_codigoPostalLabel = new JLabel("Código Postal: ");
			_codigoPostalText = new JTextField();
			_codigoPostalText.setPreferredSize(new Dimension(50, 25));
			_codigoPostalPanel = new JPanel(new FlowLayout());
			_codigoPostalPanel.add(_codigoPostalLabel);
			_codigoPostalPanel.add(_codigoPostalText);
			
			mainVistaAltaPanel.add(_codigoPostalPanel);
			
			
			//AÑADIMOS 2 BOTONES de ok y canel
			_okCancelPanel = new JPanel(new FlowLayout());
			_okButton = new JButton("Aceptar");
			_okButton.addActionListener((e)->{
				okImp();	
			});
			_okCancelPanel.add(_okButton);
			
			_cancelButton = new JButton("Cancelar");
			_cancelButton.addActionListener((e)->{
				cancelImp();	
			});
			_okCancelPanel.add(_cancelButton);
			
			mainVistaAltaPanel.add(_okCancelPanel);
			
			
			
			
			//metodos no necesarios pues los ponemos en el open
			//pack();
			
			//setSize(500,500);
			//setVisible(true);
			
			
			
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
