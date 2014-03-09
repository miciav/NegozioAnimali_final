package it.springlesson1.negozioAnimali.jpa;

import it.springlesson1.negozioAnimali.model.Pet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetDAOJpaRepository extends JpaRepository<Pet, String> {

	public Pet findByNome(String nome);
}
