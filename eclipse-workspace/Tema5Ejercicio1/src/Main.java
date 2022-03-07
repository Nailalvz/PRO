
import java.util.Scanner;


public class Main {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		Electrodomestico listaElec[] = new Electrodomestico[10];
		listaElec[0] = new Electrodomestico(200,"negro","D",20);
		listaElec[1] = new Lavadora(2000,"blanco","A",50,10);
		listaElec[2] = new Television(400, 30);
		listaElec[3] = new Electrodomestico(150,35);
		listaElec[4] = new Lavadora(1500,80);
		listaElec[5] = new Television(300,"azul","E",25,40,true);
		listaElec[6] = new Electrodomestico(350, 50);
		listaElec[7] = new Lavadora(500,"azul","F",40,10);
		listaElec[8] = new Television(270,"gris","B",20,45,false);
		listaElec[9] = new Lavadora(3000, 60);
		

		double sumaElec = 0;
		double sumaTelevision = 0;
		double sumaLavadora = 0;
		
		for(int i = 0; i < listaElec.length;i ++) {
			if(listaElec[i] instanceof Electrodomestico) {
				sumaElec += listaElec[i].precioFinal();
			}
			if(listaElec[i] instanceof Lavadora) {
				sumaLavadora += listaElec[i].precioFinal();
			}
			if(listaElec[i] instanceof Television) {
				sumaTelevision += listaElec[i].precioFinal();
			}
		}
		
		System.out.println("La suma de los precios de los Electrodomesticos es: " + sumaElec);
		System.out.println("La suma de los precios de las Lavadoras es: " + sumaLavadora);
		System.out.println("La suma de los precios de los Televisores es: " + sumaTelevision);
	}

}
