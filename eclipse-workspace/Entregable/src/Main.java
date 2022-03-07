import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
	/*
		int cont = 0;
		int n;
		
			

			System.out.println("Introduzca un número para saber si es perfecto: ");
			n = scan.nextInt();
			
			
		
			for(int i = 1; i < n; i++) {
				if(n%i==0) {
					cont = cont + i;	
				}
			}
			if(cont == n) {
			System.out.println("El número "+ n + " es perfecto");	
			}else {
				System.out.println("El número "+ n + " no es perfecto");
			}
		
			*/
		
		
		/*
		
		int n;
		int max = 0;
		int min = 0;
		int igual = 0;
		
		
		do {
			 do {
				 System.out.println("Introduzca un número positivo. \nSi desea finalizar el programa introduzca el número cero (O).");
					n = scan.nextInt();
						
				 
			 } while(n < 0);
				if(n > 0) {
					if(n > max) {
						System.out.println(n + " es mayor que el anterior.\n");
						max = n;
							
					}else {
						max = n;
					}
					if(n < min) {
						System.out.println(n + " es menor que el anterior.\n");
						min = n;
						
					}else {
						min = n;
					}
					if(n == igual){
						System.out.println(n + " es igual al anterior.\n");
						igual = n;
					}else {
						igual = n;
					}
				}
				 
		} while(n != 0);
		System.out.println("Programa finalizado.\n");
		scan.close();
	*/
		
		int n1;
		int n2;
		
		
		
			do {
				System.out.println("Introduzca el primer número positivo.\n Si desea finalizar el programa introduzca el número cero (0).");
				n1 = scan.nextInt();
				
			}while(n1 < 0);
			
			if(n1==0) { System.out.println("Programa finalizado.");
			
			}else {
			
		
			do {
			
				do {
				System.out.println("Introduzca un número positivo. \nSi desea finalizar el programa introduzca el número cero (O).");
				n2 = scan.nextInt();
				}while(n2 < 0);
				
					if(n2 > n1) {
						System.out.println( n2 + " es mayor que el anterior.\n");
						n1 = n2;	
					}else if(n2 == n1){
						System.out.println(n2 + " es igual al anterior.\n");
				
					}else {
						System.out.println(n2 + " es menor que el anterior.\n");
						n1 = n2;
					}
				
			
			}while(n2!=0);
			System.out.println("Programa finalizado.");
			}
			
	
		
//		
//		int cont = 0;
//		int n;
//		do {
//		
//		System.out.println("Introduzca un número entero y positivo para saber si es perfecto: ");
//		n = scan.nextInt();
//		}while(n <= 0);
//		
//		if(n > 0) {
//			for(int i = 1; i < n; i++) {
//				if(n%i==0) {
//					cont = cont + i;	
//				}
//			}
//
//			if(cont == n) {
//				System.out.println("El número "+ n + " es perfecto.\n");	
//			
//			}else {
//				System.out.println("El número "+ n + " no es perfecto.\n");	
//			}
//		}else {
//				System.out.println("Debes introducir un número positivo.\n");
//			}
		scan.close();
			}
			
}

