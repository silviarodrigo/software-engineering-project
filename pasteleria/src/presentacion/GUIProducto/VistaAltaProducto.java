package presentacion.GUIProducto;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import negocio.Producto.TBebida;
import negocio.Producto.TDulce;
import negocio.Producto.TPan;
import negocio.Producto.TProducto;
import presentacion.Evento;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;

public class VistaAltaProducto extends JDialog implements IGUI {

	private JTextField _tFNombre;
	private JTextField _tFPrecio;
	private JTextField _tFStock;
	private JTextField _tFAlergenos;
	private JRadioButton _dulceRB;
	private JRadioButton _panRB;
	private JRadioButton _bebidaRB;
	private JTextField _tFRelleno;
	private JCheckBox _salCB;
	private JCheckBox _integralCB;
	private JTextField _tFTamanyo;

		
	public VistaAltaProducto() {
		initGUI();
	}
	
	private void initGUI() {
		setTitle("Alta Producto");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		//Campos comunes
		JLabel nombreLabel = new JLabel("Nombre: ");
		_tFNombre = new JTextField();
		_tFNombre.setPreferredSize(new Dimension(100, 20));
		JPanel nombrePanel = new JPanel();
		nombrePanel.add(nombreLabel);
		nombrePanel.add(_tFNombre);
		mainPanel.add(nombrePanel);
		
		JLabel stockLabel = new JLabel("Stock: ");
		_tFStock = new JTextField();
		_tFStock.setPreferredSize(new Dimension(100, 20));
		JPanel stockPanel = new JPanel();
		stockPanel.add(stockLabel);
		stockPanel.add(_tFStock);
		mainPanel.add(stockPanel);
		
		JLabel precioLabel = new JLabel("Precio: ");
		_tFPrecio = new JTextField();
		_tFPrecio.setPreferredSize(new Dimension(100, 20));
		JPanel precioPanel = new JPanel();
		precioPanel.add(precioLabel);
		precioPanel.add(_tFPrecio);
		mainPanel.add(precioPanel);
		
		JLabel alergenosLabel = new JLabel("Alérgenos: ");
		_tFAlergenos = new JTextField();
		_tFAlergenos.setPreferredSize(new Dimension(100, 20));
		JPanel alergenosPanel = new JPanel();
		alergenosPanel.add(alergenosLabel);
		alergenosPanel.add(_tFAlergenos);
		mainPanel.add(alergenosPanel);
		
		//Seleccionar tipo
		JPanel tipoPanel = new JPanel();
		mainPanel.add(tipoPanel);
		ButtonGroup btnGrp = new ButtonGroup();
		_dulceRB = new JRadioButton();
		// Como tiene que seleccionarse uno obligatoriamente, dejamos dulce seleccionado por defecto
		_dulceRB.setSelected(true);
		_panRB = new JRadioButton();
		_bebidaRB = new JRadioButton();
		
		btnGrp.add(_dulceRB);
		btnGrp.add(_panRB);
		btnGrp.add(_bebidaRB);
		
		tipoPanel.add(_dulceRB);
		tipoPanel.add(_panRB);
		tipoPanel.add(_bebidaRB);
		
		_dulceRB.setText("dulce");
		_panRB.setText("pan");
		_bebidaRB.setText("bebida");

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
		_tFRelleno = new JTextField();
		_tFRelleno.setPreferredSize(new Dimension(100, 20));
		dulcePanel.add(rellenoLabel);
		dulcePanel.add(_tFRelleno);
		

		_salCB = new JCheckBox("Con Sal", false);
		_integralCB = new JCheckBox("Integral", false);
		panPanel.add(_salCB);
		panPanel.add(_integralCB);

		
		JLabel tamanyoLabel = new JLabel("Tamaño: ");
		_tFTamanyo = new JTextField();
		_tFTamanyo.setPreferredSize(new Dimension(100, 20));
		bebidaPanel.add(tamanyoLabel);
		bebidaPanel.add(_tFTamanyo);
		
		
		// Enseñamos dulce por defecto
		cL.show(specificPanel, "dulce");
		
		_dulceRB.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	    		cL.show(specificPanel, "dulce");
	        }
	    });
		
		_panRB.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	    		cL.show(specificPanel, "pan");
	        }
	    });
		
		_bebidaRB.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	    		cL.show(specificPanel, "bebida");
	        }
	    });
		
		JPanel endPanel = new JPanel();
		JButton acceptBtn = new JButton("Aceptar");
		acceptBtn.addActionListener((e)-> altaProducto());
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener((e)-> dispose());
		endPanel.add(acceptBtn);
		endPanel.add(cancelBtn);
		mainPanel.add(endPanel);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	private void altaProducto() {
		TProducto producto;
		
		String nombre = _tFNombre.getText();
		if (nombre == null || nombre.equals("")) {
			JOptionPane.showMessageDialog(this, "Debes indicar un nombre", "Alta Producto", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		double precio;
		
		try {
			precio = Double.parseDouble(_tFPrecio.getText());
			if (precio < 0) {
				JOptionPane.showMessageDialog(this, "El precio debe ser positivo", "Alta Producto", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Precio no válido", "Alta Producto", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		int stock;
		
		try {
			stock = Integer.parseInt(_tFStock.getText());
			if (stock < 0) {
				JOptionPane.showMessageDialog(this, "El stock debe ser un entero positivo", "Alta Producto", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Stock no válido", "Alta Producto", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		String alergenos = _tFAlergenos.getText();
	
		
		if (_dulceRB.isSelected()) {
			String relleno = _tFRelleno.getText();
			if (relleno == null || relleno.equals("")) {
				JOptionPane.showMessageDialog(this, "Debes indicar el relleno", "Alta Producto", JOptionPane.ERROR_MESSAGE);
				return;
			}
			producto = new TDulce(nombre, precio, alergenos, stock, 0, relleno);
		}
		
		else if (_panRB.isSelected()) {
			boolean sal = _salCB.isSelected();
			boolean integral = _salCB.isSelected();
			producto = new TPan(nombre, precio, alergenos, stock, 0, sal, integral);

		}
		
		else {
			String tamanyo = _tFRelleno.getText();
			if (tamanyo == null || tamanyo.equals("")) {
				JOptionPane.showMessageDialog(this, "Debes indicar un tamaño", "Alta Producto", JOptionPane.ERROR_MESSAGE);
				return;
			}
			producto = new TBebida(nombre, precio, alergenos, stock, 0, tamanyo);
		}
		
		Controlador.getInstance().accion(Evento.ALTA_PRODUCTO, producto);
		
	}
	
	@Override
	public void actualizar(Evento e, Object datos) {
		switch(e) {
		case ALTA_PRODUCTO_SUCCESS:
			JOptionPane.showMessageDialog(this, "Producto anadido con éxito con id: " + datos, "Alta Producto", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			break;
		case ALTA_PRODUCTO_ERROR:
			JOptionPane.showMessageDialog(this, "Error al añadir producto: " + datos.toString(), "Alta Producto", JOptionPane.ERROR_MESSAGE);
			dispose();
			break;
		default:
			break;
		}
	}

}
