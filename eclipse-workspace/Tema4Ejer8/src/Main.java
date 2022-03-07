import java.util.Scanner;
public class Main {
	


	static int indice;
	static Persona[] personas = new Persona[indice];
	static Scanner sc = new Scanner(System.in);
		
	public static void leerPersonas() {
		Persona e;
		Fecha a;
		String nombre, direc, ciudad;
		int cod_postal;
		int dia, mes, año;
		do {
			System.out.println("Introduce el número de personas: ");
			indice = sc.nextInt();
		}while(indice < 0);
		
		Persona[] personas = new Persona[indice];
		
		for(int i = 0; i < indice; i++) {
			sc.nextLine();
			System.out.println("Persona " + i);
			System.out.println("Nombre: ");
			nombre = sc.nextLine();
			System.out.println("Dirección: ");
			direc = sc.nextLine();
			System.out.println("Ciudad: ");
			ciudad = sc.nextLine();
			System.out.println("Código Postal: ");
			cod_postal = sc.nextInt();
			System.out.println("Dia de nacimiento: ");
			dia = sc.nextInt();
			System.out.println("Mes de nacimiento: ");
			mes = sc.nextInt();
			System.out.println("Año de nacimiento: ");
			año = sc.nextInt();
			
			
			a = new Fecha(dia, mes, año);
			e = new Persona(nombre, direc, cod_postal, ciudad, a);
			
			personas[indice] = e;
			indice++;
		}
	}
	
	public static void mostrar() {
		for(int i = 0; i < indice; i++) {
			System.out.println(personas[i] + "\n");
		}
	}
	
	public static void numeroDePersonas() {
		System.out.println("El número de personas es: " + indice);	
	}
	
	public static void cuantasPersonasVivenen(String a) {
		int cont = 0;
		for(int i = 0; i < indice; i ++) {
			if(personas[i].getCiudad() == a) {
				cont++;
			}
		}
		System.out.println("El número de personas que viven en " + a + "son: " + cont);
	}
	
	public static void personasMayoresDeEdad() {
		int cont = 0;
		for(int i = 0; i < indice; i++) {
			if(personas[i].esMayordeEdad()) {
				cont++;
			}
		}
		System.out.println("El número de personas mayores de edad son: " + cont);
	}
	
//	public static Persona personaMayorEdad() {
//		Persona mayor = personas[0];
//		for(int i = 0; i < indice; i++) {
//			
//		}
//		
//	
//		
//		
//		return null;
//		
//	}
	
	

	public static void main(String[] args) {
		
		
		leerPersonas();

		System.out.println("\n\nPersonas introducidas: ");
		mostrar();
		
		personasMayoresDeEdad();
		System.out.println("\n\n");
		
		
		cuantasPersonasVivenen("Vigo");
		
		Fecha a = new Fecha(01,03,1970);
		Fecha b = new Fecha(01,02,1970);
		System.out.println(a.esMayorQue(b));
		
		
		
	}



}
