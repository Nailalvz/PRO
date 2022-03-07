package P4PRO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Agencia {
	private String nombre;
	private ArrayList<Piso> ListaPisos;
	static Scanner sc = new Scanner(System.in);
	
	
	public Agencia() {
		this.nombre = "";
		this.setListaPisos(ListaPisos);
	}

	public Agencia(String nombre) {
		this.nombre = nombre;
	}
	
	public Agencia(String nombre, ArrayList<Piso> ListaPisos) {
		this.nombre = nombre;
		this.ListaPisos = ListaPisos;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public ArrayList<Piso> getListaPisos() {
		return this.ListaPisos;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setListaPisos(ArrayList<Piso> listaPisos2) {
		this.ListaPisos = listaPisos2;
	}
	
	public String toString() {
		return "La agencia" + getNombre() + "tiene los siguientes pisos disponibles:\n" + toString();
	}

	//Procedimiento para crear un piso
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
		
		System.out.println("El ID del piso es: " + Main.cont);
		System.out.println("Introduza los datos solicitados:\n");
		
		do {
			System.out.println("Metros cuadrados:");
			metrosCuadrados = Double.parseDouble(sc.nextLine());
			if(metrosCuadrados <= 0) {
				System.out.println("Los metros introducidos no son válidos.");
			}
		}while(metrosCuadrados <= 0);
		
		do {
			do {
			System.out.println("¿El piso está a la venta? Introduzca una 'y' para si y una 'n' para no.");
			venta1 = sc.nextLine();
			venta1 = venta1.toLowerCase();
			if(!venta1.equals("y") && !venta1.equals("n")) {
				System.out.println("La elección introducida no es válida.");
			}
			
			}while(!venta1.equals("y") && !venta1.equals("n"));
			
			if(venta1.equals("y")) {
				venta = true;
				System.out.println("Precio de venta:");
				precioVenta = Integer.parseInt(sc.nextLine());
			} else if(venta1.equals("n")){
				venta = false;
			}
			
			do {
				System.out.println("¿El piso está en alquiler? Introduzca una 'y' para si y una 'n' para no.");
				alquiler1 = sc.nextLine();
				alquiler1 = alquiler1.toLowerCase();
				if(!alquiler1.equals("y") && !alquiler1.equals("n")) {
					System.out.println("La elección introducida no es válida.");
				}
				
			}while(!alquiler1.equals("y") && !alquiler1.equals("n"));

			if(alquiler1.equals("y")) {
				alquiler = true;
				System.out.println("Precio del alquiler:");
				precioAlquiler = sc.nextInt();
			} else if(alquiler1.equals("n")){
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
		Piso aux2 = new Piso(Main.cont, aux, metrosCuadrados, precioAlquiler, precioVenta, alquiler, venta);
		
		Main.ListaPisos.add(aux2);
	
		System.out.println("\n\tPiso creado con éxito\n");
		
		System.out.println("\n" + Main.ListaPisos.get(Main.cont).toString() + "\n");

		
		Main.cont++;
	}
	
	//Función para determinar si el ID es correcto
	public static boolean IDCorrecto(int id) {
		boolean toret = false;
		for(int i = 0; i < Main.ListaPisos.size(); i++) {
			if(Main.ListaPisos.get(i).getID() == id) {
				toret = true;
				break;
			}else {
				toret = false;
			}
		}
		return toret;
	}
	
	
	public boolean idCorrecto(int id) {
		for(Piso piso: getListaPisos()) { //for (int i = 0; i < getListaPisos().size(); i++)
			if(piso.getID() == id) return true; //if(getListaPisos().get(i).getID() == id)
		}
		return false;
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

	//Función para comprobar que la letra es correcta
	public static boolean LetraCorrecta(String letra) {
		String[] tipoLetra = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		List<String> listaLetras = Arrays.asList(tipoLetra);
		if(listaLetras.contains(letra.toUpperCase())) {
			return true;
		} else {
			return false;
		}
	}
	
	 //Función para comprobar que la provincia sea correcta
	public static boolean ProvinciaCorrecta(String provincia) {
		provincia = provincia.toLowerCase();
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

	public void mostrar() {
		for(int i = 0; i < Main.ListaPisos.size(); i++) {
			System.out.println(Main.ListaPisos.get(i).toString() + "\n");
		}
	}
	
	public void mostrarAlquiler() {
		for(int i = 0; i < Main.ListaPisos.size(); i++) {
			if(Main.ListaPisos.get(i).getAlquiler() == true) {
				System.out.println(Main.ListaPisos.get(i).toString() + "\n");
			}
		}
	}
	
	public void mostrarVenta() {
		for(int i = 0; i < Main.ListaPisos.size(); i++) {
			if(Main.ListaPisos.get(i).getVenta() == true) {
				System.out.println(Main.ListaPisos.get(i).toString() + "\n");
			}
		}
	}

	//Función para comprobar que los pisos cumple con los rangos de metros introducidos
	public boolean MetrosCorrectos(double a, double b) {
		boolean toret;
		double min = Main.ListaPisos.get(0).getMetrosCuadrados();
		double max = Main.ListaPisos.get(1).getMetrosCuadrados();
		for(int i = 0; i < Main.ListaPisos.size(); i ++) {
			if(Main.ListaPisos.get(i).getMetrosCuadrados() < min) {
				min = Main.ListaPisos.get(i).getMetrosCuadrados();
			}
		}
		for(int i = 0; i < Main.ListaPisos.size(); i ++) {
			if(Main.ListaPisos.get(i).getMetrosCuadrados() > max) {
				max = Main.ListaPisos.get(i).getMetrosCuadrados();
			}
		}
		if(a > max && b > max) {
			toret = false;
		} else if (a < min && b < min) {
			toret = false;
		} else {
			toret = true;
		}
		return toret;
	}
	
	//Método para mostrar los pisos por rango de metros
	public void RangoMetros(double a, double b) {
		
		for(int i = 0; i < Main.ListaPisos.size(); i ++) {
			if(Main.ListaPisos.get(i).getMetrosCuadrados() > a && Main.ListaPisos.get(i).getMetrosCuadrados() < b) {
				System.out.println(Main.ListaPisos.get(i).toString() + "\n");
			}
		}
		System.out.println("");
	}
	
	//Método para eliminar un piso
	public void BorrarPiso(int id) {
		String opcion;
		int pos = 0;
		for(int i = 0; i < Main.ListaPisos.size(); i++) {
			if(Main.ListaPisos.get(i).getID() == id) {
				pos = i;
				break;
			}
		}
		do {
			System.out.println("\n¿Está seguro de que desea borrar el piso? (y/n)");
			opcion = sc.nextLine();
			opcion = opcion.toLowerCase();
			if(opcion.equals("y")) {
				Main.ListaPisos.remove(pos);
				System.out.println("\tEl piso ha sido eliminado correctamente.\n");
			} else if(opcion.equals("n")) {
				System.out.println("\tEl piso no ha sido eliminado.\n");
			}
			if(!opcion.equals("y") && !opcion.equals("n")) {
				System.out.println("\tLa opción no es válida");
			}
		}while(!opcion.equals("y") && !opcion.equals("n"));
		
	}
	
	//Función para comprobar que el rango de precio de alquiler se cumple
		public static boolean PreciosCorrectosAlquiler(int a, int b) {
		boolean toret;
		int minA = Main.ListaPisos.get(0).getPrecioAlquiler();
		int maxA = Main.ListaPisos.get(1).getPrecioAlquiler();

		
		for(int i = 0; i < Main.ListaPisos.size(); i ++) {
			if(Main.ListaPisos.get(i).getAlquiler()) {
				if(Main.ListaPisos.get(i).getPrecioAlquiler() < minA) {
				minA = Main.ListaPisos.get(i).getPrecioAlquiler();
				}
			}
		}
		for(int i = 0; i < Main.ListaPisos.size(); i ++) {
			if(Main.ListaPisos.get(i).getAlquiler()) {
				if(Main.ListaPisos.get(i).getPrecioAlquiler() > maxA) {
				maxA = Main.ListaPisos.get(i).getPrecioAlquiler();
				}
			}
		}

		if(a < minA && b < minA) {
			toret = false;
		} else if (a > maxA && b > maxA) {
			toret = false;
		} else {
			toret = true;
		}
		return toret;
	}
		
		//Función para comprobar que el rango de precio de venta se cumple
		public static boolean PreciosCorrectosVenta(int a, int b) {
			boolean toret;

			int minV = Main.ListaPisos.get(7).getPrecioVenta();
			int maxV = Main.ListaPisos.get(8).getPrecioVenta();

			for(int i = 0; i < Main.ListaPisos.size(); i ++) {
				if(Main.ListaPisos.get(i).getVenta()) {
					if(Main.ListaPisos.get(i).getPrecioVenta() < minV) {
					minV = Main.ListaPisos.get(i).getPrecioVenta();
					}
				}
			}
			for(int i = 0; i < Main.ListaPisos.size(); i ++) {
				if(Main.ListaPisos.get(i).getVenta()) {
					if(Main.ListaPisos.get(i).getPrecioVenta() > maxV) {
					maxV = Main.ListaPisos.get(i).getPrecioVenta();
					}
				}
			}
			if(a > maxV && b > maxV) {
				toret = false;
			} else if (a < minV && b < minV) {
				toret = false;
			} else {
				toret = true;
			}
			return toret;
		}
	
		//Método para listar los pisos por precio
	public void ListarPiso() {
		String opcion;
		boolean salir = false;
		int num, num2;
		
		while(!salir) {
					System.out.println("Filtrar por:"
				+ "\n1. Precio Venta."
				+ "\n2. Precio Alquiler."
				+ "\n0. Salir");
		opcion = sc.nextLine();
		
			switch(opcion) {
			case "1":
				do {
					System.out.println("Introduzca el mínimo de precio: ");
					num = Integer.parseInt(sc.nextLine());
					System.out.println("Introduzca el máximo de precio: ");
					num2 = Integer.parseInt(sc.nextLine());
					if(num > num2) {
						System.out.println("Error debe introducir primero el menor precio y luego el mayor.");
					}
					if (num < 0) {
						System.out.println("Error. Debe ser positivo.");
					}
				}while(num > num2 && num < 0);
				
				if(PreciosCorrectosVenta(num, num2)) {
					for(int i = 0; i < Main.ListaPisos.size(); i ++) {
						if(Main.ListaPisos.get(i).getPrecioVenta() >= num && Main.ListaPisos.get(i).getPrecioVenta() <= num2) {
							if(Main.ListaPisos.get(i).getAlquiler() && !Main.ListaPisos.get(i).getVenta()) {
								
							} else if (Main.ListaPisos.get(i).getAlquiler() && Main.ListaPisos.get(i).getVenta()) {
								System.out.println(Main.ListaPisos.get(i).toString() + "\n");
							} else {
								System.out.println(Main.ListaPisos.get(i).toString() + "\n");
							}
						}
					}
					System.out.println("");
				} else {
					System.out.println("No existen pisos entre los rangos de precios introducidos (" + num + " / " + num2 +")");
				}
	
				break;
				
			case "2":
				do {
					System.out.println("Introduzca el mínimo de precio: ");
					num = Integer.parseInt(sc.nextLine());
					System.out.println("Introduzca el máximo de precio: ");
					num2 = Integer.parseInt(sc.nextLine());
					if(num > num2) {
						System.out.println("Error debe introducir primero el menor precio y luego el mayor.");
					}
					if (num < 0) {
						System.out.println("Error. Debe ser positivo.");
					}
				}while(num > num2 && num < 0);
				
				if(PreciosCorrectosAlquiler(num, num2)) {
					for(int i = 0; i < Main.ListaPisos.size(); i ++) {
						if(Main.ListaPisos.get(i).getPrecioAlquiler() >= num && Main.ListaPisos.get(i).getPrecioAlquiler() <= num2) {
							if(Main.ListaPisos.get(i).getVenta() && !Main.ListaPisos.get(i).getAlquiler()) {
								
							} else if (Main.ListaPisos.get(i).getVenta() && Main.ListaPisos.get(i).getAlquiler()){
								System.out.println(Main.ListaPisos.get(i).toString() + "\n");
							} else {
								System.out.println(Main.ListaPisos.get(i).toString() + "\n");
							}
						}
					}
					System.out.println("");
				} else {
					System.out.println("No existen pisos entre los rangos de precios introducidos (" + num + " / " + num2 +")");
				}
				break;
				
			case"0":
				salir = true;
				System.out.println("Regresando al menú principal.\n");
				break;
			default:
				System.out.println("La opción no es válida.\n");
				break;
				}
			}
		}
	
	//Método para modificar el alquiler
	public void ModificarAlquiler() {
		int id;
		String opcion;
		boolean salir = false;
		
		while(!salir) {
			do {
					System.out.println("Introduzca el ID del piso que desea modificar: ");
					id = Integer.parseInt(sc.nextLine());
					if(!IDCorrecto(id)) {
						System.out.println("El ID no es correcto.");
					}
				}while(!IDCorrecto(id));
			
			System.out.println("\n" + Main.ListaPisos.get(id).toString() + "\n");

			if(Main.ListaPisos.get(id).getAlquiler()) {
				System.out.println("El piso se encuentra en alquiler:\n"
						+ "1. Eliminarlo de alquiler\n"
						+ "2. Modificar el precio\n"
						+ "0. Salir");
				opcion = sc.nextLine();
				 switch(opcion) {
				 case "1":
					 if(Main.ListaPisos.get(id).getVenta()) {
						 String aux;
						 do {
							 System.out.println("¿Está seguro de que quiere eliminarlo de alquiler? (y/n).\nSe borrará su precio de alquiler automáticamente.");
							 aux = sc.nextLine();
							 aux = aux.toLowerCase();
							 if(!aux.equals("y") && !aux.equals("n")) {
								 System.out.println("La opción no es válida");
							 }
						 }while(!aux.equals("y") && !aux.equals("n"));
						 
						 if(aux.equals("y")) {
							Main.ListaPisos.get(id).setAlquiler(false);
							Main.ListaPisos.get(id).setPrecioAlquiler(0);
							System.out.println("Cambio realizado con éxito.\n" + Main.ListaPisos.get(id).toString() + "\n");
							salir = true;
						 }
					 } else if (!Main.ListaPisos.get(id).getVenta()) {
						 System.out.println("NO se puede quitar el piso de alquiler.\nPrimero añadalo a venta.\n\tSi el piso a dejado de estar disponible tiene la opcion eliminar.");
						 salir = true;
					 }
					 break;
					 
				 case "2":
					 int num;
					 do {
						 System.out.println("Introduce el nuevo precio de alquiler: ");
						 num = Integer.parseInt(sc.nextLine());
					 }while(num <= 0);
					 
					 Main.ListaPisos.get(id).setPrecioAlquiler(num);
					 System.out.println("Cambio realizado con éxito.\n" + Main.ListaPisos.get(id).toString() + "\n");
					 salir = true;
					 break;
					 
				 case "0":
					 salir = true;
					 System.out.println("Volviendo al menú de modificación.\n");
					 break;
				default:
					System.out.println("La opción no es válida.\n");
					break;
				 }
			} else if(!Main.ListaPisos.get(id).getAlquiler()) {
				System.out.println("El piso NO se encuentra en alquiler:\n"
						+ "1. Añadirlo a alquiler\n"
						+ "0. Salir");
				opcion = sc.nextLine();
				switch(opcion) {
				case "1":
					int num;
					do {
						System.out.println("Introduzca el precio de alquiler: ");
						num = Integer.parseInt(sc.nextLine());
					}while(num <= 0);
					
					Main.ListaPisos.get(id).setAlquiler(true);
					Main.ListaPisos.get(id).setPrecioAlquiler(num);
					System.out.println("Datos modificados con éxito.\n" + Main.ListaPisos.get(id).toString() + "\n");
					salir = true;
				break;
				
				case "0":
					salir = true;
					System.out.println("Regresando al menú de modificación.\n");
				break;
				
				default:
					System.out.println("La opción no es válida.\n");
				break;
				}
			}
		}
	}
	
	//Método para modificar la venta
	public void ModificarVenta() {
		int id;
		String opcion;
		boolean salir = false;
		
		while(!salir) {
			do {
				System.out.println("Introduzca el ID del piso que desea modificar: ");
				id = Integer.parseInt(sc.nextLine());
				if(!IDCorrecto(id)) {
					System.out.println("El ID no es correcto.");
				}
			}while(!IDCorrecto(id));
			
			System.out.println("\n" + Main.ListaPisos.get(id).toString() + "\n");
			
			if(Main.ListaPisos.get(id).getVenta()) {
				System.out.println("El piso se encuentra en venta:\n"
						+ "1. Eliminarlo de venta\n"
						+ "2. Modificar el precio\n"
						+ "0. Salir");
				opcion = sc.nextLine();
				
				switch(opcion) {
				
				case "1":
					 if(Main.ListaPisos.get(id).getAlquiler()) {
						 String aux;
						 do {
							 System.out.println("¿Está seguro de que quiere eliminarlo de venta? (y/n).\nSe borrará su precio de venta automáticamente.");
							 aux = sc.nextLine();
							 aux = aux.toLowerCase();
							 if(!aux.equals("y") && !aux.equals("n")) {
								 System.out.println("La opción no es válida");
							 }
						 }while(!aux.equals("y") && !aux.equals("n"));
						 
						 if(aux.equals("y")) {
							Main.ListaPisos.get(id).setVenta(false);
							Main.ListaPisos.get(id).setPrecioVenta(0);
							System.out.println("Cambio realizado con éxito.\n" + Main.ListaPisos.get(id).toString() + "\n");
							salir = true;
						 }
					 } else if (!Main.ListaPisos.get(id).getAlquiler()) {
						 System.out.println("NO se puede quitar el piso de venta.\nPrimero añadalo a alquiler.\n\tSi el piso a dejado de estar disponible tiene la opcion eliminar.");
						 salir = true;
					 }
					 break;
					
				case "2":
					 int num;
					 do {
						 System.out.println("Introduce el nuevo precio de venta: ");
						 num = Integer.parseInt(sc.nextLine());
					 }while(num <= 0);
					 
					 Main.ListaPisos.get(id).setPrecioVenta(num);
					 System.out.println("Cambio realizado con éxito.\n" + Main.ListaPisos.get(id).toString() + "\n");
					 salir = true;
					break;
					
				case "0":
					 salir = true;
					 System.out.println("Volviendo al menú de modificación.\n");
					break;
					
				default:
					System.out.println("La opción no es válida.\n");
					break;
				}
			} else if(!Main.ListaPisos.get(id).getVenta()) {
				System.out.println("El piso NO se encuentra en venta:\n"
						+ "1. Añadirlo a venta\n"
						+ "0. Salir");
				opcion = sc.nextLine();
				
				switch(opcion) {
				
				case "1":
					int num;
					do {
						System.out.println("Introduzca el precio de venta: ");
						num = Integer.parseInt(sc.nextLine());
					}while(num <= 0);
					
					Main.ListaPisos.get(id).setVenta(true);
					Main.ListaPisos.get(id).setPrecioVenta(num);
					System.out.println("Datos modificados con éxito.\n" + Main.ListaPisos.get(id).toString() + "\n");
					salir = true;
					break;
				
				case "0":
					salir = true;
					System.out.println("Regresando al menú de modificación.\n");
					break;
				default:
					System.out.println("La opción no es válida.\n");
				break;
				}
			}
		}	
	}
}
