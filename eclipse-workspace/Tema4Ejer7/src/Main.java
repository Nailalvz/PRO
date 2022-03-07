import java.util.Scanner;

public class Main {
	   public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int dia, mes, año;

	        System.out.println("Introduce fecha: ");
	        System.out.print("dia: ");
	        dia = sc.nextInt();
	        System.out.print("mes: ");
	        mes = sc.nextInt();
	        System.out.print("año: ");
	        año = sc.nextInt();

	        Fecha fecha = new Fecha(dia,mes,año);

	        if (fecha.fechaCorrecta()) { 

	            System.out.println("Fecha introducida: " + fecha);

	                                        
	            System.out.println("Los 50 días siguientes son:");
	            for (int i = 1; i <= 50; i++) {
	                fecha.diaSiguiente();
	                System.out.println(fecha);
	               
	            }

	        } else {
	            System.out.println("Fecha no valida");
	        }
	        sc.close();
	    }
}
