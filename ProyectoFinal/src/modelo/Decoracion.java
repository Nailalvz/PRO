package modelo;

public class Decoracion extends Articulo{
	private String tipo;
	private String color;
	private Coleccion coleccion;

	
	public Decoracion(int codigo, int stock, double precio, String tipo, String color, Coleccion coleccion) {
		super(codigo, stock, precio);
		this.tipo = tipo;
		this.color = color;
		this.coleccion = coleccion;
	}

	public Decoracion(int codigo, int stock, double precio) {
		super(codigo, stock, precio);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Coleccion getColeccion() {
		return coleccion;
	}

	public void setColeccion(Coleccion coleccion) {
		this.coleccion = coleccion;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Codigo: " + getCodigo() + "\n");
		sb.append("Tipo: " + getTipo() + "\n");
		sb.append("Color: " + getColor() + "\n");
		sb.append(getColeccion());
		sb.append("Stock: " + getStock() + "\n");
		sb.append("Precio: " + getPrecio() + "\n");
		return sb.toString();
	}
	
	
	
	
}
