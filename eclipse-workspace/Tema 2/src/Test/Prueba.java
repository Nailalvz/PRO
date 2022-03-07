package Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import tema2.Main;

public class Prueba { // si el metodo es privado ponemos en esta linea extendes Main y el metodo ponerlo a protected asi hereda de la clase y se puede usar

	@BeforeAll //Antes de todos los test
	void setUpBeforeClass() {
		System.out.println("empezando");
	}
	
	@BeforeEach //Antes de cada test
	void setup() {
		System.out.println("Empezando test");
	}
	
	
	@Test
	void testEjercicio1() {
		int a = Main.x;
		int b = Main.y;
		Main.ejercicio1();
		assertEquals(b, Main.x);
		assertEquals(a, Main.y);
		
	}
	
	@Test
	void testEjercicio2() {
		int mayor = 5;
		int actual = Main.ejercicio2(1, 4, 5);
		assertEquals(mayor, actual);
		
	}
	
	@Test
	void testFactorial() {
		
		double actual = Main.factorial(5);
		double esperado = 120;
		assertEquals(actual, esperado);
	}
	
	@Test
	void testEjercicio3() {
		
		double actual = Main.ejercicio3(2);
		double esperado = Math.E;
		assertEquals(esperado, actual, 0.8);
	}
	
	@Ignore
//	@Disabled
	@Test
	void testEjercicio4() {
		
		int a = Main.ejercicio4('a');
		int esperado = 1;
		assertEquals(esperado, a);
		
	}
	
	@Test
	void testEjercicio5() {
		
		String actual = Main.invertirDigitos("1234");
		String esperado = "4321";
		assertEquals(esperado, actual);
		
	}
	
	@Test
	void testEjercicio5_2() {
		
		int actual = Main.invertirDigitos(1234);
		int esperado = 4321;
		assertEquals(esperado, actual);
	}
	
	@Test
	void testEjercicio5_3() {
		
		int actual = Main.invierte(1234);
		int esperado = 4321;
		assertEquals(esperado, actual);
	}
	
	@Test
	void testEjercicio6() {
		
		boolean actual = Main.ejercicio6(284, 220);
		boolean esperado = true;
		assertEquals(esperado, actual);
	}
	
	//Es el mismo test que el de arriba pero hecho de otra forma
	//Este comprueba que sea verdadero
	@Test
	void testEjercicio6A() {
		int a = 284;
		int b = 220;
		assertTrue(Main.ejercicio6(a, b));
	}
	
	//Este test en igual que el anterior pero está hecho para que compruebe que esos numeros
	//no sean amigos y el esperado es false
	
	@Test
	void testEjercicio6B() {
		int a = 285;
		int b = 220;
		assertFalse(Main.ejercicio6(a, b));
	}
	
	@Test
	void testEjercicio7() {
		
		boolean actual = Main.perfecto(6);
		boolean esperado = true;
		assertEquals(esperado, actual);
	}
	
	//Comprueba que el número no sea perfecto
	@Test
	void testEjercicio7A() {
		
		boolean actual = Main.perfecto(8);
		boolean esperado = false;
		assertEquals(esperado, actual);
	}
	
	@Test
	@Ignore
	void TestLogin() {
		Main.user = "admin";
		Main.psswrd = "1234";
		assertTrue(Main.login());
	}
	

	@Test
	void testEjercicio9Sumar() {
		
		int actual = Main.sumar(1, 2);
		int esperado = 3;
		assertEquals(esperado, actual);
	}
	
	@Test
	void testEjercicio9Restar() {
		
		int actual = Main.restar(4, 2);
		int esperado = 2;
		assertEquals(esperado, actual);
	}
	
	@Test
	void testEjercicio9Dividir() {
		
		int actual = Main.dividir(10, 2);
		int esperado = 5;
		assertEquals(esperado, actual);
	}
	
	@Test
	void testEjercicio9Multiplicar() {
		
		int actual = Main.multiplicar(2, 2);
		int esperado = 4;
		assertEquals(esperado, actual);
	}
	
	@Test
	void testEjercicio10PC() {
		Main.pi =  3.14159265358979;
		Main.radio = 2;
		double actual = Main.perimetroCircunferencia();
		double esperado = 12.566370614359172;
//		System.out.println(actual);
//		System.out.println(esperado);
		assertEquals(esperado, actual, 0.5);
	}
	
	@Test
	void testEjercicio10AC() {
		Main.pi =  3.14159265358979;
		Main.radio = 4;
		double actual = Main.areaCircunferencia();
		double esperado = 50.26548245743669;
//		System.out.println(actual);
//		System.out.println(esperado);
		assertEquals(esperado, actual, 0.5);
	}
	
	@Test
	void testEjercicio10PR() {
		Main.alturarec = 2;
		Main.baserec = 4;
		double actual = Main.perimetroRectangulo();
		double esperado = 12;
//		System.out.println(actual);
//		System.out.println(esperado);
		assertEquals(esperado, actual, 0.5);
	}
	
	@Test
	void testEjercicio10AR() {
		Main.alturarec = 2;
		Main.baserec = 4;
		double actual = Main.areaRectangulo();
		double esperado = 8;
//		System.out.println(actual);
//		System.out.println(esperado);
		assertEquals(esperado, actual);
	}
	
	@Test
	void testEjercicio10PCu() {
		Main.lado = 4;
		double actual = Main.perimetroCuadrado();
		double esperado = 16;
//		System.out.println(actual);
//		System.out.println(esperado);
		assertEquals(esperado, actual);
	}
	
	@Test
	public void testEjercicio10ACu() {
		Main.lado = 4;
		double actual = Main.areaCuadrado();
		double esperado = 16;
//		System.out.println(actual);
//		System.out.println(esperado);
		assertEquals(esperado, actual);
	}
	
	@Test
	void testEjercicio10PT() {
		Main.ladotri = 3;
		double actual = Main.perimetroTriangulo();
		double esperado = 9;
//		System.out.println(actual);
//		System.out.println(esperado);
		assertEquals(esperado, actual);
	}
	
	@Test
	void testEjercicio10AT() {
		Main.ladotri = 3;
		double actual = Main.areaTriangulo();
		double esperado = 7.794228634059947;
//		System.out.println(actual);
//		System.out.println(esperado);
		assertEquals(esperado, actual, 0.5);
	}
	

}
