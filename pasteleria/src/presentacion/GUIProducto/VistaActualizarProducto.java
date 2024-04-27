package presentacion.GUIProducto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;


import presentacion.Evento;
import presentacion.IGUI;

public class VistaActualizarProducto extends JDialog implements IGUI {

	public VistaActualizarProducto() {
		initGUI();
	}
	
	private void initGUI() {
		setTitle("Actualizar Producto");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		//Campos comunes
		JLabel nombreLabel = new JLabel("Nombre: ");
		JTextField tFNombre = new JTextField();
		tFNombre.setPreferredSize(new Dimension(100, 20));
		JPanel nombrePanel = new JPanel();
		nombrePanel.add(nombreLabel);
		nombrePanel.add(tFNombre);
		mainPanel.add(nombrePanel);
		
		JLabel stockLabel = new JLabel("Stock: ");
		JTextField tFStock = new JTextField();
		tFStock.setPreferredSize(new Dimension(100, 20));
		JPanel stockPanel = new JPanel();
		stockPanel.add(stockLabel);
		stockPanel.add(tFStock);
		mainPanel.add(stockPanel);
		
		JLabel precioLabel = new JLabel("Precio: ");
		JTextField tFPrecio = new JTextField();
		tFPrecio.setPreferredSize(new Dimension(100, 20));
		JPanel precioPanel = new JPanel();
		precioPanel.add(precioLabel);
		precioPanel.add(tFPrecio);
		mainPanel.add(precioPanel);
		
		JLabel alergenosLabel = new JLabel("Alérgenos: ");
		JTextField tFAlergenos = new JTextField();
		tFAlergenos.setPreferredSize(new Dimension(100, 20));
		JPanel alergenosPanel = new JPanel();
		alergenosPanel.add(alergenosLabel);
		alergenosPanel.add(tFAlergenos);
		mainPanel.add(alergenosPanel);
		
		//Seleccionar tipo
		JPanel tipoPanel = new JPanel();
		mainPanel.add(tipoPanel);
		ButtonGroup btnGrp = new ButtonGroup();
		JRadioButton dulceRB = new JRadioButton();
		// Como tiene que seleccionarse uno obligatoriamente, dejamos dulce seleccionado por defecto
		dulceRB.setSelected(true);
		JRadioButton panRB = new JRadioButton();
		JRadioButton bebidaRB = new JRadioButton();
		
		btnGrp.add(dulceRB);
		btnGrp.add(panRB);
		btnGrp.add(bebidaRB);
		
		tipoPanel.add(dulceRB);
		tipoPanel.add(panRB);
		tipoPanel.add(bebidaRB);
		
		dulceRB.setText("dulce");
		panRB.setText("pan");
		bebidaRB.setText("bebida");

		CardLayout cL = new CardLayout();
		
		JPanel specificPanel = new JPanel();
		specificPanel.setLayout(cL);
		JPanel dulcePanel = new JPanel();
		JPanel panPanel = new JPanel();
		JPanel bebidaPanel = new JPanel();
		mainPanel.add(specificPanel);
		
		specificPanel.add(dulcePanel, "dulce");
		specificPanel.add(panPanel, "pan");
		specificPanel.add(bebidaPanel, "bebida");
		
		JLabel rellenoLabel = new JLabel("Relleno: ");
		JTextField tFRelleno = new JTextField();
		tFRelleno.setPreferredSize(new Dimension(100, 20));
		dulcePanel.add(rellenoLabel);
		dulcePanel.add(tFRelleno);
		

		JCheckBox salCB = new JCheckBox("Con Sal", false);
		JCheckBox integralCB = new JCheckBox("Integral", false);
		panPanel.add(salCB);
		panPanel.add(integralCB);

		
		JLabel tamanyoLabel = new JLabel("Tamaño: ");
		JTextField tFTamanyo = new JTextField();
		tFTamanyo.setPreferredSize(new Dimension(100, 20));
		bebidaPanel.add(tamanyoLabel);
		bebidaPanel.add(tFTamanyo);
		
		
		// Enseñamos dulce por defecto
		cL.show(specificPanel, "dulce");
		
		dulceRB.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	    		cL.show(specificPanel, "dulce");
	        }
	    });
		
		panRB.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	    		cL.show(specificPanel, "pan");
	        }
	    });
		
		bebidaRB.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	    		cL.show(specificPanel, "bebida");
	        }
	    });
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	@Override
	public void actualizar(Evento e, Object datos) {
	}

}
