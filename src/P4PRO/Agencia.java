package P4PRO;

import java.util.ArrayList;

public class Agencia {
	private String nombre;
	private ArrayList<Piso> ListaPisos;
	
	
	public Agencia() {
		this.nombre = "";
		this.setListaPisos(ListaPisos);
	}

	public Agencia(String nombre) {
		this.nombre = nombre;
	}
	
	public Agencia(String nombre, ArrayList<Piso> ListaPisos) {
		this.nombre = nombre;
		this.ListaPisos = ListaPisos;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public ArrayList<Piso> getListaPisos() {
		return this.ListaPisos;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setListaPisos(ArrayList<Piso> listaPisos2) {
		this.ListaPisos = listaPisos2;
	}
	
	public String toStringString() {
		return "La agencia" + getNombre() + "tiene los siguientes pisos disponibles:\n" + toString();
	}
	
	
	
}
