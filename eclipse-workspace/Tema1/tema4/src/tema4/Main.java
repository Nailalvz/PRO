package tema4;

public class Main {
	

	public static void main(String[] args) {
		
		Libro libro1 = new Libro("1234A","Harry Potter y la piedra filosofal","J. K. Rowling",238);

		Libro libro2 = new Libro("5678B","Harry Potter y la c�mara secreta","J. K. Rowling", 356);
		
		System.out.println(libro1.toString());
		System.out.println(libro2.toString());
		
		Libro libro3 = new Libro(libro2);
		
		
		//Modifico el n�mero de p�ginas
		libro3.setNum_pag(57000);
		
		System.out.println(libro3.toString());
		
		
	}

}
