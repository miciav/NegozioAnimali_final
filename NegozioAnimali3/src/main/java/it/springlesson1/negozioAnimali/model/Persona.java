package it.springlesson1.negozioAnimali.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	
	public void setId(Long id) {
		this.id = id;
	}

	public Persona(){}
	private String nome;
	private String cognome;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

}
