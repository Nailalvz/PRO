import java.util.Scanner;


public class Fecha {

	private int dia;
	private int mes;
	private int año;
	static Scanner scan = new Scanner(System.in);
	
	public Fecha() {
		this.dia = 01;
		this.mes = 01;
		this.año = 1970;
	}
	
	public Fecha(int dia, int mes, int año) {
		this.dia = dia;
		this.mes = mes;
		this.año = año;
	}
	
	public int getDia() {
		return this.dia;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	public int getAño() {
		return this.año;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public void setAño(int año) {
		this.año = año;
	}
	
	private boolean añoBisiesto(int año) {
		
		if(año%4 == 0 && año%100 != 0 || año%400 == 0) {
			return true;
		}else {
			return false;

		}
	}
	
	public boolean fechaCorrecta() {
		
		boolean mesCorrecto, añoCorrecto;
		boolean diaCorrecto = false;
		añoCorrecto = año > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		switch(mes) {
		
			case 1, 3, 5, 7, 8, 10, 12:
				if(dia <= 31 && dia >= 1) {
					diaCorrecto = true;
				}else diaCorrecto = false;
			break;
			
			case 2:
				if(añoBisiesto(año)) {
					if(dia <= 29 && dia >=1) {
						diaCorrecto = true;
					}
				}else if(dia <= 28 && dia >=1) {
					diaCorrecto = true;
				}else diaCorrecto = false;
				
			break;
			
			case 4, 6, 9, 11:
				if(dia <= 30 && dia >= 1) {
					diaCorrecto = true;
				}else diaCorrecto = false;
			
			break;
			
			default: {
				diaCorrecto = false;
			break;
			}
			
		}
		
		return diaCorrecto && mesCorrecto && añoCorrecto;
	}
	
	public void diaSiguiente() {
		if(getMes() == 2) {
			if(añoBisiesto(año)) {
				if(getDia() == 28) {
					setDia(dia + 1);
				}else if(dia == 29) {
					setDia(01);
					setMes(mes + 1);
				}else setDia(dia +1);
			}else if(dia == 28) {
				setDia(01);
				setMes(mes + 1);
			}else setDia(dia + 1);
			
		}else if(getMes() ==  1 || getMes() == 3 || getMes() == 5 || getMes() == 7 || getMes() == 8 || getMes() == 10) {
			if(getDia() == 31) {
				setDia(01);
				setMes(mes + 1);
			}else setDia(dia + 1);
			
		}else if (getMes() == 12) {
			if(getDia() == 31) {
				setDia(01);
				setMes(01);
				setAño(año + 1);
			}else setDia(dia + 1);
			
		}else if(getMes() == 4 || getMes() == 6 || getMes() == 9 || getMes() == 11) {
			if(getDia() == 30) {
				setDia(01);
				setMes(mes + 1);
			}else setDia(dia + 1);
		}
		
	}
	
	public String toString() {
		return getDia() + "-" + getMes() + "-" + getAño();
	}
	
	
	public boolean esMayorQue(Fecha f) {
		
		if(año > f.año) {
			return true;
		} else if( año == f.año && mes > f.mes) {
			return true;
		}else if (año == f.año && mes == f.mes && dia > dia ) {
			return true;
		}
		return false;
		
	}
}
