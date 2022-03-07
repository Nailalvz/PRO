import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = 0;
		int n_max = 0;
	
		do {
			do {
					System.out.println("Introduzca un número positivo. \nSi desea finalizar el programa introduzca un O.");
					n = scan.nextInt();
					
			} while(n < 0);
			if(n > 0) {
				if(n > n_max) {
					System.out.println(n + " es mayor que el anterior");
					n_max = n;
					
				}else {
					n_max = n;
					
				}
			}
			
			
		} while (n != 0);
		System.out.println("Programa finalizado");
		scan.close();
		

	}

}
