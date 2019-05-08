package com.empresa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cuentatipo database table.
 * 
 */
@Entity
@NamedQuery(name="Cuentatipo.findAll", query="SELECT c FROM Cuentatipo c")
public class Cuentatipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cuentatipo")
	private int idCuentatipo;

	private String nombre;

	//bi-directional many-to-one association to Cuenta
	@OneToMany(mappedBy="cuentatipo",cascade = CascadeType.ALL)
	private List<Cuenta> cuentas;

	public Cuentatipo() {
	}

	public int getIdCuentatipo() {
		return this.idCuentatipo;
	}

	public void setIdCuentatipo(int idCuentatipo) {
		this.idCuentatipo = idCuentatipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta addCuenta(Cuenta cuenta) {
		getCuentas().add(cuenta);
		cuenta.setCuentatipo(this);

		return cuenta;
	}

	public Cuenta removeCuenta(Cuenta cuenta) {
		getCuentas().remove(cuenta);
		cuenta.setCuentatipo(null);

		return cuenta;
	}

}