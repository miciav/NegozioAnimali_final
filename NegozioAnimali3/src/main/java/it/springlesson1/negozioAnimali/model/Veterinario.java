package it.springlesson1.negozioAnimali.model;

import java.util.HashSet;
import java.util.Set;

public class Veterinario extends Persona {

	private Set<Specializzazione> specializzazioni;
	private Set<Pet> pets;

	public Set<Pet> getPets() {
		if (this.pets == null) {
			this.pets = new HashSet<Pet>();
		}
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	public Set<Specializzazione> getSpecializzazioni() {
		if (specializzazioni == null) {
			this.specializzazioni = new HashSet<Specializzazione>();
		}
		return specializzazioni;
	}

	public void setSpecializzazioni(Set<Specializzazione> specializzazioni) {
		this.specializzazioni = specializzazioni;
	}
}
