package TestP4PRO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import P4PRO.Agencia;
import P4PRO.Direccion;
import P4PRO.Main;
import P4PRO.Piso;

class AgenciaTest {
	
	private static ArrayList<Piso> ListaPisos;
	private static Agencia Agencia1;
	static	Direccion A1 = new Direccion(0, "de Castelao", 83, 3, "D", 36209, "pontevedra");
	static	Piso A = new Piso(0, A1, 75, 500, 0, true, false);
		
	static	Direccion B1 = new Direccion(2, "de Malasaña", 32, 5, "A", 28004, "madrid");
	static	Piso B = new Piso(1, B1, 120, 650, 0, true, false);
		
	static	Direccion C1 = new Direccion(3, "Real", 10, 4, "B", 36216, "pontevedra");
	static	Piso C = new Piso(2, C1, 100, 575, 0, true, false);
		
	static	Direccion D1 = new Direccion(5, "de Andalucía", 3, 10, "C", 29601, "malaga");
	static	Piso D = new Piso(3, D1, 150, 1000, 750000, true, true);

	@BeforeAll
	 static void setUpBeforeClass() {
		System.out.println("empezando");
		ListaPisos = new ArrayList<Piso>();
		ListaPisos.add(A);
		ListaPisos.add(B);
		ListaPisos.add(D);
		ListaPisos.add(C);
		Agencia1 = new Agencia("FotoPisos", ListaPisos);
		Main.main(null);
	}
	
	
	@Test
	void IDCorrecto() {
		int id = 0;
		boolean esperado = Agencia.IDCorrecto(id);
		assertTrue(esperado);
	}
	
	@Test
	void codigoPostalCorrecto() {
		int num = 32453;
		boolean actual = Agencia.codigoPostalCorrecto(num);
		assertTrue(actual);
	}
	
	@Test
	void LetraCorrecta() {
		String letra = "A";
		boolean actual = Agencia.LetraCorrecta(letra);
		assertTrue(actual);
	}
	
	@Test
	void ProvinciaCorrecta() {
		String provincia = "las Palmas";
		boolean actual = Agencia.ProvinciaCorrecta(provincia);
		assertTrue(actual);
	}
	

	@Test
	void MetrosCuadrados() {
		double a = 50.0;
		double b = 300.0;
		boolean actual = Main.Agencia1.MetrosCorrectos(a, b);
		assertTrue(actual);
	}
	
	@Test
	void PreciosCorrectos(){
		int a = 100;
		int b = 10000;
		boolean actual = Agencia.PreciosCorrectosAlquiler(a, b);
		assertTrue(actual);
		
		
	}


}
