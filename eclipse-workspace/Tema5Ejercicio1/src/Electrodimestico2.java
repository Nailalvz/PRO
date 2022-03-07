
public class Electrodimestico2 {

	protected static enum COLORES {BLANCO, NEGRO, ROJO, AZUL, GRIS}
	protected static enum CONSUMOS {A,B,C,D,E,F}
	
	private static COLORES color_por_defecto = COLORES.BLANCO;
	private static CONSUMOS consumo_por_defecto = CONSUMOS.F;
	private static double PRECIO_POR_DEFECTO = 100;
	private static  double PESO_POR_DEFECTO = 5;
	
	private COLORES color;
	private CONSUMOS consumo;
	
	private double precioBase, peso;
	
	public Electrodimestico2() {
		this.color = color_por_defecto;
		this.consumo = consumo_por_defecto;
		this.precioBase = PRECIO_POR_DEFECTO;
		this.peso = PESO_POR_DEFECTO;
	}
	
	public Electrodimestico2(double precioBase, double peso) {
		this.color = color_por_defecto;
		this.consumo = consumo_por_defecto;
		comprobarPrecio(precioBase);
		comprobarPeso(peso);
	}
	
	public Electrodimestico2(COLORES color, CONSUMOS consumo, double precioBase, double peso) {
		this.color = color;
		this.consumo = consumo;
		this.precioBase = precioBase;
		this.peso = peso;
	}
	
	public Electrodimestico2(String color, char consumo, double precioBase, double peso) {
		comprobarColor(color);
		comprobarConsumo(consumo);
		comprobarPrecio(precioBase);
		comprobarPeso(peso);
	}

	public static COLORES getColor_por_defecto() {
		return color_por_defecto;
	}

	public static void setColor_por_defecto(COLORES color_por_defecto) {
		Electrodimestico2.color_por_defecto = color_por_defecto;
	}

	public static CONSUMOS getConsumo_por_defecto() {
		return consumo_por_defecto;
	}

	public static void setConsumo_por_defecto(CONSUMOS consumo_por_defecto) {
		Electrodimestico2.consumo_por_defecto = consumo_por_defecto;
	}

	public COLORES getColor() {
		return color;
	}

	public void setColor(COLORES color) {
		this.color = color;
	}

	public CONSUMOS getConsumo() {
		return consumo;
	}

	public void setConsumo(CONSUMOS consumo) {
		this.consumo = consumo;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		comprobarPrecio(precioBase);
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if(peso < 0) {
			this.peso = PESO_POR_DEFECTO;
		} else {
			this.peso = peso;
		}
		
	}
	
	public void comprobarPrecio(double precio) {
		if(precio < 0) {
			this.precioBase = PRECIO_POR_DEFECTO;
		} else {
			this.precioBase = precio;
		}
	}
	
	public void comprobarPeso(double peso) {
		if(peso < 0) {
			this.peso = PESO_POR_DEFECTO;
		} else {
			this.peso = peso;
		}
	}
	
	public void comprobarColor(String color) {
		color = color.toUpperCase();
		
		switch(color) {
		case "BLANCO": this.color = COLORES.BLANCO;
		break;
		case "NEGRO": this.color = COLORES.NEGRO;
		break;
		case "ROJO": this.color = COLORES.ROJO;
		break;
		case "AZUL": this.color = COLORES.AZUL;
		break;
		case "GRIS": this.color = COLORES.GRIS;
		break;
		default: this.color = color_por_defecto;
		break;
		}
	}
	
	public void comprobarConsumo(char consumo) {
		switch(consumo) {
		case 'a': case 'A': this.consumo = CONSUMOS.A;
		break;
		case 'b': case 'B': this.consumo = CONSUMOS.B;
		break;
		case 'c': case 'C': this.consumo = CONSUMOS.C;
		break;
		case 'd': case 'D': this.consumo = CONSUMOS.D;
		break;
		case 'e': case 'E': this.consumo = CONSUMOS.E;
		break;
		case 'f': case 'F': this.consumo = CONSUMOS.F;
		break;
		default: this.consumo = consumo_por_defecto;
		
		}
	}
	
	public double precioFinal() {
		double toret = getPrecioBase();
		
		switch(getConsumo()) {
		case A: toret += 100;
		break;
		case B: toret += 80;
		break;
		case C: toret += 60;
		break;
		case D: toret += 50;
		break;
		case E: toret += 30;
		break;
		case F: toret += 10;
		break;
		}
		
		if (getPeso() < 20) {
			toret += 10;
		} else if (getPeso() < 50) {
			toret += 50;
		}else if (getPeso() < 80) {
			toret += 80;
		} else {
			toret += 100;
		}
		
		return toret;
	}
	
}
