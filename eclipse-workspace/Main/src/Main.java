import java.util.Scanner;
public class Main {
	
	static Scanner scan = new Scanner(System.in);
	
	public static int d�as() {
		int d�as = 0;
		String mes;
		int a�o;
		boolean aux;
		
		do {
			System.out.println("Introduzca el a�o:");
			a�o = scan.nextInt();
			if(a�o < 0) System.out.println("El a�o introducido no es v�lido. Debe ser positivo.");
		}while(a�o < 0);
		
		do {
			System.out.println("El mes puede ser introducido en letra o en n�mero. Introduzca el mes:");
			
			mes = scan.next();
			aux = true;
		
			switch(mes.toLowerCase()) {
			case "enero","marzo", "mayo", "julio", "agosto", "octubre", "diciembre":
				d�as = 31;
				
			break;
			case "febrero", "2":
				if(a�oBisiesto(a�o)) {
					d�as = 29;
					
					}else { d�as = 28;
					
					}
				break;
			case "abril", "junio", "septiembre", "noviembre":
				d�as = 30;
				
			break;
			case "1", "3", "5", "7", "8", "10", "12":
				d�as = 31;
				
			break;
			case "4", "6", "9", "11":
				d�as = 30;
				
			break;
			default: {
				aux = false;
				System.out.println("Introduzca un mes v�lido.");
				break;
			}
			
			
			}
		}while(!aux);
		
		System.out.println("El a�o " + a�o + " y el mes " + mes + " tiene " + d�as + " d�as.");
		return d�as;
	}


	private static boolean a�oBisiesto(int a�o) {
		
			if(a�o%4 == 0 && a�o%100 != 0 || a�o%400 == 0) {
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
				System.out.println("Introduce el primer n�mero:");
				m = scan.nextLong();
				if(m < 0) {
					System.out.println("El n�mero introducido no es v�lido. Solo se aceptan n�meros positivos.");
				}
				
			}while(m < 0);
			
			do {
				System.out.println("Introduce el segundo n�mero:");
				n = scan.nextLong();
				if(n < 0) {
					System.out.println("El n�mero introducido no es v�lido. Solo se aceptan n�meros positivos.");
				}
				if(n > m) {
					System.out.println("El primer n�mero debe ser mayor que el segundo.");
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
			System.out.println("Bienvenido al men� principal.\nSeleccione una de las siguientes opciones:\n");
			System.out.println("Introduzca 1 para calcular cuantos d�as tiene un mes y un a�o concretos.");
			System.out.println("Introduzca 2 para calcular el n�mero combinatorio de dos n�meros.");
			System.out.println("Introduzca 3 para calcular los n�meros perfectos comprendidos entre dos n�meros.");
			System.out.println("Introduzca 0 para salir.\n Introduzca su opci�n:");
			
			opcion = scan.next();
			
			switch(opcion) {
			
			case "1":
				System.out.println("Ha seleccionado la opci�n 1: ");
				d�as();
				break;
				
			case "2":
				System.out.println("Ha seleccionado la opci�n 2: ");
				System.out.println(combinatorio() + "\n");
				break;
				
			case "3":
				System.out.println("Ha seleccionado la opci�n 3: ");
				
				int n;
				int m;
				do {
					do {
						System.out.println("Introduzca el primer n�mero:");
						n = scan.nextInt();
						if(n < 0) {
							System.out.println("El n�mero debe ser positivo.");
						}
						
					}while(n < 0);
					
					do {
						System.out.println("Introduzca el segundo n�mero:");
						m = scan.nextInt();
						if(m < 0 ) {
							System.out.println("El n�mero debe ser positivo.");
						}
					
					}while(m < 0);
					if(m < n) {
						System.out.println("El segundo n�mero debe ser mayor que el primero.");
					}
				}while(m < n);
				
				for(int i = n; i <= m; i++) {
					if(perfecto(i)) {
						System.out.println("El n�mero " + i + " es perfecto.\n");
					}
				}
				
				break;
				
			case "0":
				salir = true;
				System.out.println("Ha seleccionado salir.\nFin del programa.");
				break;
			
			default: 
				System.out.println("La opci�n introducida no es v�lida.\nDebe seleccionar entre las opciones 1, 2, 3 o 0.\n");
		
			}
			
		}
		scan.close();
		
	}

}