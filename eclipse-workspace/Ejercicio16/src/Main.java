import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
	
		int x;
		System.out.println("Introduce un número entre 1 y 9 incluidos: ");
		x = scan.nextInt();
		do {
		
				if(x < 1 || x > 9) {
					System.out.println("El número debe estar entre 1 y 9");
					
				}
		}while (x < 1 || x < 9);
		if ( x < 4 || x == 5 || x==7)System.out.println("El número es primo");
		else System.out.println("El número no es primo");
	
		scan.close();

	}
}
