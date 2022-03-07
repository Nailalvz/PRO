import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	/*	
		int num1, num2;
		
		System.out.println("Introduce el primer número");
		num1 = scan.nextInt();
		
		System.out.println("Introduce el segundo número");
		num2 = scan.nextInt();
		
		if(num1 != 0 && num2 !=0) {
			if ((num1 < 0 && num2 < 0) || (num1 > 0 && num2 > 0)) {
				System.out.println("EL producto es positivo");
				
			} else { System.out.println("El producto es negativo");
			
		System.out.println("el producto es nulo");
		}
		*/
		
	
		int num = 0, sum = 0, aux = 0;
		System.out.println("Introduzca el número a analizar: \n");
		num = scan.nextInt();
		while(num!=0){
			aux = num%10;
			if(aux%2 == 0){
				sum = sum + aux;
			}
			num = num/10;
			System.out.println(aux);
		}
		System.out.println("Suma de los pares: " + sum);
		
		
		
		
		
		scan.close();
		}
	}


