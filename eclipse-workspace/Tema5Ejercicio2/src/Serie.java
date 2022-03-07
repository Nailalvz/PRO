
public class Serie implements Entregable {

	private String titulo;
	private int numTemporadas;
	private boolean entregado;
	private String genero;
	private String creador;
	
	private static final int NUM_TEMPORADAS = 3;
	private static final boolean ENTREGADO = false;
	private static final int MAYOR = 1;
	private static final int MENOR = -1;
	private static final int IGUAL = 0;
	
	public Serie() {
		this.titulo = "";
		this.numTemporadas = NUM_TEMPORADAS;
		this.entregado = ENTREGADO;
		this.genero = "";
		this.creador = "";
	}
	
	public Serie(String titulo, String creador) {
		this.titulo = titulo;
		this.numTemporadas = NUM_TEMPORADAS;
		this.entregado = ENTREGADO;
		this.genero = "";
		this.creador = creador;
	}
	
	public Serie(String titulo, int numTemporadas, String genero, String creador) {
		this.titulo = titulo;
		this.numTemporadas = numTemporadas;
		this.entregado = ENTREGADO;
		this.genero = genero;
		this.creador = creador;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public int getNumTemporadas() {
		return this.numTemporadas;
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public String getCreador() {
		return this.creador;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setNumTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setCreador(String creador) {
		this.creador = creador;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Series\n");
		sb.append("Título: " + getTitulo() + "\n");
		sb.append("Temporadas: " + getNumTemporadas() + "\n");
		sb.append("Género: " + getGenero() + "\n");
		sb.append("Creador: " + getCreador() + "\n");
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
		
		Serie ref=(Serie)a;
		if(getNumTemporadas() > ref.getNumTemporadas()) {
			return MAYOR;
		} else if(getNumTemporadas() < ref.getNumTemporadas()) {
			return MENOR;
		} else {
			return IGUAL;
		}
	}
}
