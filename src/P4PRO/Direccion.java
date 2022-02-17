package P4PRO;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Direccion {
	
	private int tipodevia;
	private String nombre;
	private int numCalle;
	private int numPiso;
	private String letra;
	private int codigopostal;
	private String provincia;
	private static final String[] provincias = {"alava","albacete","alicante","almeria","asturias","avila","badajoz","barcelona","burgos",
			"caceres","cadiz","cantabria","castellon","ciudad real","cordoba","a coruña","cuenca","gerona","granada","guadalajara","guipuzcoa",
			"huelva","huesca","islas baleares","jaen","leon","lerida","lugo","madrid","malaga","murcia","navarra","ourense","palencia",
			"las palmas","pontevedra","la rioja","salamanca","segovia","sevilla","soria","tarragona","tenerife","teruel","toledo","valencia",
			"valladolid","vizcaya","zamora","zaragoza"};
	private static final List<String> listaProvincias = Arrays.asList(provincias);
	private Scanner sc = new Scanner (System.in);
	
	public Direccion() {
		this.tipodevia = 0;
		this.nombre = "";
		this.numCalle = 0;
		this.numPiso = 0;
		this.letra = "A";
		this.codigopostal = 0;
		this.provincia = "alava";
	}
	
	//Función para comprobar que la provincia es correcta
	public boolean ProvinciaCorrecta(String provincia) {
		provincia = provincia.toLowerCase();
		if(listaProvincias.contains(provincia)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Direccion(int tipodevia, String nombre, int numCalle, int numPiso, String letra, int codigopostal, String provincia) {
		this.tipodevia = tipodevia;
		this.nombre = nombre;
		this.numCalle = numCalle;
		this.numPiso = numPiso;
		this.letra = letra;	
		this.codigopostal = codigopostal;
		while(!ProvinciaCorrecta(provincia)) {
			System.out.println("La provincia introducida no es válida. No deben llevar tildes.");
			letra = sc.nextLine();
		}
		
		this.provincia = provincia;
	}
	
	public int getTipodeVia() {
		return this.tipodevia;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getNumCalle() {
		return this.numCalle;
	}
	
	public int getNumPiso() {
		return this.numPiso;
	}
	
	public String getLetra() {
		return this.letra;
	}
	
	public int getCodigoPostal() {
		return this.codigopostal;
	}
	
	public String getProvincia() {
		return this.provincia;
	}
	
	public void setTipodeVia(int tipodevia) {
		this.tipodevia = tipodevia;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNumCalle(int numCalle) {
		this.numCalle = numCalle;
	}
	
	public void setNumPiso(int numPiso) {
		this.numPiso = numPiso;
	}
	
	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	public void setCodigoPostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}
	
	public void setProvincia(String poblacion) {
		this.provincia = poblacion;
	}
	
	private String QueTipodeVia() {
		String[] tipovia = {"Avenida","Bulevar","Calle","Camino","Carretera","Plaza","Rúa","Urbanización","Otro"};
		String aux = "";
		switch(getTipodeVia()) {
		 
		 case 0: 
			 aux = tipovia[0];
			 break;
		 case 1:
			 aux = tipovia[1];
			 break;
		 case 2: 
			 aux = tipovia[2];
			 break;
		 case 3: 
			 aux = tipovia[3];
			 break;
		 case 4:
			 aux = tipovia[4];
			 break;
		 case 5:
			 aux = tipovia[5];
			 break;
		 case 6:
			 aux = tipovia[6];
			 break;
		 case 7: 
			 aux = tipovia[7];
			 break;
		 case 8:
			 aux = tipovia[8];
			 break;
		default:
			aux = tipovia[8];
			break;
		 }
		return aux;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(QueTipodeVia());
		sb.append(" ");
		sb.append(getNombre());
		
		sb.append(" número ");
		sb.append(getNumCalle());
		sb.append(" piso ");
		sb.append(getNumPiso());

		sb.append(" letra ");
		sb.append(getLetra());

		sb.append(", ");
		sb.append(getCodigoPostal());
		sb.append(", ");
		sb.append(getProvincia());
		return sb.toString();
	}

}
