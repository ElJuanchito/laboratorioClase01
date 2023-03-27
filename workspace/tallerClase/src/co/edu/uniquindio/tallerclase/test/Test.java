package co.edu.uniquindio.tallerclase.test;

import static org.junit.Assert.*;

import co.edu.uniquindio.tallerclase.model.CuentaAhorros;
import co.edu.uniquindio.tallerclase.model.CuentaCorriente;

public class Test {

	@org.junit.Test
	public void testEqual() {

		// fail("Los objetos no son iguales");

		CuentaAhorros cuenta1 = new CuentaAhorros(100, 1, "12345");
		CuentaAhorros cuenta2 = new CuentaAhorros(200, 24, "12345");

		assertEquals(cuenta1, cuenta2);

	}

	@org.junit.Test
	public void testEqual2() {

		// fail("Los objetos no son iguales");

		CuentaCorriente cuenta1 = new CuentaCorriente(100, 1, "12345");
		CuentaCorriente cuenta2 = new CuentaCorriente(200, 24, "12345");

		assertEquals(cuenta1, cuenta2);
	}

	@org.junit.Test
	public void testNoEquals() {

		// fail("Los objetos no son iguales");

		CuentaAhorros cuenta1 = new CuentaAhorros(100, 1, "12345");
		CuentaAhorros cuenta2 = new CuentaAhorros(200, 24, "12345");

		assertNotEquals(cuenta1, cuenta2);
	}

	@org.junit.Test
	public void testNoEquals2() {

		// fail("Los objetos no son iguales");

		CuentaCorriente cuenta1 = new CuentaCorriente(100, 1, "12345");
		CuentaCorriente cuenta2 = new CuentaCorriente(200, 24, "12345");

		assertNotEquals(cuenta1, cuenta2);

	}
}
