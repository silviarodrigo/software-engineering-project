package presentacion.GUIProveedores;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class MainWindowProveedor extends JFrame{

	//vamos a tener un botón por cada vista
	//cuando los pulsemos se abrirá su JDialog correspondiente
	
	//los botones correspondiente como atributos (Quizá no es necesario que sean atributos)
	
	JButton _altaBoton;
	JButton _bajaBoton;
	JButton _buscarBoton;
	JButton _listarBoton;
	JButton _modificarBoton;

	vistaAltaProveedor _vista;
	
	
	
	
	MainProveedor(){
		 
		initGUI();
	}
	
	
	
	private void initGUI() {
		
		//creamos los paneles
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
		
		//panel de arriba para 3 botones alta baja modificar
		JPanel panelSuperior = new JPanel();
		mainPanel.add(panelSuperior, BorderLayout.PAGE_START);
		
		//panel de arriba para 2 botones listar buscar
		JPanel panelInferior = new JPanel();
		mainPanel.add(panelInferior);
		
		//creamos los botones,
		_altaBoton = new JButton("Alta proveedor");
		//ponemos su actionlistener:
		_altaBoton.addActionListener((e)->{
			altaImp();
		});
		panelSuperior.add(_altaBoton);
		
		_bajaBoton = new JButton("Baja proveedor");
		
		panelSuperior.add(_bajaBoton);
		
		
		_buscarBoton = new JButton("Buscar proveedor");
		
		panelInferior.add(_buscarBoton);
		
				
		_listarBoton = new JButton("Listar proveedores");
		
		panelInferior.add(_listarBoton);
		
		_modificarBoton = new JButton("Modificar proveedor");
		
		panelInferior.add(_modificarBoton);
				
		
		//INICIALIZAMOS LAS VISTAS PARA TENER UNA UNICA ISNTANCIA Y QUE SOLO SEA LLAMAR AL METODO OPEN
		//Y ASI NO HACER NEW CADA VEZ Q PULSAMOS UN BOTON
		_vista = new vistaAltaProveedor();
		
		//cositas de tamaño y visibilidad
		
		
		pack();
		this.setLocationRelativeTo(null);
		setSize(300,250);
		setVisible(true);
		
		
	}
	
	
	
	private void altaImp() {
		SwingUtilities.invokeLater(()->{
			_vista.open();
		});
	}
	
	
}
