package com.empresa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the transaccion database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Transaccion.findAll", query="SELECT t FROM Transaccion t"),
	@NamedQuery(name="transacciones.byCuenta", query="SELECT t FROM Transaccion t WHERE t.cuenta.idCuenta =:idCuenta")
})

public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_transaccion")
	private int idTransaccion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="monto_abono")
	private float montoAbono;

	@Column(name="monto_cargo")
	private float montoCargo;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name="id_cuenta")
	private Cuenta cuenta;

	public Transaccion() {
	}

	public int getIdTransaccion() {
		return this.idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getMontoAbono() {
		return this.montoAbono;
	}

	public void setMontoAbono(float montoAbono) {
		this.montoAbono = montoAbono;
	}

	public float getMontoCargo() {
		return this.montoCargo;
	}

	public void setMontoCargo(float montoCargo) {
		this.montoCargo = montoCargo;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}