package tema2;
import java.util.Scanner;


public class Main {
	public static int x = 1;
	public static int y = 2;
	public static Scanner scan = new Scanner(System.in);



	public static void ejercicio1() {
		int aux = x;
		x = y;
		y = aux;
		System.out.println(x + " y " + y);
	}
	
	public static int ejercicio2(int a, int b, int c) {
		if(a >= b && a >= c) return a; 
		else if(b >= a && b >= c) return b;
		 else return c;	
	}
	
	public static int ejercicio2a(int a, int b, int c) {
		int max;
		if(a >= b && a >= c) {
			max = a;
		}else if(b >= a && b >= c){
			max = b;
		}else {
			max = c;
		}
		return max;
		}
	

	
		public static int factorial(int x) {
			int fact = 1;
			for( int i = 1; i <= x; i++) {
				fact *= i;
			}
			return fact;
		}
		
		public static double ejercicio3(int acc) {
			double toret = 2;
			if(acc <= 0) return 1;
			double aux;
			for(int i = 2; i <= acc; i++) {
				aux = 1/factorial(i);
				toret += aux;
			}return toret;
		}
		
		public static int ejercicio4(char a) {
			
			String caracter="";
			int cont = 0;
			
			while(!caracter.equals(".")) {
				System.out.println("Se contaran todas las aes que introduzca\nPara salir introduzca un punto (.)\nIntroduzca un caracter: ");
				caracter = scan.next();
				if(caracter.charAt(0) == a) {
					cont++;
					}
			}
			return cont;
		
		} 
		//Ejercicio 5
	
		public static String invertirDigitos(String num) {
			String salida="";
			for(int i = num.length(); i >= 1; i --) {
				salida += num.charAt(i - 1);
			}
			return salida;
		}
		
		public static int invertirDigitos(int num) {
			int salida;
			String aux = String.valueOf(num);
			String aux_salida = "";
			for(int i = aux.length(); i >= 1; i --) {
				aux_salida += aux.charAt(i - 1);
			}
			salida = Integer.parseInt(aux_salida);
			return salida;
		}
		
		public static int invierte(int num) {
			int toret = 0;
			int resto;
			while(num > 0) {
				resto = num%10;
				toret = toret*10 + resto;
				num /=10;
			}
			return toret;
		}
			//Ejercicio 6
		
		public static boolean ejercicio6(int num1, int num2) {
			int sum = 0;
			for(int i = 1; i < num1; i++) {
				if(num1%i == 0) sum += i;
			}
			if (sum != num2) return false;
			sum = 0;
			for(int i = 1; i < num2; i++) {
				if(num2%i == 0) sum += i;
			}
			if(sum != num1)return false;
			else return true;
		}
		
		//ejercicio7
		
		public static boolean perfecto(int num) {
			int cont = 0;
			for(int i = 1; i < num; i++) {
				if(num%i == 0) {
					cont = cont +i ;
				}
			}if( cont == num) return true;
			else return false;
		}
			
		//ejercicio8
		
		public static String user;
		public static String psswrd;
		
		public static void registro() {
			
			
			System.out.println("Introduce el nombre de usuario: ");
			user = scan.nextLine();
			System.out.println("Introduce la contrase�a: ");
			psswrd = scan.nextLine();
			System.out.println("Repita la contrase�a: ");
			if(psswrd.equals(scan.nextLine())) {
				if(login()) System.out.println("Acceso correcto para " + user);
				else System.out.println("Acceso denegado");
			}else {
				System.out.println("La contrase�a no coincide. Programa finalizado.");
			}
		}
		
		public static boolean login() {
			
			System.out.println("Introduzca el nombre de usuario: ");
			if(user.equals(scan.nextLine())){
				System.out.println("Introduzca la contrase�a: ");
				if(psswrd.equals(scan.nextLine())) {
					
				}System.out.println("Usuario registrado");return true;
			}
		
		else System.out.println("Usuario o contrase�a incorrectos");
			return false;
		
			
		}
		//Ejercicio 9
		
		public static String num1cadena;
		public static String num2cadena;
		public static int num1;
		public static int num2;
		
		
		public static void operandos() {
			
			do {
				System.out.println("Introduce el primer operando");
				num1cadena = scan.next();
			}while(num1cadena.length() < 0);
			num1 = Integer.parseInt(num1cadena);
			
			do {
				System.out.println("Introduce el segundo operando");
				num2cadena = scan.next();
			}while(num2cadena.length() < 0);
			num2 = Integer.parseInt(num2cadena);
		}
		
		public static int sumar(int num1, int num2) {
			int suma = 0;
			suma = num1 + num2;
			
			return suma;
		}
		
		public static int restar(int num1, int num2) {
			int resta = 0;
			resta = num1 - num2;
			
			return resta;
		}
		
		public static int dividir(int num1, int num2) {
			int dividir = 0;
			dividir = num1 / num2;
			
			return dividir;
		}
		
		public static int multiplicar( int num1, int num2) {
			int multiplicar = 0;
			multiplicar = num1 * num2;
			
			return multiplicar;
		}
		
		//Ejercicio9 corregido
		
		public static void calculadoraSimple() {
		
			int a, b;
			String op;
			do {
				a = leerOp();
				b = leerOp();
				System.out.println("Seleccione una operaci�n a realizar:\nOperaciones adminitdas (+,...\n Introduzca 0 para salir.");
						op = scan.nextLine();
						switch(op) {
						case "+": System.out.println(a+b);
						break;
						case "-": System.out.println(a-b);
						break;
						case"*": System.out.println(a*b);
						break;
						case"/": System.out.println(a/b);
						if(b==0) {
							System.out.println("No se puede dividir entre 0");
						}
						break;
						case"%":System.out.println(a%b);
						if(b==0) {
							System.out.println("No se puede dividir entre 0");
						}
						break;
						case"0": System.out.println("Fin del programa");
						break;
						default: System.out.println("Operaci�n inv�lida");
			
						}
			}while(!op.equals("-1"));
		}
		
		private static int leerOp() {
			
			boolean isNumeric = false;
			do {
			System.out.println("Puede introducir cualquier digito o n�meros escritos del cero al nueve:");
			String aux = scan.nextLine();
			int toret;
			aux = aux.toLowerCase();
			switch(aux) {
			case "cero": return 0;
			case "uno": return 1;
			case "dos": return 2;
			case "tres": return 3;
			case "cuatro": return 4;
			case "cinco": return 5;
			case "seis": return 6;
			case "siete": return 7;
			case "ocho": return 8;
			case "nueve": return 9;
			
			default:
				//opcion 1 con srt.matches
				if(aux.matches("[+-]?\\d+")){
					toret = Integer.parseInt(aux);
					return toret;
				} else {
					System.out.println("Debe introducir un operando v�lido");
				}
				
			
			}
			
			}while(!isNumeric);
			return 0;
		}
		
		//Ejercicio 10
		 
		public static double radio;
		public static double pi = 3.1416;
		public static double baserec;
		public static double alturarec;
		public static double lado;
		public static double ladotri = 3;
		public static double basetri;
		public static double alturatri;
		
		
		public static void operaciones() {
			
			
			String opcion;
			boolean salir = false;
			
			while(!salir) {
				System.out.println("Selecciona que operaci�n quieres realizar: ");
				System.out.println("Opci�n 1 para calcular el per�metro de una circunferencia.\nOpci�n 2 para calcular el �rea de una circunferencia.");
				System.out.println("Opci�n 3 para calcular el per�metro de un rect�ngulo.\nOpci�n 4 para calcular el �rea de un rect�ngulo.");
				System.out.println("Opci�n 5 para calcular el per�metro de un cuadrado.\nOpci�n 6 para calcular el �rea de un cuadrado.");
				System.out.println("Opci�n 7 para calcular el per�metro de un tri�ngulo.\nOpci�n 8 para calcular el �rea de un tri�ngulo.");
				System.out.println("Opci�n 0 para finalizar el programa.\nIntroduzca su opci�n: ");
				opcion = scan.next();
				
				switch(opcion) {
				case "1":
					System.out.println("Introduzca el radio de la circunferencia:");
					radio = scan.nextDouble();
					
					System.out.println("El per�metro de la circunferencia es: " + perimetroCircunferencia());
					break;
				case "2":
					System.out.println("Introduzca el radio de la esfera:");
					radio = scan.nextDouble();
					
					System.out.println("El �rea de la circunferencia es: " + areaCircunferencia());
					
					break;
				case "3":
					System.out.println("Introduzca la base del rect�ngulo:");
					baserec = scan.nextDouble();
					System.out.println("Introduzca la altura del rect�ngulo:");
					alturarec = scan.nextDouble();
					
					System.out.println("El per�mtetro del rect�ngulo es: " + perimetroRectangulo());
					break;
				case "4":
					System.out.println("Introduzca la base del rect�ngulo:");
					baserec = scan.nextDouble();
					System.out.println("Introduzca la altura del rect�ngulo:");
					alturarec = scan.nextDouble();
					
					System.out.println("El �rea del rect�ngulo es: " + areaRectangulo());
					break;
				case "5":
					System.out.println("Introduzca el lado del cuadrado:");
					lado = scan.nextDouble();
					
					System.out.println("El per�metro del cuadrado es: " + perimetroCuadrado());
					break;
				case "6":
					System.out.println("Introduzca el lado del cuadrado:");
					lado = scan.nextDouble();
					
					System.out.println("El �rea del cuadrado es: " + areaCuadrado());
					break;
				case "7":
					System.out.println("Introduzca el lado del tri�ngulo:");
					ladotri = scan.nextDouble();
					
					System.out.println("El per�metro del tri�ngulo es: "+ perimetroTriangulo());
					break;
				case "8":
					System.out.println("Introduzca la base del tri�ngulo:");
					basetri = scan.nextDouble();
					System.out.println("Introduzca la altura del tri�ngulo:");
					alturatri = scan.nextDouble();
					
					System.out.println("El �rea del tri�ngulo es: "+ areaTriangulo());
					break;
				case "0":
					salir = true;
					System.out.println("Fin del programa.");
					break;
				default:
					System.out.println("Introduzca una opci�n v�lida.");
				}
				
			
			}
			
			
		}
		
		public static double perimetroCircunferencia() {
			double perimetro = 0;
			perimetro = 2 * pi * radio;
			
			return perimetro;
			
			
		}
		
		public static double areaCircunferencia() {
			double area = 0;
			area = pi * radio * radio;
			
			return area;
		}
		
		public static double perimetroRectangulo() {
			double perimetro = 0;
			perimetro = 2 * alturarec + 2 * baserec;
			
			return perimetro;
		}
		
		public static double areaRectangulo() {
			double area = 0;
			area = alturarec * baserec;
			
			return area;
		}
	
		public static double perimetroCuadrado() {
			double perimetro = 0;
			perimetro = lado * 4;
			
			return perimetro;
		}
		
		public static double areaCuadrado() {
			double area = 0 ;
			area = lado * lado;
			
			return area;
		}
		
		public static double perimetroTriangulo() {
			double perimetro = 0;
			perimetro = ladotri * 3;
			
			return perimetro;
		}
		
		public static double areaTriangulo() {
			
			return (ladotri*ladotri*Math.sqrt(3))/2;
		}
		
		
		
	public static void main(String[] args) {
//		ejercicio1(); 
//		System.out.println(ejercicio2(4, 10, 8));
//		System.out.println(ejercicio2a(4, 7, 9));
//		System.out.println(factorial(10));
//		System.out.println(ejercicio3(2));
//		System.out.println(ejercicio4('a'));
//		System.out.println(invertirDigitos("12345"));
//		System.out.println(invertirDigitos(12345));
//		System.out.println(invierte(12345));
//		System.out.println(ejercicio6(220, 284));
//		System.out.println(ejercicio6(432, 765));
//		System.out.println(perfecto(6));
//		registro();
//		login();
//		operandos();
//		System.out.println(sumar(num1, num2));
//		System.out.println(restar(num1, num2));
//		System.out.println(dividir(num1, num2));
//		System.out.println(multiplicar(num1, num2));
//		System.out.println(perimetroCircunferencia());
//		System.out.println(areaCircunferencia());
//		System.out.println(perimetroRectangulo());
//		System.out.println(areaRectangulo());
//		System.out.println(perimetroCuadrado());
//		System.out.println(areaCuadrado());
//		System.out.println(perimetroTriangulo());
//		System.out.println(areaTriangulo());
//		operaciones();
//		calculadoraSimple();
		
		
		
	}

	
		
}


