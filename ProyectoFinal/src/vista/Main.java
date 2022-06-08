package vista;

import java.util.Scanner;

public class Main {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		String opcion;
		boolean salir = false;
		
		while(!salir) {
			System.out.println("Seleccione una opci�n del men�: "
					+ "\n\t1. Gestionar art�culo."
					+ "\n\t0. Salir");
			opcion = scan.nextLine();
			switch(opcion) {
			case "1": 
				ArticuloVista.gestionaArticulos();
				break;
				
			case "0":
				System.out.println("Fin del programa");
				salir = true;
				break;
				
			default:
				System.err.println("La opci�n no es v�lida.\n\tVuelva a intentarlo.");
			}
		}
		
	}

}
