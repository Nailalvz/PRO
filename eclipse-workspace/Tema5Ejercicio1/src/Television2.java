
public class Television2 extends Electrodimestico2 {
	private static final int RESOLUCION_POR_DEFECTO = 20;
	private static final boolean SINTO_POR_DEFECTO = false;
	
	private int resolucion;
	private boolean sinto;
	
	public Television2() {
		super();
		this.resolucion = RESOLUCION_POR_DEFECTO;
		this.sinto = SINTO_POR_DEFECTO;
	}


	public Television2(COLORES color, CONSUMOS consumo, double precioBase,
			double peso, int resolucion, boolean sinto) {
		super(color, consumo, precioBase, peso);
		this.resolucion = resolucion;
		this.sinto = sinto;
	}

	public Television2(double precioBase, double peso) {
		super(precioBase, peso);
		this.resolucion = RESOLUCION_POR_DEFECTO;
		this.sinto = SINTO_POR_DEFECTO;
		
	}

	public Television2(String color, char consumo, double precioBase, double peso) {
		super(color, consumo, precioBase, peso);
		
	}


	public int getResolucion() {
		return resolucion;
	}


	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}


	public boolean isSinto() {
		return sinto;
	}


	public void setSinto(boolean sinto) {
		this.sinto = sinto;
	}


	public static int getResolucionPorDefecto() {
		return RESOLUCION_POR_DEFECTO;
	}


	public static boolean isSintoPorDefecto() {
		return SINTO_POR_DEFECTO;
	}
	
	
}
