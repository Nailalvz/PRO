import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	//Crea la estructura de datos si no existe
	public static void directory_exists(File directory) {
		if(!directory.exists()) { //Si no existe lo crea
		directory.mkdir();
		System.out.println("Los directorios fueron creados con éxito");
		}
	}
	
	// Devuelve una String con la fecha y la hora
	private static String getTimeStamp() {
		
		String timeStamp = new SimpleDateFormat("yyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		return timeStamp;
	}
	
	//Escribe la fecha y la hora en el fichero correspodiente al usuario
	public static void registrarAccesoUsuario(File f) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))){
			bw.write(getTimeStamp());
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			System.err.println("Error de E/S. " + e.getMessage());
			escribirEnErrLog(e.getMessage());
		}
	}
	
	//Menu que te da la opción de escoger el nombre de usuario con el que 
	//registrarte
	public static void userLog(String ruta) {
		String opcion;
		boolean salir = false;
		File f = null;
		
		while(!salir) {
			
			System.out.println("Seleccione como desea identificarse:\n"
				+ "1. Introduciendo un username.\n"
				+ "2. Con el username del sistema.\n"
				+ "0. Salir.");
			opcion = sc.nextLine();
			
			switch(opcion) {
			
			case "1":
				System.out.println("Introduzca el username:");
				String username = sc.nextLine();
				f = new File(ruta + "\\" + username + ".log");
				
				try {
					f.createNewFile();
					registrarAccesoUsuario(f);
					System.out.println("El resultado del netstat tardará un poco en crearse. Tenga paciencia.");
					resultadoNetstat();
					System.out.println("Registro creado con éxito.");
				} catch (IOException e) {
					System.err.println("Error de E/S. " + e.getMessage());
					escribirEnErrLog(e.getMessage());
				}
				break;
				
			case "2":
				String usr = System.getProperty("user.name");
				f = new File(ruta + "\\" + usr + ".log");
				try {
					f.createNewFile();
					registrarAccesoUsuario(f);
					System.out.println("El resultado del netstat tardará un poco en crearse. Tenga paciencia.");
					resultadoNetstat();
				
					System.out.println("Registro creado con éxito.");
				} catch (IOException e) {
					System.err.println("Error de E/S. " + e.getMessage());
					escribirEnErrLog(e.getMessage());
				}
				break;
				
			case "0":
				salir = true;
				System.out.println("Finalizando programa.");
				break;
			default:
				System.err.println("La opción no es válida.");
				break;
			}
		}
	}
		
	// Devuelve el netstat con el mayor número de netsat registrado
	public static int getNumeroUltimoNetStatLog() {
		int max = 0;
		int actual;
	
		String aux;
		
		File f = new File("net");
		String ficheros[] = f.list();
		
	
			for (String fichero : ficheros) {
				aux ="";
				if(fichero.toLowerCase().startsWith("netstat_") && fichero.toLowerCase().endsWith(".log")) {
					for (int i = 8; i < fichero.length() - 4; i++) {
						aux = aux + fichero.charAt(i);
					}
					if(aux.matches("[0-9]+")) {
						actual = Integer.parseInt(aux);
						if(actual > max) {
							max = actual;
						}
					}
					
				}
				
			}
			
		return max;
		
		}
	
	public static void resultadoNetstat() throws IOException {
		File f = null;
		ArrayList<String> netstat = new ArrayList<>();
		BufferedReader br = null;
		BufferedWriter bw = null;
		int num_netstat;
		
		if(getNumeroUltimoNetStatLog() == 0) {
			num_netstat = 1;
		} else num_netstat = getNumeroUltimoNetStatLog();
		
		f = new File("net\\netstat_" + num_netstat + ".log");
		
		try {
			Process p = Runtime.getRuntime().exec("netstat /a");
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			FileWriter fw = new FileWriter(f, true);
			bw = new BufferedWriter(fw);
			netstat.add(getTimeStamp());
			while(br.readLine() != null) {
				netstat.add(br.readLine());
			}
				for(int i = 0; i < netstat.size(); i++) {
					if(200 - contadorLineas(f) != 0) {
						bw.write(netstat.get(i));
						bw.newLine();
						bw.flush();
					} else {
						num_netstat++;
						f = new File ("net\\netstat_" + (num_netstat) + ".log");
						f.createNewFile();
						bw = new BufferedWriter(new FileWriter(f, true));
						i--;
					}
				}
		} catch (IOException e) {
			System.err.println("Error de E/S. " + e.getMessage());
			escribirEnErrLog(e.getMessage());
		} finally {
			br.close();
			bw.close();
		}
	}
	
	
	private static int contadorLineas(File f) {
		int lineas = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(f))) {
			while(br.readLine() != null)
				lineas++;
		} catch (IOException e) {
			System.err.println("Error de E/S. " + e.getMessage());
			escribirEnErrLog(e.getMessage());
		}
		return lineas;
	}
	
	/*
	 * Este método lo hice para comprobar que el array no estaba vacío
	 * 
	public static void muestraArray(ArrayList<String> netstat){
		for(int i = 0; i < netstat.size(); i++) {
			System.out.println(netstat.get(i));
		}
	}	

	*/
	
	//Escribe en la ruta err.log una nueva entrada con fecha y hora y el mensaje de error
	public static void escribirEnErrLog(String mensaje) {
		File f = new File("err.log");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {
			bw.write(getTimeStamp() + " mensaje de error: " + mensaje);
			
		} catch (IOException e) {
			System.err.println("Error de E/S. " + e.getMessage());
			escribirEnErrLog(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
			directory_exists(new File(".\\actividad"));
			directory_exists(new File(".\\net"));
			userLog("actividad");
	}
}
