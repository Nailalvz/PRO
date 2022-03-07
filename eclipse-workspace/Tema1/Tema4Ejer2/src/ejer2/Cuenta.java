package ejer2;

public class Cuenta {

	private String cliente;
	private String num_cuenta;
	private double interes;
	private double saldo;
	
	public Cuenta() {
		this.cliente = "";
		this.num_cuenta = "";
		this.interes = 0.0;
		this.saldo = 0.0;
	}
	
	public Cuenta(String cliente, String num_cuenta, double interes, double saldo) {
		this.cliente = cliente;
		this.num_cuenta = num_cuenta;
		this.interes = interes;
		this.saldo = saldo;
	}
	
	public Cuenta (Cuenta cuenta) {
		this.cliente = cuenta.getCliente();
		this.num_cuenta = cuenta.getNum_cuenta();
		this.interes = cuenta.getInteres();
		this.saldo = cuenta.getSaldo();
	}
	
	public String getCliente() {
		return this.cliente;
	}
	
	public String getNum_cuenta() {
		return this.num_cuenta;
	}
	
	public double getInteres() {
		return this.interes;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public void setNum_cuenta(String num_cuenta) {
		this.num_cuenta = num_cuenta;
	}
	
	public void setInteres(double interes) {
		this.interes = interes;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public boolean ingreso(double n) {
		boolean ingresoCorrecto = true;
		if(n < 0) {
			ingresoCorrecto = false;
		} else {
			setSaldo(getSaldo() + n);
		}
		
		return ingresoCorrecto;
		
	}
	
	public boolean reintegro(double n) {
		boolean reintegroCorrecto = true;
		if(n < 0 || n > getSaldo()) {
			reintegroCorrecto = false;
		} else {
			setSaldo(getSaldo() - n);
		}
		return reintegroCorrecto;
	}
	
	public boolean transferencia(Cuenta a, double n) {
		boolean transferencia = true;
		if(n < 0 || n >= getSaldo()) {
			transferencia = false;
		} else {
			setSaldo(getSaldo() - n);
			a.setSaldo(a.getSaldo() + n);
		}
	
		return transferencia;
	}
	
}
