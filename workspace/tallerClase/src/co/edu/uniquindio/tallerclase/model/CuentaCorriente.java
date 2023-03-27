package co.edu.uniquindio.tallerclase.model;

public class CuentaCorriente extends CuentaBancaria {

	protected float sobreGiro;

	/**
	 * Constructor de la clase CuentaCorriente, invoca el constructor heredado
	 * @param saldo
	 * @param tasaAnual
	 * @param noCuenta
	 */
	public CuentaCorriente(float saldo, float tasaAnual, String noCuenta) {
		super(saldo, tasaAnual, noCuenta);
		this.sobreGiro = 0;
	}

	public float getSobreGiro() {
		return sobreGiro;
	}

	public void setSobreGiro(float sobreGiro) {
		this.sobreGiro = sobreGiro;
	}

	/**
	 * Retira dinero de la cuenta actualizando su saldo. Se puede retirar dinero
	 * superior al saldo. El dinero que se debe queda como sobregiro.
	 *
	 */
	@Override
	public void retirar(float valor) {
		if (saldo < valor)
			sobreGiro += (valor - saldo);
		saldo -= valor;
	}

	/**
	 * Consigna dinero. Invoca al método CuentaBancaria.Consignar(). Si hay
	 * sobregiro, la cantidad consignada reduce el sobregiro.
	 *
	 */
	@Override
	public void consignar(float valor) throws Exception {
		if (sobreGiro >= valor) {
			sobreGiro -= valor;
			return;
		}
		super.consignar(valor - sobreGiro);
		sobreGiro = 0;
	}

	/**
	 * muestra en consola el saldo de la cuenta, la comisión mensual, el número
	 * de transacciones realizadas (suma de cantidad de consignaciones y
	 * retiros) y el valor de sobregiro.
	 */
	@Override
	public void imprimir() {
		System.out.println("Saldo: " + saldo + ", Comision mensual: " + comisionMensual + ", numero de transacciones: "
				+ (numeroConsignaciones + numeroRetiros) + ", Sobre giro: " + sobreGiro);
	}

}
