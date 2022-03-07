package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ejer3.Contador;
import Ejer3.Main;

class Prueba {


	@Test
	void incrementar() {
		Contador actual = new Contador(0);
		actual.incrementar();
		Contador esperado = new Contador(1);
		assertEquals (esperado, actual);
	}

}
