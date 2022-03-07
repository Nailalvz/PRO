import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int res = 0, x, y;
		do {
			System.out.println("Introduzaca la x: ");
			x = scan.nextInt();
					System.out.println("Introduza la y: ");
			y = scan.nextInt();
					if(x >= 0 && y > 0) {
						for(int i = 1; i <= y; i++){
							 res *= x;
						}
						System.out.println("El resultado es: " + res);
					}
					else if (y == 0) System.out.println("El resultado es 1.");
					else System.out.println("Ambos números deben ser positivos");
		}while( x < 0 || y < 0);
		
		
		
		
	
		scan.close();
	

	}

}
