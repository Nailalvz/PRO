package Prueba;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tema3.Main;


class Prueba {
	
	@BeforeEach
	void setUpBeforeClass() {
		System.out.println("empezando");
	}
	

	@Test
	void ejercicio3() {
		int [] paraInvertir = {1, 2, 3, 4};
		int [] actual = Main.ejercicio3(paraInvertir);
		int [] esperado = new int [] {4, 3, 2, 1};
		assertArrayEquals(actual, esperado);
	}
	
	@Test
	void ejercicio5() {
		int [] invertir = {1, 2, 3, 5};
		int actual = Main.ejercicio5(invertir);
		int esperado = 3;
		assertEquals(actual, esperado);
	}
	
	
	@Test 
	void ejer9suma() {
		int [][] matriz1= {{1,2},{3,4}};
		int [][] matriz2 = {{1,2},{3,4}};
		int [][] actual = Main.ejer9Suma(matriz1, matriz2);
		int [][] esperado = new int[][] {{2,4},{6,8}};
		assertArrayEquals(actual, esperado);
	}
	
	@Test
	void anagrama2() {
		String a = "aabc";
		String b = "abbc";
		boolean actual = Main.anagrama2(a, b);
		boolean esperado = false;
		assertEquals(actual, esperado);
	}
	
	@Test
	void TestPalabraCorrecta() {
		String palabra = "Hola";
		assertTrue(Main.palabraCorrecta(palabra));
	}
	
	@Test
	void TestPalabraCorrectaA() {
		String palabra = "Esternocleidomastoideo";
		assertFalse(Main.palabraCorrecta(palabra));
	}
	
	@Test
	void TestFraseCorrecta() {
		String frase = "sajhdgashjdgadhjagd";
		assertTrue(Main.fraseCorrecta(frase));
	}
	
	@Test
	void TestFraseCorrectaA() {
		String frase = "kasjhdajskdhasjkdhsajkhdasjkdhasjkdhajkdhasjkd"
				+ "ajksdhajksdhsajkdhsajkdhasjkdhasjkdhasjkdhajskdhjkhda"
				+ "ajksdhaksjdhasjkdhajksdjkasdkjashdkjhsadhka";
		assertFalse(Main.fraseCorrecta(frase));
	}
	
	
}
