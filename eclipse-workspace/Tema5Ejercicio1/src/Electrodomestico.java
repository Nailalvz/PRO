import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Electrodomestico {

	protected double precioBase;
	//Hacer el color y la letra con enum
	protected static final String[] colores = {"blanco","negro","azul","gris"};
	protected static final List<String> listaColores = Arrays.asList(colores);
	protected String color;
	protected final static String[] letra = {"A","B","C","D","E","F"};
	protected static final List<String> listaletra = Arrays.asList(letra);
	protected String consumoEnergetico;
	protected int peso;
	private Scanner sc = new Scanner (System.in);
	
	
	public Electrodomestico() {
		this.precioBase = 100;
		this.color = "blanco";
		this.consumoEnergetico = "F";
		this.peso = 5;
	}
	
	public Electrodomestico(double precioBase, int peso) {
		this.precioBase = precioBase;
		this.color = "blanco";
		this.consumoEnergetico = "F";
		this.peso = peso;
	}
	
	public Electrodomestico(double precioBase, String color, String consumoEnergetico, int peso) {
		this.precioBase = precioBase;
		while(!comprobarColor(color.toLowerCase())) {
			System.out.println("El color introducido no es válido.");
			color = sc.nextLine();
		}
		this.color = color;
		while(!comprobarConsumoEnergetico(consumoEnergetico.toUpperCase())) {
			System.out.println("El consumo energético introducido no es válido.");
			consumoEnergetico = sc.nextLine();
		}
		this.consumoEnergetico = consumoEnergetico;
		this.peso = peso;
		
	}
	
	public double getPrecioBase() {
		return this.precioBase;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public String getConsumoEnergetico() {
		return this.consumoEnergetico;
	}
	
	public int getPeso() {
		return this.peso;
	}
	
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	
	public void setColor(String color) {
		color = color.toLowerCase();
		if(listaColores.contains(color)) {
			this.color = color;
		} else {
			this.color = "blanco";
		}
	}
	
	public void setConsumoEnergetico(String letra) {
		letra = letra.toUpperCase();
		if(listaletra.contains(letra)) {
			this.consumoEnergetico = letra;
		} else {
			this.consumoEnergetico = "F";
		}
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	//Comprobar que el color es correcto
	private boolean comprobarColor(String color) {
		color = color.toLowerCase();
			if(listaColores.contains(color)) {
				return true;
			} else {
				return false;
			}
	}
	
	//Comprobar que la letra es correcta
	private boolean comprobarConsumoEnergetico(String letra) {
		letra = letra.toUpperCase();
			if(listaletra.contains(letra)) {
				return true;
			} else {
				return false;
			}
	}
	
	public double precioFinal() {
		double plus = 0;
		
		switch(getConsumoEnergetico()) {
		
		case "A":
			plus += 100;
			break;
		case "B":
			plus += 80;
			break;
		case "C":
			plus += 60;
			break;
		case "D":
			plus += 50;
			break;
		case "E":
			plus += 30;
			break;
		case "F":
			plus += 10;
			break;
		}
		
		if(getPeso() >= 0 && getPeso() <= 19) {
			plus += 10;
		} else if(getPeso() >= 20 && getPeso() <= 49) {
			plus += 50;
		} else if(getPeso() >= 50 && getPeso() <= 79) {
			plus += 80;
		} else if(getPeso() >= 80) {
			plus += 100;
		}
		return getPrecioBase() + plus;
	}
	
	
	
	
			
	
	
}
