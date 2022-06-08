package vista;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Scanner;
import controlador.ArticuloController;
import modelo.Coleccion;
import modelo.Decoracion;
import modelo.Hogar;
import modelo.Articulo;

public class ArticuloVista {
	private static ArticuloController controlador;
	private static Scanner scan = new Scanner(System.in);
	
	public static void gestionaArticulos() {
		
		String opcion;
		boolean salir = false;
		controlador = new ArticuloController();

		
		while(!salir) {
			System.out.println("Seleccione una opción del menú:"
					+ "\n\t1. Añadir nuevos artículos."
					+ "\n\t2. Borrar artículos existentes."
					+ "\n\t3. Modificar artículos existentes."
					+ "\n\t4. Listar los artículos."
					+ "\n\t5. Ver el resumen de los tickets."
					+ "\n\t6. Ver el resumen de los artículos más vendidos."
					+ "\n\t0. Salir.");
			opcion = scan.nextLine();
			
			switch(opcion) {
			
			case "1":
				elegirArticulo();
				break;
			
			case "2":
				eliminarArticulo();
				break;
			
			case "3":
				elegirArticuloModificar();
				break;
				
			case "4":
				controlador.mostrarArticulo();
				break;
				
			case "5":
				
				break;
			
			case "6":
				break;
				
			case "0":
				salir = true;
				
				break;
				
			default:
				System.err.println("La opción no es válida.");
				break;
			}
		}
	}
	
	public static void elegirArticulo() {

		String opcion;
		boolean salir = false;
		
		while(!salir) {
			System.out.println("Que tipo de artículo desea añadir:"
					+ "\n\t1. Artículo de decoración."
					+ "\n\t2. Artículo de hogar."
					+ "\n\t0. Salir.");
			opcion = scan.nextLine();
			
			switch(opcion) {
				 
			case "1":
				controlador.addArticuloDecoracion(nuevoArticuloDecoracion());
				break;
				
			case "2":
				controlador.addArticuloHogar(nuevoArticuloHogar());
				break;
				
			case "0":
				System.out.println("Volviendo al menú.");
				salir = true;
				break;
				
			default:
				System.err.println("La opción no es válida.");
			}
		}
	}
	
	private static Decoracion nuevoArticuloDecoracion() {
		int id = controlador.idDisponible();
		System.out.println(id);
		System.out.println("Tipo de decoración:\n");
		String tipo = menuTipo();
		System.out.println("Color de artículo:\n");
		String color = menuColor();
		System.out.println("Colección a la que pertenece el artículo:");
		Coleccion coleccion = menuColeccion();
		int stock = 0;
		do {
			System.out.println("Stock del artículo: ");
			stock = Integer.parseInt(scan.nextLine());
			if(stock < 0) {
				System.err.println("El stock no puede ser inferior a 0.");
			}
		}while(stock < 0);
		double precio = 0;
		do {
			System.out.println("Precio del artículo: ");
			precio = Double.parseDouble(scan.nextLine());
			BigDecimal bd = new BigDecimal(precio).setScale(2, RoundingMode.HALF_UP);
			precio = bd.doubleValue();
			if(precio <= 0) {
				System.out.println("El precio no puede ser inferior o igual a 0");
			}
		}while(precio <= 0);
		Decoracion toret = new Decoracion(id, stock, precio, tipo, color, coleccion);
		System.out.println(toret.toString());
		
		return toret;
	}
	
	private static String menuTipo() {
		String opcion;
		String toret = "";
		boolean salir = false;
		
		while(!salir) {
			System.out.println("1.Espejo\n"
					+ "2. Reloj\n"
					+ "3. Farol\n"
					+ "4. Plantas artificiales\n"
					+ "5. Macetero\n"
					+ "6. Jarron\n"
					+ "7. Cesto\n"
					+ "8. Portavelas\n"
					+ "9. Figuras decorativas\n"
					+ "10. Centros de mesa\n"
					+ "11. PortaFotos\n"
					+ "12. Otros\n"
					+ "Introduzca el tipo de decoración: ");
			opcion = scan.nextLine();
			
			switch(opcion) {
				case "1": toret = "Espejo";
					salir = true;
					break;
				case "2": toret = "Reloj";
					salir = true;
					break;
				case "3": toret = "Farol";
					salir = true;
					break;
				case "4": toret = "Plantas artificiales";
					salir = true;
					break;
				case "5": toret = "Macetero";
					salir = true;
					break;
				case "6": toret = "Jarron";
					salir = true;
					break;
				case "7": toret = "Cesto";
					salir = true;
					break;
				case "8": toret = "Portavelas";
					salir = true;
					break;
				case "9": toret = "Figuras decorativas";
					salir = true;
					break;
				case "10": toret = "Centros de mesa";
					salir = true;
					break;
				case "11": toret = "Portafotos";
					salir = true;
					break;
				case "12": toret = "Otros";
					salir = true;
					break;
				default:
					System.err.println("\n\tLa opción no es válida.\n");
					break;
			}
		}
			
		
		return toret;
		
	}
	
	private static String menuColor() {
		String opcion;
		String toret = "";
		boolean salir = false;
		
		while(!salir) {
			System.out.println("1. Blanco\n"
					+ "2. Negro\n"
					+ "3. Gris\n"
					+ "4. Beige\n"
					+ "5. Azul\n"
					+ "6. Malva\n"
					+ "7. Burdeos\n"
					+ "8. Otro\n"
					+ "Introduzca el tipo de decoración: ");
			opcion = scan.nextLine();
			
			switch(opcion) {
				case "1": toret = "Blanco";
					salir = true;
					break;
				case "2": toret = "Negro";
					salir = true;
					break;
				case "3": toret = "Gris";
					salir = true;
					break;
				case "4": toret = "Beige";
					salir = true;
					break;
				case "5": toret = "Azul";
					salir = true;
					break;
				case "6": toret = "Malva";
					salir = true;
					break;
				case "7": toret = "Burdeos";
					salir = true;
					break;
				case "8": toret = "Otro";
					salir = true;
					break;
				default:
					System.err.println("\n\tLa opción no es válida.\n");
					break;
			}
		}
			
		
		return toret;
	}
	
	private static Coleccion menuColeccion() {
		String opcion;
		Coleccion toret = new Coleccion();
		boolean salir = false;
		
		while(!salir) {
			System.out.println("1.Wild\tTemporada de otoño\t2022\n"
					+ "2. Brave hearts\tTemporada de primavera\t2022\n"
					+ "3. Air\tTemporada de Invierno\t2022\n"
					+ "4. Talentiam\tTemporada de verano\t2022\n"
					+ "Introduzca la colección a la que pertenece el artículo: ");
			opcion = scan.nextLine();
			
			switch(opcion) {
				case "1": toret.setNombre("Wild");
					toret.setTemporada("Otoño");
					toret.setAnho_temporada(2022);
					salir = true;
					break;
				case "2": toret.setNombre("Brave hearts");
					toret.setTemporada("Primavera");
					toret.setAnho_temporada(2022);
					salir = true;
					break;
				case "3": toret.setNombre("Air");
					toret.setTemporada("Invierno");
					toret.setAnho_temporada(2022);
					salir = true;
					break;
				case "4": toret.setNombre("Talentiam");
					toret.setTemporada("Verano");
					toret.setAnho_temporada(2022);
					salir = true;
					break;
				default:
					System.err.println("\n\tLa opción no es válida.\n");
					break;
			}
		}
			
		
		return toret;
		
	}
	private static Hogar nuevoArticuloHogar() {
		int id = controlador.idDisponible();
		System.out.println(id);
		System.out.println("Tipo de artículo de hogar: ");
		String tipo = tipoArticuloHogar();
		System.out.println("Color del artículo: ");
		String color = colorArticuloHogar();
		System.out.println("Estancia a la que pertenece el artículo: ");
		String estancia = "";
		int stock = 0;
		do {
			System.out.println("Stock del artículo: ");
			stock = Integer.parseInt(scan.nextLine());
			if(stock < 0) {
				System.err.println("El stock no puede ser inferior a 0.");
			}
		}while(stock < 0);
		double precio = 0;
		do {
			System.out.println("Precio del artículo: ");
			precio = Double.parseDouble(scan.nextLine());
			BigDecimal bd = new BigDecimal(precio).setScale(2, RoundingMode.HALF_UP);
			precio = bd.doubleValue();
			if(precio <= 0) {
				System.out.println("El precio no puede ser inferior o igual a 0");
			}
		}while(precio <= 0);
		
		Hogar toret = new Hogar(id, stock, precio, tipo, color, estancia);
		System.out.println(toret.toString());
		
		
		return toret;
		
	}
	
	private static String tipoArticuloHogar() {
		String opcion;
		String tipo = "";
		boolean salir = false;
		
		while(!salir) {
			System.out.println("1. Toalla\n"
					+ "2. Manta\n"
					+ "3. Alfombra\n"
					+ "4. Cojines\n"
					+ "5. Botellero\n"
					+ "6. Salvamantel\n"
					+ "7. Plato llano\n"
					+ "8. Plato hondo\n"
					+ "9. Plato de postre\n"
					+ "10. Copa de cristal\n"
					+ "11. Vaso de cristal\n"
					+ "12. Frutero\n"
					+ "13. Taza\n"
					+ "14. Dispensador de jabón\n"
					+ "15. Jabonera\n");
			opcion = scan.nextLine();
			
			switch(opcion) {
				case "1": tipo = "Toalla";
					salir = true;
					break;
				case "2": tipo = "Manta";
					salir = true;
					break;
				case "3": tipo = "Alfombra";
					salir = true;
					break;
				case "4": tipo = "Cojines";
					salir = true;
					break;
				case "5": tipo = "Botellero";
					salir = true;
					break;
				case "6": tipo = "Salvamantel";
					salir = true;
					break;
				case "7": tipo = "Plato llano";
					salir = true;
					break;
				case "8": tipo = "Plato hondo";
					salir = true;
					break;
				case "9": tipo = "Plato de postre";
					salir = true;
					break;
				case "10": tipo = "Copa de cristal";
					salir = true;
					break;
				case "11": tipo = "Vaso de cristal";
					salir = true;
					break;
				case "12": tipo = "Frutero";
					salir = true;
					break;
				case "13": tipo = "Taza";
					salir = true;
					break;
				case "14": tipo = "Dispensador de jabón";
					salir = true;
					break;
				case "15": tipo = "Jabonera";
					salir = true;
					break;
				default: System.err.println("\n\tLa opción introducida no es válida.\n");
					break;
			}
		}
		
		return tipo;
		
	}
	
	private static String colorArticuloHogar() {
		String opcion;
		String toret = "";
		boolean salir = false;
		
		while(!salir) {
			System.out.println("1. Blanco\n"
					+ "2. Negro\n"
					+ "3. Gris\n"
					+ "4. Beige\n"
					+ "5. Azul\n"
					+ "6. Malva\n"
					+ "7. Burdeos\n"
					+ "8. Otro");
			opcion = scan.nextLine();
			
			switch(opcion) {
				case "1": toret = "Blanco";
					salir = true;
					break;
				case "2": toret = "Negro";
					salir = true;
					break;
				case "3": toret = "Gris";
					salir = true;
					break;
				case "4": toret = "Beige";
					salir = true;
					break;
				case "5": toret = "Azul";
					salir = true;
					break;
				case "6": toret = "Malva";
					salir = true;
					break;
				case "7": toret = "Burdeos";
					salir = true;
					break;
				case "8": toret = "Otro";
					salir = true;
					break;
				default: System.err.println("\n\tLa opción introducida no es válida.\n");
					break;
			}
		}
		return toret;
	}
	
	private static String estanciaArticuloHogar() {
		String opcion;
		String toret = "";
		boolean salir = false;
		
		while(!salir) {
			System.out.println("1. Salón\n"
					+ "2. Cocina\n"
					+ "3. Cuarto de baño\n"
					+ "4. Comedor\n");
			opcion = scan.nextLine();
			switch(opcion) {
				case "1": toret = "Salón";
					salir = true;
					break;
				case "2": toret = "Cocina";
					salir = true;
					break;
				case "3": toret = "Cuarto de baño";
					salir = true;
					break;
				case "4": toret = "Comedor";
					salir = true;
					break;
				default: System.err.println("\n\tLa opción introducida no es válida.\n");
				break;
			}
		}
		
		return toret;
		
	}
	
	public static void elegirArticuloModificar() {
		
		//Poner un sysout con los artículos
		int codigo;
		
		System.out.println("Introduce el codigo del artículo:");
		codigo = Integer.parseInt(scan.nextLine());
		int pos = -1;
		boolean encontrado = false;
	
		if(controlador.idCorrecto((codigo)) == -1) {
			System.err.println("El código del artículo no existe");
		} else {
			pos = controlador.idCorrecto(codigo);
			encontrado = true;
			controlador.verArticulo(codigo);
		}
		if(encontrado) {
			if(controlador.articuloDecoracion(codigo)) { //Comprueba si es un artículo de decoración
				menuModificarDecoracion(pos, codigo);
			} else {
				menuModificarHogar(pos, codigo);
			}
		}
	
	}
	
	public static void menuModificarDecoracion(int pos, int codigo) {
		String opcion;
		boolean salir = false;
		
		while(!salir) {
			System.out.println("\t--Menú Modificar--\n\tOpciones de modificación:\n" + "\t1. Stock.\n"
					+ "\t2. Precio.\n" + "\t3. Tipo.\n"
					+ "\t4. Color.\n" + "\t5. Colección.\n"
					+ "\t0. Regresar al menú principal." + "\nIntroduzca su opción: ");
			opcion = scan.nextLine();
			
			switch(opcion) {
			
			case "1":
				int stock = 0;
				do {
					System.out.println("Introduzca el nuevo stock del artículo: ");
					stock = Integer.parseInt(scan.nextLine());
					controlador.editStock(codigo, stock, pos);
				}while(stock < 0);
				
				break;
				
			case "2":
				double precio = 0;
				do {
					System.out.println("Introduzca el nuevo precio del artículo: ");
					precio = Double.parseDouble(scan.nextLine());
					BigDecimal bd = new BigDecimal(precio).setScale(2, RoundingMode.HALF_UP);
					precio = bd.doubleValue();
					controlador.editPrecio(codigo, precio, pos);
				
				}while(precio <= 0);
				break;
				
			case "3":
				String tipo = menuTipo();
				controlador.editTipoDecoracion(codigo, tipo, pos);
				break;
				
			case "4":
				String color = menuColor();
				controlador.editcolorDecoracion(codigo, color, pos);
				break;
				
			case "5":
				Coleccion aux = menuColeccion();
				String coleccion = aux.getNombre();
				controlador.editColeccion(codigo, coleccion, pos, aux);
				break;
			
			case "0":
				System.out.println("Volviendo\n");
				salir = true;
				break;
				
			default:
				System.err.println("\n\tLa opción no es válida\n");
				break;
			
			}
		}
		
	}

	public static void menuModificarHogar(int pos, int codigo) {
		String opcion;
		boolean salir = false;
		
		while(!salir) {
			System.out.println("\t--Menú Modificar--\n\tOpciones de modificación:\n" + "\t1. Stock.\n"
					+ "\t2. Precio.\n" + "\t3. Tipo.\n"
					+ "\t4. Color.\n" + "\t5. Estancia.\n"
					+ "\t0. Regresar al menú principal." + "\nIntroduzca su opción: ");
			opcion = scan.nextLine();
			
			switch(opcion) {
			
			case "1":
				int stock = 0;
				do {
					System.out.println("Introduzca el nuevo stock del artículo: ");
					stock = Integer.parseInt(scan.nextLine());
					controlador.editStock(codigo, stock, pos);
				}while(stock < 0);
				break;
				
			case "2":
				double precio = 0;
				do {
					System.out.println("Introduzca el nuevo precio del artículo: ");
					precio = Double.parseDouble(scan.nextLine());
					BigDecimal bd = new BigDecimal(precio).setScale(2, RoundingMode.HALF_UP);
					precio = bd.doubleValue();
					controlador.editPrecio(codigo, precio, pos);
				
				}while(precio <= 0);
				break;
				
			case "3":
				String tipo = tipoArticuloHogar();
				controlador.editTipoHogar(codigo, tipo, pos);
				break;
				
			case "4":
				String color = menuColor();
				controlador.editcolorHogar(codigo, color, pos);
				break;
				
			case "5":
				String estancia = estanciaArticuloHogar();
				controlador.editEstancia(codigo, estancia, pos);
				break;
				
			case "0":
				salir = true;
				System.out.println("Volviendo");
				break;
				
			default:
				System.err.println("\n\tLa opción no es válida.");
				break;
			}
		}

	}
	
	public static void eliminarArticulo() {
		String opcion;
		boolean salir = false;
		
		//Hacer un toString() corto
		
		while(!salir) {
			System.out.println("\nOpciones:\n" + "\t1. Eliminar un artículo\n" + "\t0. Salir\n" + "Opcion:");
			opcion = scan.nextLine();
			
			switch(opcion) {
			
			case "1":
				int codigo;
				System.out.println("Introduce el codigo del artículo que desea eliminar:");
				codigo = Integer.parseInt(scan.nextLine());
				int pos = -1;
				boolean encontrado = false;
				if(controlador.idCorrecto(codigo) == -1) {
					System.err.println("\n\tEl código del artículo no existe.\n");
				} else {
					pos = controlador.idCorrecto(codigo);
					encontrado = true;
				}
				
				if(encontrado) {
					String opcion2;
					do {
						System.out.println("¿Está seguro de que desea eliminar el artículo?\n"
								+ "Introduzca 's' para si y 'n' para no.");
						opcion2 = scan.nextLine();
						opcion2 = opcion2.toLowerCase();
						
						if(opcion2.equals("s")) {
							controlador.deleteArticulo(codigo, pos);
							System.out.println("\tEl artículo ha sido eliminado con exito");
							
						} else if (opcion2.equals("n")) {
							System.out.println("\tEl artículo no ha sido eliminado.\n");
						}
						
						if (!opcion2.equals("s") && !opcion2.equals("n")) {
							System.out.println("\tLa opción no es válida");
						}
					}while(!opcion2.equals("s") && !opcion2.equals("n"));
				}
				
				
				break;
				
			case "0":
				salir = true;
				System.out.println("Volviendo");
				break;
				
			default:
				System.err.println("\n\tLa opción introducida no es válida.\n");
				break;
			}
		}
		
	}
	
	
}
