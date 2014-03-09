package it.springlesson1.negozioAnimali.DAO;

import it.springlesson1.negozioAnimali.jpa.PetDAOJpaRepository;
import it.springlesson1.negozioAnimali.model.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PetDAOJPA {

	@Autowired
	private PetDAOJpaRepository p;

	public void setP(PetDAOJpaRepository p) {
		this.p = p;
	}

	public PetDAOJpaRepository getP() {
		return p;
	}

	@PersistenceContext
	private EntityManager em;

	public void addPet(Pet p) {
		em.persist(p);
		em.flush();
	}

	public Pet getPet(String name) {
		return em.find(Pet.class, name);

	}

}
