import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		int n, sumPar = 0, numPares = 0, sumImpar = 0;
		for(int i = 1; i <= 10; i++){
			System.out.println("Introduce un número: ");
			n = scan.nextInt();
			if(n%2 == 0) {
				sumPar += n;
				numPares++;
				
			}else {
				sumImpar +=n;
				
			}
		}
		
		System.out.println("La suma de los pares es: " + sumPar);
		System.out.println("El números de pares es: " + numPares);
		System.out.println("La media de los impares es: " + sumImpar/(10f - numPares));
		
		
		scan.close();
	}

}
