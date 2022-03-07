import java.util.Scanner;
public class Main {
	
	public static int a�o;
	public static String mes;
	public static boolean a�oBisiesto;
	public static int d�as;
	public static boolean aux;
	public static int m;
	public static int n;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		String opcion;
		boolean salir = false;
		
		
		while(!salir) {
			System.out.println("Bienvenido al men� principal.\nSeleccione una de las siguientes opciones:\n");
			System.out.println("Introduzca 1 para calcular cuantos d�as tiene un mes y un a�o concretos.");
			System.out.println("Introduzca 2 para calcular el n�mero combinatorio.");
			System.out.println("Introduzca 3 para calcular los n�meros perfectos comprendidos entre dos n�meros.");
			System.out.println("Introduzca 0 para salir.\n Introduzca su opci�n:");
			
			opcion = scan.next();
			
			switch(opcion) {
			
			
			case "1":
				System.out.println("Ha seleccionado la opci�n 1: ");
				
				do {
					System.out.println("Introduzca el a�o:");
					a�o = scan.nextInt();
					if(a�o < 0) System.out.println("El a�o introducido no es v�lido. Debe ser positivo.");
				}while(a�o < 0);
				
				do {
					System.out.println("Introduzca el mes:");
					aux = true;
					mes = scan.next();
					elegirMes();
					if(aux){
						System.out.println("Tiene " + d�as + " d�as.\n");
					}
				
				}while(!aux);  
				
				
				break;
			case "2":
				System.out.println("Ha seleccionado la opci�n 2: ");
			
				do {
					
					do {
						System.out.println("Introduzca el primer n�mero:");
						m = scan.nextInt();
						if (m < 0) {
							System.out.println("El n�mero debe ser positivo.");
						}
					
					}while(m < 0);
					
					do {
						System.out.println("Introduzca el segundo n�mero:");
						n = scan.nextInt();
						if (n < 0) {
							System.out.println("El n�mero debe ser positivo.");
						}
						
					}while(n < 0);
					if (n > m) {
						System.out.println("El primer n�mero debe ser mayor que el segundo.");
					}
				
				}while(n > m);
				
				System.out.println("El combinatorio de " + m + " y de " + n + " es " + combinatorio()+ ".\n");
				
				break;
			case "3":
				System.out.println("Ha seleccionado la opci�n 3: ");

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
				System.out.println("La opci�n introducida no es v�lida.nDebe seleccionar entre las opciones 1, 2, 3 o 0.\n");
				break;
		
			}
		}
		
		
		scan.close();
	}
	public static boolean a�oBisiesto() {
		if(a�o%4 == 0 && a�o%100 != 0 || a�o%400 == 0) {
			return a�oBisiesto = true;
		}else {
			return a�oBisiesto = false;
		}
	
	}
	
	public static boolean elegirMes() {
		
		switch (mes.toLowerCase()) {
		case "enero","marzo", "mayo", "julio", "agosto", "octubre", "diciembre":
			d�as = 31;
			
		break;
		case "febrero", "2":
			if(a�oBisiesto()) {
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
			System.out.println("Introduzca un mes v�lido.");
			aux = false;
		}
	}
		return aux;
		
	}
	public static int factorial(int x) {
		int fact = 1;
		for( int i = 1; i <= x; i++) {
			fact *= i;
		}
		return fact;
	}
	
	public static int combinatorio() {
		 int aux;
		 aux = factorial(m)/(factorial(n)*factorial(m - n));
		 
		 return aux;

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

}
