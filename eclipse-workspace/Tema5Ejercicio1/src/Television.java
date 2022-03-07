
public class Television extends Electrodomestico {

	private int resolucion;
	private boolean sintonizadorTDT;
	private static final int resolucionPorDefecto = 20;
	private static final boolean sintonizadorPorDefecto = false;
	
	public Television() {
		this.resolucion = resolucionPorDefecto;
		this.sintonizadorTDT = sintonizadorPorDefecto;
	}
	
	public Television(double precio, int peso) {
		this.precioBase = precio;
		this.color = "blanco";
		this.consumoEnergetico = "F";
		this.peso = peso;
		this.resolucion = resolucionPorDefecto;
		this.sintonizadorTDT = sintonizadorPorDefecto;
	}
	
	public Television(double precioBase, String color, String consumoEnergetico, int peso, int resolucion, boolean sintonizador) {
		super(precioBase, color, consumoEnergetico, peso);
		this.resolucion = resolucionPorDefecto;
		this.sintonizadorTDT = sintonizadorPorDefecto;		
	}
	
	public int getResolucion() {
		return this.resolucion;
	}
	
	public boolean getSintonizadorTDT() {
		return this.sintonizadorTDT;
	}
	
	public double precioFinal() {
		
		double plus = super.precioFinal();
		if(getResolucion() > 40) {
			plus = getPrecioBase() * 0.30;
			
		}
		if(getSintonizadorTDT()) {
			plus += 50;
		}
		return plus;
	}
	
}
