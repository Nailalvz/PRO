import java.util.Scanner;

public class NIF {

	private int numero;
	private char letra;
	
	
	public NIF() {
		this.numero = 0;
	}
	
	public NIF(int numero) {
		this.numero = numero;
		letra = CalcularLetra();
		
	}
	

	public int getNumero() {
		return this.numero;
	}
	
	//Modificara el dni y la letra para que la letra sea siempre correcta
	public void setNumero(int numero) {
		this.numero = numero;
		this.letra = CalcularLetra();
	}
	
	public char getLetra() {
		return this.letra;
	}
	
	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	
	private char CalcularLetra() {
		char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
                'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		return letras[getNumero()%23];
		}
	
	public void leer() {
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("Introduce un número de DNI válido:");
			numero = scan.nextInt();
		}while(numero < 0);
		letra = CalcularLetra();
		scan.close();
	}
	
	public String toString() {
		return getNumero() + "-" + getLetra();
		
	}
}
	
	

