package Tema3;
import java.util.Scanner;
public class Main {
	public static Scanner scan = new Scanner(System.in);
	
	public static void ejercicio1() {
		char caracteresX[] = new char [25];
		double[] reales = new double [8];
		int enteros[] = new int [4];
		
		for(int i = 0; i < caracteresX.length; i++) {
			caracteresX[i] = 'x';
			System.out.println("En la posición " + i + " el array tiene el valor " + caracteresX[i]);
		}
		
		for(int i = 0; i < reales.length; i++) {
			reales[i] = 0.9;
			System.out.println("En la posición " + i + " el array tiene el valor " + reales[i]);
		}
		
		for(int i = 0; i < enteros.length; i++ ) {
			enteros[i] = 10;
			System.out.println("En la posición " + i + " el array tiene el valor " + enteros[i]);
		}
		
	}
	
	public static void ejercicio2_1() {
		int posiciones[] = new int [20];
		for(int i = 0; i < posiciones.length; i++) {
			posiciones[i] = i;
			
			System.out.println("En la posición " + i + " el array de posiciones tiene el valor " + posiciones[i]);
		}
	}
	
	public static void ejercicio2_2() {
		int posicionesInverso[] = new int [20];
		for(int i = 0; i < posicionesInverso.length; i++) {
			posicionesInverso[posicionesInverso.length - 1 - i] = i;
			
			
		}
		for(int i = 0; i < posicionesInverso.length; i++) {
		System.out.println("En la posición " + i + " el array de posiciones tiene el valor " + posicionesInverso[i]);
		}
	}

	public static void ejercicio2_23() {
		int posicionesInverso[] = new int [20];
		for(int i = 0; i < posicionesInverso.length; i++) {
			posicionesInverso[i] = posicionesInverso.length - 1 - i;
			System.out.println("En la posición " + i + " el array de posiciones tiene el valor " + posicionesInverso[i]);
		}
		}
	
	public static void ejercicio2_3() {
		boolean impares[] = new boolean [20];
		for (int i = 0; i < impares.length; i++) {
			if(i%2 == 0) impares[i] = false;
			else impares[i] = true;
			System.out.println("En la posición " + i + " el array de posiciones tiene el valor " + impares[i]);
			
		}
	}
/*
 * El array de notas tiene 5 posiciones, cada posición representa a una materia, la posición 0 representa a matemáticas,
 *  la 1 representa a química, la 2 a lengua, la 3 a historia, la 4 economía
 *  las notas solo pueden ser enteros
 *  
 */
	
	public static void ejercicio2_4() {
		int notas[] = {3,6,5,8,10};
		for(int i = 0; i < notas.length; i++) {
			switch(i) {
			case 0:
				System.out.print("La nota de matemáticas es: ");
				break;
			case 1:
				System.out.print("La nota de química es: ");
				break;
			case 2:
				System.out.print("La nota de lengua es: ");
				break;
			case 3:
				System.out.print("La nota de historia es: ");
				break;
			case 4:
				System.out.print("La nota de economía es: ");
				break;
			}
			if(notas[i] < 5) System.out.println("Suspenso.");
			else if(notas[i] == 5) System.out.println("Suficiente.");
			else if(notas[i] ==6) System.out.println("Bien.");
			else if(notas[i] < 9) System.out.println("Notable.");
			else System.out.println("Sobresaliente.");
		}
		
	}
	
	//Ejercicio 3
	
	public static int [] ejercicio3(int [] array) {
		int aux;
		for(int i = 0; i < array.length/2; i++) {
		aux = array[i];
		array[i] = array[array.length -1 -i];
		array[array.length -1 -i] = aux;
		}
		return array;
		
	}
	
	//Ejercicio 4 
	
	public static int aleatorio(int max) {
		double toret = Math.random()*max;
		return (int) toret;
	}
	
	public static void ejercicio4() {
		int [] urna = new int[80];
		for(int i = 0; i < urna.length; i ++) 
			urna[i] = 0;
		//Sacar bolas hasta que salga 3 veces el 33
		while(urna[33] < 3) {
		urna[aleatorio(80)]++;
		}
		for(int i = 0; i < urna.length; i++) {
			System.out.println("La bola " + i + " ha salido " + urna[i] + " veces.");
		}	
	}
	
	
	public static int ejercicio5(int [] array) {
		int max = array[0];
		int aux = 0;
		for(int i = 1; i < array.length; i ++) {
			if(array[i] > max) {
				max = array[i];
				aux = i;
			}
		}
		return aux;
		
	}
	
	public static void ejercicio1_2(){
		char caracteres[] = new char [25];
		double reales[] = new double [8];
		int enteros[] = new int [4];
		
		for(int i = 0; i < caracteres.length; i++) {
			caracteres[i] = 'x';
			System.out.println("En la posición " + i + " el valor es " + caracteres[i]);
		}
		
		for(int i = 0; i < reales.length; i++) {
			reales[i] = 0.9;
			System.out.println("En la posición " + i + " el valor es " + reales[i]);
			
		}
		
		for(int i = 0; i < enteros.length; i++) {
			enteros[i] = 10;
			System.out.println("En la posición " + i + "el valor es " + enteros[i]);
		}
	}
	
	public static void ejercicio2_2_2() {
		int iguales[] = new int [20];
		
		for(int i = 0; i < iguales.length; i++) {
			iguales[i] = i;
			System.out.println("En la posición " + i + " el valor es " + iguales[i]);
		}
	}
	
	public static void ejercicio2_2_3() {
		int inverso[] = new int [20];
		for(int i = 0; i < inverso.length; i++) {
			inverso[i] = inverso.length -1 -i;
			System.out.println("En la posición i " + i + " el valor es " + inverso[i]);
		}
		
	}
	
	public static void ejercicio2_2_4() {
		int[] notas = {1,10,7,0,8};
		
		for(int i = 0; i < notas.length; i++) {
		
			switch(i) {
			case 0: System.out.println("La nota de matemáticas es: ");
			break;
			case 1: System.out.println("La nota de química es ");
			break;
			case 2: System.out.println("La nota de lengua es ");
			break;
			case 3: System.out.println("La nota de historia es ");
			break;
			case 4: System.out.println("La nota de economía es ");
			break;
			}
			if(notas[i] == 0) {
				System.out.println(" NO PRESENTADO");
			}else if(notas[i] < 5) {
				System.out.println(" SUSPENSO");
			}else if(notas[i] < 6) {
				System.out.println(" APROBADO");
			}else if(notas[i] < 9) {
				System.out.println(" NOTABLE");
			}else if(notas[i] <= 10) {
				System.out.println(" SOBRESALIENTE");
			}
			
		
		}
		
	}
	//Ejercicio 6
	
	public static int[][] generadormatriz(){
		int toret [][] = new int [60][60];
		for(int i = 0; i < toret.length; i++) {
			for(int j = 0; i < toret.length; j++) {
				toret[i][j] = aleatorio(100);
			}
		}
		return toret;
	}
	
	public static int[][] generandomatrizpeque(int [][] entrada){
		int x = 0;
		int y = 0;
		do {
		System.out.println("Introduzca la dimensión x de la matriz");
		 x = scan.nextInt();
		 System.out.println("Introduce la dimensión de y de la matriz");
		 y = scan.nextInt();
		 if((x <= 0 || y <= 0) || (x >= entrada.length || y >= entrada.length)) {
			 System.out.println("La matriz debe ser positiva");
		 }
		}while((x <= 0 || y <= 0) || (x >= entrada.length || y >= entrada.length));
		 int toret [][] = new int [x][y];
		 for(int i = 0; i < toret.length; i++) {
				for(int j = 0; i < toret.length; j++) {
					toret[i][j] = entrada[i][j];
				}
			}
		 return toret;
	}
	
	
	public static void mostrarMatriz(int [][] entrada) {
		for(int i = 0; i < entrada.length; i++) {
			
			for(int j = 0; i < entrada.length; j++) {
				System.out.print("[" + entrada[i][j] + "]");
			}
			System.out.println();
		}
		
	}
	
	public static void mostrarMayorMenor(int [][] entrada) {
		int max = entrada[0][0];
		int min = entrada[0][0];
		for(int i = 0; i < entrada.length; i++) {
			for(int j = 0; i < entrada.length; j++) {
				if(max < entrada[i][j]) max = entrada[i][j];
				if (min > entrada[i][j]) min = entrada[i][j];
			}
		}
		System.out.println("El mayor elemento es " + max);
		System.out.println("El menor elemento es " + min);
		
	}
	
	public static void ejercicio6_4() {
		int[][] grande = generadormatriz();
		mostrarMatriz(grande);
		int[][] pequeña = generandomatrizpeque(grande);
		mostrarMatriz(pequeña);
	
		
	}
	
	
	
	public static int[][] ejer9Suma(int array1 [][] , int array2 [][]) {
		int suma [][] = new int[array1.length][array1[0].length];
		for(int i = 0; i < array1.length; i ++) {
			for(int j = 0; j < array1[i].length; j++) {
				suma[i][j] = array1[i][j] + array2[i][j];
			}
		}
		
		return suma;
	}
	
	//Ejercicio14
	//El metodo anagrama esta mal hecho!!!!
	
	public static boolean anagrama(String a, String b) {
		if(a.length() != b.length()) return false;
		boolean[] anagrama = new boolean[a.length()];
		for(int i = 0; i < a.length(); i++) {
			char letra = a.charAt(i);
			for(int j = 0; j < b.length(); j ++) {
				if(letra == b.charAt(j)) {
					anagrama[i] = true;
					
				}
			}
		}
		for( int i = 0; i < anagrama.length; i++ ) {
			if(!anagrama[i]) return false;
			else anagrama[i] = false;
		}
		for(int i = 0; i < b.length(); i++) {
			char letra = b.charAt(i);
			for(int j = 0; j < a.length(); j ++) {
				if(letra == a.charAt(j)) {
					anagrama[i] = true;
					
				}
			}
		}
		for( int i = 0; i < anagrama.length; i++ ) if(!anagrama[i]) return false;
		return true;
	}
	
	public static boolean anagrama2(String a, String b) {
		if(a.length() != b.length()) return false;
		boolean[] anagrama = new boolean[a.length()];
		int[] posiciones = new int[a.length()];
		for(int i = 0; i < posiciones.length; i++) posiciones[i] = -1;
		for(int i = 0; i < a.length(); i++) {
			char letra = a.charAt(i);
			for(int j = 0; j < b.length(); j ++) {
				if(letra == b.charAt(j)) {
					anagrama[i] = true;
					posiciones[i] = j;
				}
			}
		}
		for( int i = 0; i < anagrama.length; i++ ) {
			if(anagrama[i]) {
				int posActual = posiciones[i];
				for(int j = i+1; j < posiciones.length; j++) {
					if(posActual == posiciones[j]) return false;
				}
			}else {
				return false;
			}
		}
		return true;
	}
	
	//Ejercicio15
	
	public static void cuentaLetrasFrase(String frase) {
		String[] palabras = frase.split(" "); // La expresión regular podría ser ("[,. ]+") para que separe por espacios, puntos o comas. Split sirve para seeparar
		for(int i = 0; i < palabras.length; i ++) {
			if(!palabras[i].equals("")) //Con esto evitamos que si nos ponen dos espacios se imprima por pantalla
			System.out.println(palabras[i] + ":" + palabras[i].length());
		}
		
	}
	
	//Ejercicio16
	
	public static String eliminaBlancos(String frase) {
		String[] palabras = frase.split("[ ]+");
		String toret = "";
		for(int i = 0; i < palabras.length; i ++) {
			if(i == palabras.length -1) {
				toret += palabras[i] + ".";
			} else toret += palabras[i] + " ";
			
		}
		return toret;
	}
	
	//Ejercicio17
	public static boolean palabraCorrecta(String palabra) {
		if(palabra.length() > 15) return false;
		else return true;
	}
	
	public static boolean fraseCorrecta(String frase) {
		if(frase.length() > 80) return false;
		else return true;
	}
	
	public static void cuentaFrase(String frase) {
		String[] palabras = frase.split("[ ]+");
		int total = 0;
		if(fraseCorrecta(frase)) {
			for(int i = 0; i < frase.length(); i++) {
				if(palabraCorrecta(palabras[i])) {
					System.out.println(palabras [i] +" tiene " + palabras[i].length()+ " chars.");
					total += palabras[i].length();
				}else {
					System.out.println(palabras[i] + " no es correcta. Max 15 Chars");
				}
		
			}
			System.out.println("La frase tiene una longitud de " + total);
		}else {
			System.out.println("Frase demasiado larga.\n Max 80 chars.");
		}
		

	}
	
	public static void cuentaFrase2(String frase) {
		String[] palabras = frase.split("[ ]+");
		int total = 0;
		if(fraseCorrecta(frase)) {
			for(String palabra: palabras) { //for each; Es lo mismo que poner un bucle for con (int i ...)
				//palabra representa los mismo que palabras[i].
				if(palabraCorrecta(palabra)) {
					System.out.println(palabra +" tiene " + palabra.length()+ " chars.");
					total += palabra.length();
				}else {
					System.out.println(palabra + " no es correcta. Max 15 Chars");
				}
		
			}
			System.out.println("La frase tiene una longitud de " + total);
		}else {
			System.out.println("Frase demasiado larga.\n Max 80 chars.");
		}
		

	}
	
	public static void comunes(String frase1, String frase2) {
		
	}
	
	
	
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		ejercicio1();
//		ejercicio2_1();
//		ejercicio2_2();
//		ejercicio2_23();
//		ejercicio2_3();
//		ejercicio2_4();
//		int [] paraInvertir = {1, 2, 3, 4};
//		imprimir(ejercicio3(paraInvertir));
//		ejercicio4();
//       int [] max = {1,4,2,6};
//		System.out.println(ejercicio5(max));
//		
//		ejercicio1_2();
//		ejercicio2_2_2();
//		ejercicio2_2_3();
//		ejercicio2_2_4();
		
//		int [][] matriz1= {{1,2},{3,4}};
//		int [][] matriz2 = {{1,2},{3,4}};
//		System.out.println(ejer9Suma(matriz1, matriz2));
//		imprimirM(ejer9Suma(matriz1, matriz2));
//		ejercicio6_4();
//		System.out.println(anagrama("aabc", "abcd"));
//		System.out.println(anagrama2("abcc", "abcd"));
//		cuentaLetrasFrase("Hola Xandre no te enteras");
//		System.out.println(eliminaBlancos("Hola a todo el mundo"));
//		cuentaFrase("Hola a todo el mundo estapalabranodeberíaentrar");
//		cuentaFrase2("Hola a todo el mundo estapalabranodeberíaentrar");
		
		
		
		
		scan.close();
	}
		public static void imprimir( int [] array) {
			for(int x = 0; x < array.length; x++) {
				System.out.println(array[x]);
			}
		}
		public static void imprimirM( int [][] matriz){
			for (int x=0; x < matriz.length; x++) {
				  for (int y=0; y < matriz[x].length; y++) {
				    System.out.print (matriz[x][y]);
				    if (y!=matriz[x].length-1) System.out.print("\t");
				  }
				}
		}

		

		
}
