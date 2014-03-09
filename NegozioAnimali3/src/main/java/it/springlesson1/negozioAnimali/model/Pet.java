package it.springlesson1.negozioAnimali.model;

import java.util.Date;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

@Entity
public class Pet {

	@Id
	private String nome;

	private Date dataNascita;

	// private TipoPet tipoPet;

	// private Proprietario proprietario;

	// private Veterinario vet;

	// public Veterinario getVet() {
	// return vet;
	// }
	//
	// public void setVet(Veterinario vet) {
	// this.vet = vet;
	// }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public void stampa() {
		System.out.println("-----------------------");
		System.out.println("Nome pet: " + nome);
		System.out.println("Data di nascita: " + dataNascita.toString());
		// if(this.tipoPet != null){
		// System.out.println("Tipo Pet - specie: "+tipoPet.getSpecie());
		// System.out.println("Tipo Pet - razza: "+tipoPet.getRazza());
		// }
		// if(proprietario != null){
		// System.out.println("Proprietario - nome: "+this.proprietario.getNome());
		// System.out.println("Proprietario - Cognome: "+this.proprietario.getCognome());
		// System.out.println("Proprietario - Indirizzo: "+this.proprietario.getIndirizzo());
		// System.out.println("Proprietario - Città: "+this.proprietario.getCitta());
		// System.out.println("Proprietario - telefono: "+this.proprietario.getTelefono());
		// }
		// if(this.vet != null){
		// System.out.println("Veterinario - nome: "+this.vet.getNome());
		// System.out.println("Veterinario - Cognome: "+this.vet.getCognome());
		// for (Specializzazione sp : this.vet.getSpecializzazioni()) {
		// System.out.println("Proprietario - Specializzazione: "+sp.getNome());
		//
		// }
		// }
		System.out.println("-----------------------");
	}

	// public TipoPet getTipoPet() {
	// return tipoPet;
	// }
	//
	// public void setTipoPet(TipoPet tipoPet) {
	// this.tipoPet = tipoPet;
	// }

	// public Proprietario getProprietario() {
	// return proprietario;
	// }
	//
	// public void setProprietario(Proprietario proprietario) {
	// this.proprietario = proprietario;
	// }

}
