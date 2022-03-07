import java.util.Scanner;
import java.util.Arrays;
public class Main {
	
	public static Scanner scan = new Scanner(System.in);
	
	 public static double area(double l, double ap) {
		 double area = 0.0;
		 
		 area = (5f * l * ap)/2f;
		 
		 return area;
	 }
	 
	 public static int array() {
		int longitud = 0;
	
		int aux;
		
		do {
			System.out.println("Introduce un número: ");
			aux = scan.nextInt();
			if(aux < 0) {
				System.out.println("Introduce un número positivo");
			}
		}while(aux < 0);
		
		longitud = aux * 2;
		int array [] = new int[longitud];
		
		for(int i = 0; i < array.length; i++ ) {
			array[i] = aux;
			aux++;
		}
		
		for(int i = 0; i < array.length; i++) {
			
			 System.out.print("[" + array[i] + "]");
		}
		
		System.out.println();
		
		return longitud;
		 
	 }
	 
	 public static void mayusculasComunes(String cadena1, String cadena2) {
		String comunes = "";
		int nocomunes = 0;
		String aux = "";
		String busqueda = "";
		
		 
		 for(int i = 0; i < cadena1.length(); i ++) {
			 if(Character.isUpperCase(cadena1.charAt(i))){
				busqueda = busqueda + Character.toString(cadena1.charAt(i));
			 }
		 }
		 
		 
		 for(int i = 0; i < cadena2.length(); i++) {
			 if(Character.isUpperCase(cadena2.charAt(i))){
					aux = aux + Character.toString(cadena2.charAt(i));
				 }
		 }
		 
	
		 
		 for(int i = 0; i < busqueda.length(); i ++) {
			 for (int j = 0; j < aux.length(); j ++) {
				 if(busqueda.charAt(i) != aux.charAt(j)) {
					
				 }else {
					 comunes = comunes + busqueda.charAt(i);
				 }
			 } 
			 
		 }
			 
		
		 System.out.println("El número de letras que no son comunes son: " + nocomunes);
		 System.out.println("Las letras comunes en mayúsculas con: " + comunes);
	 }
	
	
	public static void main(String[] args) {
		
		
//		System.out.println(area(5.5, 6.0));

		
		
//		System.out.println("La longitud del array es " + array());
	
		String a = "ABCAB";
		String b = "ABA";
		mayusculasComunes(a, b);
	}

}
