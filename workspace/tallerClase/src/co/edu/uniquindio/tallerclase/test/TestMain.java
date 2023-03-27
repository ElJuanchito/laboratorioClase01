package co.edu.uniquindio.tallerclase.test;

import co.edu.uniquindio.tallerclase.model.CuentaAhorros;

public class TestMain {
	public static void main(String[] args) throws Exception {
		CuentaAhorros cuenta = new CuentaAhorros(150000, 12, "54321");
		cuenta.consignar(10000);
		cuenta.retirar(500);
		cuenta.imprimir();
	}
}
