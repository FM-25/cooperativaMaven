package com.empresa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p"),
	@NamedQuery(name="find.clientes", query="SELECT p FROM Persona p WHERE p.clientes IS NOT EMPTY")
})

public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona")
	private int idPersona;

	private String apellido;

	private String nombre;

	@Column(name="numero_documento")
	private String numeroDocumento;

	//bi-directional many-to-one association to Beneficiario
	@OneToMany(mappedBy="persona",cascade = CascadeType.PERSIST)
	private List<Beneficiario> beneficiarios;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="persona",cascade = CascadeType.PERSIST)
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="persona",cascade = CascadeType.PERSIST)
	private List<Direccion> direccions;

	//bi-directional many-to-one association to Referencia
	@OneToMany(mappedBy="persona",cascade = CascadeType.PERSIST)
	private List<Referencia> referencias;

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="persona",cascade = CascadeType.PERSIST)
	private List<Telefono> telefonos;

	public Persona() {
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public List<Beneficiario> getBeneficiarios() {
		return this.beneficiarios;
	}

	public void setBeneficiarios(List<Beneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public Beneficiario addBeneficiario(Beneficiario beneficiario) {
		getBeneficiarios().add(beneficiario);
		beneficiario.setPersona(this);

		return beneficiario;
	}

	public Beneficiario removeBeneficiario(Beneficiario beneficiario) {
		getBeneficiarios().remove(beneficiario);
		beneficiario.setPersona(null);

		return beneficiario;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setPersona(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setPersona(null);

		return cliente;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setPersona(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setPersona(null);

		return direccion;
	}

	public List<Referencia> getReferencias() {
		return this.referencias;
	}

	public void setReferencias(List<Referencia> referencias) {
		this.referencias = referencias;
	}

	public Referencia addReferencia(Referencia referencia) {
		getReferencias().add(referencia);
		referencia.setPersona(this);

		return referencia;
	}

	public Referencia removeReferencia(Referencia referencia) {
		getReferencias().remove(referencia);
		referencia.setPersona(null);

		return referencia;
	}

	public List<Telefono> getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Telefono addTelefono(Telefono telefono) {
		getTelefonos().add(telefono);
		telefono.setPersona(this);

		return telefono;
	}

	public Telefono removeTelefono(Telefono telefono) {
		getTelefonos().remove(telefono);
		telefono.setPersona(null);

		return telefono;
	}

}