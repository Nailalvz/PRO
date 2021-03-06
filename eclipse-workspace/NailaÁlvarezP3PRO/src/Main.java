import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	
	
	public static int buscarNumeros(int x, int [] array) {
		int toret = -1;
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == x) {
				toret = i;
				break;
			}	
		}
		
		return toret;
	}
	
	public static int aleatorio(int max) {
		double toret = Math.random()*max;
		return (int) toret;
	}
	
	
	public static boolean mayorFila(int array[][], int f, int col) {
		int mayor = array[f][col];
		
		
		for(int i = 0; i < array.length; i++) {
			if(array[i][col] > mayor) {
				return false;
			}	
			
		}	
		return true;
	}
		
	
	public static boolean menorColumna(int array[][], int f, int col) {
		int menor = array[f][col];
		
		
		for(int i = 0; i < array.length; i++) {
			if(array[f][i] < menor) {
				return false;
			}
		}
		return true;
		
	}
	
	public static boolean puntoSilla(boolean a, boolean b) {
		if(a && b) {
			return true;
		}else return false;
	}
	
	public static void imprimirFila(int array[]) {
		System.out.println("Fila:");
		for(int i = 0; i < array.length; i++) {
			System.out.print("[" + array[i] + "]");
		}System.out.println();
	}
	
	public static void imprimirColumna(int array[][], int col) {
		System.out.println("Columna:");
		for(int i = 0; i < array.length; i++) {
			System.out.println("[" + array[i][col] + "]");
		}
	}
	

    public static String inicioMayus(String apellido) {
        apellido = apellido.toLowerCase();
        char[] aux = apellido.toCharArray();
        aux[0] = Character.toUpperCase(aux[0]);
        return new String(aux);
    }
    
    public static void algoritmo3() {
    	String str = "";
    	
    	do {
    		System.out.println("Introduce el nombre, la inicial del segundo nombre seguida de un '.' y el apellido (Naila A. ?lvarez).\n"
    				+ "Si no tienes segundo nombre introduce el nombre y el apellido (Naila ?lvarez).");
    		str = scan.nextLine();
    		if(!str.matches("[a-zA-Z???????????? .]*")) {
    			System.out.println("Introduce solo letras, espacios y la inicial intermedia con el '.'\n"
    					+ "(No se aceptan tabulaciones, otros caracteres de puntaci?n o n?meros)\n");
    		}
    	}while(!str.matches("[a-zA-Z???????????? .]*"));
    	
    	String str2[] = str.split("[ ]+");
    	String aux[] = new String [str.length()];
    	
    	if(str2.length == 2) {
    		aux[0] = str2[1] + ',';
    		aux[0] = inicioMayus(aux[0]);
    		aux[1] = String.valueOf(Character.toUpperCase(str2[0].charAt(0))) + '.';
    		
    		for(int i = 0; i < str2.length;i++) {
    			System.out.print(aux[i]);
    		}
    		System.out.println();
    	}else if(str2.length == 3) {
    		aux[0] = str2[2] + ',';
    		aux[0] = inicioMayus(aux[0]);
    		aux[1] = String.valueOf(Character.toUpperCase(str2[0].charAt(0))) + '.';
    		aux[2] = String.valueOf(Character.toUpperCase(str2[1].charAt(0))) + '.';
    		
    		for(int i = 0; i < str2.length; i++) {
    			System.out.print(aux[i]);
    		}
    		System.out.println();
    	}else {
    		System.out.println("Formato instroducido no v?lido");
    	}
    }
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String opcion;
		boolean salir = false;
		
		while(!salir) {
			System.out.println("Bienvenido al men? principal.\nSeleccione una de las siguientes opciones:\n");
			System.out.println("Introduzca 1 para crear un vector con valores aleatorios y buscar un elemento dentro del vector creado.");
			System.out.println("Introduzca 2 para crear una matriz y comprobar si un elemento de dicha matriz es punto silla.");
			System.out.println("Introduzca 3 para introducir el nombre propio de una persona e imprimirlo en otro formato.");
			System.out.println("Introduzca 0 para salir.\n Introduzca su opci?n:");
			
			opcion = scan.next();
			
			switch(opcion) {
			
			case "1":
				System.out.println("Ha seleccionado la opci?n 1: ");
				System.out.println("Devolver? la posici?n en la que se encuentra el elemento que desea buscar, si no lo encuentr? devolver? -1.");
				int longitud = 0;
				int num = 0;
				boolean exit = false;
				char aux = 'b';
				
					
				
				do {
					System.out.println("Introduzca la longitud del vector: ");
					longitud = scan.nextInt();
					if(longitud <= 0) {
						System.out.println("La longitud del vector no puede ser menor que cero o cero.");
					}
					
				}while(longitud <= 0);
					
			
				int vector[] = new int [longitud];
				
				do {
					
					do {
						System.out.println("Introduzca el n?mero que desea buscar (Rango del 0 al 100): ");
						num = scan.nextInt();
						if(num < 0|| num > 100) {
							System.out.println("El n?mero debe estar comprendido entre 0 y 100");
						}
					}while(num < 0 || num > 100);
					
					for(int i = 0; i < vector.length; i++) {
						vector[i] = aleatorio(100);
						System.out.print("[" + vector[i] + "]");
					}System.out.println();
					
					System.out.println("El n?mero " + num + " se encuentra en la posici?n " + buscarNumeros(num, vector));
					
					do {
						
					
						System.out.println("?Quiere buscar otro elemento?\nIntroduzca una 'y' para continuar y una 'n' para salir.");
						aux =  scan.next().charAt(0);
						
						if(aux == 'n') {
							exit = true;
						}else if(aux == 'y') {
							
						}else {
							System.out.println("Introduzca una opci?n v?lida.");
							aux = 'b';
						}
					}while(aux == 'b');
				
				}while(exit == false);

				
				break;
				
			case "2":
				System.out.println("Ha seleccionado la opci?n 2: ");
				
				boolean exit2 = false;
				char aux2 = 'b';
				int dimension = 1;
				
				int fila = 0;
				int columna = 0;
				
				do {
					System.out.println("Introduce la dimensi?n de la matriz");
					dimension = scan.nextInt();
					
					if(dimension <= 0) {
						System.out.println("La dimensi?n de la matriz no puede ser cero o menor que cero.");
					}
					
				}while(dimension <= 0);
				
				int matriz[][] = new int [dimension][dimension];
				
				for(int i = 0; i < matriz.length; i++) {
					for(int j = 0; j < matriz.length; j++) {
						matriz[i][j] = aleatorio(100);
						System.out.print("[" + matriz[i][j] + "]");
					}System.out.println();
				}
				
				do {
					
					do {
						System.out.println("Introduzca la fila: ");
						fila = scan.nextInt();
						if(fila < 0 || fila >= dimension) {
							System.out.println("La fila no puede ser menor que cero o mayor que la dimensi?n de la matriz (Recordamos que las matrices comienzan en la posici?n 0).");
						}
					}while(fila < 0 || fila >= dimension);
					
					do {
						System.out.println("Introduzca la columna");
						columna = scan.nextInt();
						if(columna < 0 || columna >= dimension) {
							System.out.println("La columna no puede ser menor que cero o mayor que la dimensi?n de la matriz (Recordamos que las matrices comienzan en la posici?n 0).");
						}
					}while(columna < 0 || columna >= dimension);
					
					imprimirFila(matriz[fila]);
					imprimirColumna(matriz, columna);
					
					if(puntoSilla(mayorFila(matriz, fila, columna),menorColumna(matriz, fila, columna))) {
						System.out.println("El elemento de la fila " + fila + " y la columna " + columna + " es punto silla.");
					}else {
						System.out.println("El elemento de la fila " + fila + " y la columna " + columna + " no es punto silla.");
					}
					
					
					do {
						System.out.println("?Quiere buscar otro elemento?\nIntroduzca una 'y' para continuar y una 'n' para salir.");
						aux2 =  scan.next().charAt(0);
						
						if(aux2 == 'n') {
							exit2 = true;
						}else if(aux2 == 'y') {
							
						}else {
							System.out.println("Introduzca una opci?n v?lida.");
							aux2 = 'b';
						}
					}while(aux2 == 'b');
					
				}while(exit2 == false);
				
				
				
				break;
			case "3":
				System.out.println("Ha seleccionado la opci?n 3: ");
				algoritmo3();
				
			
				break;
				
			case "0":
				salir = true;
				System.out.println("Ha seleccionado salir.\nFin del programa.");
				break;
			
			default: 
				System.out.println("La opci?n introducida no es v?lida.\nDebe seleccionar entre las opciones 1, 2, 3 o 0.\n");
		
			}
			
		}
		scan.close();
		
	}

}