
public class Fraccion {
	private int num;
	private int den;
	
	
	public Fraccion() {
        this.num = 0;
        this.den = 1;
    }

	
	public Fraccion(int num) {
	    this.num = num;
	    this.den = 1;
	}
	
    public Fraccion(int num, int den) {
        this.num = num;
        if(den==0){
            den = 1;
        }
        this.den = den;
        simplificar();
    }
	
	public int getNum() {
		return this.num;
	}
	
	public int getDen() {
		return this.den;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	 public void setDen(int den) {
	     this.den = den;
	 }
	
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = this.num * f.den + this.den * f.num;
		aux.den = this.den * f.den;
		aux.simplificar();
		return aux;
	}
	
    //restar fracciones
    public Fraccion restar(Fraccion f) { // Este metodo te devuwlve una fraccion
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.den - this.den * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }
   
    //multiplicar fracciones
    public Fraccion multiplicar(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }

    //dividir fracciones
    public Fraccion dividir(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.den;
        aux.den = this.den * f.num;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }
	
	private void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}
	
    private int mcd() {
        int u = Math.abs(num); //valor absoluto del numerador
        int v = Math.abs(den); //valor absoluto del denominador
        if (v == 0) {
            return u;
        }
        int r;
        while (v != 0) {
            r = u % v;
            u = v;
            v = r;
        }
        return u;
    }
    
    public String toString() {
        simplificar();
        return num + "/" + den;
    } 
	
	
	
	
}
