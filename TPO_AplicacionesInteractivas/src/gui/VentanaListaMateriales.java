package gui;

import implementacion.Material;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;

public class VentanaListaMateriales extends JFrame{
	
	private JTable tabla;
	
	public VentanaListaMateriales(){
	
		componentes();
		comportamiento();
	}
	
	
	private void componentes(){
		
		Container c = this.getContentPane();
		DefaultTableModel modelo = new DefaultTableModel();
		Collection<Material> materiales = Controlador.getControlador().getMateriales();
		c.setLayout(new BorderLayout());
		
		// COLUMNAS
		
		modelo.addColumn("C�digo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Punto Pedido");
		modelo.addColumn("Proveedor");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Costo");
		
		// FILAS 
		
		for(Material m : materiales){
			
			Object[] nuevo = {m.getCodigo(), m.getNombre(), m.getPuntoPedido(), m.getProveedor().getNombre(), m.getCantidad(), m.getCosto()};
			modelo.addRow(nuevo);
		}
		
		tabla = new JTable(){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;
		}};
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setModel(modelo);
		tabla.setAutoCreateRowSorter(true);
		
		c.add(tabla.getTableHeader(), BorderLayout.NORTH);
		c.add(new JScrollPane(tabla), BorderLayout.CENTER);
		
	}
	
	private void comportamiento(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Lista Materiales");		
		this.setSize(580, 400);
		setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);	
	}
	
	public static void main(String args[]) {
		new VentanaListaMateriales();
	}

}