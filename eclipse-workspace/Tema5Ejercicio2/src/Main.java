
public class Main {

	public static void main(String[] args) {

		Videojuego listaVideojuego[] = new Videojuego[5];
		listaVideojuego[0] = new Videojuego("Zelda", 200, "Acción y Aventuras","Nintendo");
		listaVideojuego[1] = new Videojuego("Dying Ligth", 80, "Plataformas", "Techland");
		listaVideojuego[2] = new Videojuego("Call of Duty", 100, "Shooter", "Activision");
		listaVideojuego[3] = new Videojuego("Uncharted", 190, "Acción y Aventuras", "Sony");
		listaVideojuego[4] = new Videojuego("Farcry", 300,"Acción", "Ubisoft");
		
		Serie listaSerie[] = new Serie[5];
		listaSerie[0] = new Serie("Shingeki no Kyojin", 4, "Anime", " Hajime Isayama");
		listaSerie[1] = new Serie("Como conocí a vuestra madre", 8, "Comedia", "Uno de ellos");
		listaSerie[2] = new Serie("Juego de tronos", 7, "Ciencia ficción","Un señor con barba");
		listaSerie[3] = new Serie("El juego del calamar", 1, "Ciencia ficción", "Un señor coreano");
		listaSerie[4] = new Serie("Friends", 12, "Comedia", "Alguien");
		
		listaSerie[1].entregar();
		listaSerie[3].entregar();
		listaVideojuego[2].entregar();
		listaVideojuego[4].entregar();
		
		int numEntregados = 0;
		
		for(int i = 0; i < listaVideojuego.length; i++) {
			if(listaVideojuego[i].isEntregado()) {
				numEntregados++;
				listaVideojuego[i].devolver();
				
			}if(listaSerie[i].isEntregado()) {
				numEntregados++;
				listaSerie[i].devolver();
		}
	}
		System.out.println("Hay " + numEntregados + " acticulos entregados");

		Serie mayorTemp = listaSerie[0];
		Videojuego masHoras = listaVideojuego[0];
		
		for(int i = 1; i < listaSerie.length; i++) {
			if(listaSerie[i].compareTo(mayorTemp) == Serie.MAYOR) {
				
			}
		}
		

	}

}
