
public class main {

	public static void main(String[] args) {
		
		/*
		int i;
		for(i = 0; i < 10; i++) { // Bucle for: har� esto hasta que i valga 10, si quiero que decrezca se pone -- en vez de los ++
			System.out.println(i);
		}
		System.out.println("Estoy fuera, valgo: " + i );
		
		*/
		
		/*
		int i;
		for(i = 0; i < 10; i++) { // Bucle for: har� esto hasta que i valga 10, si quiero que decrezca se pone -- en vez de los ++
			if(i == 10) {
				System.out.println(i + ".");
				else if (i)
				System.out.println(i + ",");
			}
			System.out.println(i);
		}
		System.out.println("Estoy fuera, valgo: " + i );
		
		
		*/
		
		//bucle while. Condici�n switch case
		
		int x = 0;
		while(x != 10) {
			switch(x) {
			case 0: 
				System.out.println("Estoy en el cero");
				break;
			case 5:
				System.out.println("Estoy en el cinco");
				break;
			case 7:
				System.out.println("estoy en el siete");
				break;
			case 10:
				System.out.println("No deber�a ejecutarme");
				break;
					
			}
			 x++; // Para sumar 1 en cada vuelta del bucle
		  }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
