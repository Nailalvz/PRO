import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int a = 0, e = 0, i = 0, o = 0, u = 0;
		String ch;
		String aux;
		  
		for(int x = 0; x < 20; x++) {
			do {
				System.out.println("Introduzca un caracter");
			aux = scan.next();
			} while (aux.length()!=1);
			aux = aux.toLowerCase();
			ch = aux; // No se que problema hay aqui
			switch(ch) {
			case "a": a++; break;
			case "e": e++; break;
			case "i": i++; break;
			case "o": o++; break;
			case "u": u++; break;	
			}
		
		}
		
		System.out.println("Tenemos tantas a:" + a);
		System.out.println("Tenemos tantas e:" + e);
		System.out.println("Tenemos tantas i:" + i);
		System.out.println("Tenemos tantas o:" + o);
		System.out.println("Tenemos tantas u:" + u);
		
		
		scan.close();
		

		
		
	}

}
