import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		 int num1;
		 int num2;
		 String chr = "";
		 boolean opOK = false;
		 while(!chr.equals("0")) {
		 System.out.println("Introduzca el primer n�mero");
		 	num1 = scan.nextInt();
		 System.out.println("Introduzca el segundo n�mero");
		 	num2 = scan.nextInt();
		 	scan.nextLine();
		 	while (!opOK) {
		 System.out.println("Introduzca el signo de la operaci�n a realizar");
		 	chr = scan.nextLine();
		 	opOK= true;
		 	switch(chr){
		 		case "+":
		 			System.out.println("Resultado: " + (num1+num2));
		 		break;
		 		case "-":
		 			System.out.println("Resultado: " + (num1-num2));
		 		break;
		 		case "*":
		 			System.out.println("Resultado: " + (num1*num2));
		 		break;
		 		case "/": 
		 			System.out.println("Resultado: " + (num1/num2));
		 		break;
		 		case "%": 
		 			System.out.println("Resultado: " + (num1%num2));
		 		break;
		 		default: System.out.println("Operador inv�lido"); opOK = false;
		 		
		 		}
		 	}
		 } 
		 scan.close();
	}

}
