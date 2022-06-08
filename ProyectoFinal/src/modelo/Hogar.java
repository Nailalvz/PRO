package modelo;

public class Hogar extends Articulo{

	private String tipo;
	private String color;
	private String estancia;
	
	public Hogar(int codigo, int stock, double precio, String tipo, String color, String estancia) {
		super(codigo, stock, precio);
		this.tipo = tipo;
		this.color = color;
		this.estancia = estancia;
	}
	
	public Hogar(int codigo, int stock, double precio) {
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

	public String getEstancia() {
		return estancia;
	}

	public void setEstancia(String estancia) {
		this.estancia = estancia;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Codigo: " + getCodigo() + "\n");
		sb.append("Tipo: " + getTipo() + "\n");
		sb.append("Color: " + getColor() + "\n");
		sb.append("Estancia: " + getEstancia() + "\n");
		sb.append("Stock: " + getStock() + "\n");
		sb.append("Precio: " + getPrecio() + "\n");
		
		return sb.toString();
	}
		
}
