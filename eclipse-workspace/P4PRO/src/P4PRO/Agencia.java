package P4PRO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Agencia {

	private String nombre;
	private  ArrayList<Piso> listaPisos;
	private int cont = 10;
	static Scanner sc = new Scanner(System.in);
	
	public Agencia() {
		this.nombre = "";
		this.setListaPisos(listaPisos);
	}
	
	public Agencia(String nombre) {
		this.nombre = nombre;
	}
	
	public Agencia(String nombre, ArrayList<Piso> listaPisos) {
		this.nombre = nombre;
		this.listaPisos = listaPisos;
	}
	
	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public ArrayList<Piso> getListaPisos() {
		return listaPisos;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setListaPisos(ArrayList<Piso> listaPisos) {
		this.listaPisos = listaPisos;
	}
	

	//Comprueba si el id que le llega es correcto
	public boolean idCorrecto(int id) {
		for (int i = 0; i < getListaPisos().size(); i++)
			if(getListaPisos().get(i).getID() == id) {
				return true;
		}
		return false;
	}
	
	//Comprueba qeu el c?digo postal sea de 5 n?meros
	public boolean codigoPostalCorrecto(int num) {
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
	
	//Comprueba que la letra sea correcta
	public boolean letraCorrecta(String letra) {
		String[] tipoLetra = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		List<String> listaLetras = Arrays.asList(tipoLetra);
		if(listaLetras.contains(letra.toUpperCase())) {
			return true;
		} else {
			return false;
		}
	}
	
	//Comprueba que la provincia es correcta
	public boolean provinciaCorrecta(String provincia) {
		provincia = provincia.toLowerCase();
		String[] provincias = {"alava","albacete","alicante","almeria","asturias","avila","badajoz","barcelona","burgos",
				"caceres","cadiz","cantabria","castellon","ciudad real","cordoba","a coru?a","cuenca","gerona","granada","guadalajara","guipuzcoa",
				"huelva","huesca","islas baleares","jaen","leon","lerida","lugo","madrid","malaga","murcia","navarra","ourense","palencia",
				"las palmas","pontevedra","la rioja","salamanca","segovia","sevilla","soria","tarragona","tenerife","teruel","toledo","valencia",
				"valladolid","vizcaya","zamora","zaragoza"};
		List<String> listaProvincias = Arrays.asList(provincias);
		if(listaProvincias.contains(provincia.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}
	
	//Muestra todos lo pisos
	public void mostrar() {
		for(int i = 0; i < getListaPisos().size(); i++) {
			System.out.println(getListaPisos().get(i).toString() + "\n");
		}
	}
	
	//Muestra solo el piso del ID
	public void mostrarPiso(int id) {
		for(int i = 0; i < getListaPisos().size(); i++) {
			if(getListaPisos().get(i).getID() == id) {
				System.out.println(getListaPisos().get(i).toString() + "\n");
			}
		}
	}
	
	//Muestra solo los pisos en alquiler
	public void mostrarAlquiler() {
		for(int i = 0; i < getListaPisos().size(); i++) {
			if(getListaPisos().get(i).getAlquiler() == true) {
				System.out.println(getListaPisos().get(i).toString() + "\n");
			}
		}
	}
	
	//Muestra solo los pisos en venta
	public void mostrarVenta() {
		for(int i = 0; i < listaPisos.size(); i++) {
			if(getListaPisos().get(i).getVenta() == true) {
				System.out.println(listaPisos.get(i).toString() + "\n");
			}
		}
	}
	
	//Comprueba que los pisos cumplan con los rangos introducidos
	public boolean metrosCorrectos(double a, double b) {
		boolean toret;
		double min = getListaPisos().get(0).getMetrosCuadrados();
		double max = getListaPisos().get(1).getMetrosCuadrados();
		for(int i = 0; i < getListaPisos().size(); i ++) {
			if(getListaPisos().get(i).getMetrosCuadrados() < min) {
				min = getListaPisos().get(i).getMetrosCuadrados();
			}
		}
		for(int i = 0; i < getListaPisos().size(); i ++) {
			if(getListaPisos().get(i).getMetrosCuadrados() > max) {
				max = getListaPisos().get(i).getMetrosCuadrados();
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
	
	//Muestra los pisos por los rangos introducidos
	private void rangoMetros(double a, double b) {
			
			for(int i = 0; i < getListaPisos().size(); i ++) {
				if(getListaPisos().get(i).getMetrosCuadrados() > a && getListaPisos().get(i).getMetrosCuadrados() < b) {
					System.out.println(getListaPisos().get(i).toString() + "\n");
				}
			}
			System.out.println("");
	}

	//Pide los rangos de metros y llama a otrso m?todos para comprobar que son correctos
	public void listarPisosMetros() {
		double metros = 0;
		double metros2 = 0;
	
		do {
			System.out.println("Introduzca el m?nimo de metros cuadrados: ");
			metros = Double.parseDouble(sc.nextLine());
			System.out.println("Introduzca el m?ximo de metros cuadrados: ");
			metros2 = Double.parseDouble(sc.nextLine());
			if(metros > metros2) {
				System.out.println("Datos mal introducidos.\nPrimero debe introducir el m?nimo de metros cuadrados"
						+ " y a continuaci?n el m?ximo.");
			}
		}while(metros > metros2);
		if(!metrosCorrectos(metros, metros2)) {
			System.out.println("\tNo existen pisos entre esos rangos de metros cuadrados.\n");
		} else {
			rangoMetros(metros,metros2);
		}
	}

	//M?todo para eliminar un piso
	public void borrarPiso(int id) {
		
		String opcion;
		int pos = 0;
		for(int i = 0; i < getListaPisos().size(); i++) {
			if(getListaPisos().get(i).getID() == id) {
				pos = i;
				break;
			}
		}
		do {
			System.out.println("\n?Est? seguro de que desea borrar el piso? (y/n)");
			opcion = sc.nextLine();
			opcion = opcion.toLowerCase();
			if(opcion.equals("y")) {
				getListaPisos().remove(pos);
				System.out.println("\tEl piso ha sido eliminado correctamente.\n");
			} else if(opcion.equals("n")) {
				System.out.println("\tEl piso no ha sido eliminado.\n");
			}
			if(!opcion.equals("y") && !opcion.equals("n")) {
				System.out.println("\tLa opci?n no es v?lida");
			}
		}while(!opcion.equals("y") && !opcion.equals("n"));
		
	}
	
	//Comprueba que los pisos cumplan con los rangos introducidos
	public boolean preciosCorrectosAlquiler(int a, int b) {
		boolean toret;
		int minA = getListaPisos().get(0).getPrecioAlquiler();
		int maxA = getListaPisos().get(1).getPrecioAlquiler();

		
		for(int i = 0; i < getListaPisos().size(); i ++) {
			if(getListaPisos().get(i).getAlquiler()) {
				if(getListaPisos().get(i).getPrecioAlquiler() < minA) {
				minA = getListaPisos().get(i).getPrecioAlquiler();
				}
			}
		}
		for(int i = 0; i < getListaPisos().size(); i ++) {
			if(getListaPisos().get(i).getAlquiler()) {
				if(getListaPisos().get(i).getPrecioAlquiler() > maxA) {
				maxA = getListaPisos().get(i).getPrecioAlquiler();
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

	//Comprueba que los pisos cumplan con los rangos introducidos
	public boolean preciosCorrectosVenta(int a, int b) {
		boolean toret;

		int minV = getListaPisos().get(7).getPrecioVenta();
		int maxV = getListaPisos().get(8).getPrecioVenta();

		for(int i = 0; i < getListaPisos().size(); i ++) {
			if(getListaPisos().get(i).getVenta()) {
				if(getListaPisos().get(i).getPrecioVenta() < minV) {
				minV = getListaPisos().get(i).getPrecioVenta();
				}
			}
		}
		for(int i = 0; i < getListaPisos().size(); i ++) {
			if(getListaPisos().get(i).getVenta()) {
				if(getListaPisos().get(i).getPrecioVenta() > maxV) {
				maxV = getListaPisos().get(i).getPrecioVenta();
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

	//Filtra los pisos por precio de venta y alquiler
	public void listarPiso() {
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
					System.out.println("Introduzca el m?nimo de precio: ");
					num = Integer.parseInt(sc.nextLine());
					System.out.println("Introduzca el m?ximo de precio: ");
					num2 = Integer.parseInt(sc.nextLine());
					if(num > num2) {
						System.out.println("Error debe introducir primero el menor precio y luego el mayor.");
					}
					if (num < 0) {
						System.out.println("Error. Debe ser positivo.");
					}
				}while(num > num2 && num < 0);
				
				if(preciosCorrectosVenta(num, num2)) {
					for(int i = 0; i < getListaPisos().size(); i ++) {
						if(getListaPisos().get(i).getPrecioVenta() >= num && getListaPisos().get(i).getPrecioVenta() <= num2) {
							if(getListaPisos().get(i).getAlquiler() && !getListaPisos().get(i).getVenta()) {
								
							} else if (getListaPisos().get(i).getAlquiler() && getListaPisos().get(i).getVenta()) {
								System.out.println(getListaPisos().get(i).toString() + "\n");
							} else {
								System.out.println(getListaPisos().get(i).toString() + "\n");
							}
						}
					}
					System.out.println("");
				} else {
					System.out.println("No existen pisos entre los rangos de precios introducidos (" + num + " / " + num2 +")\n");
				}
	
				break;
				
			case "2":
				do {
					System.out.println("Introduzca el m?nimo de precio: ");
					num = Integer.parseInt(sc.nextLine());
					System.out.println("Introduzca el m?ximo de precio: ");
					num2 = Integer.parseInt(sc.nextLine());
					if(num > num2) {
						System.out.println("Error debe introducir primero el menor precio y luego el mayor.");
					}
					if (num < 0) {
						System.out.println("Error. Debe ser positivo.");
					}
				}while(num > num2 && num < 0);
				
				if(preciosCorrectosAlquiler(num, num2)) {
					for(int i = 0; i < getListaPisos().size(); i ++) {
						if(getListaPisos().get(i).getPrecioAlquiler() >= num && getListaPisos().get(i).getPrecioAlquiler() <= num2) {
							if(getListaPisos().get(i).getVenta() && !getListaPisos().get(i).getAlquiler()) {
								
							} else if (getListaPisos().get(i).getVenta() && getListaPisos().get(i).getAlquiler()){
								System.out.println(getListaPisos().get(i).toString() + "\n");
							} else {
								System.out.println(getListaPisos().get(i).toString() + "\n");
							}
						}
					}
					System.out.println("");
				} else {
					System.out.println("No existen pisos entre los rangos de precios introducidos (" + num + " / " + num2 +")\n");
				}
				break;
				
			case"0":
				salir = true;
				System.out.println("Regresando al men? principal.\n");
				break;
			default:
				System.out.println("La opci?n no es v?lida.\n");
				break;
				}
			}
		}

	//M?todo para modificar el alquiler que comprueba si el piso est? en alquiler o no
	private void modificarAlquiler() {
		int id;
		String opcion;
		boolean salir = false;
		
		while(!salir) {
			do {
					System.out.println("Introduzca el ID del piso que desea modificar: ");
					id = Integer.parseInt(sc.nextLine());
					if(!idCorrecto(id)) {
						System.out.println("El ID no es correcto.");
					}
				}while(!idCorrecto(id));
			
			mostrarPiso(id);

			if(getListaPisos().get(id).getAlquiler()) {
				System.out.println("El piso se encuentra en alquiler:\n"
						+ "1. Eliminarlo de alquiler\n"
						+ "2. Modificar el precio\n"
						+ "0. Salir");
				opcion = sc.nextLine();
				 switch(opcion) {
				 case "1":
					 if(getListaPisos().get(id).getVenta()) {
						 String aux;
						 do {
							 System.out.println("?Est? seguro de que quiere eliminarlo de alquiler? (y/n).\nSe borrar? su precio de alquiler autom?ticamente.");
							 aux = sc.nextLine();
							 aux = aux.toLowerCase();
							 if(!aux.equals("y") && !aux.equals("n")) {
								 System.out.println("La opci?n no es v?lida");
							 }
						 }while(!aux.equals("y") && !aux.equals("n"));
						 
						 if(aux.equals("y")) {
							getListaPisos().get(id).setAlquiler(false);
							getListaPisos().get(id).setPrecioAlquiler(0);
							System.out.println("Cambio realizado con ?xito.\n");
							mostrarPiso(id);
							salir = true;
						 }
					 } else if (!getListaPisos().get(id).getVenta()) {
						 System.out.println("NO se puede quitar el piso de alquiler.\nPrimero a?adalo a venta.\n\tSi el piso a dejado de estar disponible tiene la opcion eliminar.");
						 salir = true;
					 }
					 break;
					 
				 case "2":
					 int num;
					 do {
						 System.out.println("Introduce el nuevo precio de alquiler: ");
						 num = Integer.parseInt(sc.nextLine());
					 }while(num <= 0);
					 
					 getListaPisos().get(id).setPrecioAlquiler(num);
					 System.out.println("Cambio realizado con ?xito.\n");
					 mostrarPiso(id);
					 salir = true;
					 break;
					 
				 case "0":
					 salir = true;
					 System.out.println("Volviendo al men? de modificaci?n.\n");
					 break;
				default:
					System.out.println("La opci?n no es v?lida.\n");
					break;
				 }
			} else if(!getListaPisos().get(id).getAlquiler()) {
				System.out.println("El piso NO se encuentra en alquiler:\n"
						+ "1. A?adirlo a alquiler\n"
						+ "0. Salir");
				opcion = sc.nextLine();
				switch(opcion) {
				case "1":
					int num;
					do {
						System.out.println("Introduzca el precio de alquiler: ");
						num = Integer.parseInt(sc.nextLine());
					}while(num <= 0);
					
					getListaPisos().get(id).setAlquiler(true);
					getListaPisos().get(id).setPrecioAlquiler(num);
					System.out.println("Datos modificados con ?xito.\n");
					mostrarPiso(id);
					salir = true;
				break;
				
				case "0":
					salir = true;
					System.out.println("Regresando al men? de modificaci?n.\n");
				break;
				
				default:
					System.out.println("La opci?n no es v?lida.\n");
				break;
				}
			}
		}
	}
	
	//M?todo para modificar la venta que comprueba si el piso est? en venta o no
	private void modificarVenta() {
		int id;
		String opcion;
		boolean salir = false;
		
		while(!salir) {
			do {
				System.out.println("Introduzca el ID del piso que desea modificar: ");
				id = Integer.parseInt(sc.nextLine());
				if(!idCorrecto(id)) {
					System.out.println("El ID no es correcto.");
				}
			}while(!idCorrecto(id));
			
			mostrarPiso(id);
			
			if(getListaPisos().get(id).getVenta()) {
				System.out.println("El piso se encuentra en venta:\n"
						+ "1. Eliminarlo de venta\n"
						+ "2. Modificar el precio\n"
						+ "0. Salir");
				opcion = sc.nextLine();
				
				switch(opcion) {
				
				case "1":
					 if(getListaPisos().get(id).getAlquiler()) {
						 String aux;
						 do {
							 System.out.println("?Est? seguro de que quiere eliminarlo de venta? (y/n).\nSe borrar? su precio de venta autom?ticamente.");
							 aux = sc.nextLine();
							 aux = aux.toLowerCase();
							 if(!aux.equals("y") && !aux.equals("n")) {
								 System.out.println("La opci?n no es v?lida");
							 }
						 }while(!aux.equals("y") && !aux.equals("n"));
						 
						 if(aux.equals("y")) {
							getListaPisos().get(id).setVenta(false);
							getListaPisos().get(id).setPrecioVenta(0);
							System.out.println("Cambio realizado con ?xito.\n");
							mostrarPiso(id);
							salir = true;
						 }
					 } else if (!getListaPisos().get(id).getAlquiler()) {
						 System.out.println("NO se puede quitar el piso de venta.\nPrimero a?adalo a alquiler.\n\tSi el piso a dejado de estar disponible tiene la opcion eliminar.");
						 salir = true;
					 }
					 break;
					
				case "2":
					 int num;
					 do {
						 System.out.println("Introduce el nuevo precio de venta: ");
						 num = Integer.parseInt(sc.nextLine());
						 if(num <= 0) {
							 System.out.println("El precio de venta no puede ser 0 o inferior.");
						 }
					 }while(num <= 0);
					 
					 getListaPisos().get(id).setPrecioVenta(num);
					 System.out.println("Cambio realizado con ?xito.\n");
					 mostrarPiso(id);
					 salir = true;
					break;
					
				case "0":
					 salir = true;
					 System.out.println("Volviendo al men? de modificaci?n.\n");
					break;
					
				default:
					System.out.println("La opci?n no es v?lida.\n");
					break;
				}
			} else if(!getListaPisos().get(id).getVenta()) {
				System.out.println("El piso NO se encuentra en venta:\n"
						+ "1. A?adirlo a venta\n"
						+ "0. Salir");
				opcion = sc.nextLine();
				
				switch(opcion) {
				
				case "1":
					int num;
					do {
						System.out.println("Introduzca el precio de venta: ");
						num = Integer.parseInt(sc.nextLine());
					}while(num <= 0);
					
					getListaPisos().get(id).setVenta(true);
					getListaPisos().get(id).setPrecioVenta(num);
					System.out.println("Datos modificados con ?xito.\n");
					mostrarPiso(id);
					salir = true;
					break;
				
				case "0":
					salir = true;
					System.out.println("Regresando al men? de modificaci?n.\n");
					break;
				default:
					System.out.println("La opci?n no es v?lida.\n");
				break;
				}
			}
		}	
	}
	
	//Crear un piso
	public void crearPiso() {
		
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
		
		System.out.println("El ID del piso es: " + getCont());
		System.out.println("Introduza los datos solicitados:\n");
		
		do {
			System.out.println("Metros cuadrados:");
			metrosCuadrados = Double.parseDouble(sc.nextLine());
			if(metrosCuadrados <= 0) {
				System.out.println("Los metros introducidos no son v?lidos.");
			}
		}while(metrosCuadrados <= 0);
		
		do {
			do {
			System.out.println("?El piso est? a la venta? Introduzca una 'y' para si y una 'n' para no.");
			venta1 = sc.nextLine();
			venta1 = venta1.toLowerCase();
			if(!venta1.equals("y") && !venta1.equals("n")) {
				System.out.println("La elecci?n introducida no es v?lida.");
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
				System.out.println("?El piso est? en alquiler? Introduzca una 'y' para si y una 'n' para no.");
				alquiler1 = sc.nextLine();
				alquiler1 = alquiler1.toLowerCase();
				if(!alquiler1.equals("y") && !alquiler1.equals("n")) {
					System.out.println("La elecci?n introducida no es v?lida.");
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
		
		
		
		System.out.println("Datos de la direcci?n:\n");
		do {
			System.out.println("Tipo de v?a:"
					+ "\n\tAvenida: 0"
					+ "\n\tBulevar: 1"
					+ "\n\tCalle: 2"
					+ "\n\tCamino: 3"
					+ "\n\tCarretera: 4"
					+ "\n\tPlaza: 5"
					+ "\n\tR?a : 6"
					+ "\n\tUrbanizacion: 7"
					+ "\n\tOtro: 8"
					+ "\nIntroduzca el identificador para seleccionar el tipo de v?a: ");
			tipodevia = sc.nextInt();
			sc.nextLine();
		}while(tipodevia < 0 | tipodevia > 8);
		
		System.out.println("Nombre de la calle:");
		calle = sc.nextLine();
		calle = calle.toLowerCase();
		
		do {
			System.out.println("Introduce el n?mero de la calle: ");
			numCalle = sc.nextInt();
			sc.nextLine();
			if(numCalle <= 0) {
				System.out.println("El n?mero de la calle no puede ser inferior o igual a 0.");
			}
		}while(numCalle <= 0);
		
		do {
			System.out.println("N?mero del piso:");
			numPiso = sc.nextInt();
			sc.nextLine();
		}while(numPiso < 0);
		
		
		do {
			System.out.println("Letra:");
			letra = sc.nextLine();
			letra = letra.toUpperCase();
			if(!letraCorrecta(letra)) {
				System.out.println("La letra introducida no es correcta.");
			}
		}while(!letraCorrecta(letra));
		
		
		do {
			System.out.println("C?digo postal:");
			cod_postal = sc.nextInt();
			sc.nextLine();
			if(!codigoPostalCorrecto(cod_postal)) {
				System.out.println("El c?digo postal introducido no es v?lido. Debe tener 5 cifras.");
			}
		}while(!codigoPostalCorrecto(cod_postal));
		
		do {
			System.out.println("Provincia:\n(La provincia debe ser introducida sin tildes)");
			provincia = sc.nextLine();
			provincia = provincia.toLowerCase();
			if(!provinciaCorrecta(provincia)) {
				System.out.println("La provincia introducida no es v?lida.");
			}
		}while(!provinciaCorrecta(provincia));
		
		
		Direccion aux = new Direccion(tipodevia, calle, numCalle, numPiso, letra, cod_postal, provincia);
		Piso aux2 = new Piso(getCont(), aux, metrosCuadrados, precioAlquiler, precioVenta, alquiler, venta);
		
		getListaPisos().add(aux2);
	
		System.out.println("\n\tPiso creado con ?xito\n");
		
		mostrarPiso(cont);

		setCont(getCont() + 1);
	}

	//Men? para modificar un piso
	public void modificarPiso() {
		
		mostrar();

		String opcion;
		boolean salir = false;
		
		while(!salir) {
			System.out.println("Opciones de modificaci?n:\n"
					+ "\t1. Direcci?n.\n"
					+ "\t2. Metros cuadrados.\n"
					+ "\t3. Precio y disponibilidad de alquiler.\n"
					+ "\t4. Precio y disponibilidad de venta.\n"
					+ "\t0. Regresar al men? principal."
					+ "\nIntroduzca su opci?n: ");
			opcion = sc.nextLine();
			
			switch(opcion) {
			
			case "1":
				modificarDireccion();
			break;
			
			case "2":
				modificarMetros();
			break;
			
			case "3":
				modificarAlquiler();
			break;
			
			case"4":
				modificarVenta();
			break;
			
			case "0":
				System.out.println("Ha seleccionado salir\n\t Volviendo al men? principal\n");
				salir = true;
			break;
			
			default:
				System.out.println("La opci?n no es v?lida");
			break;
				
			}
		}
	}

	//Men? para modificar la direcci?n
	private void modificarDireccion() {
		String opcion;
		boolean salir = false;
		int id;
		
			do {
				System.out.println("Introduzca el ID del piso que desea modificar: ");
				id = Integer.parseInt(sc.nextLine());
				if(!idCorrecto(id)) {
					System.out.println("El ID no es correcto.");
				}
			}while(!idCorrecto(id));
			
			mostrarPiso(id);
			
			while(!salir) {
				System.out.println("Opciones de modificaci?n de la direcci?n:\n"
						+ "\t1- Tipo de v?a\n"
						+ "\t2- Nombre de la calle\n"
						+ "\t3- N?mero de la calle\n"
						+ "\t4- N?mero del piso\n"
						+ "\t5- Letra del piso\n"
						+ "\t6- C?digo postal\n"
						+ "\t7- Provincia\n"
						+ "\t0- Para salir\n"
						+ "Introduzca su opcion: ");
				opcion = sc.nextLine();
	
				switch(opcion) {
				
				case "1":
					int aux;
					do {
						System.out.println("Se le ha asignado a cada tipo de v?a un identificador de la siguiente forma:"
							+ "\n\tAvenida: 0"
							+ "\n\tBulevar: 1"
							+ "\n\tCalle: 2"
							+ "\n\tCamino: 3"
							+ "\n\tCarretera: 4"
							+ "\n\tPlaza: 5"
							+ "\n\tR?a: 6"
							+ "\n\tUrbanizacion: 7"
							+ "\n\tOtro: 8"
							+ "\nIntroduzca el identificador para seleccionar el tipo de v?a: ");
						aux = Integer.parseInt(sc.nextLine());
						if(aux < 0 || aux > 8) {
							System.out.println("Error al seleccionar el tipo de v?a. Vuelva a introducir el identificador.\n");
						}
					}while(aux < 0 || aux > 8);
					getListaPisos().get(id).getDireccion().setTipodeVia(aux);
					System.out.println("\n");
					mostrarPiso(id);
					System.out.println("\n\tCambio realizado con ?xito.\n\tVolviendo al men? de modificaci?n de la direcci?n.\n");
				
				break;
				
				case "2":
					System.out.println("Introduzca el nombre de la calle:");
					String calle = sc.nextLine();
					getListaPisos().get(id).getDireccion().setNombre(calle);
					System.out.println("\n");
					mostrarPiso(id);
					System.out.println("\n\tCambio realizado con ?xito.\n\tVolviendo al men? de modificaci?n de la direcci?n.\n");
				break;
				
				case "3":
					int numCalle;
					do {
						System.out.println("Introduzca el n?mero de la calle:");
						numCalle = Integer.parseInt(sc.nextLine());
						if(numCalle <= 0) {
							System.out.println("El n?mero de la calle no debe ser menor o igual a 0.");
						}
					}while(numCalle <= 0);
					
					getListaPisos().get(id).getDireccion().setNumCalle(numCalle);
					System.out.println("\n");
					mostrarPiso(id);
					System.out.println("\n\tCambio realizado con ?xito.\n\tVolviendo al men? de modificaci?n de la direcci?n.\n");
				break;
				
				case "4":
					int numPiso;
					do {
						System.out.println("Introduzca el n?mero del piso:");
						numPiso = Integer.parseInt(sc.nextLine());
						if(numPiso < 0) {
							System.out.println("El piso introducido NO puede ser inferior a 0.");
						}
					}while(numPiso < 0);
					
					getListaPisos().get(id).getDireccion().setNumPiso(numPiso);
					System.out.println("\n");
					mostrarPiso(id);
					System.out.println("\n\tCambio realizado con ?xito.\n\tVolviendo al men? de modificaci?n de la direcci?n.\n");
				break;
				
				case "5":
					String letra;
					do {
						System.out.println("Introduzca la letra del piso:");
						letra = sc.nextLine();
						letra = letra.toUpperCase();
						if(!letraCorrecta(letra)) {
							System.out.println("La letra introducida NO es v?lida.");
						}
					}while(!letraCorrecta(letra));
					
					getListaPisos().get(id).getDireccion().setLetra(letra);
					System.out.println("\n");
					mostrarPiso(id);
					System.out.println("\n\tCambio realizado con ?xito.\n\tVolviendo al men? de modificaci?n de la direcci?n.\n");
				break;
				
				case "6":
					int cod_postal;
					do {
						System.out.println("Introduzca el c?digo postal:");
						cod_postal = Integer.parseInt(sc.nextLine());
	
						if(!codigoPostalCorrecto(cod_postal)) {
							System.out.println("El c?digo postal NO es v?lido recuerde que debe tener 5 cifras.");
						}
					}while(!codigoPostalCorrecto(cod_postal));
					
					getListaPisos().get(id).getDireccion().setCodigoPostal(cod_postal);
					System.out.println("\n");
					mostrarPiso(id);
					System.out.println("\n\tCambio realizado con ?xito.\n\tVolviendo al men? de modificaci?n de la direcci?n.\n");
				break;
				
				case "7":
					String provincia;
					do {
						System.out.println("Introduzca la provincia del piso:\n(Sin tildes)");
						provincia = sc.nextLine();
						if(!provinciaCorrecta(provincia)) {
							System.out.println("La provincia introducida NO es correcta. Tenga en cuenta que puede haber errores como por ejemplo"
									+ " escribir La Coru?a que ser?a erroneo siendo lo correcto A Coru?a.\n");
						}
					}while(!provinciaCorrecta(provincia));
					
					getListaPisos().get(id).getDireccion().setProvincia(provincia);
					System.out.println("\n");
					mostrarPiso(id);
					System.out.println("\n\tCambio realizado con ?xito.\n\tVolviendo al men? de modificaci?n de la direcci?n.\n");
				break;
				
				case"0":
					salir = true;
					System.out.println("\nHa seleccionado salir.\n\t Volviendo al men? de modificaci?n\n");
				break;
				
				default:
					System.out.println("La opci?n no es v?lida");
				
				}
			}
	 	}
		
	//M?todo para modificar los metros cuadrados
	 private void modificarMetros() {
		 double metrosCuadrados;
		 int id;
		 do {
			 
			System.out.println("Introduzca el ID del piso que desea modificar: ");
			id = Integer.parseInt(sc.nextLine());
			if(!idCorrecto(id)) {
				System.out.println("El ID no es correcto.");
			}
		}while(!idCorrecto(id));
		  mostrarPiso(id);
		  do {
				System.out.println("\nIntroduzca lo metros cuadrados: ");
				metrosCuadrados = Double.parseDouble(sc.nextLine());
			}while(metrosCuadrados <= 0);
			
			getListaPisos().get(id).setMetrosCuadrados(metrosCuadrados);
			System.out.println("\n");
			mostrarPiso(id);
			System.out.println("\n\tCambio realizado con ?xito.\n\tVolviendo al men? de modificaci?n.\n");
	 }
}
