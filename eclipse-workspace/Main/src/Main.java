import java.util.Scanner;
public class Main {
	
	static Scanner scan = new Scanner(System.in);
	
	public static int días() {
		int días = 0;
		String mes;
		int año;
		boolean aux;
		
		do {
			System.out.println("Introduzca el año:");
			año = scan.nextInt();
			if(año < 0) System.out.println("El año introducido no es válido. Debe ser positivo.");
		}while(año < 0);
		
		do {
			System.out.println("El mes puede ser introducido en letra o en número. Introduzca el mes:");
			
			mes = scan.next();
			aux = true;
		
			switch(mes.toLowerCase()) {
			case "enero","marzo", "mayo", "julio", "agosto", "octubre", "diciembre":
				días = 31;
				
			break;
			case "febrero", "2":
				if(añoBisiesto(año)) {
					días = 29;
					
					}else { días = 28;
					
					}
				break;
			case "abril", "junio", "septiembre", "noviembre":
				días = 30;
				
			break;
			case "1", "3", "5", "7", "8", "10", "12":
				días = 31;
				
			break;
			case "4", "6", "9", "11":
				días = 30;
				
			break;
			default: {
				aux = false;
				System.out.println("Introduzca un mes válido.");
				break;
			}
			
			
			}
		}while(!aux);
		
		System.out.println("El año " + año + " y el mes " + mes + " tiene " + días + " días.");
		return días;
	}


	private static boolean añoBisiesto(int año) {
		
			if(año%4 == 0 && año%100 != 0 || año%400 == 0) {
				return true;
			}else {
				return false;
	
			}
	}

	public static long combinatorio() {
		
		long m;
		long n;
		long aux;
		
		do {
			do {
				System.out.println("Introduce el primer número:");
				m = scan.nextLong();
				if(m < 0) {
					System.out.println("El número introducido no es válido. Solo se aceptan números positivos.");
				}
				
			}while(m < 0);
			
			do {
				System.out.println("Introduce el segundo número:");
				n = scan.nextLong();
				if(n < 0) {
					System.out.println("El número introducido no es válido. Solo se aceptan números positivos.");
				}
				if(n > m) {
					System.out.println("El primer número debe ser mayor que el segundo.");
				}
				
			}while(n < 0);
			
		}while(n > m);
		 aux = (factorial(m)/(factorial(n)*factorial(m - n)));
		 System.out.println("El combinatorio de " + m + " y de " + n + " es: ");
		 return aux;

	}
	
	public static long factorial(long x) {
		long fact = 1;
		for( int i = 1; i <= x; i++) {
			fact *= i;
		}
		return fact;
	}

	public static boolean perfecto(int x) {
		int cont = 0;
		for(int i = 1; i < x; i++) {
			if(x%i==0) {
				cont = cont + i;	
			}
		}
		if(x == cont) {
			return true;
		}else {
			return false;
		}
	
	}
	
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String opcion;
		boolean salir = false;
		
		while(!salir) {
			System.out.println("Bienvenido al menú principal.\nSeleccione una de las siguientes opciones:\n");
			System.out.println("Introduzca 1 para calcular cuantos días tiene un mes y un año concretos.");
			System.out.println("Introduzca 2 para calcular el número combinatorio de dos números.");
			System.out.println("Introduzca 3 para calcular los números perfectos comprendidos entre dos números.");
			System.out.println("Introduzca 0 para salir.\n Introduzca su opción:");
			
			opcion = scan.next();
			
			switch(opcion) {
			
			case "1":
				System.out.println("Ha seleccionado la opción 1: ");
				días();
				break;
				
			case "2":
				System.out.println("Ha seleccionado la opción 2: ");
				System.out.println(combinatorio() + "\n");
				break;
				
			case "3":
				System.out.println("Ha seleccionado la opción 3: ");
				
				int n;
				int m;
				do {
					do {
						System.out.println("Introduzca el primer número:");
						n = scan.nextInt();
						if(n < 0) {
							System.out.println("El número debe ser positivo.");
						}
						
					}while(n < 0);
					
					do {
						System.out.println("Introduzca el segundo número:");
						m = scan.nextInt();
						if(m < 0 ) {
							System.out.println("El número debe ser positivo.");
						}
					
					}while(m < 0);
					if(m < n) {
						System.out.println("El segundo número debe ser mayor que el primero.");
					}
				}while(m < n);
				
				for(int i = n; i <= m; i++) {
					if(perfecto(i)) {
						System.out.println("El número " + i + " es perfecto.\n");
					}
				}
				
				break;
				
			case "0":
				salir = true;
				System.out.println("Ha seleccionado salir.\nFin del programa.");
				break;
			
			default: 
				System.out.println("La opción introducida no es válida.\nDebe seleccionar entre las opciones 1, 2, 3 o 0.\n");
		
			}
			
		}
		scan.close();
		
	}

}