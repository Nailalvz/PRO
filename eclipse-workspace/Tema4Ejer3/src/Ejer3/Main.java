package Ejer3;
public class Main {

	public static void main(String[] args) {
	
		
		Contador contador = new Contador (2);
		Contador contador2 = new Contador (1);
		System.out.println(contador.getCont());
			
		contador.incrementar();
		
		System.out.println(contador.getCont());
		
		contador.decrementar();
		
		System.out.println(contador.getCont());
		
		contador2.decrementar();
		System.out.println(contador2.getCont());
		contador2.decrementar();
		System.out.println(contador2.getCont());
		contador2.decrementar();
		System.out.println(contador2.getCont());
		
	}



}
