package it.springlesson1.negozioAnimali.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

public class Proprietario extends Persona {

	private String indirizzo;
	private String citta;
	private String telefono;
	private Set<Pet> pets;

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	public String getTelefono() {
		return telefono;
	}

	public Set<Pet> getPets() {
		if (this.pets == null) {
			this.pets = new HashSet<Pet>();
		}
		return pets;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Proprietario(String nome, String cognome) {
		this.setNome(nome);
		this.setCognome(cognome);
	}

	protected Set<Pet> getPetsInternal() {
		if (this.pets == null) {
			this.pets = new HashSet<Pet>();
		}

		return this.pets;
	}

	public void addPet(Pet pet) {
		getPetsInternal().add(pet);
		// pet.setProprietario(this);
	}

}
