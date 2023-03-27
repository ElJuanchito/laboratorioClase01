package co.edu.uniquindio.tallerclase.model;

public abstract class CuentaBancaria {
	protected float saldo;
	protected String noCuenta;
	protected int numeroConsignaciones;
	protected int numeroRetiros;
	protected float tasaAnual;
	protected float comisionMensual;

	public CuentaBancaria() {

	}

	/**
	 * este es el metodo constructor de cuentaBancaria: inicializa los atributos
	 * saldo, tasa anual y numero de cuenta con valores pasados como parámetros.
	 *
	 * @param saldo
	 * @param tasaAnual
	 * @param noCuenta
	 */
	public CuentaBancaria(float saldo, float tasaAnual, String noCuenta) {
		this.saldo = saldo;
		this.tasaAnual = tasaAnual;
		this.numeroConsignaciones = 0;
		this.numeroRetiros = 0;
		this.comisionMensual = 0;
		this.noCuenta = noCuenta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getNumeroConsignaciones() {
		return numeroConsignaciones;
	}

	public void setNumeroConsignaciones(int numeroConsignaciones) {
		this.numeroConsignaciones = numeroConsignaciones;
	}

	public int getNumeroRetiros() {
		return numeroRetiros;
	}

	public void setNumeroRetiros(int numeroRetiros) {
		this.numeroRetiros = numeroRetiros;
	}

	public float getTasaAnual() {
		return tasaAnual;
	}

	public void setTasaAnual(float tasaAnual) {
		this.tasaAnual = tasaAnual;
	}

	public float getComisionMensual() {
		return comisionMensual;
	}

	public void setComisionMensual(float comisionMensual) {
		this.comisionMensual = comisionMensual;
	}



	public String getNoCuenta() {
		return noCuenta;
	}

	public void setNoCuenta(String noCuenta) {
		this.noCuenta = noCuenta;
	}

	/**
	 * Consigna una cantidad de dinero en la cuenta actualizando su saldo.
	 *
	 * @param valor
	 * @throws Exception
	 */
	public void consignar(float valor) throws Exception {
		this.saldo += valor;
	}

	/**
	 * Retirar una cantidad de dinero en la cuenta actualizando su saldo. El
	 * valor a retirar no debe superar el saldo.
	 *
	 * @param valor
	 * @throws Exception
	 */
	public void retirar(float valor) throws Exception {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return;
		}
		throw new Exception("Error al retirar, el valor supera el saldo en cuenta");
	}

	/**
	 * Calcular el interés mensual de la cuenta y actualiza el saldo
	 * correspondiente.
	 */
	protected void calcularInteresMensual() {
		saldo += (float) ((saldo) * (0.10) * (1 / 12));
	}

	/**
	 * Actualiza el saldo restándole la comisión mensual y calculando el interés
	 * mensual correspondiente (invoca el metodo calcularInteresMensual() ).
	 *
	 * @throws Exception
	 */
	public void extractoMensual() throws Exception {
		saldo -= comisionMensual;
		calcularInteresMensual();
	}

	@Override
	public String toString() {
		return "CuentaBancaria [saldo=" + saldo + ", numeroConsignaciones=" + numeroConsignaciones + ", numeroRetiros="
				+ numeroRetiros + ", tasaAnual=" + tasaAnual + ", comisionMensual=" + comisionMensual + "]";
	}

	/**
	 * muestra en consola los valores de los atributos.
	 *
	 */
	public abstract void imprimir();
}
