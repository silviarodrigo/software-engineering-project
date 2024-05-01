package presentacion.GUICliente;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Collection;

import javax.swing.*;

import negocio.Producto.TProducto;
import presentacion.Evento;
import presentacion.IGUI;
import presentacion.GUIProducto.ModeloTablaProducto;

import negocio.Cliente.TCliente;

public class VistaListarClientes extends JFrame implements IGUI{
	private static final long serialVersionUID = 1L;
	
	private ModeloTablaCliente _modeloTablaCliente;
	
	public VistaListarClientes() {
		this.initGUI();
	}
	
	private void initGUI() {
		this.setTitle("Listar Clientes");
		
		// Creamos panel principal.
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.setContentPane(mainPanel);
		
		// Creamos tabla y la añadimos al panel principal.
		this._modeloTablaCliente = new ModeloTablaCliente();
		JTable table = new JTable(this._modeloTablaCliente);
		JPanel tablePanel = new JPanel();
		tablePanel.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		tablePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2), "Clientes"));
		
		mainPanel.add(tablePanel);
		
		// Botón para continuar.
		JButton bcontinuar = new JButton("Continuar");
		bcontinuar.addActionListener((e) -> dispose());
		mainPanel.add(bcontinuar);
		
		setPreferredSize(new Dimension (600, 500));
		pack();
		setLocationRelativeTo(null); // Para que la ventana aparezca en el centro de la pantalla.
		setVisible(true);
	}

	@Override
	public void actualizar(Evento e, Object datos) {
		switch (e) {
		case LISTAR_CLIENTES:
			Collection<TCliente> clientes = (Collection<TCliente>) datos;
			this._modeloTablaCliente.loadData(clientes);
			break;
		default:
			break;
		}
	}

}
