import java.util.Scanner;
public class Main {
	
	public static int año;
	public static String mes;
	public static boolean añoBisiesto;
	public static int días;
	public static boolean aux;
	public static int m;
	public static int n;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		String opcion;
		boolean salir = false;
		
		
		while(!salir) {
			System.out.println("Bienvenido al menú principal.\nSeleccione una de las siguientes opciones:\n");
			System.out.println("Introduzca 1 para calcular cuantos días tiene un mes y un año concretos.");
			System.out.println("Introduzca 2 para calcular el número combinatorio.");
			System.out.println("Introduzca 3 para calcular los números perfectos comprendidos entre dos números.");
			System.out.println("Introduzca 0 para salir.\n Introduzca su opción:");
			
			opcion = scan.next();
			
			switch(opcion) {
			
			
			case "1":
				System.out.println("Ha seleccionado la opción 1: ");
				
				do {
					System.out.println("Introduzca el año:");
					año = scan.nextInt();
					if(año < 0) System.out.println("El año introducido no es válido. Debe ser positivo.");
				}while(año < 0);
				
				do {
					System.out.println("Introduzca el mes:");
					aux = true;
					mes = scan.next();
					elegirMes();
					if(aux){
						System.out.println("Tiene " + días + " días.\n");
					}
				
				}while(!aux);  
				
				
				break;
			case "2":
				System.out.println("Ha seleccionado la opción 2: ");
			
				do {
					
					do {
						System.out.println("Introduzca el primer número:");
						m = scan.nextInt();
						if (m < 0) {
							System.out.println("El número debe ser positivo.");
						}
					
					}while(m < 0);
					
					do {
						System.out.println("Introduzca el segundo número:");
						n = scan.nextInt();
						if (n < 0) {
							System.out.println("El número debe ser positivo.");
						}
						
					}while(n < 0);
					if (n > m) {
						System.out.println("El primer número debe ser mayor que el segundo.");
					}
				
				}while(n > m);
				
				System.out.println("El combinatorio de " + m + " y de " + n + " es " + combinatorio()+ ".\n");
				
				break;
			case "3":
				System.out.println("Ha seleccionado la opción 3: ");

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
				System.out.println("La opción introducida no es válida.nDebe seleccionar entre las opciones 1, 2, 3 o 0.\n");
				break;
		
			}
		}
		
		
		scan.close();
	}
	public static boolean añoBisiesto() {
		if(año%4 == 0 && año%100 != 0 || año%400 == 0) {
			return añoBisiesto = true;
		}else {
			return añoBisiesto = false;
		}
	
	}
	
	public static boolean elegirMes() {
		
		switch (mes.toLowerCase()) {
		case "enero","marzo", "mayo", "julio", "agosto", "octubre", "diciembre":
			días = 31;
			
		break;
		case "febrero", "2":
			if(añoBisiesto()) {
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
			System.out.println("Introduzca un mes válido.");
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
