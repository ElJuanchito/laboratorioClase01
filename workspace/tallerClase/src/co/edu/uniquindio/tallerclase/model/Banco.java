package co.edu.uniquindio.tallerclase.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nombre;
	private String direccion;
	private List<CuentaBancaria> listaCuentas;

	/**
	 * Constructor de la clase Banco.
	 *
	 * @param nombre
	 * @param direccion
	 */
	public Banco(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaCuentas = new ArrayList<CuentaBancaria>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<CuentaBancaria> getListaCuentas() {
		return listaCuentas;
	}

	public void setListaCuentas(List<CuentaBancaria> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}

	/**
	 * Valida si la cuenta existe en la lista con base a el numero de cuenta;
	 * @param noCuenta
	 * @return
	 */
	private boolean validarCuenta(String noCuenta){
		return listaCuentas.stream().anyMatch(cuenta -> cuenta.getNoCuenta().equals(noCuenta));
	}

	/**
	 * Crea y añade una cuenta a las lista del banco. invoca el metodo validarCuenta()
	 * @param saldo
	 * @param tasaAnual
	 * @param noCuenta
	 * @param tipo
	 * @throws Exception
	 */
	public void crearCuenta(float saldo, float tasaAnual, String noCuenta, TipoCuenta tipo) throws Exception{
		if(validarCuenta(noCuenta)) throw new Exception("La cuenta ya existe");

		if(tipo == TipoCuenta.CORRIENTE) listaCuentas.add(new CuentaCorriente(saldo, tasaAnual, noCuenta));
		if(tipo == TipoCuenta.AHORROS) listaCuentas.add(new CuentaAhorros(saldo, tasaAnual, noCuenta));
	}

	/**
	 * Elimina una cuenta de la lista del banco. invoca el metodo validarCuenta()
	 * @param noCuenta
	 * @throws Exception
	 */
	public void eliminarCuenta(String noCuenta) throws Exception{
		if(!validarCuenta(noCuenta)) throw new Exception("La cuenta no existe");

		CuentaBancaria cBorrar = listaCuentas.stream().filter(cuenta -> cuenta.noCuenta.equals(noCuenta)).findFirst().get();
		listaCuentas.remove(cBorrar);
	}

	/**
	 * Consigna dinero a una cuenta con base a su numero de Cuenta
	 *
	 * @param noCuenta
	 * @param valor
	 * @throws Exception
	 */
	public void consignar(String noCuenta, float valor) throws Exception {
		if(!validarCuenta(noCuenta)) throw new Exception("La cuenta no exite");
		for (CuentaBancaria cuenta : listaCuentas) {
			if (cuenta.getNoCuenta().equals(noCuenta))
				cuenta.consignar(valor);
		}
	}

	/**
	 * Retira dinero a una cuenta con base a su numero de Cuenta
	 * @param noCuenta
	 * @param valor
	 * @throws Exception
	 */
	public void retirar(String noCuenta, float valor) throws Exception {
		if(!validarCuenta(noCuenta)) throw new Exception("La cuenta no exite");
		for (CuentaBancaria cuenta : listaCuentas) {
			if (cuenta.getNoCuenta().equals(noCuenta))
				cuenta.retirar(valor);
		}
	}

	/**
	 * Realiza el extracto mensual de una cuenta
	 * @param noCuenta
	 * @throws Exception
	 */
	public void extractoMensual(String noCuenta) throws Exception {
		if(!validarCuenta(noCuenta)) throw new Exception("La cuenta no exite");
		for (CuentaBancaria cuenta : listaCuentas) {
			if (cuenta.getNoCuenta().equals(noCuenta))
				cuenta.extractoMensual();
		}
	}

	/**
	 * Imprime por consola los datos de una cuenta segun su tipo
	 * @param noCuenta
	 * @throws Exception
	 */
	public void imprimir(String noCuenta) throws Exception {
		if(!validarCuenta(noCuenta)) throw new Exception("La cuenta no exite");
		for (CuentaBancaria cuenta : listaCuentas) {
			if (cuenta.getNoCuenta().equals(noCuenta))
				cuenta.imprimir();
		}
	}
}
