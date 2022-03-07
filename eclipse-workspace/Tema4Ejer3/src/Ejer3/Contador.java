package Ejer3;

public class Contador {
	private int cont;
	
	public Contador() {
		this.cont = 0;
	}
	
	public Contador(int cont) {
		if(cont < 0) {
			this.cont = 0;
		}else this.cont = cont;
	}
	
	public int getCont() {
		return this.cont;
	}
	
	public void setCont(int cont) {
		if(cont < 0) {
			this.cont = 0;
		}else this.cont = cont;
	}
	
	public void incrementar() {
		setCont(getCont() + 1);
	}
	
	public void decrementar() {
		
		setCont(getCont() - 1);
		if(getCont() < 0) {
			setCont(0);
		}
	}

}
