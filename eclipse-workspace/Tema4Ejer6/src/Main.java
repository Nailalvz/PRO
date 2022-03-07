
public class Main {

	public static void main(String[] args) {
		   NIF dni1 = new NIF();
		    dni1.leer();
		    System.out.println(dni1.toString());
		
		    NIF dni2 = new NIF(12345678);
		    System.out.println(dni2.toString());
		}
		
	}


