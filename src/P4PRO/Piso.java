package P4PRO;

public class Piso {
	
	private int id;
	private Direccion direccion;
	private double metrosCuadrados;
	private int precioAlquiler;
	private int precioVenta;
	private boolean alquiler;
	private boolean venta;
	
	
	//Constructor vacío
	public Piso() {
		this.id = 0;
		this.setDireccion(direccion);
		this.metrosCuadrados = 0;
		this.precioAlquiler = 0;
		this.precioVenta = 0;
		this.alquiler = false;
		this.venta = false;
	}
	
	//Constructor al que le llegan los parámetros
	public Piso(int id, Direccion direccion, double metrosCuadrados, int precioAlquiler, int precioVenta, boolean alquiler, boolean venta) {
		this.id = id;
		this.direccion = direccion;
		this.metrosCuadrados = metrosCuadrados;
		this.precioAlquiler = precioAlquiler;
		this.precioVenta = precioVenta;
		this.alquiler = alquiler;
		this.venta = venta;
	}
	
	
	public int getID() {
		return this.id;
	}
	
	public Direccion getDireccion() {
		return this.direccion;
	}
	
	public double getMetrosCuadrados() {
		return this.metrosCuadrados;
	}
	
	public int getPrecioAlquiler() {
		return this.precioAlquiler;
	}
	
	public int getPrecioVenta() {
		return this.precioVenta;
	}
	
	public boolean getAlquiler() {
		return this.alquiler;
	}
	
	public boolean getVenta() {
		return this.venta;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public void setMetrosCuadrados(double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}
	
	public void setPrecioAlquiler(int precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	
	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	public void setAlquiler(boolean alquiler) {
		this.alquiler = alquiler;
	}
	
	public void setVenta(boolean venta) {
		this.venta = venta;
	}
	
	//Constructor para copiar los datos de un Piso a otro
	public Piso(Piso piso) {
		this.id = piso.getID();
		this.direccion = piso.getDireccion();
		this.metrosCuadrados = piso.getMetrosCuadrados();
		this.precioAlquiler = piso.getPrecioAlquiler();
		this.precioVenta = piso.getPrecioVenta();
		this.alquiler = piso.getAlquiler();
		this.venta = piso.getVenta();
	}
	
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(getVenta() && getAlquiler()) {
			sb.append("El piso con id: ");
			sb.append(getID());
			sb.append("\n");
			sb.append("\tcon dirección en: ");
			sb.append(getDireccion());
			sb.append("\n");
			sb.append("\tTiene ");
			sb.append(getMetrosCuadrados());
			sb.append(" metros cuadrados");
			sb.append("\n");
			sb.append("\tEl precio de alquiler es ");
			sb.append(getPrecioAlquiler());
			sb.append(" euros");
			sb.append("\n");
			sb.append("\tEl precio de venta es ");
			sb.append(getPrecioVenta());
			sb.append(" euros");
		} else if(getAlquiler()) {
			sb.append("El piso con id: ");
			sb.append(getID());
			sb.append("\n");
			sb.append("\tcon dirección en: ");
			sb.append(getDireccion());
			sb.append("\n");
			sb.append("\tTiene ");
			sb.append(getMetrosCuadrados());
			sb.append(" metros cuadrados");
			sb.append("\n");
			sb.append("\tEl precio de alquiler es ");
			sb.append(getPrecioAlquiler());
			sb.append(" euros");
		} else {
			sb.append("El piso con id: ");
			sb.append(getID());
			sb.append("\n");
			sb.append("\tcon dirección en: ");
			sb.append(getDireccion());
			sb.append("\n");
			sb.append("\tTiene ");
			sb.append(getMetrosCuadrados());
			sb.append(" metros cuadrados");
			sb.append("\n");
			sb.append("\tEl precio de venta es ");
			sb.append(getPrecioVenta());
			sb.append(" euros");
		}
		
		return sb.toString();
	}
	

}
