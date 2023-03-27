package co.edu.uniquindio.tallerclase.model;

public class CuentaAhorros extends CuentaBancaria {

	/**
	 * Constructor de la clase CuentaAhorros, invoca el constructor heredado
	 * @param saldo
	 * @param tasaAnual
	 * @param noCuenta
	 */
	public CuentaAhorros(float saldo, float tasaAnual, String noCuenta) {
		super(saldo, tasaAnual, noCuenta);
	}

	/**
	 * Valida el estado de la cuenta: Si el saldo es menor a $10000, la cuenta
	 * est� inactiva, en caso contrario se considera activa.
	 *
	 * @return
	 */
	private boolean validarEstadoCuenta() {
		return this.saldo > 10000;
	}

	@Override
	/**
	 * Consigna dinero si la cuenta est� activa. Invoca el metodo
	 * consignarValor().
	 *
	 * @param valor
	 * @throws Exception
	 */
	public void consignar(float valor) throws Exception {
		if (!validarEstadoCuenta())
			throw new Exception("La cuenta no esta activa");
		super.consignar(valor);
		numeroConsignaciones++;
	}

	@Override
	/**
	 * Retira dinero si la cuenta est� activa. Invoca el metodo retirarValor().
	 *
	 * @param valor
	 * @throws Exception
	 */
	public void retirar(float valor) throws Exception {
		if (!validarEstadoCuenta())
			throw new Exception("La cuenta no esta activa");
		super.retirar(valor);
		numeroRetiros++;
	}

	/**
	 * Calcula el numero de retiros adicionales. se empieza a contar si es mas
	 * de 4;
	 *
	 * @return
	 */
	private int calcularRetirosAdicionales() {
		if (numeroRetiros > 4)
			return numeroRetiros - 4;
		return 0;
	}

	/**
	 * si el n�mero de retiros es mayor que 4, por cada retiro adicional, se
	 * cobra $1000 como comisi�n mensual. Al generar el extracto, se determina
	 * si la cuenta est� activa o no con el saldo.
	 *
	 * @throws Exception
	 */
	@Override
	public void extractoMensual() throws Exception {

		if (!validarEstadoCuenta())
			throw new Exception("La cuenta no esta activa");

		if (calcularRetirosAdicionales() > 0)
			comisionMensual = 1000;
		saldo -= comisionMensual * calcularRetirosAdicionales();
		calcularInteresMensual();

	}

	/**
	 * muestra en consola el saldo de la cuenta, la comisi�n mensual y el n�mero
	 * de transacciones realizadas (suma de cantidad de consignaciones y
	 * retiros).
	 *
	 */
	@Override
	public void imprimir() {
		System.out.println("Saldo: " + saldo + ", Comision mensual: " + comisionMensual + ", numero de transacciones: "
				+ (numeroConsignaciones + numeroRetiros));
	}
}
