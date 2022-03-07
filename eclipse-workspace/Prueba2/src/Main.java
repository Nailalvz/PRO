
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		// Ejercicio 1
	/*
		float far = 0, cel = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca los grados Farenheit: ");
		far = scan.nextFloat();
		cel = (5f/9f)*(far-32f);
		System.out.println("El resultado en Celsius es: " + cel);
					scan.close();
		 
		*/
		
		
					//Ejercicio 2
		
	
	/*
		float r, v, a;
		float PI = 3.1416f;
					
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca el radio de la esfera:" );
					
		r = scan.nextFloat();
		a = r*r*4*PI;
		v = (4*PI*r*r*r) / 3;
					
		System.out.println("El área de la esfera es: " + a );
		System.out.println("El volumen de la esfera es: " + v);
				scan.close();
			
	*/
		
		
				//Ejercicio 3
	/*
		
		float nota;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca la nota. Debe estar entre 0 y 10.");
		
		
		nota = scan.nextFloat();
		
		if (nota < 5) {System.out.println("Suspenso");
		
		}
		else if (nota < 7) {System.out.println("Aprobado");
		
		}
		else if (nota < 9) {System.out.println("Notable");
		
		}
		else if (nota <= 10) {System.out.println("Sobresaliente");		
		
		}
		
				scan.close();
		
         */
				
				//Ejercicio 3 corregido 29/09
		
		/*
		
				int nota;
				
				Scanner scan = new Scanner(System.in);
				do {
					System.out.println("Introduzca la nota.");
					nota = scan.nextInt();
					if(nota < 0 || nota > 10) {
						System.out.println("Debe estar entre 0 y 10");
					}	  	
				}	while(nota < 0 || nota > 10); 
			
				
				if (nota < 5) {
					System.out.println("Suspenso");
				
				} else if (nota < 7) {
					System.out.println("Aprobado");
				
				} else if (nota < 9) {
					System.out.println("Notable");
				
				} else if (nota <= 10) {
					System.out.println("Sobresaliente");		
				
				}
						scan.close();
				
				*/
		
				//Ejercicio 3 con switch
		/*
		
		int nota;
		boolean notaOK;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Introduzca la nota.");
			nota = scan.nextInt();
				System.out.println("Debe estar entre 0 y 10");
			}	  	
		}	while(nota < 0 || nota > 10); 
		
			switch(nota) {
			case 0:
			case 1: 
			case 2:
			case 3:
			case 4:
				System.out.println("Suspenso");
				break;
			case 5:
				System.out.println("Aprobado");
				break;
			case 6:	
				System.out.println("Bien");
				break;
			case 7:
			case 8:
				System.out.println("Notable");
				break;
			case 9:
			case 10:
				System.out.println("Sobresaliente");
				break;
			Default:
				System.out.println("Debe estar entre 0 y 10");
				notaOK = false;
				
				
			}
			*/
		
			char vocal = 'a';
			char vocal2 = 'e';
			char vocal3 = 'i';
			char vocal4 = 'o';
			char vocal5 = 'u';
			
			
		
		
		
		
		
		
	 }
 }

