import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		 
		int minutos = 0, horas = 0, dias = 0;
		int total;
		do {
			System.out.println("Introduce los minutos ");
			total = scan.nextInt();
			if(total < 0) {
				System.out.println(); System.out.println("Debe ser un valor positivo");
			}
		} while (total < 0);
		dias = total/1440;
		horas = total/60 - dias*24;
		minutos = total%60;
		
				
		System.out.println("El resultado es: " + dias + " dias, " + horas + " horas, " + minutos + " minutos." );
		
		scan.close();
		
	}

}
