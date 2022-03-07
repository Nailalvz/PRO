package tema4;

public class Libro {
	
	private String isbn;
	private String titulo;
	private String autor;
	private int num_pag;
	
	
	//Constructor por defecto
	public Libro() {
		this.isbn = "";
		this.titulo = "";
		this.autor = "";
		this.num_pag = 0;
	}
	
	
	//Constructor que define el valor por los parametros
	public Libro (String isbn, String titulo, String autor, int num_pag) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.num_pag = num_pag;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public int getNum_pag() {
		return this.num_pag;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void setNum_pag(int num_pag) {
		this.num_pag = num_pag;
	}
	
	public String toString() {
		return "El libro con ISBN " + getIsbn() + " creado por el autor " + getAutor() + " tiene " + getNum_pag() + " páginas";	
	}
	
	//Constructor para copiar los datos de un libro a otro
	
	public Libro (Libro libro) {
		this.isbn = libro.getIsbn();
		this.titulo = libro.getTitulo();
		this.autor = libro.getAutor();
		this.num_pag = libro.getNum_pag();
	}
	
	
}













