import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i = 1; i <= 500; i++) {
			if((i%5) == 0 && (i%7) == 0) sum +=i; // && es para que sean múltiplos de 5 y 7 a la vez; || Para que sean los de 5 y también los de 7;
				
			}
		
				System.out.println("EL resultado de la suma es " + sum);
		
	
		
		
		scan.close();
		
		
		
		
		
		
		
		
		
		
	}

}
