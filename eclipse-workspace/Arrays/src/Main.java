import java.util.Scanner;
public class Main {
	
	public static boolean anagrama(String a, String b) {
		boolean anagrama[] = new boolean [a.length()];
		if(a.length() != b.length()) { return false;
		
		}else 
			for (int i = 0; i < a.length(); i++) {
				char letra = a.charAt(i);
				for(int j = 0; j < b.length(); j++) {
					if(b[j] == letra) {
						anagrama[i] = true;
					}
				}
			}
			
		return true;
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String cadena1[] = "abcd";
		String cadena2[] = "abee";
		
		//Ejercicio pedir la longitud del array
//		int longitud = 0;
//		 
//		  System.out.print("¿Cuantos número deseas ingresar?");
//		  longitud = scan.nextInt(); //Leemos la longitud del array
//		  
//		  int numeros[] = new int[longitud]; //Asignamos al array numeros la longitud
//
//		  for(int i = 0; i < numeros.length; i++){
//		   System.out.println("Por favor dame el valor número " + (i + 1));
//		   numeros[i] = scan.nextInt(); //Con este for damos valores a la posiciones del array
//		  }
		//Con este for recorremos el array para mostrar los valores de cada posición
//		  for(int i = 0; i < numeros.length; i++){
//		   System.out.print("En la posición "+ i + " el valor es [" + numeros[i] + "]\n"); 
//		  }
//		  
//		  
//		//Ejercicio sencillo matrices bidimensionales
//			int numeros[][] = new int [2][2]; //Declaro la matriz
//		
//			//Asigno valores a las posisicones de la matriz primero i, luego j
//			numeros [0][0] = 5;
//			numeros [0][1] = 2;
//			numeros [1][0] = 2;
//			numeros [1][1] = 5;
//			
//			//Imprimo la matriz en la posición deseada
//			
//			System.out.print("[" + numeros[0][0] + "]");
//			System.out.println("[" + numeros[0][1] + "]");
//			System.out.print("[" + numeros[1][0] + "]");
//			System.out.print("[" + numeros[1][1] + "]");
			
		
		//Ejercicio que asigna valores a las columnas y filas de la matriz 
//		  int filas = 8;
//		  int columnas = 3;
//		  int contador = 1;
//		  
//		  int numeros[][] = new int[filas][columnas];
//		  
//		  for(int i = 0; i < filas; i++) {
//			  for(int j = 0; j < columnas; j++) {
//				  numeros[i][j] = contador;
//				  contador++;
//				  System.out.print("[" + numeros[i][j] + "]");
//			  }
//			  System.out.println();
//		  }
		  
		//Ejercicio 1_1 tema 3
		//Asignamos a cada posición del vestor el caracter x
//		
//		  char caracter[] = new char [25];
//		  
//		  for(int i = 0; i < caracter.length; i++) {
//			  caracter[i] = 'x';
//			  System.out.println("En la posición " + i + " el valor es: " + caracter[i]);
//		  }
//		  
//		  
//		//Ejercicio 1_2 tema 3
//		  
//		  float reales[] = new float [8];
//		  
//		  for(int i = 0; i < reales.length; i++) {
//			  reales[i] = (float) 0.9;
//			  System.out.println("En la posición " + i + " el valor es: " + reales[i]);
//		  }
		  
		//Ejercicio 2_1 tema3
		  
//		  int vector[] = new int [20];
//		  
//		  for(int i = 0; i < vector.length; i++) {
//			  vector[i] = i;
//			  System.out.println("En la posición " + i + " el valor es: " + vector[i]);
//		  }
		  
		//Ejercicio 2_2 tema 3
		  
//		  int inverso[] = new int [20];
//		  
//		  for(int i = 0; i < inverso.length; i++) {
//			  inverso[i] = (inverso.length - i - 1);
//			  System.out.println("En la posición " + i + " el valor es: " + inverso[i]);
//		  }
		  
		 //Ejercicio 2_3 tema 3
		  
//		  boolean numeros[] = new boolean [20];
//		  
//		  for(int i = 0; i < numeros.length; i++) {
//			  if(i%2 == 0) {
//				  numeros[i] = false;
//			  }else {
//				  numeros[i] = true;
//			  }
//			  System.out.println("En la posición " + i + " su valor es: " + numeros[i]);
//		  }
//		  
		  //Ejercicio 3 Tema 3
		  
//		  int invertir[] = {1,2,3,4};
//		  int aux = 0;
//		  
//		  for(int i = 0; i < invertir.length/2; i++) {
//			  aux = invertir[i];
//			  invertir[i] = invertir[invertir.length -1 -i];
//			  invertir[invertir.length -1 -i] = aux;
//			  
//		  }
//		  for(int i = 0; i < invertir.length; i ++){
//			  System.out.println("En la posición " + i + " su valor es: " + invertir[i]);
//		  }
		  
		  //Ejercicio 4 Tema 3
		
//		int urna[] = new int [80];
//		int cont = 0;
//		
//		for(int i = 0; i < urna.length; i++) {
//			urna[i] = 0;
//		}
//		do {
//			urna[ (int) (Math.random()*79)]++;
//			cont++;
//		}while(urna[33] < 3);
//		  for(int i = 0; i < urna.length; i++) {
//			  System.out.println("La bola " + i + " ha salido " + urna[i]);
//		  }
//		  System.out.println("El total de bolas es: " + cont);
//		  
		//Ejercicio 5 tema 3
		
//		int enteros[] = {1,2,6,8,4};
//		int max = enteros[0];
//		int pos = 0;
//		
//		
//		for(int i = 0; i < enteros.length; i++) {
//			if(enteros[i] > max) {
//				max = enteros[i];
//				pos = i;
//			}
//			
//		}
//		System.out.println("El mayor valor es: " + max + " y la posición es: " + pos);
//		
//		
		
		//Ejercicio 9 tema 3
		
//		int num1 [][] = new int [3][3];
//		int num2 [][] = new int [3][3];
//		int suma [][] = new int [num1.length][num1.length];
//		int contador = 1;
//		
//		for(int i = 0; i < num1.length; i++) {
//			for(int j = 0; j < num1.length; j++) {
//				num1[i][j] = contador;
//				contador++;
//				System.out.print("[" + num1[i][j] + "]");
//			}
//			System.out.println();
//		}
//		
//		
//		for(int i = 0; i < num2.length; i++) {
//			for(int j = 0; j < num2.length; j++) {
//				num2[i][j] = contador;
//				contador++;
//				System.out.print("[" + num2[i][j] + "]");
//			}
//			System.out.println();
//		}
//		
//		for(int i = 0; i < num2.length; i++) {
//			for(int j = 0; j < num2.length; j++) {
//				suma[i][j] = num2[i][j] + num1[i][j];
//				
//			}
//		}
//		for(int i = 0; i < suma.length; i++) {
//			for(int j = 0; j < suma.length; j++) {
//				System.out.print("[" + suma[i][j] + "]");
//			}
//			System.out.println();
//		}
//		
//		
//		
		
		//Ejercicio 17 tema 3
		

		
		
		
		
		 }
		}

	


