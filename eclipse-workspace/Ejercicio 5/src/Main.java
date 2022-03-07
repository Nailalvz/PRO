import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
				
	Scanner scan = new Scanner(System.in);
	
	 int num1;
	 int num2;
	 String chr = "";
	
	 System.out.println("Introduzca el primer número");
	 	num1 = scan.nextInt();
	 System.out.println("Introduzca el segundo número");
	 	num2 = scan.nextInt();
	 System.out.println("Introduzca el signo de la operación a realizar");
	 	chr = scan.next();
	 	
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
	 				
	 	}
	
	 	 scan.close();
	
	
	
	
	
	

	}

}
