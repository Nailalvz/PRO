package P4PRO;

import java.util.*;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	static int cont = 10;
	static ArrayList<Piso> ListaPisos = new ArrayList<Piso>();

	
	
	public static void CrearPiso() {
		
		double metrosCuadrados = 0;
		int precioAlquiler = 0;
		int precioVenta = 0;
		String alquiler1;
		String venta1;
		boolean alquiler = false;
		boolean venta = false;
		
		int tipodevia;
		String calle;
		int numCalle;
		int numPiso;
		String letra;
		int cod_postal;
		String provincia;
		
		
		System.out.println("El ID del piso es: " + cont);
		System.out.println("Introduza los datos solicitados:\n");
		
		do {
			System.out.println("Metros cuadrados:");
			metrosCuadrados = sc.nextDouble();
			if(metrosCuadrados <= 0) {
				System.out.println("Los metros introducidos no son válidos.");
			}
		}while(metrosCuadrados <= 0);
		
		do {
			do {
			System.out.println("¿El piso está a la venta? Introduzca una 'y' para si y una 'n' para no.");
			venta1 = sc.next();
			venta1 = venta1.toLowerCase();
			if(!venta1.contains("y") && !venta1.contains("n")) {
				System.out.println("La elección introducida no es válida.");
			}
			
			}while(!venta1.contains("y") && !venta1.contains("n"));
			
			if(venta1.contains("y")) {
				venta = true;
				System.out.println("Precio de venta:");
				precioVenta = sc.nextInt();
			} else if(venta1.contains("n")){
				venta = false;
			}
			
			do {
				System.out.println("¿El piso está en alquiler? Introduzca una 'y' para si y una 'n' para no.");
				alquiler1 = sc.next();
				alquiler1 = alquiler1.toLowerCase();
				if(!alquiler1.contains("y") && !alquiler1.contains("n")) {
					System.out.println("La elección introducida no es válida.");
				}
				
			}while(!alquiler1.contains("y") && !alquiler1.contains("n"));
			
			if(alquiler1.contains("y")) {
				alquiler = true;
				System.out.println("Precio del alquiler:");
				precioAlquiler = sc.nextInt();
			} else if(alquiler1.contains("n")){
				alquiler = false;
			}
			if(!alquiler && !venta) {
				System.out.println("Para poder dar el piso de alta debe estar en venta, en alquiler o en ambas.");
			}
		}while(!alquiler && !venta);
		
		
		
		System.out.println("Datos de la dirección:\n");
		do {
			System.out.println("Tipo de vía:"
					+ "\n\tAvenida: 0"
					+ "\n\tBulevar: 1"
					+ "\n\tCalle: 2"
					+ "\n\tCamino: 3"
					+ "\n\tCarretera: 4"
					+ "\n\tPlaza: 5"
					+ "\n\tRúa : 6"
					+ "\n\tUrbanizacion: 7"
					+ "\n\tOtro: 8"
					+ "\nIntroduzca el identificador para seleccionar el tipo de vía: ");
			tipodevia = sc.nextInt();
			sc.nextLine();
		}while(tipodevia < 0 | tipodevia > 8);
		
		System.out.println("Nombre de la calle:");
		calle = sc.nextLine();
		calle = calle.toLowerCase();
		
		do {
			System.out.println("Introduce el número de la calle: ");
			numCalle = sc.nextInt();
			sc.nextLine();
			if(numCalle <= 0) {
				System.out.println("El número de la calle no puede ser inferior o igual a 0.");
			}
		}while(numCalle <= 0);
		
		do {
			System.out.println("Número del piso:");
			numPiso = sc.nextInt();
			sc.nextLine();
		}while(numPiso < 0);
		
		
		do {
			System.out.println("Letra:");
			letra = sc.nextLine();
			letra = letra.toUpperCase();
			if(!LetraCorrecta(letra)) {
				System.out.println("La letra introducida no es correcta.");
			}
		}while(!LetraCorrecta(letra));
		
		
		do {
			System.out.println("Código postal:");
			cod_postal = sc.nextInt();
			sc.nextLine();
			if(!codigoPostalCorrecto(cod_postal)) {
				System.out.println("El código postal introducido no es válido. Debe tener 5 cifras.");
			}
		}while(!codigoPostalCorrecto(cod_postal));
		
		do {
			System.out.println("Provincia:\n(La provincia debe ser introducida sin tildes)");
			provincia = sc.nextLine();
			provincia = provincia.toLowerCase();
			if(!ProvinciaCorrecta(provincia)) {
				System.out.println("La provincia introducida no es válida.");
			}
		}while(!ProvinciaCorrecta(provincia));
		
		Direccion aux = new Direccion(tipodevia, calle, numCalle, numPiso, letra, cod_postal, provincia);
		Piso aux2 = new Piso(cont, aux, metrosCuadrados, precioAlquiler, precioVenta, alquiler, venta);
		
		ListaPisos.add(aux2);
	
		
		System.out.println("Piso creado con éxito\n");
		
		System.out.println(ListaPisos.get(cont).toString() + "\n");
		
		cont++;
	}
	
	public static boolean PisoAlquilerVenta(int id) {
		boolean alquiler;
		boolean venta;
		
		alquiler = ListaPisos.get(id).getAlquiler();
		venta = ListaPisos.get(id).getVenta();
		
		if(!alquiler && !venta) {
			return false;
		} else return true;
		
	}
	
	public static boolean IDCorrecto(int id) {
		boolean toret = false;
		for(int i = 0; i < ListaPisos.size(); i++) {
			if(ListaPisos.get(i).getID() == id) {
				toret = true;
				break;
			}else {
				toret = false;
			}
			
		}
		return toret;
		
		
		
	}
	
	//Función para comprobar que los códigos postales sean de 5 cifras
	public static boolean codigoPostalCorrecto(int num) {
		int max = 5;
		int cifras = 0;
		
		while(num!=0) {
			num = num/10;
			cifras++;
		}
		if(cifras == max) {
			return true;
		} else {
			return false;
		}
		
	}

	
	public static boolean LetraCorrecta(String letra) {
		String[] tipoLetra = {"A","B","C","D","F","G","H","I","J","K","L","M","O","P","Q","R","S","T","V","W","X","Y","Z"};
		List<String> listaLetras = Arrays.asList(tipoLetra);
		if(listaLetras.contains(letra)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean ProvinciaCorrecta(String provincia) {
		String[] provincias = {"alava","albacete","alicante","almeria","asturias","avila","badajoz","barcelona","burgos",
				"caceres","cadiz","cantabria","castellon","ciudad real","cordoba","a coruña","cuenca","gerona","granada","guadalajara","guipuzcoa",
				"huelva","huesca","islas baleares","jaen","leon","lerida","lugo","madrid","malaga","murcia","navarra","ourense","palencia",
				"las palmas","pontevedra","la rioja","salamanca","segovia","sevilla","soria","tarragona","tenerife","teruel","toledo","valencia",
				"valladolid","vizcaya","zamora","zaragoza"};
		List<String> listaProvincias = Arrays.asList(provincias);
		if(listaProvincias.contains(provincia)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	public static void mostrar() {
		for(int i = 0; i < ListaPisos.size(); i++) {
			System.out.println(ListaPisos.get(i).toString() + "\n");
		}
	}
	
	public static void mostrarAlquiler() {
		for(int i = 0; i < ListaPisos.size(); i++) {
			if(ListaPisos.get(i).getAlquiler() == true) {
				System.out.println(ListaPisos.get(i).toString() + "\n");
			}
		}
	}
	
	public static void mostrarVenta() {
		for(int i = 0; i < ListaPisos.size(); i++) {
			if(ListaPisos.get(i).getVenta() == true) {
				System.out.println(ListaPisos.get(i).toString() + "\n");
			}
		}
	}
	
	public static void RangoPrecio(int a, int b) {
		
		for(int i = 0; i < ListaPisos.size(); i ++) {
			if(ListaPisos.get(i).getPrecioAlquiler() >= a && ListaPisos.get(i).getPrecioAlquiler() <= b || ListaPisos.get(i).getPrecioVenta() >= a && ListaPisos.get(i).getPrecioVenta() <= b) {
				System.out.println(ListaPisos.get(i).toString() + "\n");
			}
		}
		System.out.println("");
	}
	
	public static void RangoMetros(int a, int b) {
		
		for(int i = 0; i < ListaPisos.size(); i ++) {
			if(ListaPisos.get(i).getMetrosCuadrados() > a && ListaPisos.get(i).getMetrosCuadrados() < b) {
				System.out.println(ListaPisos.get(i).toString() + "\n");
			}
		}
		System.out.println("");
	}
	
	

	public static void main(String[] args) {
		
		Direccion A1 = new Direccion(1, "purificacion saavedra", 52, 3, "C", 36207, "pontevedra");
		Direccion B1 = new Direccion(2, "calle del centro", 180, 5, "D", 36201, "alava");
		Direccion C1 = new Direccion(1, "calle de valladares", 80, 36510, "vigo");
		Direccion D1 = new Direccion(3, "calle de A coruña", 120, 35607, "a coruña");
		Direccion E1 = new Direccion(1, "calle de albacete", 12, 2, "A", 56798, "albacete");
		Direccion F1 = new Direccion(5, "calle de madrid", 45, 7, "B", 12000, "madrid");
		Direccion G1 = new Direccion(3, "calle de málaga", 145, 6, "A", 87690, "malaga");
		Direccion H1 = new Direccion(1, "calle de vigo", 87, 36211, "vigo");
		Direccion I1 = new Direccion(2, "calle de toledo", 30, 1, "A", 38900, "toledo");
		Direccion J1 = new Direccion(1, "calle de salamanca", 90, 6, "E", 32345, "salamanca");
		
		
		Piso A = new Piso(0, A1, 175, 900, 0, true, false);
		Piso B = new Piso(1, B1, 90, 450, 0, true, false);
		Piso C = new Piso(2, C1, 100, 600, 0, true, false);
		Piso D = new Piso(3, D1, 150, 1000, 0, true, false);
		Piso E = new Piso(4, E1, 50, 470, 900000, true, true);
		Piso F = new Piso(5 ,F1, 200, 0, 190000, false, true);
		Piso G = new Piso(6, G1, 90, 0, 90000, false, true);
		Piso H = new Piso(7, H1, 50, 0, 75000, false, true);
		Piso I = new Piso(8, I1, 300, 0, 1200000, false, true);
		Piso J = new Piso(9, J1, 120, 0, 95000, false, true);
		
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
		
		
		Agencia a = new Agencia("Agencia1", ListaPisos);
		
		
		
		String opcion;
		boolean salir = false;
		
		while(!salir) {
			System.out.println("Bienvenido al menú principal de alquiler y venta de pisos\n"
					+ "Introduzca 1 para listar toda la lista de pisos disponibles\n"
					+ "Introduzca 2 para listar todos los pisos que están en alquiler\n"
					+ "Introduzca 3 para listar todos los pisos que están en venta\n"
					+ "Introduzca 4 para modificar un piso en alquiler o en venta\n"
					+ "Introduzca un 5 para añadir un piso en venta o en alquiler\n"
					+ "Introduzca un 6 para listar los pisos en un rango de precio\n"
					+ "Introduzca un 7 para listar los pisos en un rango de metros cuadrados\n"
					+ "Introduzca un 8 si desea eliminar un piso de la lista"
					+ "Introduzca un 0 para finalizar.\n Introduzca su opción: ");
			opcion = sc.nextLine();
			
			switch(opcion) {
			
			case "1":
				System.out.println("\nEstos son todos los pisos disponibles:\n");
				mostrar();
			break;
				
			case "2":
				System.out.println("\nEstos son todos los pisos en alquiler disponibles:\n");
				mostrarAlquiler();
			break;
			case "3":
				System.out.println("\nEstos son todos los pisos en venta disponibles:\n");
				mostrarVenta();
			break;
			case "4":
				String opcion2 = "";
				boolean salir2 = false;
				
				while(!salir2) {
					System.out.println("Introduzca 1 para modificar la dirección del piso.\n"
							+ "Introduzca 2 para modificar los metros cuadrados del piso.\n"
							+ "Introduzca 3 para modificar el precio de alquiler del piso.\n"
							+ "Introduzca 4 para modificar el precio de venta del piso.\n"
							+ "Introduzca 5 para modificar si el piso está en alquiler o en venta."
							+ "Introduzca 0 para regresar al menú principal."
							+ "\nIntroduzca su opción: ");
					opcion2 = sc.nextLine();

				
				switch(opcion2) {
				
					case "1":
						
						int id3;
						do {
							System.out.println("Introduce el id del piso que desea modificar: ");
							id3 = sc.nextInt();
							sc.nextLine();
							if(!IDCorrecto(id3)) {
								System.out.println("El ID introducido no existe.");
							}
						}while(!IDCorrecto(id3));
						
						String opcion3 = "";
						boolean salir3 = false;
						while(!salir3) {
								System.out.println("Introduzca 1 si desea modificar el tipo de vía\n"
								+ "Introduzca 2 si desea modificar el nombre de la calle\n"
								+ "Introduzca 3 si desea modificar el número de la calle\n"
								+ "Introduzca 4 si desea modificar el número del piso\n"
								+ "Introduzca 5 si desea modificar la letra del piso\n"
								+ "Introduzca 6 si desea modificar el código postal\n"
								+ "Introduzca 7 si desea modificar la población del piso\n"
								+ "Introduzca 0 para salir\n"
								+ "\tIntroduzca su opcion: ");
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
											+ "\n\tUrbanizacion: 6"
											+ "\n\tOtro: 7"
											+ "\nIntroduzca el identificador para seleccionar el tipo de vía: ");
									aux = sc.nextInt();
									sc.nextLine();
									if(aux < 0 | aux > 7) {
										System.out.println("Error al seleccionar el tipo de vía. Vuelva a introducir el identificador.\n");
									}
								}while(aux < 0 | aux > 7);
								ListaPisos.get(id3).getDireccion().setTipodeVia(aux);
							break;
							
							case"2":
								System.out.println("Introduzca el nombre de la calle:");
								String calle = sc.nextLine();
								ListaPisos.get(id3).getDireccion().setNombre(calle);
							break;
							
							case"3":
								int numCalle;
								do {
									System.out.println("Introduzca el número de la calle:");
									numCalle = sc.nextInt();
									sc.nextLine();
									if(numCalle <= 0) {
										System.out.println("El número de la calle no debe ser menor o igual a 0.");
									}
								}while(numCalle <= 0);
								
								ListaPisos.get(id3).getDireccion().setNumCalle(numCalle);
							break;
							
							case "4":
								int numPiso;
								do {
									System.out.println("Introduzca el número del piso:");
									numPiso = sc.nextInt();
									sc.nextLine();
									if(numPiso < 0) {
										System.out.println("El piso introducido no puede ser inferior a 0.");
									}
								}while(numPiso < 0);
								
								ListaPisos.get(id3).getDireccion().setNumPiso(numPiso);
							break;
							
							case"5":
								
								String letra;
								do {
									System.out.println("Introduzca la letra del piso:");
									letra = sc.nextLine();
									if(!LetraCorrecta(letra)) {
										System.out.println("La letra introducida no es válida.");
									}
								}while(!LetraCorrecta(letra));
								
								ListaPisos.get(id3).getDireccion().setLetra(letra);
							break;
							
							case"6":
								int cod_postal;
								do {
									System.out.println("Introduzca el código postal:");
									cod_postal = sc.nextInt();
									sc.nextLine();
									if(!codigoPostalCorrecto(cod_postal)) {
										System.out.println("El código postal no es válido recuerde que debe tener 5 cifras.");
									}
								}while(!codigoPostalCorrecto(cod_postal));
								
								ListaPisos.get(id3).getDireccion().setCodigoPostal(cod_postal);
							break;
							
							case"7":
								String provincia;
								do {
									System.out.println("Introduzca la provincia del piso:\n(Sin tildes)");
									provincia = sc.nextLine();
									if(!ProvinciaCorrecta(provincia)) {
										System.out.println("La provincia introducida no es correcta. Tenga en cuenta que puede haber errores como por ejemplo"
												+ " escribir La Coruña que sería erroneo siendo lo correcto A Coruña.\n");
									}
								}while(!ProvinciaCorrecta(provincia));
								
								ListaPisos.get(id3).getDireccion().setProvincia(provincia);
							break;
							
							case"0":
								salir3 = true;
							break;
						}
					}
					 break;
					case "2":
						double metrosCuadrados;
						int idcase2;
						do {
							System.out.println("Introduzca el id del piso que desea modificar: ");
							idcase2 = sc.nextInt();
							sc.nextLine();
							if(!IDCorrecto(idcase2)) {
								System.out.println("El ID introducido no existe.");
							}
						}while(!IDCorrecto(idcase2));
						
						do {
							System.out.println("Introduzca lo metros cuadrados: ");
							metrosCuadrados = sc.nextDouble();
							sc.nextLine();
						}while(metrosCuadrados <= 0);
						
						ListaPisos.get(idcase2).setMetrosCuadrados(metrosCuadrados);
						
					break;
					
					case "3":
						int idcase3;
						do {
							System.out.println("Introduzca el id del piso que desea modificar: ");
							idcase3 = sc.nextInt();
							sc.nextLine();
							if(!IDCorrecto(idcase3)) {
								System.out.println("El ID introducido no existe.");
							}
						}while(!IDCorrecto(idcase3));
						int precioalquiler;
						
						do {
							System.out.println("Introduzca el nuevo precio de alquiler del piso");
							precioalquiler = sc.nextInt();
							sc.nextLine();
						}while(precioalquiler <= 0);
						
						ListaPisos.get(idcase3).setPrecioAlquiler(precioalquiler);
					break;
					
					case "4":
						
						int idcase4;
						do {
							System.out.println("Introduzca el id del piso que desea modificar: ");
							idcase4 = sc.nextInt();
							sc.nextLine();
							if(!IDCorrecto(idcase4)) {
								System.out.println("El ID introducido no existe.");
							}
						}while(!IDCorrecto(idcase4));
						int precioventa;
						
						do {
							System.out.println("Introduzca el nuevo precio de alquiler del piso");
							precioventa = sc.nextInt();
							sc.nextLine();
						}while(precioventa <= 0);
						
						ListaPisos.get(idcase4).setPrecioVenta(precioventa);
					break;
					
					case "5":
						int idcase5;
						do {
							System.out.println("Introduzca el id del piso que desea modificar: ");
							idcase5 = sc.nextInt();
							sc.nextLine();
							if(!IDCorrecto(idcase5)) {
								System.out.println("El ID introducido no existe.");
							}
						}while(!IDCorrecto(idcase5));
						
						String aux;
						boolean aux2;
						
						do {
							System.out.println("Introduzca una A si quiere modificar el alquiler y una V si quiere modificar la venta:");
							aux = sc.nextLine();
							aux = aux.toUpperCase();
						}while(aux != "A" | aux != "V");
						
						switch(aux) {
						
						case "A": 
							boolean alquiler;
							String selec;
							alquiler = ListaPisos.get(idcase5).getAlquiler();
							if(alquiler) {
								do {
									System.out.println("El piso con ID " + idcase5 + " está ahora mismo en alquiler.\n"
										+ "¿Desea quitarlo de pisos en alquiler? (y/n)"
										+ "\nSi quita el piso de pisos en alquiler se borrará su precio de alquiler automáticamente.");
									selec = sc.nextLine();
									selec = selec.toLowerCase();
									if(!selec.contains("y") && !selec.contains("n")) {
										System.out.println("La elección no es válida.");
									}
								}while(!selec.contains("y") && !selec.contains("n"));
								
								if(selec.contains("y")) {
									ListaPisos.get(idcase5).setAlquiler(false);
									ListaPisos.get(idcase5).setPrecioAlquiler(0);
									
									System.out.println("Los datos se han actualizado correctamente.\n"
											+ ListaPisos.get(idcase5).toString());
									
								} else {
									System.out.println("No se ha modificado nada.");
								}
							}else {
								do {
									System.out.println("El piso con ID " + idcase5 + " NO está ahora mismo en alquiler.\n"
										+ "¿Desea agregarlo a pisos en alquiler? (y/n)");
									selec = sc.nextLine();
									selec = selec.toLowerCase();
									if(!selec.contains("y") && !selec.contains("n")) {
										System.out.println("La elección no es válida.");
									}
								}while(!selec.contains("y") && !selec.contains("n"));
								
								if(selec.contains("y")) {
									ListaPisos.get(idcase5).setAlquiler(true);
									int precio;
									do {
										System.out.println("Introduce el precio del alquiler:");
										precio = sc.nextInt();
										sc.nextLine();
										if(precio <= 0) {
											System.out.println("El precio no puede ser inferior o igual a 0.");
										}
									}while(precio <= 0);
									
									ListaPisos.get(idcase5).setPrecioAlquiler(precio);
									System.out.println("Los datos se han actualizado correctamente.\n"
											+ ListaPisos.get(idcase5).toString());
								}
							}
						}
						
					break;
					
					case "0":
						System.out.println("Ha seleccionado salir");
						salir2 = true;
					}
				}
			break;
			case "5":
				System.out.println("Ha seleccionado la opción 5:");
				CrearPiso();
				
			break;
			case "6":
				
				int num = 0;
				int num2 = 0;
				do {
					System.out.println("Introduzca el mínimo de precio: ");
					num = sc.nextInt();
					System.out.println("Introduzca el máximo valor de precio: ");
					num2 = sc.nextInt();
					if(num > num2) {
						System.out.println("Datos mal introducidos.\n"
								+ "Primero debe introducir el mínimo de precio y a continuación el máximo.");
					}
				}while(num > num2);
				
				RangoPrecio(num,num2);
			break;
			case "7":
				int metros = 0;
				int metros2 = 0;
				do {
					System.out.println("Introduzca el mínimo de metros cuadrados: ");
					metros = sc.nextInt();
					System.out.println("Introduzca el máximo de metros cuadrados: ");
					metros2 = sc.nextInt();
					if(metros > metros2) {
						System.out.println("Datos mal introducidos.\nPrimero debe introducir el mínimo de metros cuadrados"
								+ " y a continuación el máximo.");
					}
				}while(metros > metros2);
				
				RangoMetros(metros,metros2);
			break;
			}
		}
		

	}

}
