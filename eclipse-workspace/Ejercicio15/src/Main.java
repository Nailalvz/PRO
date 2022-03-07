
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	float min, max, var;
	System.out.println("Introduce un numero: ");
	var = scan.nextFloat();
			min = max = var;
	
	for( int i = 1; i < 20; i++) {
		System.out.println("Introduzca el valor " + (i+1) + ":");
		var = scan.nextFloat();
		if(var > max) max = var;
		else if (var < min) min = var;
		
		
	}
System.out.println("El valor máximo es " + max + " y el valor mínimo es " + min + ".");
	
	
	
	scan.close();

	}

}
