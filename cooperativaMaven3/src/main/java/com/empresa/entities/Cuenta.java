package com.empresa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the cuenta database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
		@NamedQuery(name = "cuentas.byCliente", query = "SELECT c FROM Cuenta c WHERE c.cliente.idCliente =:idCliente") })

public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cuenta")
	private int idCuenta;

	private String numero_cuenta;

	private float saldo;

	private float total_abonos;

	private float total_cargos;

	// bi-directional many-to-one association to Cuentatipo
	@ManyToOne
	@JoinColumn(name = "id_cuentatipo")
	private Cuentatipo cuentatipo;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	// bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy = "cuenta", cascade = CascadeType.PERSIST)
	private List<Transaccion> transaccions;

	public Cuenta() {
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getTotal_abonos() {
		return total_abonos;
	}

	public void setTotal_abonos(float total_abonos) {
		this.total_abonos = total_abonos;
	}

	public float getTotal_cargos() {
		return total_cargos;
	}

	public void setTotal_cargos(float total_cargos) {
		this.total_cargos = total_cargos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cuentatipo getCuentatipo() {
		return this.cuentatipo;
	}

	public void setCuentatipo(Cuentatipo cuentatipo) {
		this.cuentatipo = cuentatipo;
	}

	public List<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(List<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	public Transaccion addTransaccion(Transaccion transaccion) {
		getTransaccions().add(transaccion);
		transaccion.setCuenta(this);

		return transaccion;
	}

	public Transaccion removeTransaccion(Transaccion transaccion) {
		getTransaccions().remove(transaccion);
		transaccion.setCuenta(null);

		return transaccion;
	}

}