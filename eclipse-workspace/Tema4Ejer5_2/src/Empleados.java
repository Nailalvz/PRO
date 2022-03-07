import java.util.Scanner;

public class Empleados {

	private static Empleado [] empleados;
	private static int maxEmpleados = 20;
	static Scanner sc = new Scanner(System.in);
	
	public Empleados(Empleado[] empleados) {
		Empleados.empleados = empleados;
	}
	
	public Empleados() {
		Empleados.empleados = new Empleado[maxEmpleados];
	}
	
	public Empleados(int numEmpleados) {
		Empleados.setMaxEmpleados(numEmpleados);
		Empleados.empleados = new Empleado[maxEmpleados];
	}

	public Empleado[] getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Empleado[] empleados) {
		Empleados.empleados = empleados;
	}

	public static int getMaxEmpleados() {
		return maxEmpleados;
	}

	public static void setMaxEmpleados(int maxEmpleados) {
		if(maxEmpleados > 20) maxEmpleados = 20;
		Empleados.maxEmpleados = maxEmpleados;
	}
	
	public static void leerEmpleados() {
		int n;
		Empleado a;
		String NIF;
		String nombre;
		double sueldoBase;
		double horasExtra;
		double IRPF;
		boolean casado;
		int hijos;

		
		do {
			System.out.println("Introduce el número de empleados:");
			n = sc.nextInt();
		}while(n < 0 || n > maxEmpleados);
		
		for(int i = 0; i <= n; i++) {
			sc.nextLine();
			System.out.println("Empleado: " + i);
			System.out.println("Nif: ");
			NIF = sc.nextLine();
			System.out.println("Nombre: ");
			nombre = sc.nextLine();
			System.out.println("Sueldo base: ");
			sueldoBase = sc.nextDouble();
			System.out.println("Horas extra: ");
			horasExtra = sc.nextDouble();
			System.out.println("IRPF: ");
			IRPF = sc.nextDouble();
			System.out.println("Casado: ");
			casado = sc.hasNext();
			System.out.println("Número de hijos: ");
			hijos = sc.nextInt();
			
			a = new Empleado(NIF);
			
			a.setNombre(nombre);
			a.setSueldoBase(sueldoBase);
			a.setHorasExtra(horasExtra);
			a.setIRPF(IRPF);
			a.setCasado(casado);
			a.setHijos(hijos);
			
			empleados[i] = a;
			
		}
	}
	
}
