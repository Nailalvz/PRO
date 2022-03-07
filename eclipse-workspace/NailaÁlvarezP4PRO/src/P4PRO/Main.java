package P4PRO;

import java.util.*;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	static int cont = 10;
	static ArrayList<Piso> ListaPisos = new ArrayList<Piso>();
	public static Agencia Agencia1;


	public static void main(String[] args) {
		
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

		ListaPisos.add(A);
		ListaPisos.add(B);
		ListaPisos.add(C);
		ListaPisos.add(D);
		ListaPisos.add(E);
		ListaPisos.add(F);
		ListaPisos.add(G);
		ListaPisos.add(H);
		ListaPisos.add(I);
		ListaPisos.add(J);
		
		Agencia1 = new Agencia("FotoPisos", ListaPisos);

		String opcion;
		boolean salir = false;
		
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
				Agencia1.mostrar();
			break;
				
			case "2":
				System.out.println("\nEstos son todos los pisos en alquiler disponibles:\n");
				Agencia1.mostrarAlquiler();
			break;
			case "3":
				System.out.println("\nEstos son todos los pisos en venta disponibles:\n");
				Agencia1.mostrarVenta();
			break;
			case "4":
				String opcion2 = "";
				boolean salir2 = false;
				
				System.out.println("\nLista de pisos:\n");
				Agencia1.mostrar();
				
				while(!salir2) {
					System.out.println("Opciones de modificación:\n"
							+ "\t1. Dirección.\n"
							+ "\t2. Metros cuadrados.\n"
							+ "\t3. Precio y disponibilidad de alquiler.\n"
							+ "\t4. Precio y disponibilidad de venta.\n"
							+ "\t0. Regresar al menú principal."
							+ "\nIntroduzca su opción: ");
					opcion2 = sc.nextLine();

				switch(opcion2) {
				
					case "1":
						
						int id3;
						do {
							System.out.println("Introduce el ID del piso que desea modificar: ");
							id3 = Integer.parseInt(sc.nextLine());
							if(!Agencia.IDCorrecto(id3)) {
								System.out.println("El ID introducido no existe.");
							}
						}while(!Agencia.IDCorrecto(id3));
						
						System.out.println(Agencia1.getListaPisos().get(id3).toString() + "\n");
						String opcion3 = "";
						boolean salir3 = false;
						while(!salir3) {
								System.out.println("Opciones de modificación de la dirección:\n"
								+ "\t1- Tipo de vía\n"
								+ "\t2- Nombre de la calle\n"
								+ "\t3- Número de la calle\n"
								+ "\t4- Número del piso\n"
								+ "\t5- Letra del piso\n"
								+ "\t6- Código postal\n"
								+ "\t7- Provincia\n"
								+ "\t0- Para salir\n"
								+ "Introduzca su opcion: ");
								opcion3 = sc.nextLine();

						switch(opcion3) {
							case"1": 
								int aux;
								do {
									System.out.println("Se le ha asignado a cada tipo de vía un identificador de la siguiente forma:"
											+ "\n\tAvenida: 0"
											+ "\n\tBulevar: 1"
											+ "\n\tCalle: 2"
											+ "\n\tCamino: 3"
											+ "\n\tCarretera: 4"
											+ "\n\tPlaza: 5"
											+ "\n\tRúa: 6"
											+ "\n\tUrbanizacion: 7"
											+ "\n\tOtro: 8"
											+ "\nIntroduzca el identificador para seleccionar el tipo de vía: ");
									aux = Integer.parseInt(sc.nextLine());
									if(aux < 0 || aux > 8) {
										System.out.println("Error al seleccionar el tipo de vía. Vuelva a introducir el identificador.\n");
									}
								}while(aux < 0 || aux > 8);
								Agencia1.getListaPisos().get(id3).getDireccion().setTipodeVia(aux);
								System.out.println("\n" + Agencia1.getListaPisos().get(id3).toString() + "\n\n\tCambio realizado con éxito.\n\tVolviendo al menú de modificación.\n");
							break;
							
							case"2":
								System.out.println("Introduzca el nombre de la calle:");
								String calle = sc.nextLine();
								Agencia1.getListaPisos().get(id3).getDireccion().setNombre(calle);
								System.out.println("\n" + Agencia1.getListaPisos().get(id3).toString() + "\n\n\tCambio realizado con éxito.\n\tVolviendo al menú de modificación.\n");
							break;
							
							case"3":
								int numCalle;
								do {
									System.out.println("Introduzca el número de la calle:");
									numCalle = Integer.parseInt(sc.nextLine());
									if(numCalle <= 0) {
										System.out.println("El número de la calle no debe ser menor o igual a 0.");
									}
								}while(numCalle <= 0);
								
								Agencia1.getListaPisos().get(id3).getDireccion().setNumCalle(numCalle);
								System.out.println("\n" + Agencia1.getListaPisos().get(id3).toString() + "\n\n\tCambio realizado con éxito.\n\tVolviendo al menú de modificación.\n");
							break;
							
							case "4":
								int numPiso;
								do {
									System.out.println("Introduzca el número del piso:");
									numPiso = Integer.parseInt(sc.nextLine());
									if(numPiso < 0) {
										System.out.println("El piso introducido NO puede ser inferior a 0.");
									}
								}while(numPiso < 0);
								
								Agencia1.getListaPisos().get(id3).getDireccion().setNumPiso(numPiso);
								System.out.println("\n" + Agencia1.getListaPisos().get(id3).toString() + "\n\n\tCambio realizado con éxito.\n\tVolviendo al menú de modificación.\n");
							break;
							
							case"5":
								
								String letra;
								do {
									System.out.println("Introduzca la letra del piso:");
									letra = sc.nextLine();
									letra = letra.toUpperCase();
									if(!Agencia.LetraCorrecta(letra)) {
										System.out.println("La letra introducida NO es válida.");
									}
								}while(!Agencia.LetraCorrecta(letra));
								
								Agencia1.getListaPisos().get(id3).getDireccion().setLetra(letra);
								System.out.println("\n" + Agencia1.getListaPisos().get(id3).toString() + "\n\n\tCambio realizado con éxito.\n\tVolviendo al menú de modificación.\n");
							break;
							
							case"6":
								int cod_postal;
								do {
									System.out.println("Introduzca el código postal:");
									cod_postal = Integer.parseInt(sc.nextLine());

									if(!Agencia.codigoPostalCorrecto(cod_postal)) {
										System.out.println("El código postal NO es válido recuerde que debe tener 5 cifras.");
									}
								}while(!Agencia.codigoPostalCorrecto(cod_postal));
								
								Agencia1.getListaPisos().get(id3).getDireccion().setCodigoPostal(cod_postal);
								System.out.println("\n" + Agencia1.getListaPisos().get(id3).toString() + "\n\n\tCambio realizado con éxito.\n\tVolviendo al menú de modificación.\n");
							break;
							
							case"7":
								String provincia;
								do {
									System.out.println("Introduzca la provincia del piso:\n(Sin tildes)");
									provincia = sc.nextLine();
									if(!Agencia.ProvinciaCorrecta(provincia)) {
										System.out.println("La provincia introducida NO es correcta. Tenga en cuenta que puede haber errores como por ejemplo"
												+ " escribir La Coruña que sería erroneo siendo lo correcto A Coruña.\n");
									}
								}while(!Agencia.ProvinciaCorrecta(provincia));
								
								Agencia1.getListaPisos().get(id3).getDireccion().setProvincia(provincia);
								System.out.println("\n" + Agencia1.getListaPisos().get(id3).toString() + "\n\n\tCambio realizado con éxito.\n\tVolviendo al menú de modificación.\n");
							break;
							
							case"0":
								salir3 = true;
								System.out.println("\nHa seleccionado salir.\n");
							break;
						}
					}
					 break;
					case "2":
						double metrosCuadrados;
						int idcase2;
						do {
							System.out.println("Introduzca el id del piso que desea modificar: ");
							idcase2 = Integer.parseInt(sc.nextLine());
							if(!Agencia.IDCorrecto(idcase2)) {
								System.out.println("El ID introducido NO existe.");
							}
						}while(!Agencia.IDCorrecto(idcase2));
						
						System.out.println("\n" + Agencia1.getListaPisos().get(idcase2).toString());
						
						do {
							System.out.println("\nIntroduzca lo metros cuadrados: ");
							metrosCuadrados = Double.parseDouble(sc.nextLine());
						}while(metrosCuadrados <= 0);
						
						Agencia1.getListaPisos().get(idcase2).setMetrosCuadrados(metrosCuadrados);
						System.out.println("\n" + Agencia1.getListaPisos().get(idcase2).toString() + "\n\n\tCambio realizado con éxito.\n\tVolviendo al menú de modificación.\n");
						
					break;
					
					case "3":
						Agencia1.ModificarAlquiler();
					break;
					
					case "4":
						Agencia1.ModificarVenta();
					break;
	
					case "0":
						System.out.println("Ha seleccionado salir\n");
						salir2 = true;
					}
				}
			break;
			
			case "5":
				System.out.println("Ha seleccionado la opción 5:");
				Agencia.CrearPiso();
			break;
			
			case "6":
				Agencia1.ListarPiso();
			break;
			
			case "7":
				double metros = 0;
				double metros2 = 0;
			
				do {
					System.out.println("Introduzca el mínimo de metros cuadrados: ");
					metros = Double.parseDouble(sc.nextLine());
					System.out.println("Introduzca el máximo de metros cuadrados: ");
					metros2 = Double.parseDouble(sc.nextLine());
					if(metros > metros2) {
						System.out.println("Datos mal introducidos.\nPrimero debe introducir el mínimo de metros cuadrados"
								+ " y a continuación el máximo.");
					}
				}while(metros > metros2);
				if(!Agencia1.MetrosCorrectos(metros, metros2)) {
					System.out.println("\tNo existen pisos entre esos rangos de metros cuadrados.\n");
				} else {
					Agencia1.RangoMetros(metros,metros2);
				}
			break;
			
			case "8":
				int idcase8;
				System.out.println("\n");
				Agencia1.mostrar();
				do {
					System.out.println("Introduce el ID del piso que desea eliminar: ");
					idcase8 = Integer.parseInt(sc.nextLine());
					if(!Agencia.IDCorrecto(idcase8)) {
						System.out.println("El ID introducido no es válido.");
					}
				}while(!Agencia.IDCorrecto(idcase8));

				Agencia1.BorrarPiso(idcase8);
			break;
			
			case"0":
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
