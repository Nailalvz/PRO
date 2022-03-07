import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		
		
		String tweet; // Declaro una variable de texto
		int maximo = 281; //Declaro el máximo de caracteres
		
		System.out.println("Escriba el texto que quiere twittear: "); //Le indico por pantalla que escriba el texto
		tweet = scan.nextLine(); // Leo el texto
		
			if (tweet.length() > 0 && tweet.length()> maximo) {System.out.println("No twiteable"); // convierto el texto en variable numerica y si el numero es superior a 280 print no twiteable
			}
			else {System.out.println("Twiteable");// Si el número es menor indica que es twiteable
			
			}
			
			
			/*
		String tweet;
		System.out.println("Escriba el texto que quiere twittear: ");
		tweet = scan.next();
			if(tweet.length() < 0 && tweet.length()<281) {System.out.println("Twiteable");
				} 
			else { System.out.println("No twiteable");
			
			}
			*/
			
			
			scan.close();
			
			
			
			
			
			
			
			
			
			
	}


}