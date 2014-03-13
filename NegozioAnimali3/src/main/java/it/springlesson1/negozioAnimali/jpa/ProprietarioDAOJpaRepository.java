package it.springlesson1.negozioAnimali.jpa;

import it.springlesson1.negozioAnimali.model.Proprietario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietarioDAOJpaRepository extends JpaRepository<Proprietario, Long> {

	public Proprietario findById(Long id);
	public Proprietario findByNome(String nome);
}
