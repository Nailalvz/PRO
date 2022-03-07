package Tema1;
import java.util.Scanner;

public class Main {
	
	public static Scanner scan = new Scanner(System.in);
	
	//Ejercicio 1 Tema 1
	
	public static float grados() {
		
		float fah = 0;
		float cel;
		
		
			System.out.println("Introduce los grados Fahrenheit: ");
			fah = scan.nextFloat();
		
		cel = (5f/9f) * (fah - (float)32);
		
		return cel;
	
	}
	
	//Ejercicio 2 Tema 1
	
	public static double volumen() {
		
		double radio = 3.5;
		return (4*Math.PI*radio*radio*radio)/3;
	}
	
	public static double area() {
		
		double radio = 3.5;
		return 4*Math.PI*radio*radio;
	}
	
	//Ejercicio3 Tema 1
	
	public static void notas() {
		int nota = 0;
		do {
			System.out.println("La nota debe estar entre 0 y 10.\nIntroduce la nota: ");
			nota = scan.nextInt();
			if(nota < 0 || nota > 10) {
				System.out.println("La nota introducida no es correcta");
			}
		}while(nota < 0 || nota > 10);
		
		switch(nota) {
		case 0, 1, 2, 3, 4:
			System.out.println("SUSPENSO");
		break;
		case 5, 6:
			System.out.println("APROBADO");
		break;
		case 7, 8:
			System.out.println("NOTABLE");
		case 9, 10:
			System.out.println("SOBRESALIENTE");
		break;
		}
	}
	
	//Ejercicio 4 Tema 1
	
	public static void contadorVocales() {
		String ch;
		int ca = 0;
		int ce = 0;
		int ci = 0;
		int co = 0;
		int cu = 0;
		
		for(int i = 0; i < 20; i++) {
			do {
				System.out.println("Introduce un caracter: ");
				ch = scan.next();
				ch = ch.toLowerCase();
			}while(ch.length()!=1);
			
			switch(ch) {
			case "a": ca++;
			break;
			case "e": ce++;
			break;
			case "i": ci++;
			break;
			case "o": co++;
			break;
			case "u": cu++;
			break;
			
			}
		}
		System.out.println("El número de aes es : " + ca);
		System.out.println("El número de es es: " + ce);
		System.out.println("El número de ies es: " + ci);
		System.out.println("El número de oes es: " + co);
		System.out.println("El nñumero de ues es: " + cu);
		
	}
	
	//Ejercicio 5 Tema 1
	public static void operandoValores() {
		int num1, num2;
		String chr = "";
		
		do {
			System.out.println("Introduce el primero número: ");
			num1 = scan.nextInt();
			if(num1 < 0) {
				System.out.println("El número debe ser positivo.");
			}
			
		}while(num1 < 0);
		
		do {
			System.out.println("Introduce el segundo número: ");
			num2 = scan.nextInt();
			if(num2 < 0) {
				System.out.println("El número debe ser positivo.");
			}
			
		}while(num2 < 0);
		
		System.out.println("Introduce el operando para realizar la operación deseada (+, -, *, /, %).");
		chr = scan.next();
		switch(chr) {
		case "+": System.out.println("El resultado de " + num1 + " + " + num2 + " es " + (num1+num2));
		break;
		case "-": System.out.println("El resultado de " + num1 + " - " + num2 + " es " + (num1-num2));
		break;
		case "*": System.out.println("El resultado de " + num1 + " * " + num2 + " es " + (num1*num2));
		break;
		case "/": System.out.println("El resultado de " + num1 + " / " + num2 + " es " + ((float)num1/(float)num2));
		break;
		case"%": System.out.println("El resultado de " + num1 + " % " + num2 + " es " + ((float)num1%(float)num2));
		break;
		default: System.out.println("Introduce un operando válido.");
		}
		
	}
	
	
	//Ejercicio 6 Tema 1
	
	public static float promedio() {
		float num;
		float sum = 0;
		float promedio;
		
		for(int i = 0; i < 20; i++) {
			System.out.println("Introduce un número: ");
			num = scan.nextFloat();
			sum = sum + num;
		}
		
		promedio = sum/20;
		return promedio;
	}
	
	//Ejercicio 7 Tema 1
	
	public static int factorial() {
		int num;
		int fac = 1;
		
		do {
			System.out.println("Introduce un número para calcular su factorial: ");
			num = scan.nextInt();
		}while(num < 0);
		
		for(int i = 1; i <= num; i++) {
			fac *= i;
		}
		return fac;
	}
	
	
	//Ejercicio 8 Tema 1
	public static int sumaImpares() {
		int num;
//		int num2;
		int aux = 0;
		
		System.out.println("Introduzca un número: ");
		num = scan.nextInt();
//		num2 = num;
		
		for(int i = 1; i <= num;i++) {
			if(!(i%2 == 0)) {
				aux = aux + i;
			}else {
				num++;
			}
		}
		return aux;
	}
	
	public static int invertir(int x) {
		int num2;
		int aux = 0;
		
		while(x!=0) {
			num2 = x%10;
			aux = aux*10 + num2;
			x = x/10;
		}
		return aux;
	}
	
	//Ejercicio 9 Tema 1
	
	public static void sumaComprendidos() {
		int suma = 0;
		for(int i = 1; i <= 500; i ++) {
			if(i%5 == 0 && i%7 == 0) {
			 suma = suma + i;
			}
		}
		System.out.println("EL resultado de la suma es " + suma);
	}
	
	//Ejercicio 10 Tema 1
	
	public static void twitter() {
		System.out.println("Introduce el texto que desea twittear: ");
		String tweet = scan.nextLine();
		
		if(tweet.length() > 0 && tweet.length() < 281) {
			System.out.println("Twiteable");	
		}else System.out.println("No twiteable");
	}
	
	//Ejercicio 11 Tema 1
	
//	public static void calculoDias() {
//		double minutos;
//		double horas;
//		double segundos;
//		double min;
//		System.out.println("Introduce los minutos:");
//		min = scan.nextDouble();
//		horas = min/60;
//		
//	}
	
	//Ejercicio 12 Tema 1
	
	public static boolean dosPares() {
		int num1 = 0, num2 = 0, num3 = 0;
		do {
			System.out.println("Introduce el primer número:");
			num1 = scan.nextInt();
		}while(num1 < 0);
		do {
			System.out.println("Introduce el segundo número:");
			num2 = scan.nextInt();
		}while(num2 < 0);
		do {
			System.out.println("Introduce el tercer número:");
			num3 = scan.nextInt();
		}while(num3 < 0);
		
		if(num1%2 == 0 && num2%2 == 0) {
			return true;
		}else if (num1%2 == 0 && num3%2 == 0) {
			return true;
		}else if (num2%2 == 0 && num3%2 == 0) {
			return true;
		}else return false;
		
		
	
		
		
	}
	
	public static void main (String [] args) {
		
		//Ejercicio 1 Tema 1
//		System.out.println("El resultado serían: " + grados() + " grados Celsius");
		//Ejercicio 2 Tema 1
//		System.out.println(volumen());
//		System.out.println(area());
		//Ejercicio 3 Tema 1
//		notas();
		//Ejercicio 4 Tema 1
//		contadorVocales();
		//Ejercicio 5 Tema 1
//		operandoValores();
		//Ejercicio 7 Tema 1
//		System.out.println("El factorial es " + factorial());
		//Ejercicio 6 Tema 1
//		System.out.println("El promedio es " + promedio());
		//Ejercicio 8 Tema 1
//		System.out.println("La suma de los primeros impares es: " + sumaImpares());
//		System.out.println("El número invertido es: " + invertir(1234));
		//Ejercicio 9 Tema 1
//		sumaComprendidos();
		//Ejercicio 10 Tema 1
//		twitter();
		//Ejercicio 11 Tema 1
		
		//Ejercicio 12 Tema 1
//		System.out.println(dosPares());
		
	}
}
