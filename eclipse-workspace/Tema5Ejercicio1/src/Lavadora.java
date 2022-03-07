
public class Lavadora  extends Electrodomestico {

	private int carga;
	private static final int cargaPorDefecto = 5;
	
	

	public Lavadora() {
		super();
		this.carga = cargaPorDefecto;
	}
	
	public Lavadora(double precio, int peso) {
		this.precioBase = precio;
		this.color = "blanco";
		this.consumoEnergetico = "F";
		this.peso = peso;
		this.carga = cargaPorDefecto;
	}
	
	public Lavadora(double precioBase, String color, String consumoEnergetico, int peso, int carga) {
		super(precioBase, color, consumoEnergetico, peso);
		this.peso = peso;
	}
	
	public int getCarga() {
		return this.carga;
	}
	
	public void setCarga(int carga) {
		this.carga = carga;
	}
	
	public double PrecioFinal() {
		double plus = super.precioFinal();
		if(getCarga() > 30) {
			plus += 50;
		}
		return plus;
	}
	
}
