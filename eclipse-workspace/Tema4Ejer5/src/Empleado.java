
public class Empleado {
	private String NIF;
	private String nombre;
	private double sueldoBase;
	private double horasExtra;
	private double IRPF;
	private boolean casado;
	private int hijos;
	private static double importeHoraExtra;
	
	
	public Empleado() {
		this.NIF = "";
		this.nombre = "";
		this.sueldoBase = 0.0;
		this.horasExtra = 0.0;
		this.IRPF = 0.0;
		this.casado = false;
		this.hijos = 0;
		Empleado.setImporteHoraExtra(0.0);
		
	}
	
	public Empleado(String NIF, String nombre, double sueldoBase, double horasExtra, double IRPF, boolean casado, int hijos, double importeHoraExtra) {
		this.NIF = NIF;
		this.nombre = nombre;
		this.sueldoBase = sueldoBase;
		this.horasExtra = horasExtra;
		this.IRPF = IRPF;
		this.casado = casado;
		this.hijos = hijos;
		Empleado.setImporteHoraExtra(importeHoraExtra);
	}
	
	public Empleado(String NIF) {
		this.NIF = NIF;
	}

	public static double getImporteHoraExtra() {
		return importeHoraExtra;
	}

	public static void setImporteHoraExtra(double importeHoraExtra) {
		Empleado.importeHoraExtra = importeHoraExtra;
	}
	
	public String getNIF() {
		return this.NIF;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getSueldoBase() {
		return this.sueldoBase;
	}
	
	public double getHorasExtra() {
		return this.horasExtra;
	}
	
	public double getIRPF() {
		return this.IRPF;
	}
	
	public boolean getCasado() {
		return this.casado;
	}
	
	public int getHijos() {
		return this.hijos;
	}
	
	public void setNIF(String NIF) {
		this.NIF = NIF;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	public void setHorasExtra(double horasExtra) {
		this.horasExtra = horasExtra;
	}
	
	public void setIRPF(double IRPF) {
		this.IRPF = IRPF;
	}
	
	public void setCasado(boolean casado) {
		this.casado = casado;
	}
	
	public void setHijos(int hijos) {
		this.hijos = hijos;
	}
	
	public String toString() {
		return  getNIF() + " " + getNombre() + " \n"
				+ "Sueldo Base: " + getSueldoBase() + "\nHoras Extra: " + getHorasExtra() + "\n"
						+ "Tipo IRPF: " + getIRPF() + "\nCasado: " + getCasado() + "\nNúmero de hijos: "+ getHijos();
	}
	
	public double CalculoExtras() {
		double complemento = getHorasExtra() * Empleado.importeHoraExtra;
		return complemento;
	}
	
	public double SueldoBruto() {
		double sueldoBruto = getSueldoBase() + CalculoExtras();
		return sueldoBruto;
	}
	
	public double CalculoIRPF() {
		double irpf = getIRPF();
		
		if(getCasado() == true) {
			irpf = irpf - 2;
		}
		
		if(getHijos() >= 0) {
			irpf = irpf - getHijos();
		}
		 return SueldoBruto() * irpf / 100;
	}
	
	 
	
}
