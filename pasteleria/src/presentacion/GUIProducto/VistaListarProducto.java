package presentacion.GUIProducto;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentacion.Evento;
import presentacion.IGUI;

public class VistaListarProducto extends JFrame implements IGUI {
	private static final long serialVersionUID = -3264311669905931506L;
	private ModeloTablaProducto modeloTabla;
	
	public VistaListarProducto() {
		initGUI();
	}
	
	void initGUI() {
		setTitle("Listar Productos");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);
		
		modeloTabla = new ModeloTablaProducto();
		JTable table = new JTable(modeloTabla);
		JPanel tablePanel = new JPanel();
		mainPanel.add(tablePanel);
		
		tablePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2), "Productos"));
		tablePanel.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		JButton continuarBtn = new JButton("Continuar");
		continuarBtn.addActionListener((e) -> dispose());
		mainPanel.add(continuarBtn);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actualizar(Evento e, Object datos) {		
	}

}
