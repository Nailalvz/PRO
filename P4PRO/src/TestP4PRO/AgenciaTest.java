package TestP4PRO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import P4PRO.Agencia;
import P4PRO.Direccion;
import P4PRO.Piso;

class AgenciaTest {
	
	private static ArrayList<Piso> listaPisos;
	private static Agencia agencia1;
	static Direccion a1 = new Direccion(0, "de Castelao", 83, 3, "D", 36209, "pontevedra");
	static Piso a = new Piso(0, a1, 75, 500, 0, true, false);
	
	static Direccion b1 = new Direccion(2, "de Malasaña", 32, 5, "A", 28004, "madrid");
	static Piso b = new Piso(1, b1, 120, 650, 0, true, false);
	
	static Direccion c1 = new Direccion(3, "Real", 10, 4, "B", 36216, "pontevedra");
	static Piso c = new Piso(2, c1, 100, 575, 0, true, false);
	
	static Direccion d1 = new Direccion(5, "de Andalucía", 3, 10, "C", 29601, "malaga");
	static Piso d = new Piso(3, d1, 150, 1000, 750000, true, true);
	
	static Direccion e1 = new Direccion(0, "de Galicia", 12, 2, "F", 49024, "zamora");
	static Piso e = new Piso(4, e1, 70, 460, 450000, true, true);
	
	static Direccion f1 = new Direccion(6, "Rosalía de Castro", 45, 7, "B", 36201, "pontevedra");
	static Piso f = new Piso(5 ,f1, 110, 0, 875000, false, true);
	
	static Direccion g1 = new Direccion(2, "de Praga", 55, 6, "D", 87690, "barcelona");
	static Piso g = new Piso(6, g1, 55, 0, 313000, false, true);
	
	static Direccion h1 = new Direccion(7, "Los Pinos", 87, 20, "A", 33006, "asturias");
	static Piso h = new Piso(7, h1, 250, 0, 1200000, false, true);
	
	static Direccion i1 = new Direccion(2, "de San Bartolomé", 30, 1, "A", 38900, "sevilla");
	static Piso i = new Piso(8, i1, 35, 0, 130000, false, true);
	
	static Direccion j1 = new Direccion(1, "El Madrigal", 25, 22, "B", 32911, "ourense");
	static Piso j = new Piso(9, j1, 220, 0, 950000, false, true);

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		listaPisos = new ArrayList<Piso>();
		listaPisos.add(a);
		listaPisos.add(b);
		listaPisos.add(c);
		listaPisos.add(d);
		listaPisos.add(e);
		listaPisos.add(f);
		listaPisos.add(g);
		listaPisos.add(h);
		listaPisos.add(i);
		listaPisos.add(j);
		agencia1 = new Agencia("FotoPisos", listaPisos);
	}

	@Test
	void testIDCorrecto() {
		int id = 0;
		boolean esperado = agencia1.idCorrecto(id);
		assertTrue(esperado);
	}
	
	@Test
	void codigoPostalCorrecto() {
		int num = 36204;
		boolean esperado = agencia1.codigoPostalCorrecto(num);
		assertTrue(esperado);
	}
	
	@Test
	void letraCorrecta() {
		String letra = "a";
		boolean esperado = agencia1.letraCorrecta(letra);
		assertTrue(esperado);
	}
	
	@Test
	void provinciaCorrecta() {
		String provincia = "Madrid";
		boolean esperado = agencia1.provinciaCorrecta(provincia);
		assertTrue(esperado);
	}
	
	@Test
	void metrosCorrectos() {
		double a = 50;
		double b = 200;
		boolean esperado = agencia1.metrosCorrectos(a, b);
		assertTrue(esperado);
	}
	
	@Test
	void preciosAlquiler() {
		int a = 200;
		int b = 1000;
		boolean esperado = agencia1.preciosCorrectosAlquiler(a, b);
		assertTrue(esperado);
	}
	
	@Test
	void preciosVenta() {
		int a = 20000;
		int b = 900000;
		boolean esperado = agencia1.preciosCorrectosVenta(a, b);
		assertTrue(esperado);
	}
	
}
