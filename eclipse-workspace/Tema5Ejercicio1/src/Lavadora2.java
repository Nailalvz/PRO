
public class Lavadora2 extends Electrodimestico2 {

	private static final int CARGA_POR_DEFECTO = 5;
	
	private int carga;

	public Lavadora2() {
		super();
		this.carga = CARGA_POR_DEFECTO;
	}
	
	public Lavadora2(double precioBase, double peso) {
		super(precioBase, peso);
		this.carga = CARGA_POR_DEFECTO;
	}

	public Lavadora2(COLORES color, CONSUMOS consumo, double precioBase, double peso, int carga) {
		super(color, consumo, precioBase, peso);
		this.carga = carga;
	}

	public Lavadora2(String color, char consumo, double precioBase, double peso) {
		super(color, consumo, precioBase, peso);
		this.carga = CARGA_POR_DEFECTO;
	}
	
	
}
