import java.util.Scanner;
public class Main {


	public static void main(String[] args) {
		
		
		
		Scanner scan = new Scanner(System.in);
		
		int num;
		int factorial = 1;
		boolean neg = false;
		
		System.out.println("Introduce un n�mero:");
		num = scan.nextInt();
		if(num < 0) { 
			num = num * -1; // Si es menor que cero multiplico el n�mero por -1 para tener el n�mero positivo
			neg = true;
		}
		for (int i = 1; i <= num; i++) {
			factorial = factorial * i;
		}
		System.out.println("El factorial de " + num + " es: " + factorial);
		
		
	
		
		scan.close();
		
		
		
		
		
	}

}
