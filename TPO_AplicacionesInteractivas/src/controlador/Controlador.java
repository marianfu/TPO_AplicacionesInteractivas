package controlador;

import implementacion.Material;
import implementacion.Prenda;
import implementacion.Proveedor;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;

public class Controlador {
	private Collection<Material> materiales;
	private Collection<Proveedor> proveedores;
	private Collection<Prenda> prendas;
	public static Controlador con;
	
	public Controlador() {
	materiales = new ArrayList<Material>();
	proveedores = new ArrayList<Proveedor>();
	prendas = new ArrayList<Prenda>();
	}
	
	public static Controlador getControlador(){
		if(con == null)
			con = new Controlador();
		return con;
	}

	public void altaMaterial(String codigo, String nombre, String puntoPedido, String cuit, float cantidad, float costo){
		if (!existeMaterial(codigo)){
			Proveedor proveedor = obtenerProveedor(cuit);
			if (proveedor!=null){
				Material material = new Material(codigo, nombre, puntoPedido, proveedor, cantidad, costo);	
				materiales.add(material);
				JOptionPane.showMessageDialog(null, "Material agregado correctamente.","OK",JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null,"No existe proveedor con el CUIT ingresado.","Error",JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null,"Ya existe un material con el c�digo ingresado.","Error",JOptionPane.ERROR_MESSAGE);			
	}
	
	public void altaProveedor(String nombre, String cuit){
		if (!existeProveedor(cuit)){
			Proveedor proveedor = new Proveedor(nombre, cuit);
			proveedores.add(proveedor);
			JOptionPane.showMessageDialog(null, "Proveedor agregado correctamente.","OK",JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null,"Ya existe un proveedor con el CUIT ingresado.","Error",JOptionPane.ERROR_MESSAGE);					
	}
	
	public void modificarMaterial(String codigo, String nombre, String puntoPedido, String cuit, float cantidad, float costo){
		if (obtenerMaterial(codigo)!=null){
			Proveedor proveedor = obtenerProveedor(cuit);
			if (proveedor != null){
				obtenerMaterial(codigo).setNombre(nombre);
				obtenerMaterial(codigo).setPuntoPedido(puntoPedido);
				obtenerMaterial(codigo).setCantidad(cantidad);
				obtenerMaterial(codigo).setCosto(costo);
				JOptionPane.showMessageDialog(null, "Material modificado.","OK",JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null,"No existe proveedor con el CUIT ingresado.","Error",JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null,"No existe material con el c�digo seleccionado.","Error",JOptionPane.ERROR_MESSAGE);	//no se tendr�a que llegar nunca aca pero bue
	}
	
	public boolean existeMaterial(String codigo){
		for (Material m : materiales)
			if (m.sosElMaterial(codigo)==true){
				return true;
			}
		return false;
	}
	
	public boolean existeProveedor(String cuit){
		for (Proveedor p : proveedores)
			if (p.sosElProveedor(cuit)==true){
				return true;
			}
		return false;
	}
	
	public Proveedor obtenerProveedor(String cuit){
		for (Proveedor p : proveedores)
			if (p.sosElProveedor(cuit)==true){
				return p;
			}
		return null;
	}
	
	public void eliminarMaterial(String codigo){
		for (Material m : materiales)
			if (m.sosElMaterial(codigo)==true){
				materiales.remove(m);
				JOptionPane.showMessageDialog(null,"Material eliminado.","Error",JOptionPane.ERROR_MESSAGE);
			}
	}

	public Collection<Material> getMateriales() {
		return materiales;
	}

	public Collection<Proveedor> getProveedores() {
		return proveedores;
	}

	public Collection<Prenda> getPrendas() {
		return prendas;
	}

	public Material obtenerMaterial(String codigo) {
		for (Material m : materiales)
			if (m.sosElMaterial(codigo)==true){
				return m;
			}
		return null;
	}
	
	public String hola(){
		
		return null;
	}

}
