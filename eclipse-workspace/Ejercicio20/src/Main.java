import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
	int n, sum = 0, aux = 0;
	System.out.println("Introduca un número para analizarlo: ");
	n = scan.nextInt();
	
	while(n != 0) {
		aux = n%10;
			if (aux%2 == 0) {
				sum = sum + aux;
			}
			n = n/10;
			System.out.println(aux);
	}
	System.out.println("La suma de los pares es: " + sum);
		
	
	
		
		
		
		
		
		
		
		scan.close();

	}

	
	}


