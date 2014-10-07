package gui;
import implementacion.Material;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import controlador.Controlador;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class VentanaBajaMaterial extends javax.swing.JFrame implements ActionListener{
	private JButton eliminar;
	private JComboBox materiales;

	public static void main(String[] args) {
		new VentanaBajaMaterial();
	}
	
	public VentanaBajaMaterial() {
		comportamiento();
		componentes();
	}
	
	private void comportamiento(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Baja Material");		
		this.setSize(335, 117);
		setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		getContentPane().setLayout(null);
	}
	
	private void componentes() {
		try {
			{
				eliminar = new JButton();
				getContentPane().add(eliminar);
				eliminar.setText("Eliminar");
				eliminar.setBounds(222, 48, 91, 24);
				eliminar.addActionListener(this);
			}
			{

				materiales = new JComboBox();
				getContentPane().add(materiales);
				materiales.setBounds(12, 12, 301, 24);
				for (Material m : Controlador.getControlador().getMateriales())
					materiales.addItem(m.getCodigo());
				materiales.setSelectedIndex(-1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==eliminar){
			if (materiales.getSelectedItem()!=null)
				Controlador.getControlador().eliminarMaterial(materiales.getSelectedItem().toString());
			else
				JOptionPane.showMessageDialog(this.getComponent(0),"Por favor elija un material a eliminar.","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
