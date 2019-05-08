package com.empresa.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.empresa.dao.PersonaDao;
import com.empresa.entities.Beneficiario;
import com.empresa.entities.Cliente;
import com.empresa.entities.Direccion;
import com.empresa.entities.Persona;
import com.empresa.entities.PersonaGenerica;
import com.empresa.entities.Referencia;
import com.empresa.entities.Telefono;

@ManagedBean
@ViewScoped
public class RegistroMb {
	 private Persona persona;
	 private List<Cliente> cliList;
	 private Cliente cliente;
	 private List<Direccion> listDirCliente;
	 private List<Telefono> telLitCliente;
	 private List<PersonaGenerica> referencias;
	 private List<PersonaGenerica> beneficiario;
	 private List<Referencia> refListRefCliente;
	 private List<Beneficiario> refLitBenCliente;
	 private PersonaDao perDao;
	 
	  @PostConstruct
	  public void init() {
		   			persona = new Persona();
		   			cliList = new ArrayList<Cliente>();
		   			cliente = new Cliente();
		   			listDirCliente = new ArrayList<Direccion>();
		   			telLitCliente = new ArrayList<Telefono>();
		   			refListRefCliente = new ArrayList<Referencia>();
		   			refLitBenCliente = new  ArrayList<Beneficiario>();
		   			referencias = new ArrayList<PersonaGenerica>();
		   			beneficiario = new ArrayList<PersonaGenerica>();
		   			perDao = new PersonaDao();
	  }
	  
	  public void insertCliente() {
		  cliente.setPersona(persona);
		  cliList.add(cliente);
		  persona.setClientes(cliList);
		  for(Direccion dir:listDirCliente) {
			  dir.setPersona(persona);
			  
		  }
		  persona.setDireccions(listDirCliente);
		  for(Telefono tel:telLitCliente) {
			  tel.setPersona(persona);
		  }
		  persona.setTelefonos(telLitCliente);
		  for(PersonaGenerica per: beneficiario){
			  Beneficiario ben = new Beneficiario();
			  ben.setCliente(cliente);
			  ben.setEdad(per.getEdad());
			  ben.setParentesco(per.getParentesco());
			  Persona perBen = new Persona();
			  perBen.setNombre(per.getNombre());
			  perBen.setApellido(per.getApellido());
			  perBen.setNumeroDocumento(per.getNumeroDocumento());
			  Persona perRepuesta = perDao.insertPersona(perBen);
			  ben.setPersona(perRepuesta);
			  ben.setPorcentaje(per.getPorcentaje());
			  refLitBenCliente.add(ben);  
		  }
		  persona.setBeneficiarios(refLitBenCliente);
		  for(PersonaGenerica perGen: referencias) {
			  Referencia ref = new Referencia();
			  ref.setCliente(cliente);
			  Persona perRef = new Persona();
			  perRef.setNombre(perGen.getNombre());
			  perRef.setApellido(perGen.getApellido());
			  perRef.setNumeroDocumento(perGen.getNumeroDocumento());
			  Persona personaRepuesta = perDao.insertPersona(perRef);
			  ref.setPersona(personaRepuesta);
			  ref.setTiempoconocerse(perGen.getTiempoconocerse());
			  refListRefCliente.add(ref);
		  }
		  persona.setReferencias(refListRefCliente);
		 Persona clienteGuardado = perDao.insertPersona(persona);
		  FacesMessage msg = new FacesMessage("Persona Guardada"+clienteGuardado.getIdPersona());
		  FacesContext.getCurrentInstance().addMessage(null, msg);
		  
	  }
	  
	  public void addDireccion() {
		  listDirCliente.add(new Direccion());
	  }
	 
	  public void addTelefonoCliente() {
		  telLitCliente.add(new Telefono());
	  }
	  
	  public void addReferencia() {
		referencias.add(new PersonaGenerica());
	  }

	  
	  public void addBeneficiario() {
		 beneficiario.add(new PersonaGenerica());
	  }
	  
	  public String iraCuentas() {
		  return "cuentas.xhtml";
	  }
	 
	 public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public List<Cliente> getCliLit() {
		return cliList;
	}
	public void setCliLit(List<Cliente> cliLit) {
		this.cliList = cliLit;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Direccion> getListDirCliente() {
		return listDirCliente;
	}
	public void setListDirCliente(List<Direccion> listDirCliente) {
		this.listDirCliente = listDirCliente;
	}
	public List<Telefono> getTelLitCliente() {
		return telLitCliente;
	}
	public void setTelLitCliente(List<Telefono> telLitCliente) {
		this.telLitCliente = telLitCliente;
	}
	public List<Referencia> getRefListRefCliente() {
		return refListRefCliente;
	}
	public void setRefListRefCliente(List<Referencia> refListRefCliente) {
		this.refListRefCliente = refListRefCliente;
	}
	public List<Beneficiario> getRefLitBenCliente() {
		return refLitBenCliente;
	}
	public void setRefLitBenCliente(List<Beneficiario> refLitBenCliente) {
		this.refLitBenCliente = refLitBenCliente;
	}

	public List<PersonaGenerica> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<PersonaGenerica> referencias) {
		this.referencias = referencias;
	}

	public List<PersonaGenerica> getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(List<PersonaGenerica> beneficiario) {
		this.beneficiario = beneficiario;
	}


	 
	 
}
