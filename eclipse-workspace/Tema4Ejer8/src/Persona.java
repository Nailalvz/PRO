import java.util.Calendar;

public class Persona {
	private String nombre;
	private String direc;
	private int cod_postal;
	private String ciudad;
	private Fecha fechaNacimiento;
	
	
	public Persona() {
		this.nombre = "";
		this.direc = "";
		this.cod_postal = 0;
		this.ciudad = "";
		this.setFechaNacimiento(fechaNacimiento);
	}

	public Persona(String nombre, String direc, int cod_postal, String ciudad, Fecha fechaNacimiento) {
		this.nombre = nombre;
		this.direc = direc;
		this.cod_postal = cod_postal;
		this.ciudad = ciudad;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDirec() {
		return this.direc;
	}
	
	public int getCod_Postal() {
		return this.cod_postal;
	}
	
	public String getCiudad() {
		return this.ciudad;
	}
	
	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDirec(String direc) {
		this.direc = direc;
	}
	
	public void setCod_postal(int cod_postal) {
		this.cod_postal = cod_postal;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setFechaNacimiento(Fecha fechanacimiento) {
		this.fechaNacimiento = fechanacimiento;
	}
	
	public boolean esMayordeEdad() {
		Calendar cal = Calendar.getInstance();
		int dia, mes, year;
		dia = cal.get(Calendar.DATE);
		mes = cal.get(Calendar.MONTH) + 1;
		year = cal.get(Calendar.YEAR);
		
		if(year - fechaNacimiento.getAño() > 18) {
			return true;
		} else if (year - fechaNacimiento.getAño() == 18 && mes > fechaNacimiento.getMes()) {
			return true;
		} else if (year - fechaNacimiento.getAño() == 18 && mes == fechaNacimiento.getMes() 
				&& dia >= fechaNacimiento.getDia()) {
			return true;
		}
		
		return false;
		
	}
	
	public String toString() {
		return "Nombre: " + getNombre() + "\nFecha Nacimiento: " + getFechaNacimiento() + 
				"\nDirección: " + getDirec() + "\n" + getCod_Postal();
	}
	
}

