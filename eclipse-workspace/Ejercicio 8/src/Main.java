import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
	
		/*
		int n;
		int v;
		int aux = 0;
		
		
		System.out.println("Introduce el número de impares que quiere calcular: ");
		n = scan.nextInt();
		v = n;
		for ( int i = 1;i <= n; i++) {
			if((i%2) !=0) {
				aux = aux + i;
				
			} else {
				n++;
			}
			
			System.out.println("El resultado es " + aux);
		}
		
		*/
				
		
		//Ejercicio 8 versión impares hasta un número
		
		/*
		int n;
		int aux = 0;
		
		
		System.out.println("Introduce el número de impares que quiere calcular: ");
		n = scan.nextInt();
		for( int i = 1; i <= n; i ++)
		{
			aux = aux + i;
			i++;
		}
		
			System.out.println("La suma de los impares hasta " + n + " es: " + aux);
		
		*/
		
		int n, a = 1, sum = 0;
		System.out.println("Introduce el número de impares que quiere calcular: ");
		n = scan.nextInt();
		for(int i = 0; i < n; i++) { //bluce que empieza desde 0 y va a dar tantas vueltas como n le pongamos (n = 5, 5 vueltas dará el bucle;
			sum += a; // sum = sum + a
			a += 2; // a = a + 2
		}
		System.out.println("La suma de los impares hasta " + n + " es: " + sum);
	
		scan.close();
		
		
		
		
		
		
	}



}
