import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		
			String opcion;
			boolean salir = false;
			
			while(!salir) {
				System.out.println("Bienvenido al menú principal.\nSeleccione una de las siguientes opciones:\n");
				System.out.println("Introduzca 1 para ejecutar el primer programa.");
				System.out.println("Introduzca 2 para ejecutar el segundo programa.");
				System.out.println("Introduzca 3 para salir.");
				System.out.println("Introduzca su opción:");
				opcion = scan.next();
				
				switch (opcion) {
                case "1":
                    System.out.println("Has seleccionado la opción 1:\n");
                    
                    int cont = 0;
            		int n;
            		
            		do {
            		System.out.println("Introduzca un número entero y positivo para saber si es perfecto: ");
            		n = scan.nextInt();
            		}while(n < 0); 
            		
            		
            		if(n > 0) {
            			for(int i = 1; i < n; i++) {
            				if(n%i==0) {
            					cont = cont + i;	
            				}
            			}
         
            			if(cont == n) {
            				System.out.println("El número "+ n + " es perfecto.\n");	
            			
            			}else {
            				System.out.println("El número "+ n + " no es perfecto.\n");	
            			}
            		}else {
            				System.out.println("Debes introducir un número positivo.\n");
            			}
                    break;
                case "2":
                    System.out.println("Has seleccionado la opción 2:\n");
                    
                    int n1;
            		int n2;
            		
            		do {
            			System.out.println("Introduzca el primer número positivo. Si desea finalizar el programa introduzca el número cero (0).");
            			n1 = scan.nextInt();
            		}while(n1 < 0);
            		
            		if(n1==0) { System.out.println("Programa finalizado.\n");
        			
        			}else {
            		
        				do {
            			
        					do {
        						System.out.println("Introduzca un número positivo. Si desea finalizar el programa introduzca el número cero (O).");
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
        					System.out.println("Programa finalizado.\n");
        			}
                    
                    break;
                case "3":
                	salir = true;
                    System.out.println("Has seleccionado la opción 3.\nFin del programa.");
                    break;
                default:
                    System.out.println("La opción no es válida. Seleccione entre la opción 1, 2 o 3.\n");
				}
	
			}
			
		scan.close();
	}

}
