
public class Videojuego implements Entregable{

	private String titulo;
	private int horasEstimadas;
	private boolean entregado;
	private String genero;
	private String companhia;
	
	private static final int HORAS_ESTIMADAS = 10;
	private static final boolean ENTREGADO = false;
	private static final int MAYOR = 1;
	private static final int MENOR = -1;
	private static final int IGUAL = 0;
	
	public Videojuego() {
		this.titulo = "";
		this.horasEstimadas = HORAS_ESTIMADAS;
		this.entregado = ENTREGADO;
		this.genero = "";
		this.companhia = "";
	}
	
	public Videojuego(String titulo, int horasEstimadas) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.entregado = ENTREGADO;
		this.genero = "";
		this.companhia = "";
	}
	
	public Videojuego(String titulo, int horasEstimadas, String genero, String companhia) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.entregado = ENTREGADO;
		this.genero= genero;
		this.companhia = companhia;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public int getHorasEstimadas() {
		return this.horasEstimadas;
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public String getCompanhia() {
		return this.companhia;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Videojuego\n");
		sb.append("Título: " + getTitulo() + "\n");
		sb.append("Horas estimadas de juego: " + getHorasEstimadas() + "\n");
		sb.append("Género: " + getGenero() + "\n");
		sb.append("Compañia: " + getCompanhia() + "\n");
		return sb.toString();
	}

	@Override
	public void entregar() {
		this.entregado = true;
		
	}

	@Override
	public void devolver() {
		this.entregado = false;
		
	}

	@Override
	public boolean isEntregado() {
		return this.entregado;
	}

	@Override
	public int compareTo(Object a) {
		
		Videojuego ref =(Videojuego)a;
		if(getHorasEstimadas() > ref.getHorasEstimadas()) {
			return MAYOR;
		} else if (getHorasEstimadas() < ref.getHorasEstimadas()) {
			return MENOR;
		} else {
			return IGUAL;
		}
	}


}
