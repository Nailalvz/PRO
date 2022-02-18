package P4PRO;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		String opcion;
		boolean salir = false;
		
		ArrayList<Piso> listaPisos = new ArrayList<Piso>();
		
		Direccion A1 = new Direccion(0, "de Castelao", 83, 3, "D", 36209, "pontevedra");
		Piso A = new Piso(0, A1, 75, 500, 0, true, false);
		
		Direccion B1 = new Direccion(2, "de Malasaña", 32, 5, "A", 28004, "madrid");
		Piso B = new Piso(1, B1, 120, 650, 0, true, false);
		
		Direccion C1 = new Direccion(3, "Real", 10, 4, "B", 36216, "pontevedra");
		Piso C = new Piso(2, C1, 100, 575, 0, true, false);
		
		Direccion D1 = new Direccion(5, "de Andalucía", 3, 10, "C", 29601, "malaga");
		Piso D = new Piso(3, D1, 150, 1000, 750000, true, true);
		
		Direccion E1 = new Direccion(0, "de Galicia", 12, 2, "F", 49024, "zamora");
		Piso E = new Piso(4, E1, 70, 460, 450000, true, true);
		
		Direccion F1 = new Direccion(6, "Rosalía de Castro", 45, 7, "B", 36201, "pontevedra");
		Piso F = new Piso(5 ,F1, 110, 0, 875000, false, true);
		
		Direccion G1 = new Direccion(2, "de Praga", 55, 6, "D", 87690, "barcelona");
		Piso G = new Piso(6, G1, 55, 0, 313000, false, true);
		
		Direccion H1 = new Direccion(7, "Los Pinos", 87, 20, "A", 33006, "asturias");
		Piso H = new Piso(7, H1, 250, 0, 1200000, false, true);
		
		Direccion I1 = new Direccion(2, "de San Bartolomé", 30, 1, "A", 38900, "sevilla");
		Piso I = new Piso(8, I1, 35, 0, 130000, false, true);
		
		Direccion J1 = new Direccion(1, "El Madrigal", 25, 22, "B", 32911, "ourense");
		Piso J = new Piso(9, J1, 220, 0, 950000, false, true);
		
		listaPisos.add(A);
		listaPisos.add(B);
		listaPisos.add(C);
		listaPisos.add(D);
		listaPisos.add(E);
		listaPisos.add(F);
		listaPisos.add(G);
		listaPisos.add(H);
		listaPisos.add(I);
		listaPisos.add(J);
		
		Agencia agencia1 = new Agencia("FotoPisos", listaPisos);
		
		
		while(!salir) {
			System.out.println("Bienvenido al menú principal\n\n"
					+ "Lista de opciones:\n"
					+ "\t1. Mostrar toda la lista de pisos disponibles\n"
					+ "\t2. Mostrar solo pisos en alquiler\n"
					+ "\t3. Mostrar solo los pisos en venta\n"
					+ "\t4. Modificar un piso\n"
					+ "\t5. Añadir un piso\n"
					+ "\t6. Filtrar pisos por un rango de precio\n"
					+ "\t7. Filtrar pisos por un rango de metros cuadrados\n"
					+ "\t8. Eliminar un piso de la lista\n"
					+ "\tIntroduzca un 0 para finalizar.\nIntroduzca su opción: ");
			opcion = sc.nextLine();
			
			switch(opcion) {
			
			case "1": 
				System.out.println("\nEstos son todos los pisos disponibles:\n");
				agencia1.mostrar();
			break;
			
			case "2":
				System.out.println("\nEstos son todos los pisos en alquiler disponibles:\n");
				agencia1.mostrarAlquiler();
			break;
			
			case"3":
				System.out.println("\nEstos son todos los pisos en venta disponibles:\n");
				agencia1.mostrarVenta();
			break;
			
			case "4":
				agencia1.modificarPiso();
			break;
			
			case "5":
				System.out.println("Ha seleccionado la opción 5:");
				agencia1.crearPiso();
			break;
			
			case "6":
				System.out.println("Ha seleccionado la opción 6:");
				agencia1.listarPiso();
			break;
			
			case"7":
				System.out.println("Ha seleccionado la opción 6:");
				agencia1.listarPisosMetros();
			break;
			
			case "8":
				int idcase8;
				agencia1.mostrar();
				do {
					System.out.println("Introduce el ID del piso que desea eliminar: ");
					idcase8 = Integer.parseInt(sc.nextLine());
					if(!agencia1.idCorrecto(idcase8)) {
						System.out.println("El ID introducido no es válido.");
					}
				}while(!agencia1.idCorrecto(idcase8));
				
				agencia1.borrarPiso(idcase8);
			break;
			
			case "0" :
				salir = true;
				System.out.println("\nFin del Programa.");
				break;
				
			default:
				System.out.println("\nOpción no válida.\n");
			break;
				

			}
		}
		
		

	}

}
